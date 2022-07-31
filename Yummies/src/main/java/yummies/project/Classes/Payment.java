package yummies.project.Classes;

public abstract class Payment {
    public double Amount;

    public Payment() {}

    public Payment(double amount) {
        Amount = amount;
    }

    public abstract String ViewRecite();
}
