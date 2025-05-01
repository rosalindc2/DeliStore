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

    public void additemtocart(String name, int amount)
    {
        for (Item item : inventory.getItems())
        {
            if (item.getName().equals(name))
            {
                int qty = item.getStock();
                if (amount <= qty)
                {
                    Customer.CartItem newCartItem = new CartItem(name, amount);
                    cart.add(newCartItem);
                }
                else
                {
                    System.out.print("We currently don't have " + amount + " " + name + ".");
                    System.out.println(" However, we have " + qty + " currently in stock.");
                }
                return;
            }
        }
        System.out.print("This product is not avaliable in our store.");
    }

    public void removeItemfromcart(String name)
    {
        for (int i = 0; i < cart.size(); i++ )
            if (cart.get(i).getName().equals(name))
            {
                cart.remove(i);
            }
    }

    public void subtractamount(String name, int Amountsubtracted)
    {
        for (int i = 0; i < cart.size(); i++)
        {
            if (cart.get(i).getName().equals(name))
            {
                Customer.CartItem cartitem = cart.get(i);
                if (Amountsubtracted >= 0 && Amountsubtracted < cart.get(i).getAmount())
                {
                    for (int s = 0; s < Amountsubtracted; s++)
                    {
                        cartitem.subtractAmount();
                    }
                }
                else
                {
                    System.out.println("Please remove a valid amount");
                }
            }
        } 
    }

    public void addamount(String name, int Amountadded)
    {
        if(Amountadded <= 0)
        {
            System.out.println("Please add a valid amount.");
            return;
        }

        for (int i = 0; i < cart.size(); i++)
        {
            if (cart.get(i).getName().equals(name))
            {
                Customer.CartItem cartitem = cart.get(i);
                if (inventory.checkStock(name, Amountadded))
                {
                    for (int s = 0; s < Amountadded; s++)
                    {
                        cartitem.addAmount();
                    }
                }
            }
        } 
    }

private class CartItem 
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
