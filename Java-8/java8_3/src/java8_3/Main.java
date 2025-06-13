package java8_3;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
    	List<User> users = new ArrayList<>();
    	 
        users.add(new User(1, "Amit", 50000.0));
        users.add(new User(2, "Priya", 60000.0));
        users.add(new User(3, "rahul", 55000.0));
        users.add(new User(4, "Sneha", 70000.0));
        users.add(new User(5, "Vikram", 48000.0));
        users.add(new User(6, "pooja", 62000.0));
        users.add(new User(7, "Rohit", 75000.0));
        users.add(new User(8, "neha", 58000.0));
        users.add(new User(9, "ankit", 54000.0));
        users.add(new User(10, "Kiran", 67000.0));
        
        
        System.out.println (users.stream().min((u1,u2)-> Double.compare(u1.getSalary(),u2.getSalary())));
    }
}



