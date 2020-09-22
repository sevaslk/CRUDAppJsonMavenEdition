package com.sevaslk.crudappjsonmavenedition.view;

import com.sevaslk.crudappjsonmavenedition.controller.AccountController;

import java.io.IOException;
import java.util.Scanner;

public class AccountView implements CurrentView {

    private final AccountController controller = new AccountController();
    private final Scanner scanner = new Scanner(System.in);

    public void getAll() throws IOException {
        System.out.println(controller.getAll());
    }

    public void getByID() throws IOException {
        System.out.println("Enter account ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.getById(id));
    }

    public void save() throws IOException {
        System.out.println("Enter new account:");
        Long newAccountID = this.scanner.nextLong();
        System.out.println(controller.save(newAccountID));
    }

    public void update() throws IOException {
        System.out.println("Enter account:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.update(id));
    }

    public void deleteByID() throws IOException {
        System.out.println("Enter account ID:");
        Long id = this.scanner.nextLong();
        controller.deleteById(id);
    }

}
