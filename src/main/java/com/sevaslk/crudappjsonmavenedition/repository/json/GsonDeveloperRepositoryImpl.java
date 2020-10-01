package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.sevaslk.crudappjsonmavenedition.model.Developer;
import com.sevaslk.crudappjsonmavenedition.repository.DeveloperRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static com.sevaslk.crudappjsonmavenedition.repository.json.GsonUtils.getListFromJson;
import static com.sevaslk.crudappjsonmavenedition.repository.json.GsonUtils.writeListToJson;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
    private String DEVELOPERS_JSON = "src\\main\\resources\\developers.json";
    private Gson gson = new Gson();

    @Override
    public List<Developer> getAll() throws IOException {
        return getListFromJson(DEVELOPERS_JSON).stream().map(Developer.class::cast).collect(Collectors.toList());
    }

    @Override
    public Developer getById(Long id) throws IOException {
        return getListFromJson(DEVELOPERS_JSON)
                .stream()
                .map(Developer.class::cast)
                .filter(developer -> developer.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Developer save(Developer newDeveloper) throws IOException {
        if (Files.exists(Paths.get(DEVELOPERS_JSON))) {
            List<Developer> developerList = getListFromJson(DEVELOPERS_JSON).stream().map(Developer.class::cast).collect(Collectors.toList());
            if (developerList.contains(newDeveloper)) {
                System.out.println("Developer already exist");
                return newDeveloper;
            } else {
                developerList.add(newDeveloper);
                writeListToJson(developerList, DEVELOPERS_JSON);
            }
        } else {
            Files.createFile(Paths.get(DEVELOPERS_JSON));
            save(newDeveloper);
        }
        return newDeveloper;
    }

    @Override
    public Developer update(Developer newDeveloper) throws IOException {
        List<Developer> developerList = getListFromJson(DEVELOPERS_JSON)
                .stream()
                .map(Developer.class::cast)
                .map(developer -> developer.getId().equals(newDeveloper.getId()) ? newDeveloper : developer)
                .collect(Collectors.toList());
        writeListToJson(developerList, DEVELOPERS_JSON);
        return newDeveloper;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Developer> developerList = getListFromJson(DEVELOPERS_JSON).stream().map(Developer.class::cast).collect(Collectors.toList());
        developerList.removeIf(item -> item.getId().equals(id));
        writeListToJson(developerList, DEVELOPERS_JSON);
    }

}
