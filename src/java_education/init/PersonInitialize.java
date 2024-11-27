package java_education.init;

import java.util.*;
import java_education.service.PersonService;
import java_education.model.*;

public class PersonInitialize {

    public PersonService service = new PersonService();

    private ArrayList<Person> personsList = new ArrayList<>(Arrays.asList(
            new Man("Voltaire", "Francois", "Arouet", 83, "French"),
            new Man("Jean-Jacques", "Rousseau", "de la Tour", 66, "Swiss/French"),
            new Man("Alexander", "Pope", "N/A", 56, "English"),
            new Man("Samuel", "Johnson", "N/A", 75, "English"),
            new Man("Jonathan", "Swift", "N/A", 78, "Irish"),
            new Woman("Mary", "Wollstonecraft", "N/A", 53, "English"),
            new Woman("Fanny", "Burney", "N/A", 87, "English"),
            new Woman("Lady", "Montagu", "N/A", 73, "English"),
            new Woman("Hannah", "More", "N/A", 88, "English"),
            new Woman("Aphra", "Behn", "N/A", 49, "English")
    ));

    public void init() {
        for (Person person : personsList) {
//            System.out.println(person);
            service.save(person);
        }
    }
}
