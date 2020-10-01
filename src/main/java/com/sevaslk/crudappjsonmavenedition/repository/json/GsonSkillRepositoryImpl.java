package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.sevaslk.crudappjsonmavenedition.model.Skill;
import com.sevaslk.crudappjsonmavenedition.repository.SkillRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static com.sevaslk.crudappjsonmavenedition.repository.json.GsonUtils.getListFromJson;
import static com.sevaslk.crudappjsonmavenedition.repository.json.GsonUtils.writeListToJson;

public class GsonSkillRepositoryImpl implements SkillRepository {
    private String SKILLS_JSON = "src\\main\\resources\\skills.json";
    private Gson gson = new Gson();

    @Override
    public List<Skill> getAll() throws IOException {
        return getListFromJson(SKILLS_JSON).stream().map(Skill.class::cast).collect(Collectors.toList());
    }

    @Override
    public Skill getById(Long id) throws IOException {
        return getListFromJson(SKILLS_JSON)
                .stream()
                .map(Skill.class::cast)
                .filter(skill -> skill.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Skill save(Skill newSkill) throws IOException {
        if (Files.exists(Paths.get(SKILLS_JSON))) {
            List<Skill> skillList = getListFromJson(SKILLS_JSON).stream().map(Skill.class::cast).collect(Collectors.toList());
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
        List<Skill> skillList = getListFromJson(SKILLS_JSON)
                .stream()
                .map(Skill.class::cast)
                .map(skill -> skill.getId().equals(newSkill.getId()) ? newSkill : skill)
                .collect(Collectors.toList());
        writeListToJson(skillList, SKILLS_JSON);
        return newSkill;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Skill> skillList = getListFromJson(SKILLS_JSON).stream().map(Skill.class::cast).collect(Collectors.toList());
        skillList.removeIf(item -> item.getId().equals(id));
        writeListToJson(skillList, SKILLS_JSON);
    }

}
