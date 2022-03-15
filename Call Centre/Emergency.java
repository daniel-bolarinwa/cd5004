/** Class used to record the details of a tenant
 *  @author Daniel Bolarinwa
 */

public class Emergency {
    private String requiredService;
    private String description;
    private String location;

    public Emergency(String serviceIn, String descriptionIn, String locationIn) {
        requiredService = serviceIn;
        description = descriptionIn;
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

    @Override
	public String toString()
   {
        return "("  + requiredService + ", " + description  + ", " + location  + ")";
   }
}
