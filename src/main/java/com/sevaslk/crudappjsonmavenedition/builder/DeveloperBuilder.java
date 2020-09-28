package com.sevaslk.crudappjsonmavenedition.builder;

import com.sevaslk.crudappjsonmavenedition.model.Developer;

abstract class DeveloperBuilder {
    Developer developer;

    void createDeveloper() {
        developer = new Developer(null,null,null,null);
    }

    abstract void setID();

    abstract void setName();

    abstract void setSkills();

    abstract void setAccount();

    Developer getDeveloper() {
        return developer;
    }

}
