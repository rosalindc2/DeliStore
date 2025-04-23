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

    public Item getItem(int index) //Allows you to get the item using it's index in list items 
    {
        if (index >= 0 && index < items.size())
        {
            return items.get(index);
        }
        return null;
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

    public Item checkIndex(int indexid)
    {
        return items.get(indexid);
    }


}
