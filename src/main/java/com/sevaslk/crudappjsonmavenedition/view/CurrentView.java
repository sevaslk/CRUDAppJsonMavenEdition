package com.sevaslk.crudappjsonmavenedition.view;

import java.io.IOException;

public interface CurrentView {
    void getAll() throws IOException;

    void getByID() throws IOException;

    void save() throws IOException;

    void update() throws IOException;

    void deleteByID() throws IOException;
}
