class Item
{   // Instance variables for the item
    private String name;
    private double price;
    private String locationinstore; 
    private int qty; 
    private int sales;

    public Item(String name, double price, String locationinstore)
    {
        this.name = name; // Assigns the parameter 'name' to the instance variable 'name'
        this.price = price; // why? To store these values inside of the object to use later on. 
        this.locationinstore = locationinstore;
        this.qty = 0; // Default values for the quantity and sales, because none have been made yet.
        this.sales = 0; 
    }
// Basic get methods to retrive the item's name, price, location and quantity. 
    public String getName()
    {
        return name;
    }
    
    public double getPrice() 
    {
        return price;
    }

    public String getLocationinstore()
    {
        return locationinstore;
    }

    public int getStock()
    {
        return qty;
    }

    public int getSales()
    {
        return sales;
    }

    public void addSale() // We don't want it to return anything, void method 
    {
        sales++; // Increases the sales of the item by one 
    }
}