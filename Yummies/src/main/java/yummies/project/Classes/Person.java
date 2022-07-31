package yummies.project.Classes;

public abstract class Person {
    public String Name;
    public String PhoneNumber;
    public String Address;

    public Person() {}

    public Person(String name, String phoneNumber, String address) {
        Name = name;
        PhoneNumber = phoneNumber;
        Address = address;
    }
}
