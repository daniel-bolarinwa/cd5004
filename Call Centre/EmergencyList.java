/** Class used to record a list of emergencies
 *  @author Daniel Bolarinwa
 */

import java.util.concurrent.CopyOnWriteArrayList;

public class EmergencyList {
    public CopyOnWriteArrayList<Emergency> emergencyList;

    public EmergencyList() {
       emergencyList = new CopyOnWriteArrayList<Emergency>();
    }

    public Emergency getEmergencyByPosition(int positionIn) {   
        // take one off logical position to get ArrayList position
        return emergencyList.get(positionIn-1);
	}

    public void displayAllEmergencies() {
        for (Emergency emergency: emergencyList) {
            System.out.println(emergency.toString());
        }
    }

    @Override
	public String toString() {
        return emergencyList.toString();
    }
}
