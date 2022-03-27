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
            csvWriter.append("RequiredService");
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
                Emergency tempEmergency = new Emergency(Integer.parseInt(emergencyData[0]), emergencyData[2], emergencyData[3]);
                tempEmergency.setService(emergencyData[1]);
                tempEmergency.dateRaised = LocalDateTime.parse(emergencyData[4]);
                tempEmergency.status = Emergency.Status.valueOf(emergencyData[5]);
                
                // data manipulation for caller details
                String[] callerData = emergencyData[6].split(";");
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
