package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sevaslk.crudappjsonmavenedition.model.Skill;
import com.sevaslk.crudappjsonmavenedition.repository.SkillRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sevaslk.crudappjsonmavenedition.repository.json.IOUtil.readFile;

public class GsonSkillRepositoryImpl implements SkillRepository {
    private final String SKILLS_JSON = "skills.json";
    private Gson gson = new Gson();
//    private Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public List<Skill> getAll() throws IOException {
        return null;
    }

    @Override
    public Skill getById(Long aLong) throws IOException {

        return null;
    }

    @Override
    public Skill save(Skill newSkill) throws IOException {
        if (Files.exists(Paths.get(SKILLS_JSON))) {
            try (FileReader reader = new FileReader(SKILLS_JSON)) {
                List<Skill> skillList = Arrays.asList(gson.fromJson(reader, new TypeToken<List<Skill>>() {}.getType())); //что-то не так здесь
                skillList.add(newSkill);
                try (FileWriter writer = new FileWriter(SKILLS_JSON, true)) {
                    gson.toJson(skillList, writer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Files.createFile(Paths.get(SKILLS_JSON));
            save(newSkill);
        }
        return newSkill;
    }

    @Override
    public Skill update(Skill skill) throws IOException {
        return null;
    }

    @Override
    public void deleteById(Long aLong) throws IOException {

    }
}
