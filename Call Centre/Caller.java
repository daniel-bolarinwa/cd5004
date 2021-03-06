/** Class used to record the details of a Caller
 *  @author Daniel Bolarinwa
 */

public class Caller {
    private String fullName;
    private int age;
    private String phoneNumber;
    
    public Caller(String nameIn, int ageIn, String phoneNumberIn) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String displayCallerDetails() {
        return "Full Name: " + fullName + " Age: " + age + " Phone number: " + phoneNumber;
    }

    @Override
	public String toString()
   {
        return fullName + ";" + age + ";" + phoneNumber;
   }
}
