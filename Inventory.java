import java.util.ArrayList;
public class Inventory
{
    private ArrayList<Item> items;

    public Inventory()
    {
        items = new ArrayList<>(); 
    }

    public ArrayList<Item> getItems() 
    {
        return items; //Returns the array list of items
    }

    public void addItem(String name, double price, String locationinstore, int qty, int sales)
    {
        Item newItem = new Item(name, price, locationinstore, qty, sales);  
        items.add(newItem); // Adds a new Item to the Item array list
    }

    public void subtractItem(String name)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(name))
            {
                items.remove(i); 
            }
        } 
    }

    public void removeStock(String name, int qtysubtract)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(name))
            {
                Item item = items.get(i);
                for (int s = 0; s < qtysubtract; s++)
                {
                    item.removeStock();
                }
            }
        } 
    }

    public void addStock(String name, int qtysubtract)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName().equals(name))
            {
                Item item = items.get(i);
                for (int s =0; s < qtysubtract; s++)
                {
                    item.addStock();
                }
            }
        } 
    }

      public boolean checkinstock(String name, int amount)
    {
        for(int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
           if(item.getName().equals(name))
           {
                int qty = item.getStock();
                if(amount <= qty)
                {
                    return true;
                }
           }
        }
        return false;
    } 


    public String getIndexid(String name) // Gets the index of the item, I use it because subtract item moves down the indexes by 1. 
    {                                     // Also, I use the index as sort of a changing identifier/ shortcut. 
        for (int i = 0; i < items.size(); i++) // Traverses through the array to find at what index name is at. 
        {
            if (items.get(i).getName().equals(name))
            return String.valueOf(i);
        }
        return "No Item Matches"; // In the case nothing matches the name. 
    }
// Basic get methods returning the indexid and months. 
    public Item getItem(int indexid) // To get the Item that corresponds with the indexid
    {
        return items.get(indexid); 
    }

    public ArrayList<ArrayList<String>> getdisplaytable() // A more completed overview of everything in a 2D arraylist. 
    {
        ArrayList<ArrayList<String>> displaytable = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) // For each row, get  
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

