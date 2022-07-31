package yummies.project.Controllers;

import javafx.scene.control.TextArea;
import yummies.project.Classes.IWorker;
import yummies.project.passer;


public class OrderRemaining {
    public TextArea ordersRemaining;

    public IWorker staff = passer.staff;

    public void initialize(){
        ordersRemaining.setText(staff.ViewOrdersRemaining());
    }
}
