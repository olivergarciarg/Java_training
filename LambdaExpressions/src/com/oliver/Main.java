package com.oliver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("printing from anonymous runnable");
//            }
//        }).start();

//        new Thread(() -> System.out.println("printing from lambda runnable")).start();
//        new Thread(() -> {
//            System.out.println("printing from lambda runnable");
//            System.out.println("line 2");
//        }).start();

        Employee john = new Employee("John", 30);
        Employee tim = new Employee("Tim", 21);
        Employee jack = new Employee("Jack", 40);
        Employee snow = new Employee("Snow", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

//        Collections.sort(employees, (Employee employee1, Employee employee2) -> {
//            return employee1.getName().compareTo(employee2.getName());
//        });
//
//        for(Employee employee: employees) {
//            System.out.println(employee.getName());
//        }

//        String sillyString = doStringStuf(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(1).getName(), employees.get(2).getName());
//
//        System.out.println(sillyString);

//        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();
//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
//        UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//
//        String sillyString = doStringStuf(uc, employees.get(1).getName(), employees.get(2).getName());
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuf(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
//    public String doSomething() {
//        System.out.println("The anotherClass class name is: " + getClass().getSimpleName());
//        return Main.doStringStuf(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anotherClass class name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");
//    }

    public String doSomething() {
//        UpperConcat uc = (s1, s2) -> {
//            System.out.println("lamba expression class " + getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
       int i = 0;
       UpperConcat uc = (s1, s2) -> {
           System.out.println("lamba expression class " + getClass().getSimpleName());
           String result = s1.toUpperCase() + s2.toUpperCase();
           return result;
       };
//       UpperConcat uc = new UpperConcat() {
//           @Override
//           public String upperAndConcat(String s1, String s2) {
//               System.out.println("i inside anonymous class =" + i);
//               return s1.toUpperCase() + s2.toUpperCase();
//           }
//       };
       System.out.println("The anotherClass class name is: " + getClass().getSimpleName());
//       System.out.println("i=" + i);
       return Main.doStringStuf(uc, "String1", "String2");


    }
}

//class CodeToRun implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("printing from runnable");
//    }
//}