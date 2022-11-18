package com.oliver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Employee john = new Employee("John x", 31);
        Employee tim = new Employee("Tim x", 21);
        Employee jack = new Employee("Jack x", 40);
        Employee snow = new Employee("Snow x", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(2));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' ') + 1);
        };

//        employees.forEach(employee -> {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });

//        for (Employee employee: employees) {
//            if (employee.getAge() >30) {
//                System.out.println(employee.getName());
//            }
//        }

//        employees.forEach(employee -> {
//            if (employee.getAge() >30) {
//                System.out.println(employee.getName());
//            }
//        });

//        printByAge(employees,"over 30", employee -> employee.getAge() > 30);
//        printByAge(employees,"under 31", employee -> employee.getAge() < 31);

    }

    private static void printByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        for (Employee employee: employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}