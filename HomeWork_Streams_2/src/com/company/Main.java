package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(surnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println("Количество несовершеннолетних: " + persons.stream().
                filter(person -> person.getAge() < 18).count());

        System.out.println("\nПризывники:" + persons.stream().filter(person -> person.getAge() > 18).
                filter(person -> person.getAge() < 27).filter(person -> person.getSex() == Sex.MAN).
                map(Person::getSurname).toList());

        System.out.println("\n Работоспособное население с высшим образованием:");
        persons.stream().filter(person -> person.getAge() > 18).
                filter(person -> person.getSex() == Sex.MAN ? person.getAge() < 65 : person.getAge() < 60).
                filter(person -> person.getEducation() == Education.HIGHER).
                sorted(Comparator.comparing(Person::getSurname)).toList().forEach(x -> System.out.print(x + " \n"));
    }
}
