
public class Checker
{
  public static void main(String[] args)
  {
    // create two oblongs
    CheckableOblong oblong1 = new CheckableOblong(10, 8); // valid
    CheckableOblong oblong2 = new CheckableOblong(0, 8); // invalid: first argument is zero
		
    // create three bank accounts

    CheckableBankAccount account1 = new CheckableBankAccount("12345678", "Smith"); // valid
    CheckableBankAccount account2 = new CheckableBankAccount("S1234567", "Patel"); // invalid: account number
                                                                                   // must contain digits only
    CheckableBankAccount account3 = new CheckableBankAccount("1234567", "Adewale"); // invalid: account number
                                                                         // must be 8 characters long

    CheckableCustomer customer1 = new CheckableCustomer("k234", "Smith", 34); // valid
    CheckableCustomer customer2 = new CheckableCustomer("dhgvhgbrj", "Patel", 577); // invalid: id must be 4 chartacters only
    CheckableCustomer customer3 = new CheckableCustomer("1234", "Adewale", 900); // invalid: id first character must be a letter
		

    // send objects to the checkValidity method 
    System.out.println("oblong1 is " + checkValidity(oblong1));
    System.out.println("oblong2 is " + checkValidity(oblong2));
             
    System.out.println("account1 is " + checkValidity(account1));
    System.out.println("account2 is " + checkValidity(account2));
    System.out.println("account3 is " + checkValidity(account3));

    System.out.println("customer1 is " + checkValidity(customer1));
    System.out.println("customer2 is " + checkValidity(customer2));
    System.out.println("customer3 is " + checkValidity(customer3));
  }

  private static String checkValidity(Checkable objectIn) // receives any Checkable object
  {
    if(objectIn.check())  // call the check method
    {
	return "valid";
    }
    else
    {
       return "invalid";			
    }
  }	
}

