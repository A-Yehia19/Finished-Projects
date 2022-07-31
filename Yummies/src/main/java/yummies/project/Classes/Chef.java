package yummies.project.Classes;

import java.util.ArrayList;

public class Chef extends Staff implements IWorker {
    public ArrayList<Booking> OrdersID = new ArrayList<>();
    public ArrayList<Booking> Finished = new ArrayList<>();

    public Chef() {}

    public Chef(String name, String phoneNumber, String address, int ID, double salary) {
        super(name, phoneNumber, address, ID, salary);
    }


    @Override
    public void Work(int OrderID) {
        Finished.add(OrdersID.get(OrderID));
        OrdersID.remove(OrderID);
    }
    @Override
    public String ViewOrdersRemaining() {
        String s = "";
        for (int counter = 0; counter < OrdersID.size(); counter++) {
            s += "Main Dish: " + OrdersID.get(counter).order.MainDish + "\n";
            s += "Side Dish: " + OrdersID.get(counter).order.SideDish + "\n";
            s += "Appetizer: " + OrdersID.get(counter).order.Appetizer + "\n";
            s += "Drink: " + OrdersID.get(counter).order.Drink + "\n";
            s += "Dessert: " + OrdersID.get(counter).order.Dessert + "\n\n";
        }
        return s;
    }
}
