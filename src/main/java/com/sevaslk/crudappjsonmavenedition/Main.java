package com.sevaslk.crudappjsonmavenedition;

import com.sevaslk.crudappjsonmavenedition.builder.Director;
import com.sevaslk.crudappjsonmavenedition.builder.JavaDeveloper;
import com.sevaslk.crudappjsonmavenedition.model.Developer;
import com.sevaslk.crudappjsonmavenedition.view.CommonView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CommonView commonView = new CommonView();
        commonView.start();

//        Director director = new Director();
//        director.setDeveloperBuilder(new JavaDeveloper());
//        Developer developer = director.buildDeveloper();
//        System.out.println(developer);

    }
}
