package java_education.init;

import java.util.*;
import java_education.service.*;
import java_education.model.*;

public class PersonInitialize {

    public PersonService service = PersonServiceConnection.getPersonService();

    private ArrayList<Person> personsList = new ArrayList<>(Arrays.asList(
            new Man("Voltaire", "Francois", "Arouet", 35, "French"),
            new Man("Jean-Jacques", "Rousseau", "de la Tour", 45, "Swiss/French"),
            new Man("Alexander", "Pope", "N/A", 44, "English"),
            new Man("Samuel", "Johnson", "N/A", 18, "English"),
            new Man("Jonathan", "Swift", "N/A", 20, "Irish"),
            new Woman("Mary", "Wollstonecraft", "N/A", 53, "English"),
            new Woman("Fanny", "Burney", "N/A", 50, "English"),
            new Woman("Lady", "Montagu", "N/A", 35, "English"),
            new Woman("Hannah", "More", "N/A", 22, "English"),
            new Woman("Aphra", "Behn", "N/A", 43, "English")
    ));

    public void init() {
        for (Person person : personsList) {
            service.save(person);
        }
    }
}


