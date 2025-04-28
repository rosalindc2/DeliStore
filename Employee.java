import java.util.ArrayList;
public class Employee 
{
    private int currentMonth = 1;
    private int id;
    private Inventory inventory;

    public Employee(int id, Inventory inventory)
    {
        this.inventory = inventory;
        this.id = id;

    }

    public int getCurrentmonth()
    {
        return currentMonth;
    }

    public void updateCurrentmonth(int amount) // Used later to determine sale rate per month, allows for this info to be updated. 
    {
        currentMonth = currentMonth + amount;
    }
    
    public getMonthlyrate(String name)
    {
       
        return sales/currentMonth;
    }
}

