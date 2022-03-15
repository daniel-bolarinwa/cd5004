/** Class used to record the details of a tenant
 *  @author Daniel Bolarinwa
 */

import java.util.HashMap;

public class EmergencyList {
    private static HashMap<String, Emergency> emergencyMap;

    public EmergencyList() {
        emergencyMap = new HashMap<String, Emergency>();
    }

    public static void addEmergency(String CallerId, Emergency emergencyIn) {
        emergencyMap.put(CallerId, emergencyIn);
    }

    public Emergency getEmergency(String keyIn) {   
        // take one off logical position to get ArrayList position
        return emergencyMap.get(keyIn);
	}

    @Override
	public String toString() {
        return emergencyMap.toString();
    }
}
