package com.sevaslk.crudappjsonmavenedition;

import com.sevaslk.crudappjsonmavenedition.repository.json.GsonSkillRepositoryImpl;
import com.sevaslk.crudappjsonmavenedition.model.Skill;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GsonSkillRepositoryImpl gsonSkillRepository = new GsonSkillRepositoryImpl();
        gsonSkillRepository.save(new Skill(3L, "SQL"));

    }
}
