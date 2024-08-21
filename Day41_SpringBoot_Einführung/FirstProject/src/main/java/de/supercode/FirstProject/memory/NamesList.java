package de.supercode.FirstProject.memory;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class NamesList {
    ArrayList<String> namesList;

    public NamesList() {
        this.namesList = new ArrayList<>();
    }

    public ArrayList<String> getNamesList() {
        return namesList;
    }

    public void setNamesList(ArrayList<String> namesList) {
        this.namesList = namesList;
    }
}
