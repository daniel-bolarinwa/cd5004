/** Class used to record the details of a tenant
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

    // public void reportEmergency(Emergency emergencyIn) {
    //     addEmergency(emergencyIn); // reports a given emergency
    // }

    @Override
	public String toString()
   {
            return fullName+", "+age +", "+address;
   }
}
