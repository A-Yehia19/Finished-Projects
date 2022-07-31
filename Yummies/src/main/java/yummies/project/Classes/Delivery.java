package yummies.project.Classes;

import java.util.ArrayList;

public class Delivery extends Staff implements IWorker{
    public ArrayList<Booking> Finished = new ArrayList<>();
    public ArrayList<Booking> Delivered = new ArrayList<>();

    public Delivery() {}

    public Delivery(String name, String phoneNumber, String address, int ID, double salary) {
        super(name, phoneNumber, address, ID, salary);
    }

    @Override
    public void Work(int OrderID) {
        Delivered.add(Finished.get(OrderID));
        Finished.remove(OrderID);
    }

    @Override
    public String ViewOrdersRemaining(){
        String s = "";

        for (int counter = 0; counter < Finished.size(); counter++) {
            s += "Main Dish: " + Finished.get(counter).order.MainDish + "\n";
            s += "Side Dish: " + Finished.get(counter).order.SideDish + "\n";
            s += "Appetizer: " + Finished.get(counter).order.Appetizer + "\n";
            s += "Drink: " + Finished.get(counter).order.Drink + "\n";
            s += "Dessert: " + Finished.get(counter).order.Dessert + "\n";
            s += "delivery: " + Finished.get(counter).IsDelivery +"\n";
            s += "Address: " + Finished.get(counter).Address + "\n";
            s += "Payment Method: " + Finished.get(0).PaymentMethode.ViewRecite()+ "\n\n";
        }

        return s;
    }
}
