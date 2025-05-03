public class Main 
{   
    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();
        Employee employee = new Employee(1234, inventory);
        employee.addItem("Hot Cheetos", 4.50, "Westside", 5, 5);



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

