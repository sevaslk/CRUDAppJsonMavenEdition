package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class GsonCommonRepository<T> {
    private Gson gson;

    List<T> getListFromJson(String json) {
        List<T> list = new ArrayList<>();
        try (FileReader reader = new FileReader(json)) {
            list = gson.fromJson(reader, new TypeToken<List<T>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    void writeListToJson(List<T> list, String json) throws IOException {
        try (FileWriter writer = new FileWriter(json)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
