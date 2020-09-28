package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sevaslk.crudappjsonmavenedition.model.Developer;
import com.sevaslk.crudappjsonmavenedition.repository.DeveloperRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GsonDeveloperRepositoryImpl extends GsonCommonRepository implements DeveloperRepository {
    private String DEVELOPERS_JSON = "src\\main\\resources\\developers.json";
    private Gson gson = new Gson();

    @Override
    public List<Developer> getAll() throws IOException {
        return getListFromJson(DEVELOPERS_JSON);
    }

    @Override
    public Developer getById(Long id) throws IOException {
        return getDevelopersFromJson(DEVELOPERS_JSON)
                .stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Developer save(Developer newDeveloper) throws IOException {
        if (Files.exists(Paths.get(DEVELOPERS_JSON))) {
            List<Developer> developerList = getDevelopersFromJson(DEVELOPERS_JSON);
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
        List<Developer> developerList = getDevelopersFromJson(DEVELOPERS_JSON)
                .stream()
                .map(developer -> developer.getId().equals(newDeveloper.getId()) ? newDeveloper : developer)
                .collect(Collectors.toList());
        writeListToJson(developerList, DEVELOPERS_JSON);
        return newDeveloper;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Developer> developerList = getDevelopersFromJson(DEVELOPERS_JSON);
        developerList.removeIf(item -> item.getId().equals(id));
        writeListToJson(developerList, DEVELOPERS_JSON);
    }

    private List<Developer> getDevelopersFromJson(String json) {
        List<Developer> developerList = new ArrayList<>();
        try (FileReader reader = new FileReader(json)) {
            developerList = gson.fromJson(reader, new TypeToken<List<Developer>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developerList;
    }

}
