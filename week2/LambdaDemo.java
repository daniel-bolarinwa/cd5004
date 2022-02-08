public class LambdaDemo
{
    public static void main(String[] args)
    {
        // create a test oblong
        Oblong testOblong = new Oblong (8,8); 
        // creat a test customer
        Customer testCustomer = new Customer("4jbb", "Teyah", 70); 

        // this checks if the customerId is valid
       System.out.println("customer is " + checkValidity(() ->{
           return Character.isLetter(testCustomer.getCustomerId().charAt(0)) && testCustomer.getCustomerId().length() == 4;
       }));
         
       // this checks that the sides are greater than zero
       System.out.println("oblong is " + checkValidity(() ->
                              {
                                 return testOblong.getLength() > 0 && testOblong.getHeight() > 0;
                              }
                         ));
       
       // this checks that the length and height are not equal
       System.out.println("oblong is " + checkValidity(() ->
                               {
                                 return testOblong.getLength() != testOblong.getHeight();
                               }
                            ));
    }
    
    private static String checkValidity(Checkable objectIn)
    {
        if(objectIn.check())
        {
            return "valid";
        }
        else
        {
            return "invalid";
        }
    }
}
