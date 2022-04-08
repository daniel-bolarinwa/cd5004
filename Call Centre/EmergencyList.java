/** Class used to record a list of emergencies
 *  @author Daniel Bolarinwa
 */

import java.util.concurrent.CopyOnWriteArrayList;

public class EmergencyList {
    public CopyOnWriteArrayList<Emergency> emergencyList;

    public EmergencyList() {
       emergencyList = new CopyOnWriteArrayList<Emergency>();
    }

    /** retrieves an emergency in the list based on id input parameter
     *  This is to ensure that the use of auto incremental emergency id doesn't result in duplicates
     *  @param emergencyId
     *  @return the emergency that matches the input id, if no matches we return null
     */
    public Emergency getEmergencyByID(int emergencyId) {   
        for (Emergency emergency: emergencyList) {
            if (emergency.id == emergencyId) {
                return emergency;
            }
        }

        return null;
	}

    public void displayAllEmergencies() {
        for (Emergency emergency: emergencyList) {
            emergency.displayEmergencyDetails();
        }
    }

    @Override
	public String toString() {
        return emergencyList.toString();
    }
}
