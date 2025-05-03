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
        if (valid)
        {
            return currentMonth;
        }
    return 0;
    }

    public void updateCurrentmonth(int amount) // Used later to determine sale rate per month, 
    //allows for this info to be updated. 
    {
        if (valid)
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
                return (double) inventory.getItems().get(i).getSales()/ currentMonth; //Divides number of sales by 
                //month to get the rate. 
            }
        }
        return 0;
    }

    public ArrayList<Item> monthlyrank()
    {
        ArrayList<Item> rankedItems  = new ArrayList<>(inventory.getItems()); // Duplicates the inventory list to
        // rankeditems list
        for (int i = 0; i < rankedItems.size() - 1; i++)
        { 
            int maxindex = i;
            for (int frontindex = i + 1; frontindex < rankedItems.size(); frontindex++)
            {
                double frontsalesrate = getMonthlyrate(rankedItems.get(frontindex).getName());
                double salesratemax = getMonthlyrate(rankedItems.get(maxindex).getName()); 
                if (frontsalesrate > salesratemax)
                {
                    maxindex = frontindex;
                }
                if (maxindex != i)
                {
                    // Selection sort, Max index items go in the start of the list. 
                    Item temp = rankedItems.get(i); // Stores the item at i into temp item 
                    rankedItems.set(maxindex, rankedItems.get(i)); // Replaces item at i with the item at max index  
                    rankedItems.set(i, temp); // Replaces item at maxindex with item at i
                }
            }
        }
        return rankedItems;
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
        return inventory.checkStock(name, amount);
        else 
        System.out.print("Access Denied.");
        return false;
    }

    public String getIndexid(String name)
    {
        if (valid)
        return inventory.getIndexid(name);
        else 
        System.out.print("Access Denied.");
        return null;
    }

    public Item getItem(int indexid)
    {
        if (valid)
        return inventory.getItem(indexid);
        else 
        System.out.print("Access Denied.");
        return null;
    }

    public double calculatePrice(String name, int amount)
    {
        if (valid)
        return inventory.calculatePrice(name, amount);
        else 
        System.out.print("Access Denied.");
        return 0;
    }

    public double totalcartPrice(Customer customer)
    {
        if (valid)
        {
            double totalPrice = 0.0;
            for (Customer.CartItem item : customer.getCart())
            {
                totalPrice += inventory.calculatePrice(item.getName(), item.getAmount());
            }
            return totalPrice;
        }
        else
        {
            System.out.print("Access Denied.");
            return 0;
        }
    }

    public ArrayList<ArrayList<String>> getdisplaytable()
    {
        if (valid)
        return inventory.getdisplaytable();
        
    return null;
    }
}



