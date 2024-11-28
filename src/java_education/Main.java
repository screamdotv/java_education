package java_education;

import java_education.init.*;
import java_education.service.*;
import java_education.model.*;

public class Main {
    
    public static void main(String[] args) {
        initData();
        doStudyTasks();
    }

    private static void initData() {
        new PersonInitialize().init();
    }

    private static void doStudyTasks() {
        PersonService service = new PersonService()
        List<Person> persons = service.getAll();
        persons.forEach(System.out::println);
    }
}
