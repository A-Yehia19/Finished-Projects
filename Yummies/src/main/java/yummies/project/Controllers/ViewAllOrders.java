package yummies.project.Controllers;

import javafx.scene.control.TextArea;
import yummies.project.passer;

public class ViewAllOrders {
    public TextArea orderList;

    //3ashan tkoon malyana lwa7daha mn 8eer ay action
    public void initialize(){
        orderList.setText(passer.history);
    }
}
