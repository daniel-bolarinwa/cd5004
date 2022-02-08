public class CheckableCustomer extends Customer implements Checkable{
    // override the constructor
    public CheckableCustomer(String IdIn, String nameIn, double limitIn)
    {
        super(IdIn, nameIn, limitIn);
    }
    
    @Override
    public boolean check()
    {
        // check that the account number is exactly 8 characters long
        if(getCustomerId().length() != 4) 
        {
            return false;
        }
        
        // check that the account number contains only digits
        if(!Character.isLetter(getCustomerId().charAt(0)))
        {
            return false;
        }   
        return true;
    }
}