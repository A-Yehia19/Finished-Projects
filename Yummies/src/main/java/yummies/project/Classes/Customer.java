package yummies.project.Classes;

import java.util.ArrayList;

public class Customer extends Person{
    public ArrayList<Booking> Bookings;

    public Customer() {
         Bookings = new ArrayList<>();
    }

    public Customer(String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
        Bookings = new ArrayList<>();
    }

    public void SetBooking(Booking booking){
        this.Bookings.add(booking);
    }

    public String ViewBookings(){
        String s="";
        for (Booking booking:Bookings) {
            s+="MainDish: " +  booking.order.MainDish + "\n";
            s+="SideDish: " +  booking.order.SideDish + "\n";
            s+="Appetizer: " +  booking.order.Appetizer + "\n";
            s+="Dessert: " +  booking.order.Dessert + "\n";
            s+="Drink: " +  booking.order.Drink + "\n";
            s+="Price: " +  booking.order.Price + "\n";
            s+="Date: " +  booking.Date + "\n";
            s+="IsDelivery: " +  booking.IsDelivery + "\n";
            s+="Address: " + booking.Address + "\n";
            s+=booking.PaymentMethode.ViewRecite() + "\n\n";
        }
        return  s;
    }
}
