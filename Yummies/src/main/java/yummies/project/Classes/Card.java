package yummies.project.Classes;

public class Card extends Payment {
    public int CardNumber;
    public String Password;
    public String ExpiryDate;

    public Card() {}

    public Card(double amount, int cardNumber, String password, String expiryDate) {
        super(amount);
        CardNumber = cardNumber;
        Password = password;
        ExpiryDate = expiryDate;
    }

    @Override
    public String ViewRecite() {
        return "Payment Method: Card\nCard No.: " + CardNumber;
    }
}
