/** Class used to record the details of a tenant
 *  @author Daniel Bolarinwa
 */

public class Emergency {
    private int id;
    private String requiredService;
    private String description;
    private String location;
    public Caller callerDetails;

    public Emergency(int idIn, String descriptionIn, String locationIn) {
        id = idIn;
        description = descriptionIn;
        location = locationIn;
    }

    public void setService(String serviceIn) {
        requiredService = serviceIn;
    }

    public void setDescription(String descriptionIn) {
        description = descriptionIn;
    }

    public void setLocation(String locationIn) {
        location = locationIn;
    }

    public String getRequiredService() {
        return requiredService;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public void setCallerDetails(Caller callerIn) {
        callerDetails = callerIn;
    }

    public Caller getCallerDetails() {
        return callerDetails;
    }

    public int getId() {
        return id;
    }

    @Override
	public String toString()
   {
        return "("  + requiredService + ", " + description  + ", " + location  + ")";
   }
}
