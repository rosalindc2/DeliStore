public class Main 
{   
    public static void main(String[] args)
    {
        // Example #1 & Example #2 
        Inventory inventory = new Inventory();
        Employee employee = new Employee(1234, inventory);
        employee.checkvalidid(1234); //Needed, without checking my id, It would say access 
        //denied. or return a default value. 
        employee.addItem("Hot Cheetos", 4.50, "Westside", 5, 2 );
        System.out.println(inventory.getItems()); // To check if it was sucessfully added.
        System.out.println(employee.getCurrentmonth()); // Currently January (Default)
        employee.updateCurrentmonth(3); //Adds 3 months, Now april 
        System.out.println(employee.getCurrentmonth()); //To check if the months were changed 
        System.out.println(employee.getMonthlyrate("Hot Cheetos")); // Finds the sale rate per 
        // month. Sales/Months 

        // Extra 
        employee.addItem("Arizona Sweet Tea", 1.50, "Eastside", 2, 3);
        System.out.println(employee.getdisplaytable());  // Shows everything in Inventory 

        //Example 3
        Customer customer = new Customer(inventory);
        customer.additemtocart("Hot Cheetos", 2);
        customer.additemtocart("Arizona Sweet Tea", 1); 
        System.out.println(customer.getCart()); //To check if they were successfully added. 

        System.out.println(employee.totalcartPrice(customer));

        //Example 4
        customer.removeItemfromcart("Hot Cheetos");
        System.out.println(customer.getCart()); // To check if it was successfully removed.
        customer.addamount("Arizona Sweet Tea", 3);
        System.out.println(customer.getCart()); // To check if it was successfully changed.
        customer.addamount("Arizona Sweet Tea", 1);
        System.out.println(customer.getCart());
        customer.subtractAmount("Arizona Sweet Tea", 1);
        System.out.println(customer.getCart());
        System.out.println(customer.reccomendations("sweet"));

        //Example 5
        System.out.print(customer.findLocation("Arizona Sweet Tea"));

        
        







        /* Inventory inventory = new Inventory();
        inventory.addItem("Hot Cheetos", 4.50, "Westside", 5, 3);
        System.out.println(inventory.getItems()); //Testing out .addItem
        inventory.removeStock("Hot Cheetos", 3);
        System.out.println(inventory.getItems()); //Testing out .removeStock 
        System.out.println(inventory.checkStock("Hot Cheetos", 1)); //Checks if there are 1 bag of 

        Customer customer = new Customer(inventory);
        customer.additemtocart("Hot Cheetos",1);
        System.out.println(customer.getCart());
        
        inventory.subtractItem("Hot Cheetos");
        System.out.println(inventory.getItems()); //Testing out .subtractItem */

    

        
    }

}

