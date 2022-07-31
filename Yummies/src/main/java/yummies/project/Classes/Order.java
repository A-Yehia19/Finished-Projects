package yummies.project.Classes;

public class Order{
    public String Appetizer;
    public String MainDish;
    public String SideDish;
    public String Dessert;
    public String Drink;
    public double Price;

    public Order() {
        this.Appetizer = "";
        this.MainDish = "";
        this.SideDish = "";
        this.Dessert = "";
        this.Drink = "";
        this.Price = 0;
    }

    public void SetOrder(String MainDish, String SideDish, String Appetizer, String Dessert, String Drink, double Price){
        this.MainDish=MainDish;
        this.SideDish=SideDish;
        this.Appetizer=Appetizer;
        this.Dessert=Dessert;
        this.Drink=Drink;
        this.Price=Price;
    }
}
