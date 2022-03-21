/** Class used to record the details of a tenant
 *  @author Daniel Bolarinwa
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Main {

    static EmergencyList emergencyList = new EmergencyList(); // these will eventually be read from file to keep state records from past 
    public static void main(String[] args) {          
        int option;
        do {
            System.out.println();
            System.out.println("<-*-*-*-*-MENU-*-*-*-*->");
            System.out.println();
            System.out.println("1. Answer Call");
            System.out.println("2. Update Emergency");
            System.out.println("3. Get Emergency Details");
            System.out.println("4. Generate Reports");
            System.out.println("5. Save and Quit");
            System.out.println();
            System.out.print("Enter choice (1-5): ");
            option = EasyScanner.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    answerCall();
                    break;
                case 2:
                    updateEmergency();
                    break;
                case 3:
                    getEmergencyDetails();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    saveAndQuit();
                    break;
                default:
                    System.out.println("Enter 1-5 only");

            }
        } while (option != '7');
    }

    static void answerCall() {
        // TODO: retrive existing data to keep up to date the total emergencies rasied so far -> will help with autogenrating id for emergencies
        // once done send the total + 1 as id for new emergency
        retrieveExistingEmergencyData();
        int emergencyId = emergencyList.getSize();
        System.out.println("Hi, emergency services! What emergency service do you need?");
        System.out.println("<---Please choose enter (1-3) for one the following: \n1. Fire Brigade \n2. Police \n3. Ambulance--->"); // TODO: remember to implement implicit logic to add other services they might need
        int serviceOption = EasyScanner.nextInt();

        System.out.println("<---Please provide your personal details below--->");
        System.out.println("FULL NAME: ");
        String nameIn = EasyScanner.nextString();
        
        System.out.println("AGE: ");
        int ageIn = EasyScanner.nextInt();

        System.out.println("HOME ADDRESS: ");
        String addressIn = EasyScanner.nextString();

        System.out.println("<---Please provide details of the emergency below--->");
        System.out.println("BRIEF DESCRIPTION: ");
        String descIn = EasyScanner.nextString();

        System.out.println("LOCATION OF INCIDENT: ");
        String locationIn = EasyScanner.nextString();

        recordCallInformation(serviceOption, nameIn, ageIn, addressIn, descIn, locationIn, emergencyId+1);
    }

    static void recordCallInformation(int serviceIn, String nameIn, int ageIn, String addressIn, String descIn, String locationIn, int emergencyIdIn) {
        Caller caller = new Caller(nameIn, ageIn, addressIn);
        Emergency emergency = new Emergency(emergencyIdIn, descIn, locationIn);
        emergency.setCallerDetails(caller);
        switch (serviceIn) {
            case 1:
                emergency.setService("Fire Brigade");
                break;
            case 2:
                emergency.setService("Police");
                break;
            case 3:
                emergency.setService("Ambulance");
                break;
            default:
                System.out.println("Please try again: the service which was specified is invalid!");
        }
        addEmergencyToList(emergency);
    }

    static void updateEmergency() {
        System.out.println("<---Please choose the caller you would like to update an emergency for--->");
        // Display all callers and their associated emergencies
        System.out.println("<---Please choose the emergency you want to update for the caller--->");
        // Display list of emergencies currently associated to the chosen caller

    }

    static void generateReport() {

    }

    static void getEmergencyDetails() {
        
    }

    static void addEmergencyToList(Emergency emergencyIn) {
        emergencyList.addEmergency(emergencyIn);
    }

    static void retrieveExistingEmergencyData() {
        boolean endOfFile = false;
        Emergency emergency;
        
        try( 
            FileInputStream file = new FileInputStream("emergencies.txt");
            ObjectInputStream emergencyStream = new ObjectInputStream(file);
        ) {
        emergency =  (Emergency) emergencyStream.readObject();
        while(endOfFile != true)
        {
            try {
                emergencyList.addEmergency(emergency);
                emergency =  (Emergency) emergencyStream.readObject();
            } catch(Exception  e)
            {
                endOfFile = true;
            }
        }
        
        } catch (Exception e) {
            System.out.println("couldn't load existing emergency data! aborting program...");
            return;
        }
    }

    static boolean saveAndQuit(){
        System.out.println("<---Saving and quitting--->");
        System.out.println();
        // write current state information to file, whether complete or not write regardless

        boolean fail = false;

        try(
            FileWriter file = new FileWriter("emergencies.txt");
            PrintWriter writer = new PrintWriter(file);
        ) {
            while (fail = false) {
                for(int i = 0; i <= emergencyList.getSize(); i++) {
                    writer.println(emergencyList.getEmergencyByPosition(i));
                }
            }
        } catch (Exception e) {
            System.out.println("error writing data! trying again...");
            fail = true;
        }

        return fail;
    }
}