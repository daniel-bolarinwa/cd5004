/** Class used to record a list of emergencies
 *  @author Daniel Bolarinwa
 */

import java.util.ArrayList;

public class EmergencyList {
    public ArrayList<Emergency> emergencyList;

    public EmergencyList() {
       emergencyList = new ArrayList<>();
    }

    public Emergency getEmergencyByPosition(int positionIn) {   
        // take one off logical position to get ArrayList position
        return emergencyList.get(positionIn);
	}

    @Override
	public String toString() {
        return emergencyList.toString();
    }
}
