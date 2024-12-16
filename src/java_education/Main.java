package java_education;

import java.util.*;
import java_education.init.*;
import java_education.service.*;
import java_education.model.*;

public class Main {

    private Map<String, String> questionsList = new LinkedHashMap<>();
    private Scanner scannerInput = new Scanner(System.in);

    private void initData() {
        new PersonInitialize().init();
    }

    private void doStudyTasks() {
        PersonService service = PersonServiceConnection.getPersonService();
        Collection<Person> persons = service.getAll();
        persons.forEach(System.out::println);
    }

    private void initListQuestion() {
        this.questionsList.put("gender", "Enter your gender (male/female): ");
        this.questionsList.put("firstName", "Enter your First Name: ");
        this.questionsList.put("lastName", "Enter your Last Name: ");
        this.questionsList.put("surname", "Enter your Surname: ");
        this.questionsList.put("nation", "Enter your nation: ");
        this.questionsList.put("age", "Enter your age: ");
    }

    public void startRegistration() {
        Person person = null;
        boolean start = true;
        MatchService match = new MatchService();

        while (start) {
            for (Map.Entry<String, String> question : questionsList.entrySet()) {
                System.out.print(question.getValue());
                String inputValue = scannerInput.nextLine();

                if ("exit".equalsIgnoreCase(inputValue)) {
                    start = false;
                    break;
                }

                if ("gender".equals(question.getKey())) {
                    if ("male".equalsIgnoreCase(inputValue)) {
                        person = new Man();
                    } else if ("female".equalsIgnoreCase(inputValue)) {
                        person = new Woman();
                    }
                }

                switch (question.getKey()) {
                    case "firstName" ->
                        person.setFirstName(inputValue);
                    case "lastName" ->
                        person.setLastName(inputValue);
                    case "surname" ->
                        person.setSurname(inputValue);
                    case "nation" ->
                        person.setNation(inputValue);
                    case "age" -> {
                        boolean correctNum = false;
                        while (!correctNum) {
                            try {
                                person.setAge(Integer.parseInt(inputValue));
                                correctNum = true;
                                start = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid age. Please enter a number.");
                                System.out.print(question.getValue());
                                inputValue = scannerInput.nextLine();
                            }
                        }
                    }
                }
            }

            scannerInput.close();
        }
        Collection<Person> matchListPesron = match.matchPerson(person);
        matchListPesron.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.initData();
        main.initListQuestion();
        main.startRegistration();

//        PersonService service = PersonServiceConnection.getPersonService();
//        Collection<Person> persons = service.getAll();
//        persons.stream().filter(person->"male".equals(person.getGander())).forEach(person->System.out.println(person.getFirstName()));
    }

}
