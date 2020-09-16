package com.sevaslk.crudappjsonmavenedition.repository.json;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class IOUtil {
    static void writeStringToFile(String string, String path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            byte[] strBytes = string.getBytes();
            fileOutputStream.write(strBytes);
        }
    }

    static String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    static <T> String convertListToString(List<T> t) {
        return t.stream().map(String::valueOf).sorted().collect(Collectors.joining());
    }
}
