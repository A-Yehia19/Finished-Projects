package yummies.project.Controllers;

import javafx.scene.control.TextArea;
import yummies.project.Classes.Manager;

public class StaffSalary {
    public TextArea Salaries;

    public void initialize(){
        Salaries.setText(Manager.GetManager().ViewStaffSalary());
    }
}
