package service;

import java.util.*;
import model.*;

public class Main {

	public static void main(String[] args) {

		HashMap<Integer, Person> personMap = new HashMap<>();
		
        Person helga = new Woman("Helga", "Json", "Jou", 13, "Greek");
        Man jhon = new Man("Jhon", "Jacob", "Monarh", 13, "Greek");
       
        int id = 1;
        
        personMap.put(id++, helga);
        personMap.put(id++, jhon);
        
        for (Map.Entry<Integer, Person> person : personMap.entrySet()) {
            System.out.println("Key: " + person.getKey() + ", Value: " + person.getValue());
        }
        
	}
}
