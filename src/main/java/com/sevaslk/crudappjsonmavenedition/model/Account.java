package com.sevaslk.crudappjsonmavenedition.model;

public class Account {
    private Long id;
    private AccountStatus accountStatus;

    public Account(Long id, AccountStatus accountStatus) {
        this.id = id;
        this.accountStatus = accountStatus;
    }
}
