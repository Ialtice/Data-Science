
/**
 * Customer class to create and display a customers last and first name along with ID and balance,compare them with other customers,
 * change the balance, and get the various field values
 * 
 * @author Isaac Altice
 * @version 6/14/2019
 */
public class Customer<T> implements Comparable<T>
{
   private String lastName;//Last name of customer
   private String firstName;//First name of customer
   private String custID;// customer ID number
   private double balance;// customer current balance
   /**
    * default customer constructor
    * fields all initialized to zero or null
   */
    public Customer()
    {
       lastName = firstName = custID = null;
       balance = 0.0;
    }
   /**
    * Customer constructor that accepts 4 parameters from user or data file
    * 
    * @param String inLast -Last name, String inFirst - first name, String inID -customer ID, double inBalance - customer current balance
    * 
    */
    public Customer(String inLast, String inFirst, String inID, double inBalance)
    {
      lastName = new String (inLast);
      firstName = new String(inFirst);
      custID = new String(inID);
      balance = inBalance;
   }
   /**
    * toString method displays the field values of a customer with a description
    * 
    * @return a string of the field values of a customer with a description
    */    
   public String toString( )
   {
       return "Last: " + lastName + " First: " + firstName + "\n" +
               "ID: " + custID + " Balance Owed " + balance;
   }
   /**
    * equals method that compares two customers ID numbers to see if they are equal
    * 
    * @param Object inOther -  a second customer object
    * @return true if customer ID's match or false if they dont
    */
   public boolean equals(Object inOther)
   {
       Customer cOther = (Customer)inOther;
       return this.custID.equals(cOther.custID);
   }
   /**
    * compareTo method - compares customers using their last name and if the last name is the same  will compare based on first name
    * 
    * @param T inCustomer -  a second customer object
    * @return int answer - a 0 if names are the same, a postive number if this customer's name has a greater value, a negative number if inCustomer has a greater value
    */
   public int compareTo( T inCustomer)
   {
        Customer compCust = (Customer)inCustomer;
        int answer = (this.lastName.compareToIgnoreCase(compCust.lastName));
        if(answer == 0)
        {
            answer = this.firstName.compareTo(compCust.firstName);
        }
        return answer;
   }
   /**
    * setBalance method takes in a decimal number and sets the customers balance to that number
    * 
    * @param double inAmountDue - a new dollar amount to set to the balance field
    * 
    */
   public void setBalance(double inAmountDue)
   {
      balance = inAmountDue;
   }
   /**
    * getLastName method returns the lastName field of a customer 
    * 
    * @return lastName field of customer
    */
   public String getLastName()
   {
       return lastName;
   }
   /**
    * getfirstName method returns the firstName field of a customer 
    * 
    * @return firstName field of customer
    */
   public String getFirstName()
   {
       return firstName;
   }
   /**
    * getCustID method returns the CustID field of a customer 
    * 
    * @return custID field of customer
    */
   public String getCustID()
   {
       return custID;
   }
   /**
    * getBalance method returns the balance field of a customer 
    * 
    * @return balance field of customer
    */
   public double getBalance()
   {
       return balance;
   }
}