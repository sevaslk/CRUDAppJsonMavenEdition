package com.sevaslk.crudappjsonmavenedition.builder;

import com.sevaslk.crudappjsonmavenedition.model.Account;
import com.sevaslk.crudappjsonmavenedition.model.AccountStatus;
import com.sevaslk.crudappjsonmavenedition.model.Skill;

import java.util.ArrayList;
import java.util.Collections;

public class PythonDeveloper extends DeveloperBuilder {

    @Override
    void setID() {
        developer.setId(2L);
    }

    @Override
    void setName() {
        developer.setName("Python Developer");
    }

    @Override
    void setSkills() {
        developer.setSkills(new ArrayList<>(Collections.singleton(new Skill(2L, "Python"))));
    }

    @Override
    void setAccount() {
        developer.setAccount(new Account(456L, AccountStatus.ACTIVE));
    }
}
