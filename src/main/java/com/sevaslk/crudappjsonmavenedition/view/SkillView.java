package com.sevaslk.crudappjsonmavenedition.view;

import com.sevaslk.crudappjsonmavenedition.controller.SkillController;

import java.io.IOException;
import java.util.Scanner;

public class SkillView implements CurrentView {
    private final SkillController controller = new SkillController();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void getAll() throws IOException {
        System.out.println(controller.getAll());
    }

    @Override
    public void getByID() throws IOException {
        System.out.println("Enter skill ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.getById(id));
    }

    @Override
    public void save() throws IOException {
        System.out.println("Enter new skill:");
        String newSkillName = this.scanner.nextLine();
        System.out.println("Enter new skill ID:");
        Long newSkillID = this.scanner.nextLong();
        System.out.println(controller.save(newSkillID, newSkillName));
    }

    @Override
    public void update() throws IOException {
        System.out.println("Enter new skill:");
        String newName = this.scanner.nextLine();
        System.out.println("Enter skill ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.update(id, newName));
    }

    @Override
    public void deleteByID() throws IOException {
        System.out.println("Enter skill ID:");
        Long id = this.scanner.nextLong();
        controller.deleteById(id);
    }

}
