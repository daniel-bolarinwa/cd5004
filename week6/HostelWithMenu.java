
import java.text.NumberFormat;



/**GUI for the Hostel application
  *@author Charatan and Kans
  *@version 7th April 2018
  */
public class HostelWithMenu 
{  
  //   static int noOfRoomsIn;
  //   static TenantList list;

     
    public static void main(String[] args)
    {
        
        int rooms;
        TenantList list;

     
     System.out.print("Enter number of rooms: ");
     rooms = EasyScanner3.nextInt(); // call private method 
	 	// initialise tenant list
     list  = new TenantList(rooms);   
     TenantFileHandler.readRecords(list);
     
     char choice;
     do
     {   
        System.out.println();
        System.out.println("1. Add Tenant");
        System.out.println("2. Display Tenants");
        System.out.println("3. Remove Tenant");
        System.out.println("4. Make Payment");
        System.out.println("5. List Payments");
        System.out.println("6. Save and Quit");
        System.out.println();
        System.out.print("Enter choice (1-6): ");
        choice = EasyScanner3.nextChar();
        System.out.println();
        
        switch(choice)
        {
            case '1': addHandler(rooms,list);
                      break;
            case '2': displayHandler(list);
                      break;
            case '3': removeHandler(rooms,list);
                      break;
            case '4': paymentHandler(rooms,list);
                      break;
            case '5': listHandler(rooms,list);
                      break;
            case '6': saveAndQuitHandler(rooms,list);
                      break;
            default: System.out.println("Enter 1-6 only");
                      
        }
     }while(choice!= '6');
        
        
    }

    
    

    /**
     * Method to request number of hostel rooms from the user
     * @return number of rooms
     */


    static void addHandler(int noOfRoomsIn, TenantList listIn)
    {
        
        System.out.println("Enter room number: ");
        int roomEntered = EasyScanner3.nextInt();
        System.out.println("Enter name: ");
        String nameEntered = EasyScanner3.nextString();
     
        if(roomEntered < 1 || roomEntered > noOfRoomsIn)
        {
            System.out.println ("There are only "  + noOfRoomsIn  + " rooms");
        } 
        else if(listIn.search(roomEntered) !=  null)
        {
            System.out.println("Room number "  + roomEntered  + " is occupied");
        }
        else  // ok to add a Tenant
        {
            Tenant t =  new Tenant(nameEntered,roomEntered);
            listIn.addTenant(t);
            System.out.println("New tenant in room " 	+  roomEntered +  " successfully added");
        }
    }
    
    static void displayHandler(TenantList listIn)
    {
        int i;
        if(listIn.isEmpty()) // no rooms to display
        {
            System.out.println("All rooms are empty");
        } 
        else // display rooms
        {
            System.out.println("Room" +  "\t" +  "Name" +  "\n");
            for(i = 1; i <=  listIn.getTotal(); i++ )
            {
                System.out.println(listIn.getTenant(i).getRoom() 
                                        + "\t\t" 
                                        + listIn.getTenant(i).getName());
            }
        }
    }
    
  static void removeHandler(int noOfRoomsIn, TenantList listIn)
    {
        System.out.println("Enter room number: ");
        int roomEntered = EasyScanner3.nextInt();
        // check for errors
        if(roomEntered < 1 || roomEntered>noOfRoomsIn)
        {
            System.out.println("Invalid room number");
        } 
        else if(listIn.search(roomEntered)== null)
        {
            System.out.println("Room number " +  roomEntered +  " is empty");
        } 
        else // ok to remove Tenant
        {
            listIn.removeTenant(roomEntered);
            System.out.println("Tenant removed from room " +  roomEntered);
        }
    }
    
    static void paymentHandler(int noOfRoomsIn, TenantList listIn)
    {
        System.out.println("Enter room number: ");
        int roomEntered = EasyScanner3.nextInt();
        System.out.println("Enter month: ");
        String monthEntered = EasyScanner3.nextString();
        System.out.println("Enter amount: ");
        double amountEntered = EasyScanner3.nextDouble();
      
        // check for errors
      
        if(roomEntered < 1 || roomEntered>noOfRoomsIn)
        {
            System.out.println("Invalid room number");
        } 
        else if(listIn.search(roomEntered) == null)
        {
            System.out.println("Room number " +  roomEntered +  " is empty");
        } 
        else // ok to process payment
        {
            Payment p =  new Payment(monthEntered,amountEntered);
            listIn.search(roomEntered).makePayment(p);
            System.out.println("Payment recorded");
        }
    }
    
    static void listHandler(int noOfRoomsIn, TenantList listIn)
    {
        int i;
        System.out.println("Enter room number: ");
        int roomEntered = EasyScanner3.nextInt();
        // check for errors
        if(roomEntered < 1 || roomEntered > noOfRoomsIn)
        {
            System.out.println("Invalid room number");
        } 
        else if(listIn.search(roomEntered) == null)
        {
            System.out.println("Room number " + roomEntered + " is empty");
        } 
        else // ok to list payments
        {
            Tenant t =  listIn.search(roomEntered);
            PaymentList p  = t.getPayments();
            if(t.getPayments().getTotal() == 0)
            {
                System.out.println("No payments made for this tenant");
            } 
            else
            {  
                // The NumberFormat class is similar to the DecimalFormat class that we previously.
                //   The getCurrencyInstance method of this class reads the system values to find out 				     
              //  which country we are in, then uses the correct currency symbol 
                NumberFormat nf =  NumberFormat.getCurrencyInstance();
                String s;
                System.out.println("Month" +  "\t\t" +  "Amount" +  "\n");
                for(i =  1; i <=  p.getTotal(); i++  )
                {
                    s =  nf.format(p.getPayment(i).getAmount());
                    System.out.println("" + p.getPayment(i).getMonth() +  "\t\t\t" + s);
                } 
                System.out.println("\n" + "Total paid so far :   " + 	nf.format(p.calculateTotalPaid()));
             } 
       } 
    }
    
    static void saveAndQuitHandler(int noOfRoomsIn, TenantList listIn)
    {
               TenantFileHandler.saveRecords(noOfRoomsIn,listIn);
    }
    

}


