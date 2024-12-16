package java_education.service;

import java.util.*;
import java_education.model.Person;

public class MatchService {

    private PersonService service = PersonServiceConnection.getPersonService();

    Collection<Person> persons = service.getAll();

    public Collection<Person> matchPerson(Person newPerson) {
        Collection<Person> matchListPerson = new ArrayList<>();

        String targetGender = "male".equalsIgnoreCase(newPerson.getGander()) ? "female" : "male";

        persons.stream()
                .filter(person -> targetGender.equalsIgnoreCase(person.getGander()))
                .filter(person -> ((person.getAge() >= newPerson.getAge() - 5) & (person.getAge() <= newPerson.getAge() + 5)))
                .forEach(person -> matchListPerson.add(person));

        return matchListPerson;
    }

}
