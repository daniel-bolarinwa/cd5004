/** Class used to record the details of a Caller
 *  @author Daniel Bolarinwa
 */

public class Caller {
    private String fullName;
    private int age;
    private long phoneNumber;
    
    public Caller(String nameIn, int ageIn, long phoneNumberIn) {
        fullName = nameIn;
        age = ageIn;
        phoneNumber = phoneNumberIn;
    }

    public String getName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
	public String toString()
   {
            return fullName + ";" + age + ";" + phoneNumber;
   }
}
