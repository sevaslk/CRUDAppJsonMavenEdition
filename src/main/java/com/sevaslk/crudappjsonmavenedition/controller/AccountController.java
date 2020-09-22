package com.sevaslk.crudappjsonmavenedition.controller;

import com.sevaslk.crudappjsonmavenedition.model.Account;
import com.sevaslk.crudappjsonmavenedition.model.AccountStatus;
import com.sevaslk.crudappjsonmavenedition.model.Skill;
import com.sevaslk.crudappjsonmavenedition.repository.AccountRepository;
import com.sevaslk.crudappjsonmavenedition.repository.SkillRepository;
import com.sevaslk.crudappjsonmavenedition.repository.json.GsonAccountRepositoryImpl;
import com.sevaslk.crudappjsonmavenedition.repository.json.GsonSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class AccountController {
    private AccountRepository repository = new GsonAccountRepositoryImpl();

    public List<Account> getAll() throws IOException {
        return repository.getAll();
    }

    public Account getById(Long id) throws IOException {
        return repository.getById(id);
    }

    public Account save(Long id) throws IOException {
        return repository.save(new Account(id, AccountStatus.ACTIVE));
    }

    public Account update(Long id) throws IOException {
        return repository.update(new Account(id, AccountStatus.ACTIVE));
    }

    public void deleteById(Long id) throws IOException {
        repository.deleteById(id);
    }
}
