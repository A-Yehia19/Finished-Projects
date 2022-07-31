package yummies.project.Classes;
public abstract class Staff extends Person{
    public int ID;
    public double Salary;

    public Staff() {}

    public Staff(String name, String phoneNumber, String address, int ID, double salary) {
        super(name, phoneNumber, address);
        this.ID = ID;
        Salary = salary;
    }

}
