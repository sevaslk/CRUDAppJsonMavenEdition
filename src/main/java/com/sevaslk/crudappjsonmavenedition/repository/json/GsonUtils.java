package com.sevaslk.crudappjsonmavenedition.repository.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GsonUtils {
    private static Gson gson;

    static List<String> getListFromJson(String json) {
        List<String> list = new ArrayList<>();
        try (FileReader reader = new FileReader(json)) {
           list = gson.fromJson(reader, new TypeToken<List<String>>() {}.getType());
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    static void writeListToJson(List<?> list, String json) {
        try (FileWriter writer = new FileWriter(json)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
