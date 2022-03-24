/** Class used to record the details of an Emergency
 *  @author Daniel Bolarinwa
 */

public class Emergency {
    private int id;
    private String requiredService;
    private String description;
    private String location;
    public Caller callerDetails;
    public Status status;
    public enum Status {
        PENDING,
        RESOLVED;
    }

    public Emergency(int idIn, String descriptionIn, String locationIn) {
        id = idIn;
        description = descriptionIn;
        location = locationIn;
        status = Status.PENDING;
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

    @Override
	public String toString()
   {
        return "("  + requiredService + ", " + description  + ", " + location  + ")";
   }
}
