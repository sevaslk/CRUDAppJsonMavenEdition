package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.sevaslk.crudappjsonmavenedition.model.Account;
import com.sevaslk.crudappjsonmavenedition.repository.AccountRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static com.sevaslk.crudappjsonmavenedition.repository.json.GsonUtils.getListFromJson;
import static com.sevaslk.crudappjsonmavenedition.repository.json.GsonUtils.writeListToJson;

public class GsonAccountRepositoryImpl implements AccountRepository {
    private String ACCOUNTS_JSON = "src\\main\\resources\\accounts.json";
    private Gson gson = new Gson();

    @Override
    public List<Account> getAll() throws IOException {
        return getListFromJson(ACCOUNTS_JSON).stream().map(Account.class::cast).collect(Collectors.toList());
    }

    @Override
    public Account getById(Long id) throws IOException {
        return getListFromJson(ACCOUNTS_JSON)
                .stream()
                .map(Account.class::cast)
                .filter(account -> account.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Account save(Account newAccount) throws IOException {
        if (Files.exists(Paths.get(ACCOUNTS_JSON))) {
            List<Account> accountList = getListFromJson(ACCOUNTS_JSON).stream().map(Account.class::cast).collect(Collectors.toList());
            if (accountList.contains(newAccount)) {
                System.out.println("Account already exist");
                return newAccount;
            } else {
                accountList.add(newAccount);
                writeListToJson(accountList, ACCOUNTS_JSON);
            }
        } else {
            Files.createFile(Paths.get(ACCOUNTS_JSON));
            save(newAccount);
        }
        return newAccount;
    }

    @Override
    public Account update(Account newAccount) throws IOException {
        List<Account> accountList = getListFromJson(ACCOUNTS_JSON)
                .stream()
                .map(Account.class::cast)
                .map(account -> account.getId().equals(newAccount.getId()) ? newAccount : account)
                .collect(Collectors.toList());
        writeListToJson(accountList, ACCOUNTS_JSON);
        return newAccount;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Account> accountList = getListFromJson(ACCOUNTS_JSON).stream().map(Account.class::cast).collect(Collectors.toList());
        accountList.removeIf(item -> item.getId().equals(id));
        writeListToJson(accountList, ACCOUNTS_JSON);
    }

}
