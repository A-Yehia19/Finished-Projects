package yummies.project.Classes;

import java.util.Date;

public class Booking {
    public int BookingID;
    public Payment PaymentMethode;
    public String Date;
    public boolean IsDelivery;
    public String Address;
    public Order order;

    public Booking() {
        BookingID = 0;
        this.Date = String.valueOf(new Date());
        IsDelivery = false;
        Address = "";
        PaymentMethode = new Cash(0,0);
        order = new Order();
    }

    public Booking(int bookingID, String paymentMethode, String date, boolean isDelivery, String address) {
        BookingID = bookingID;
        this.Date = String.valueOf(new Date());
        IsDelivery = isDelivery;
        Address = address;
        if (paymentMethode.toUpperCase().equals("CASH")){
            PaymentMethode = new Cash();
        }else{
            PaymentMethode = new Card();
        }
        order = new Order();
    }
}
