package com.sevaslk.crudappjsonmavenedition.controller;

import com.sevaslk.crudappjsonmavenedition.model.Developer;
import com.sevaslk.crudappjsonmavenedition.model.Skill;
import com.sevaslk.crudappjsonmavenedition.repository.DeveloperRepository;
import com.sevaslk.crudappjsonmavenedition.repository.SkillRepository;
import com.sevaslk.crudappjsonmavenedition.repository.json.GsonDeveloperRepositoryImpl;
import com.sevaslk.crudappjsonmavenedition.repository.json.GsonSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class DeveloperController {
    private DeveloperRepository repository = new GsonDeveloperRepositoryImpl();

    public List<Developer> getAll() throws IOException {
        return repository.getAll();
    }

    public Developer getById(Long id) throws IOException {
        return repository.getById(id);
    }

    public Developer save(Long id, String name) throws IOException {
        return repository.save(new Developer(id, name, null,null));
    }

    public Developer update(Long id, String newName) throws IOException {
        return repository.update(new Developer(id, newName, null, null));
    }

    public void deleteById(Long id) throws IOException {
        repository.deleteById(id);
    }
}
