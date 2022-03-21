/** Class used to record the details of a tenant
 *  @author Daniel Bolarinwa
 */

import java.util.ArrayList;

public class EmergencyList {
    public ArrayList<Emergency> emergencyList;

    public EmergencyList() {
       emergencyList = new ArrayList<>();
    }

    public void addEmergency(Emergency emergencyIn) {
        emergencyList.add(emergencyIn);
    }

    public void removeEmergency(Emergency emergencyIn) {
        emergencyList.remove(emergencyIn);
    }

    // public Emergency getEmergency(int keyIn) {   
    //     // take one off logical position to get ArrayList position
    //     return emergencyMap.get(keyIn);
	// }

    public Emergency getEmergencyByPosition(int positionIn) {   
        // take one off logical position to get ArrayList position
        return emergencyList.get(positionIn);
	}

    public int getSize() {
        return emergencyList.size();
    }

    @Override
	public String toString() {
        return emergencyList.toString();
    }
}
