package com.sevaslk.crudappjsonmavenedition.model;

import java.util.List;

public class Developer {
    private Long id;
    private String name;
    private List<Skill> skills;
    private Account account;

    public Developer(Long id, String name, List<Skill> skills, Account account) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.account = account;
    }
}
