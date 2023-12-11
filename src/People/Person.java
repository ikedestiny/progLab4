package People;

import Appliances.Telephone;
import RootOfModel.Gender;

import java.util.Objects;
import java.util.Scanner;

public abstract class Person {

    private static int objectCount = 0;
    private final String name;
    private final Gender gender;
    private final int age;
    private final int id;
    private String phoneNumber;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        objectCount++;
        this.id = objectCount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void call(Person person) throws InterruptedException {
        try {
            Telephone telephone = new Telephone();
            String phoneNumber = person.getPhoneNumber();
            System.out.println("Calling " + person.getName());
            telephone.call(phoneNumber);
        } catch (NullPointerException e) {
            System.out.println(person.getName() + " does not have a set Number");
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is The number to call: ");
            person.setPhoneNumber(scanner.next());
            call(person);
        }
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getName(), getGender());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Person person = (Person) obj;
        return Objects.equals(getName(), person.getName()) && getAge() == person.getAge() && getGender() == person.getGender();
    }

    @Override
    public String toString() {
        return "Person " + getName();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
