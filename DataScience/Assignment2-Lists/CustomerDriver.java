import java.io.*;
import java.util.*;

/**
 * A program that takes text data from a file "customerdata.txt" and creates a list of customers ordered by name and then displays a menu of 
 * options that a user can do to the list that includes displaying the list, finding and dislaying a customer from entering their ID,
 * change a balance of a customer, delete a customer from a list, add a customer to the list, and update the "customerdata.txt" file with
 * the altered list
 * 
 *
 * @author (Isaac Altice)
 * @version (6/10/2019)
 */
public class CustomerDriver
{
    public static void main (String args[]) throws IOException
    {
        LinkedOrderedList<Customer> customerList = new LinkedOrderedList<Customer>(); //declares and initializes a list "customerList" of Customer objects ordered by name
        File file = new File("C:\\Users\\isaac\\Downloads\\customerdata.txt");//declares and initializes a file that contains the data for the customer list
        Iterator<Customer> it;// declares an iterator of Customer type
        Scanner in = new Scanner(file);// declares and initializes scanner to go through file data
        String targetID;// variable to hold Customer ID you are searching for
        Customer temp;// variable to hold a temporary Customer while going through customer list
        Customer target;//varaible to hold target customer
        boolean found;// variable to hold true or false value for searches or comparisons
        while(in.hasNextLine())// loop to go through every line of text file
        {
            StringTokenizer st = new StringTokenizer(in.nextLine(),",");//tokenizer st splits apart each line of text in file into correct parameters for new Cusomters in the list
            while(st.hasMoreTokens())//loop through st tokens using them as parameters for new customer objects
            {
                customerList.add(new Customer(st.nextToken(),st.nextToken(),st.nextToken(),//adds newly created customers to customerList
                Double.parseDouble(st.nextToken())));
            }
        }
        int choice = 0;// holds menu choice from user
        do{//program continues until menu choice "0" is entered
            menu();// displays menu 
            in = new Scanner(System.in);//scanner to get user menu choice and other inputs
            System.out.println("\nMenu number choice: ");// ask user for menu number choice and sets choice variable to number inputed
            choice = in.nextInt();
            switch(choice)//for menu number options
            {
                case 0://if choice = 0, exits the program and displays goodbye
                    System.out.println("\nGoodbye");
                    break;
                case 1 ://if choice = 1, display all customers in list
                    System.out.println(customerList.toString());
                    break;
                case 2 ://if choice = 2, find customer by the user entering an ID
                    in = new Scanner(System.in);//initialize scanner for user input
                    
                    System.out.println("\nEnter the Customer ID you want to search for : ");//ask user for Customer ID they want to find and sets to variable targetID
                    targetID = in.nextLine();
                    target = new Customer("temp","temp",targetID,0.00);//creates a temporary Customer for comparing to customers in list with the search ID
                    it = customerList.iterator();//initializes new iterator for customer list
                    found = false;//starting value for have we found target customer is set to false
                    while(it.hasNext() && !found)//iterator loops through customer list until list has ended or it finds the target customer
                    {
                        temp = it.next();
                        if(temp.equals(target))//if target customer is found its fields is displayed with description and loop ends
                            {
                                System.out.println(temp.toString());
                                found = true;
                            }
                        if(!it.hasNext() && !found)//if target customer is not found display message to suer
                            System.out.println("Customer not found"); 
                    }
                    break;
                case 3 ://if menu choice = 3 change customer balance field
                    
                    in = new Scanner(System.in);//initializes scanner
                    
                    System.out.println("\nEnter the Customer ID you want to change the balance of : ");//asks user for customer ID of the customer they want to change the balance of
                    targetID = in.nextLine();
                    target = new Customer("temp","temp",targetID,0.00);//temporary customer created with ID they want to find
                    it = customerList.iterator();//initizlizes iterator for customer list
                    found = false;//set found customer to false
                    while(it.hasNext() && !found)//loop through customer list until target customer ID is found or end of list is reached
                    {
                        temp = it.next();
                        if(temp.equals(target))// when iterator finds target custmer ask user for new balance for the customer
                            {
                                System.out.println("Enter the new customer balance: ");
                                double newBalance = in.nextDouble();
                                temp.setBalance(newBalance);//change customer Balance field
                                System.out.println(temp.toString());//display to user change
                                found = true;//exit loop condition
                            }
                        if(!it.hasNext() && !found)
                            System.out.println("Customer not found"); //dsplays message to user that customer was not found
                    }
                    
                    break;
                case 4 ://if menu choice = 4, delete customer from list and display list
                    in = new Scanner(System.in);//initialize scanner for user input
                    System.out.println("\nEnter the Customer ID you wish to delete from the list");// ask user for customer ID to search for ,get input, and create temporary customer for search
                    targetID = in.nextLine();
                    target = new Customer("temp","temp",targetID,0.00);
                    it = customerList.iterator();//initializes iterator for Customer list
                    found = false;// set found target customer to false
                    while(it.hasNext() && !found)//loop through list until target customer is found or 
                    {
                        temp = it.next();
                        if(temp.equals(target))// when target is found display customer to user and then delete from list and display full list
                            {
                               System.out.println(temp.toString() + "\nhas been removed\n");
                               customerList.remove(temp);
                               System.out.println(customerList.toString());
                               it =customerList.iterator();//initializes iterator for Customer list after change
                               found = true;
                            }
                        if(!it.hasNext() && !found)//if target is not found display customer not found message
                            System.out.println("Customer not found"); 
                    }
                    break;
                case 5 ://add new customer
                    in = new Scanner(System.in);//initialize scanner for user input
                    String inLastName, inFirstName, inID;//varaibles to hold user inputs for new customer construction
                    double inBalance;
                    
                    System.out.println("\nEnter the new customers Last name: ");//ask the user for each parameter for new customer construction and set to variables
                    inLastName = in.nextLine();
                    System.out.println("Enter the new Customers First name: ");
                    inFirstName = in.nextLine();
                    System.out.println("Enter the new Customers ID: ");
                    inID = in.nextLine();
                    System.out.println("Enter the new Customers Balance: ");
                    inBalance = in.nextDouble();
                    customerList.add(new Customer(inLastName, inFirstName, inID, inBalance));//construct new customer from user inputs and add to customer list
                    System.out.println("Customer added\n");//displays customer added message and altered list
                    System.out.println(customerList.toString());
                    break;
                case 6 ://write altered customer list to data file
                    PrintWriter alterData = new PrintWriter(file);//declare printwriter and initialize for data file "customerdata.txt"
                    it = customerList.iterator();//initialize iterator for current customerList
                    while(it.hasNext())//loop through customer list until end
                    {
                        temp = it.next();//iterate through list setting each customer to temp and writing all customer field data to file
                        alterData.println(temp.getLastName() + "," + temp.getFirstName() + ","
                        + temp.getCustID() + "," + temp.getBalance() );
                        
                    }
                    alterData.close();//close the printwriter
                    System.out.println("Data file customerdata.txt has been saved with altered customer List");  
                    break;
                default://if menu choice number is not a menu option display message to user
                    System.out.println("Invalid menu choice");
            }
            
        }while(choice !=0);
    }
    /**
     * menu method to ask user for menu number and display all menu options
     * 
     */
    public static void menu()
    {
        System.out.print("\nPlease enter a menu number from below"
        + "\n1. Display all the Customers" + "\n2. Find customer by ID"
        + "\n3. Change Customer balance" + " \n4. Delete a Customer"
        + "\n5. Add a new Customer" + "\n6. Write altered Customer list to data file"
        + "\n0. Exit");
    }
}
