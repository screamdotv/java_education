package service;

import java.util.*;
import model.*;

public class PersonService {

    private int id = 1;
    private HashMap<Integer, Person> personMap = new HashMap<>();

    public void save(Person person) {
        personMap.put(id++, person);
    }

    public int getById(int id) {
        return id;
    }

    public void getAll() {
        for (Map.Entry<Integer, Person> person : personMap.entrySet()) {
            System.out.println("id: " + person.getKey() + "; " + person.getValue());
        }
    }
}
