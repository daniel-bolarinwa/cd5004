/** Class used to record the details of a Caller
 *  @author Daniel Bolarinwa
 */

public class Caller {
    private String fullName;
    private int age;
    private String address;
    
    public Caller(String nameIn, int ageIn, String addressIn) {
        fullName = nameIn;
        age = ageIn;
        address = addressIn;
    }

    public String getName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
	public String toString()
   {
            return fullName+", "+age +", "+address;
   }
}
