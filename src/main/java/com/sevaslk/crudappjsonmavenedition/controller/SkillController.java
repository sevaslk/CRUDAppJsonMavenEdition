package com.sevaslk.crudappjsonmavenedition.controller;

import com.sevaslk.crudappjsonmavenedition.model.Skill;
import com.sevaslk.crudappjsonmavenedition.repository.SkillRepository;
import com.sevaslk.crudappjsonmavenedition.repository.json.GsonSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SkillController {
    private SkillRepository repository = new GsonSkillRepositoryImpl();

    public List<Skill> getAll() throws IOException {
        return repository.getAll();
    }

    public Skill getById(Long id) throws IOException {
        return repository.getById(id);
    }

    public Skill save(Long id, String name) throws IOException {
        return repository.save(new Skill(id, name));
    }

    public Skill update(Long id, String newName) throws IOException {
        return repository.update(new Skill(id, newName));
    }

    public void deleteById(Long id) throws IOException {
        repository.deleteById(id);
    }
}
