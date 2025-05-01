import java.util.ArrayList;

public class Employee 
{
    private int currentMonth = 1;
    private int id;
    private boolean valid;
    private Inventory inventory;

    public Employee(int id, Inventory inventory)
    {
        this.inventory = inventory;
        this.id = id;
    }

    public boolean checkvalidid(int id)
    {
        if (id == 1234 || id == 4567)
        {
            valid = true;
            return true;
        }
        valid = false;
        return false;
    }

    public int getCurrentmonth()
    {
        if (valid == true)
        {
            return currentMonth;
        }
    return 0;
    }

    public void updateCurrentmonth(int amount) // Used later to determine sale rate per month, allows for this info to be updated. 
    {
        if (valid == true)
        {
            currentMonth = currentMonth + amount;
        }
    }
    
    public double getMonthlyrate(String name)
    {
        if (valid)
        {
            if (currentMonth == 0)
            {
                return 0;
            }
    
            for (int i = 0; i < inventory.getItems().size(); i++)
            {
                if (inventory.getItems().get(i).getName().equals(name))
                return (double) inventory.getItems().get(i).getSales()/ currentMonth;
            }
        }
        return 0;
    }
    // Just allowing the Employee to access every inventory method
    public void addItem(String name, double price, String location, int stock, int sales)
    {
        if (valid)
        inventory.addItem(name, price, location, stock, sales);
        else 
        System.out.print("Access Denied.");
    }

    public void subtractItem(String name, double price, String location, int stock, int sales)
    {
        if (valid)
        inventory.subtractItem(name);
        else 
        System.out.print("Access Denied.");
    }

    public void removeStock(String name, int qtysubtract)
    {
        if (valid)
        inventory.removeStock(name, qtysubtract);
        else 
        System.out.print("Access Denied.");
    }

    public void addStock(String name, int qtyadd)
    {
        if (valid)
        inventory.addStock(name, qtyadd);
        else 
        System.out.print("Access Denied.");
    }

    public boolean checkStock(String name, int amount)
    {
        if (valid)
        inventory.checkStock(name, amount);
        else 
        System.out.print("Access Denied.");
        return false;
    }

    public String getIndexid(String name)
    {
        if (valid)
        inventory.getIndexid(name);
        else 
        System.out.print("Access Denied.");
        return null;
    }

    public Item getItem(int indexid)
    {
        if (valid)
        inventory.getItem(indexid);
        else 
        System.out.print("Access Denied.");
        return null;
    }

    public ArrayList<ArrayList<String>> getdisplaytable()
    {
        if (valid)
        inventory.getdisplaytable();
        
    return null;
    }
}



