package yummies.project.Classes;

import java.util.ArrayList;
import java.util.Objects;

public class Manager extends Staff{
    private static Manager myManager;

    public ArrayList<Staff>staff;

    private Manager() {
       staff = new ArrayList<>();
    }

    public static Manager GetManager() {
        if (myManager == null) {
            synchronized (Manager.class) {
                if (myManager == null) {
                    myManager = new Manager();
                }
            }
        }
        return myManager;
    }


    public void Add(int ID, double Salary,String Type,String name){
        if(Objects.equals(Type, "chef"))
        {
            Chef chef=new Chef(name,"090","hena",ID,Salary);
            staff.add(chef);
        }
        else{
            Delivery delivery=new Delivery(name,"909","henak",ID,Salary);
            staff.add(delivery);
        }

    }

    public void Remove(int ID){
        for (int i = 0; i < staff.size(); i++) {
            if(staff.get(i).ID==ID)
                staff.remove(i);
        }
    }

    public String ViewStaffSalary(){
        String s = "";
        for (int counter = 0; counter < staff.size(); counter++) {
            s+="ID: "+staff.get(counter).ID+"\n";
            s+="Name: "+staff.get(counter).Name+"\n";
            s+="Salary: "+staff.get(counter).Salary+"\n\n";
        }
        return s;
    }
}
