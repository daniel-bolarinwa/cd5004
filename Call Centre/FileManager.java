import java.io.FileWriter;
import java.time.LocalDateTime;

import java.io.FileReader;
import java.io.BufferedReader;

public class FileManager {

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
                Caller tempCaller = new Caller(callerData[0], Integer.parseInt(callerData[1]), Long.parseLong(callerData[2]));

                tempEmergency.setCallerDetails(tempCaller);

                emergencyListToRead.emergencyList.add(tempEmergency);
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
        }
    }
}
