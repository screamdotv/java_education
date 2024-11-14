package practise;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<Person>();
        Woman helga = new Woman("Helga", "Json", "Jou", 13, "Greek");
        Man jhon = new Man("Jhon", "Jacob", "Monarh", 13, "Greek");

        personList.add(helga);
        personList.add(jhon);
        
        for (Person person : personList) {
           System.out.println(person);
        }
    }
}
