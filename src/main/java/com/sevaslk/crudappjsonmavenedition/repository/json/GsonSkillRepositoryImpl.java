package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sevaslk.crudappjsonmavenedition.model.Skill;
import com.sevaslk.crudappjsonmavenedition.repository.SkillRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonSkillRepositoryImpl implements SkillRepository {

    String SKILLS_JSON = "src\\main\\resources\\skills.json";

    Gson gson = new Gson();
    private Skill Skill;

    @Override
    public List<Skill> getAll() throws IOException {
        return getSkillsFromJson(SKILLS_JSON);
    }

    @Override
    public Skill getById(Long id) throws IOException {
        return getSkillsFromJson(SKILLS_JSON)
                .stream()
                .filter(skill -> skill.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Skill save(Skill newSkill) throws IOException {
        if (Files.exists(Paths.get(SKILLS_JSON))) {
            List<Skill> skillList = getSkillsFromJson(SKILLS_JSON);
            if (skillList.contains(newSkill)) {// TODO: 20.09.2020 validation doesnt work
                System.out.println("Skill already exist");
                return newSkill;
            } else {
                skillList.add(newSkill);
                writeSkillsToJson(skillList);
            }
        } else {
            Files.createFile(Paths.get(SKILLS_JSON));
            save(newSkill);
        }
        return newSkill;
    }


    @Override
    public Skill update(Skill newSkill) throws IOException {
        List<Skill> skillList = getSkillsFromJson(SKILLS_JSON)
                .stream()
                .map(skill -> skill.getId().equals(newSkill.getId()) ? newSkill : skill)
                .collect(Collectors.toList());
        writeSkillsToJson(skillList);
        return newSkill;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Skill> skillList = getSkillsFromJson(SKILLS_JSON);
        skillList.removeIf(item -> item.getId().equals(id));
        writeSkillsToJson(skillList);
    }

    private List<Skill> getSkillsFromJson(String json) {
        List<Skill> skillList = new ArrayList<>();
        try (FileReader reader = new FileReader(json)) {
            skillList = gson.fromJson(reader, new TypeToken<List<Skill>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skillList;
    }

    private void writeSkillsToJson(List<Skill> skillList) throws IOException {
        try (FileWriter writer = new FileWriter(SKILLS_JSON)) {
            gson.toJson(skillList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
