package com.sevaslk.crudappjsonmavenedition;

import com.google.gson.Gson;
import com.sevaslk.crudappjsonmavenedition.model.Skill;
import com.sevaslk.crudappjsonmavenedition.repository.GenericRepository;
import com.sevaslk.crudappjsonmavenedition.repository.json.GsonSkillRepositoryImpl;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        GenericRepository gsonSkillRepository = new GsonSkillRepositoryImpl();

        System.out.println(gsonSkillRepository.getAll());
//        gsonSkillRepository.deleteById(4L);
//        gsonSkillRepository.save(new Skill(5L, "JUnit"));
//        gsonSkillRepository.update(new Skill(4L, "C++"));
        System.out.println(gsonSkillRepository.getAll());
        System.out.println(gsonSkillRepository.getById(1L));


    }
}
