import java.util.ArrayList;
public class Inventory
{
    private ArrayList<Item> items;
    private int currentMonth;
    private int indexid;

    public Inventory()
    {
        items = new ArrayList<>();
        currentMonth = 1; // January is the first month 
    }

    public ArrayList<Item> getItems() 
    {
        return items; //Returns the array list of items
    }

    public void addItem(String name, double price, String locationinstore)
    {
        Item newItem = new Item(name, price, locationinstore);
        items.add(newItem);
    }

    public void subtractItem(String name, double price, String locationinstore)
    {
        Item newItem = new Item(name, price, locationinstore);
        items.remove(newItem);
    }

    public String getIndexid(String name)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(name))
            return String.valueOf(i);
        }
        return "No Item Matches";
    }

    public Item getItem(int indexid)
    {
        return items.get(indexid);
    }

    public int getCurrentmonth()
    {
        return currentMonth;
    }

    public void updateCurrentmonth(int amount)
    {
        currentMonth = currentMonth + amount;
    }

    public ArrayList<ArrayList<String>> displaytable;
    {
        ArrayList<ArrayList<String>> displaytable = new ArrayList<ArrayList<String>> displaytable 
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
            ArrayList<String> row = new ArrayList<>();
            row.add("Name: " + item.getName());
            row.add("Price: " + item.getPrice());
            row.add("Stock: " + item.getStock());
            row.add("Sales: " + item.getSales());
            row.add("Index: " + i);
            row.add("Location: " +  item.getLocationinstore());
            displaytable.add(row);
        }
        return displaytable;
    }
}
