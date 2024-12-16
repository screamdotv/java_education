package java_education.service;

import java.util.*;
import java.util.stream.*;
import java_education.model.Person;

public class MatchService {

    private PersonService service = PersonServiceConnection.getPersonService();

    Collection<Person> persons = service.getAll();

    public Collection<Person> matchPerson(Person newPerson) {
        String targetGender = "male".equalsIgnoreCase(newPerson.getGander()) ? "female" : "male";

        return persons.stream()
                .filter(person -> targetGender.equalsIgnoreCase(person.getGander()))
                .filter(person -> ((person.getAge() >= newPerson.getAge() - 5) & (person.getAge() <= newPerson.getAge() + 5)))
                .collect(Collectors.toList());
    }

}
