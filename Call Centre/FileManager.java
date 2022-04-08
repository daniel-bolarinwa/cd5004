/** Class used to manage file handling for persistent data storage
 *  @author Daniel Bolarinwa
 */

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileManager {

    /** Writes list of emergencies currently in the system to the file with the specified file name
     * @param fileName
     * @param emergencyListToWrite
     */
    static void writeToFile(String fileName, EmergencyList emergencyListToWrite) {
        try {
            FileWriter csvWriter = new FileWriter(fileName);
            csvWriter.append("ID");
            csvWriter.append(",");
            csvWriter.append("FireBrigadeRequired");
            csvWriter.append(",");
            csvWriter.append("PoliceRequired");
            csvWriter.append(",");
            csvWriter.append("AmbulanceRequired");
            csvWriter.append(",");
            csvWriter.append("Description");
            csvWriter.append(",");
            csvWriter.append("Location");
            csvWriter.append(",");
            csvWriter.append("DateRaised");
            csvWriter.append(",");
            csvWriter.append("Status");
            csvWriter.append(",");
            csvWriter.append("CallerDetails");
            csvWriter.append("\n");

            for(Emergency emergency: emergencyListToWrite.emergencyList) { 
                csvWriter.append(emergency.toString());
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            System.out.println("Error writing file: " + e);
        }        
    }

    /** Reads emergency data from the specified file
     *  parses the data into relevant emergency atttributes 
     *  which are loaded back into an empty list of emergencies
     * @param fileName
     * @param emergencyListToRead
     */
    static void readFromFile(String fileName, EmergencyList emergencyListToRead) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            csvReader.readLine(); // to skip header line

            String line = null;
            while ((line = csvReader.readLine()) != null) {
                String[] emergencyData = line.split(",");
                Emergency tempEmergency = new Emergency(Integer.parseInt(emergencyData[0]), emergencyData[4], emergencyData[5]);
                tempEmergency.fireBrigade = Boolean.parseBoolean(emergencyData[1]);
                tempEmergency.police = Boolean.parseBoolean(emergencyData[2]);
                tempEmergency.ambulance = Boolean.parseBoolean(emergencyData[3]);
                tempEmergency.dateRaised = LocalDateTime.parse(emergencyData[6]);
                tempEmergency.status = Emergency.Status.valueOf(emergencyData[7]);
                
                // data manipulation for caller details
                String[] callerData = emergencyData[8].split(";");
                Caller tempCaller = new Caller(callerData[0], Integer.parseInt(callerData[1]), callerData[2]);

                tempEmergency.setCallerDetails(tempCaller);

                emergencyListToRead.emergencyList.add(tempEmergency);
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
        }
    }
}
