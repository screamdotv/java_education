package java_education.service;

import java.util.*;
import java_education.model.*;

public class PersonService {

    private int id = 1;
    private HashMap<Integer, Person> personMap = new HashMap<>();

    public void save(Person person) {
        personMap.put(id++, person);
    }

    public int getById(int id) {
        return id;
    }

    public Collection<Person> getAll() {
        return personMap.values();
    }
}
