/** Class used to record the details of an Emergency
 *  @author Daniel Bolarinwa
 */

import java.time.*;

public class Emergency {
    public int id;
    public boolean fireBrigade;
    public boolean police;
    public boolean ambulance;
    private String description;
    private String location;
    public Caller callerDetails;
    public LocalDateTime dateRaised; 
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
        dateRaised = LocalDateTime.now();
        fireBrigade = false;
        police = false;
        ambulance = false;
    }

    public void setDescription(String descriptionIn) {
        description = descriptionIn;
    }

    public void setLocation(String locationIn) {
        location = locationIn;
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

    public void displayEmergencyDetails() {
        System.out.printf("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n", 
                        id, 
                        fireBrigade, 
                        police, 
                        ambulance, 
                        description, 
                        location, 
                        dateRaised.toString(), 
                        status.toString(), 
                        callerDetails.displayCallerDetails()
        );
    }

    @Override
	public String toString()
   {
        return id + "," + fireBrigade + "," + police + "," + ambulance + "," + description  + "," + location  + "," + dateRaised.toString() + "," + status.toString() + "," + callerDetails.toString();
   }
}
