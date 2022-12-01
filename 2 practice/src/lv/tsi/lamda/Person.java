package lv.tsi.lamda;

import java.util.ArrayList;
import java.util.List;

public class Person {
        private final String name;
        private final int age;
        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        public String getName(){
            return name;
        }
        public int getAge() {
            return age;
        }
        public void print() {
            System.out.println(name + ", " + age + ";");
        }
    }
    class PersonEvaluator{
        private final List<Person> person;
        PersonEvaluator(List<Person> list){
            this.person = list;
        }
        public void findAndPrint(char start) {
            System.out.println("Persons name starts with '" + start + "':");
            for (Person per : person) {
                if (per.getName().indexOf(start) == 0) {
                    per.print();
                }
            }
            System.out.println();
        }

        public void findAndPrint18(int age, char sign) {
            System.out.println("Persons older than 18:");
            for (Person per : person) {
                if (sign == '>') {
                    if (per.getAge() > age) {
                        per.print();
                    }
                } else if (sign == '<') {
                    if (per.getAge() < age) {
                        per.print();
                    }
                }
            }
            System.out.println();
        }

        public void groupAndPrint() {
            System.out.println("List of grouped by age persons:");
            for (int i = 0; i < 30; i++) {
                boolean a = true;
                for (Person per : person) {
                    if (i == per.getAge()){
                        if (a) {
                            System.out.print("Age " + i + ":");
                            a = false;
                        }
                        System.out.print(per.getName() + ",");
                    }
                }
                if (!a) {
                    System.out.println();
                }
            }
        }
        public void getAverageAge() {
            System.out.println();
            int average = 0;
            for (Person per : person) {
                average += per.getAge();
            }
            average /= person.size();
            System.out.println("The average age of all people is " + average + ".");
        }
    }

    class PersonProcessingWithStreams{
        public static void main(String[] args) {

            List<Person> l = new ArrayList<>();

            Person p = new Person("Max", 28);
            l.add(p);
            Person p1 = new Person("Peter", 22);
            l.add(p1);
            Person p2 = new Person("Anna", 28);
            l.add(p2);
            Person p3 = new Person("Lilianna", 16);
            l.add(p3);
            Person p4 = new Person("Pamela", 13);
            l.add(p4);
            Person p5 = new Person("David", 22);
            l.add(p5);

            PersonEvaluator listOfPersons = new PersonEvaluator(l);

            listOfPersons.findAndPrint('P');

            listOfPersons.findAndPrint18(18,'>');

            listOfPersons.groupAndPrint();

            listOfPersons.getAverageAge();
        }
    }


