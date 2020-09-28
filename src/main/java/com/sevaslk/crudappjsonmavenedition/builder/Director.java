package com.sevaslk.crudappjsonmavenedition.builder;

import com.sevaslk.crudappjsonmavenedition.model.Developer;

public class Director {
    private DeveloperBuilder developerBuilder;

   public void setDeveloperBuilder(DeveloperBuilder developerBuilder) {
        this.developerBuilder = developerBuilder;
    }

   public Developer buildDeveloper() {
       developerBuilder.createDeveloper();
        developerBuilder.setID();
        developerBuilder.setName();
        developerBuilder.setSkills();
        developerBuilder.setAccount();
        return developerBuilder.getDeveloper();
    }
}
