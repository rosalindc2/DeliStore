import java.util.ArrayList;
public class Customer 
{
    private Inventory inventory;
    private ArrayList<CartItem> cart;

    public Customer(Inventory inventory)
    {
        this.cart = new ArrayList<>();
        this.inventory = inventory;
    }

    public ArrayList<CartItem> getCart()
    {
        return cart;
    }

    public void additemtocart(String name, int amount) {
        for (int i = 0; i < inventory.getItems().size(); i++) 
        {
            Item item = inventory.getItems().get(i); 
             if (item.getName().equals(name)) //Checks if item name  is in the inventory 
             {
                int qty = item.getStock(); 
                if (amount <= qty) // Checks if the amount you want to add is more than avaliable stock. 
                {

                    Customer.CartItem newCartItem = new CartItem(name, amount);
                    cart.add(newCartItem); // If so, it adds it to your cart. 
                } else 
                {
                    System.out.print("We currently don't have " + amount + " " + name + ".");
                    System.out.println(" However, we have " + qty + " currently in stock.");
                }
            }
            else
            {
                System.out.print("This product is not available in our store.");
            }
        }
    }
    
    public void removeItemfromcart(String name)
    {
        for (int i = 0; i < cart.size(); i++ )
            if (cart.get(i).getName().equals(name))
            {
                cart.remove(i);
            }
    }

    public void subtractAmount(String name, int Amountsubtracted) 
    {
        for (int i = 0; i < cart.size(); i++) 
        {
            if (cart.get(i).getName().equals(name)) 
            {
                Customer.CartItem cartItem = cart.get(i);
                if (Amountsubtracted >= 0 && Amountsubtracted <= cart.get(i).getAmount()) 
                {
                    cartItem.amount -= Amountsubtracted;  // Subtract the amount directly
                } else 
                {
                    System.out.println("Please remove a valid amount");
                }
            }
        }
    }

    public void addamount(String name, int Amountadded)
    {
        if(Amountadded <= 0) // You can't add 0, it wouldn't do anything. 
        {
            System.out.println("Please add a valid amount.");
            return;
        }

        for (int i = 0; i < cart.size(); i++)
        {
            if (cart.get(i).getName().equals(name)) 
            {
                Customer.CartItem cartitem = cart.get(i);
                if (inventory.checkStock(name, Amountadded)) // Checks if this amount is avaliable Inventory-wise
                {
                    for (int s = 0; s < Amountadded; s++) // There's a simpler way to do this idk why I did 
                    // It this way... 
                    {
                        cartitem.addAmount(); // This adds one to amount in the cart item. 
                    }
                }
            }
        } 
    }

    public String reccomendations(String mood)
    {
        if (mood.equals("sweet"))
        {
            return "You should have some candy.";
        }
        if (mood.equals("spicy"))
        {
            return "You should have some spicy chips.";
        }
        if (mood.equals("salty"))
        {
            return "You should have some classic chips ";
        }
        if (mood.equals("neutral"))
        {
            return "Try our most popular items!";
        }
        return "Please enter in a valid preference. (sweet, spicy, salty or neutral)";
    }

    public String findLocation(String name) 
    {
        for (int i = 0; i < cart.size(); i++) 
        {
            CartItem cartItem = cart.get(i);
            if (cartItem.getName().equals(name)) // Checks if item is in the cart
            {
                for (int j = 0; j < inventory.getItems().size(); j++) 
                {
                    Item item = inventory.getItems().get(j); //Checks if item is in the inventory 
                    if (item.getName().equals(name)) 
                    {
                        return item.getLocationinstore(); // Returns location of that item 
                    }
                }
            }
        }
   return "Item not found in cart or inventory.";
    }
    

class CartItem 
{
    private String name;
    private int amount;

    public CartItem(String name, int amount)
     {
        this.name = name;
        this.amount = amount;
    }

    public String getName() 
    {
        return name;
    }

    public int getAmount() 
    {
        return amount;
    }

    public void addAmount() 
    {
        amount++;
    }
    public void subtractAmount()
    {
        amount--;
    }

    public String toString()
    {
            return "Item: " + name + " Amount: " + amount;
    }

}
}
