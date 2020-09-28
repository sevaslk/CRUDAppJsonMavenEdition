package com.sevaslk.crudappjsonmavenedition.builder;

import com.sevaslk.crudappjsonmavenedition.model.Account;
import com.sevaslk.crudappjsonmavenedition.model.AccountStatus;
import com.sevaslk.crudappjsonmavenedition.model.Skill;

import java.util.ArrayList;
import java.util.Collections;

public class JavaDeveloper extends DeveloperBuilder {

    @Override
    void setID() {
        developer.setId(1L);
    }

    @Override
    void setName() {
        developer.setName("Java Developer");
    }

    @Override
    void setSkills() {
        developer.setSkills(new ArrayList<>(Collections.singleton(new Skill(1L, "Java"))));
    }

    @Override
    void setAccount() {
        developer.setAccount(new Account(345L, AccountStatus.ACTIVE));
    }
}
