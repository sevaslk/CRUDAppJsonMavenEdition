package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sevaslk.crudappjsonmavenedition.model.Account;
import com.sevaslk.crudappjsonmavenedition.repository.AccountRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonAccountRepositoryImpl extends GsonCommonRepository implements AccountRepository {
    private String ACCOUNTS_JSON = "src\\main\\resources\\accounts.json";
    private Gson gson = new Gson();

    @Override
    public List<Account> getAll() throws IOException {
        return getListFromJson(ACCOUNTS_JSON);
    }

    @Override
    public Account getById(Long id) throws IOException {
        return getAccountsFromJson(ACCOUNTS_JSON)
                .stream()
                .filter(account -> account.getId().equals(id))
                .findFirst().orElse(null);    }

    @Override
    public Account save(Account newAccount) throws IOException {
        if (Files.exists(Paths.get(ACCOUNTS_JSON))) {
            List<Account> accountList = getAccountsFromJson(ACCOUNTS_JSON);
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
        List<Account> accountList = getAccountsFromJson(ACCOUNTS_JSON)
                .stream()
                .map(account -> account.getId().equals(newAccount.getId()) ? newAccount : account)
                .collect(Collectors.toList());
        writeListToJson(accountList, ACCOUNTS_JSON);
        return newAccount;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Account> accountList = getAccountsFromJson(ACCOUNTS_JSON);
        accountList.removeIf(item -> item.getId().equals(id));
        writeListToJson(accountList, ACCOUNTS_JSON);
    }

    private List<Account> getAccountsFromJson(String json) {
        List<Account> accountList = new ArrayList<>();
        try (FileReader reader = new FileReader(json)) {
            accountList = gson.fromJson(reader, new TypeToken<List<Account>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountList;
    }

}
