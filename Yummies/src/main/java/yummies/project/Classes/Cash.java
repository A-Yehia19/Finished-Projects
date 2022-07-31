package yummies.project.Classes;

public class Cash extends Payment {
    public double Paid;
    public double Remaining;

    public Cash() {}

    public Cash(double amount, double paid) {
        super(amount);
        Paid = paid;
        Remaining = paid-Amount;
    }

    public void CalculateRemaining(){}

    @Override
    public String ViewRecite() {
        return "Payment Method: Cash\nPaid: " + Paid + "\nRemaining: " + Remaining;
    }
}
