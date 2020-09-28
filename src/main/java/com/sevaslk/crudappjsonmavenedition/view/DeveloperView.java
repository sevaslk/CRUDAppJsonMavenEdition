package com.sevaslk.crudappjsonmavenedition.view;

import com.sevaslk.crudappjsonmavenedition.builder.Director;
import com.sevaslk.crudappjsonmavenedition.builder.JavaDeveloper;
import com.sevaslk.crudappjsonmavenedition.builder.PythonDeveloper;
import com.sevaslk.crudappjsonmavenedition.controller.DeveloperController;

import java.io.IOException;
import java.util.Scanner;

public class DeveloperView implements CurrentView {

    private final DeveloperController controller = new DeveloperController();
    private final Scanner scanner = new Scanner(System.in);
    private Director director = new Director();

    public void getAll() throws IOException {
        System.out.println(controller.getAll());
    }

    public void getByID() throws IOException {
        System.out.println("Enter developer ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.getById(id));
    }

    public void save() throws IOException {
        System.out.println("Choose type of developer: " +
                "'1' - Java Developer" +
                "'2' - Python Developer");
        int select = this.scanner.nextInt();
        if (select == 1) {
            director.setDeveloperBuilder(new JavaDeveloper());
        }
        if (select == 2) {
            director.setDeveloperBuilder(new PythonDeveloper());
        }
        controller.save(director.buildDeveloper());

    }

    public void update() throws IOException {
        System.out.println("Enter new developer name:");
        String newDeveloperName = this.scanner.nextLine();
        System.out.println("Enter new developer ID:");
        Long newDeveloperID = this.scanner.nextLong();
        System.out.println(controller.update(newDeveloperID, newDeveloperName));
    }

    public void deleteByID() throws IOException {
        System.out.println("Enter developer ID:");
        Long id = this.scanner.nextLong();
        controller.deleteById(id);
    }

}
