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

public class GsonSkillRepositoryImpl extends GsonCommonRepository implements SkillRepository {

    private String SKILLS_JSON = "src\\main\\resources\\skills.json";

    private Gson gson = new Gson();

    @Override
    public List<Skill> getAll() throws IOException {
        return getListFromJson(SKILLS_JSON);
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
            List<Skill> skillList = getListFromJson(SKILLS_JSON);
            if (skillList.contains(newSkill)) {
                System.out.println("Skill already exist");
                return newSkill;
            } else {
                skillList.add(newSkill);
                writeListToJson(skillList, SKILLS_JSON);
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
        writeListToJson(skillList, SKILLS_JSON);
        return newSkill;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Skill> skillList = getSkillsFromJson(SKILLS_JSON);
        skillList.removeIf(item -> item.getId().equals(id));
        writeListToJson(skillList, SKILLS_JSON);
    }

    List<Skill> getSkillsFromJson(String json) {
        List<Skill> skillList = new ArrayList<>();
        try (FileReader reader = new FileReader(json)) {
            skillList = gson.fromJson(reader, new TypeToken<List<Skill>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skillList;
    }

}
