/** Class used to execute Call Centre logic
 *  @author Daniel Bolarinwa
 */

import java.util.concurrent.CopyOnWriteArrayList;

public class Main extends FileManager {
    static EmergencyList emergencies = new EmergencyList(); 
    public static void main(String[] args) {          
        retrieveExistingEmergencyData();
        int option;
        do {
            System.out.println();
            System.out.println("<-*-*-*-*-MENU-*-*-*-*->");
            System.out.println();
            System.out.println("1. Answer Call");
            System.out.println("2. Update Emergency details");
            System.out.println("3. Archive Resolved Emergencies");
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
                    archiveResolvedEmergencies();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    saveAndQuit();
                    break;
                default:
                    System.out.println("Enter 1-5 only!");
            }
        } while (option != 5);
    }

    static void answerCall() {
        int emergencyId = emergencies.emergencyList.size();
        System.out.println("Hi, emergency services! What emergency service do you need?");
        System.out.println("<---Please choose enter (1-3) for one the following---> \n1. Fire Brigade \n2. Police \n3. Ambulance");
        int serviceOption = EasyScanner.nextInt();

        System.out.println("<---Please provide your personal details below--->");
        System.out.println("Enter full name: ");
        String nameIn = EasyScanner.nextString();
        
        System.out.println("Enter age: ");
        int ageIn = EasyScanner.nextInt();

        System.out.println("Enter home address: ");
        String addressIn = EasyScanner.nextString();

        System.out.println("<---Please provide details of the emergency below--->");
        System.out.println("Enter brief description: ");
        String descIn = EasyScanner.nextString();

        System.out.println("Enter location of incident: ");
        String locationIn = EasyScanner.nextString();

        recordCallInformation(serviceOption, nameIn, ageIn, addressIn, descIn, locationIn, emergencyId+1);
        writeToFile("Emergencies.csv", emergencies);
    }

    static void recordCallInformation(int serviceIn, String nameIn, int ageIn, String addressIn, String descIn, String locationIn, int emergencyIdIn) {
        Caller caller = new Caller(nameIn, ageIn, addressIn);
        Emergency emergency = new Emergency(emergencyIdIn, descIn, locationIn);
        emergency.setCallerDetails(caller);
        switch (serviceIn) {
            case 1:
                emergency.fireBrigade = true;
                break;
            case 2:
                emergency.police = true;
                break;
            case 3:
                emergency.ambulance = true;
                break;
            default:
                System.out.println("Please try again: the service which was specified is invalid!");
        }
        addEmergencyToList(emergency);
    }

    static void updateEmergency() {
        System.out.println("<---Please specify the id of the emergency you would like to update--->\n");
        // Display all emergencies
        emergencies.displayAllEmergencies();
        int option = EasyScanner.nextInt();

        Emergency emergencyToUpdate = emergencies.getEmergencyByPosition(option);
        System.out.println("<---Please choose what you would like to update about the emergency by entering (1-6) for one the following--->\n1. Required Services \n2. Description \n3. Location \n4. Caller Details \n5. Status \n6. Return to main menu");

        int secondOption = EasyScanner.nextInt();
        switch (secondOption) {
        case 1:
            System.out.println("<---Please enter (1-3) for the service you would like to add to the emergency---> \n1. Fire Brigade \n2. Police \n3. Ambulance");
            int serviceToAdd = EasyScanner.nextInt();
            addExtraServices(serviceToAdd, emergencyToUpdate);
            break;
        case 2:
            System.out.println("<---Enter new description: --->");
            String descriptionToUpdate = EasyScanner.nextString();
            emergencyToUpdate.setDescription(descriptionToUpdate);
            break;
        case 3:
            System.out.println("<---Enter new location: --->");
            String locationToUpdate = EasyScanner.nextString();
            emergencyToUpdate.setLocation(locationToUpdate);
            break;
        case 4:
            System.out.println("<---Please provide updated Caller details--->");

            System.out.println("<---Enter Caller full name: --->");
            String callerFullNameToUpdate = EasyScanner.nextString();

            System.out.println("<---Enter Caller age: --->");
            int callerAgeToUpdate = EasyScanner.nextInt();

            System.out.println("<---Enter Caller address: --->");
            String callerAddressToUpdate = EasyScanner.nextString();

            Caller caller = new Caller(callerFullNameToUpdate, callerAgeToUpdate, callerAddressToUpdate);
            emergencyToUpdate.setCallerDetails(caller);
            break;
        case 5:
            System.out.println("<---Please choose the status to set by entering 1 or 2 ---> \n1. PENDING \n2. RESOLVED");
            int statusOption = EasyScanner.nextInt();
            if (statusOption == 1) {
                emergencyToUpdate.status = Emergency.Status.PENDING;
            } else if (statusOption == 2) {
                emergencyToUpdate.status = Emergency.Status.RESOLVED;
            }
            break;
        case 6:
            System.out.println("returning to main menu...");
            break;
        default:
            System.out.println("Please try again: the choice which was specified is invalid! Enter 1-6 only");
        }
        writeToFile("Emergencies.csv", emergencies);
    }

    static void archiveResolvedEmergencies() {
        for(Emergency emergency: emergencies.emergencyList) {
            if (emergency.status == Emergency.Status.RESOLVED) {
                emergencies.emergencyList.remove(emergency);
            }
        }
        writeToFile("Emergencies.csv", emergencies);
    }

    static void generateReport() {
        System.out.println("<---Please choose how you would like to generate your report by entering (1-4) for any of the following--->");
        System.out.println("1. View all emergencies");
        System.out.println("2. View Emergencies by service");
        System.out.println("3. View Emergencies by status");
        System.out.println("4. Return to main menu");
        int reportOption = EasyScanner.nextInt();
        CopyOnWriteArrayList<Emergency> tempEmergencyList = new CopyOnWriteArrayList<Emergency>();

        switch (reportOption) {
        case 1:
            System.out.println("Loading all emergencies...");
            for (Emergency emergency: emergencies.emergencyList) {
                System.out.println(emergency.toString());
            }
            break;
        case 2:
            System.out.println("Loading emergencies by service...");
            System.out.println("<---Please choose the service you would like to filter with by entering (1-3)---> \n1. Fire Brigade \n2. Police \n3. Ambulance");
            int serviceOption = EasyScanner.nextInt();
            tempEmergencyList = filterByService(serviceOption);

            if (tempEmergencyList.size() == 0) {
                System.out.println("the service you chose has no associated emergencies to view...");
            } else {
                for (Emergency tempEmergency: tempEmergencyList) {
                    System.out.println(tempEmergency.toString());
                }
            }
            break;
        case 3:
            System.out.println("Loading emergencies by status...");
            System.out.println("<---Please choose one of the following---> \nPENDING \nRESOLVED");
            String statusOption = EasyScanner.nextString();
            for (Emergency emergency: emergencies.emergencyList) {
                if (emergency.status.toString().equals(statusOption)) {
                    tempEmergencyList.add(emergency);
                }
            }

            if (tempEmergencyList.size() == 0) {
                System.out.println("the status you chose has no associated emergencies to view...");
            } else {
                for (Emergency tempEmergency: tempEmergencyList) {
                    System.out.println(tempEmergency.toString());
                }
            }
            break;
        case 4:
            System.out.println("returning to main menu...");
            break;
        default:
            System.out.println("Please try again: the choice which was specified is invalid! Enter 1-4 only");
        }
    }

    static void addEmergencyToList(Emergency emergencyIn) {
        emergencies.emergencyList.add(emergencyIn);
    }

    static void retrieveExistingEmergencyData() {
        readFromFile("Emergencies.csv", emergencies);
    }

    static void addExtraServices(int serviceOption, Emergency emergencyToUpdate) {
        switch (serviceOption) {
            case 1:
                emergencyToUpdate.fireBrigade = true;
                break;
            case 2:
                emergencyToUpdate.police = true;
                break;
            case 3:
                emergencyToUpdate.ambulance = true;
                break;
            default:
                System.out.println("The service you have chosen isn't not valid. Please try again...");
        }
    }

    static CopyOnWriteArrayList<Emergency> filterByService(int serviceOption) {
        CopyOnWriteArrayList<Emergency> filteredServiceList = new CopyOnWriteArrayList<Emergency>();
        for (Emergency emergency: emergencies.emergencyList) {
            switch (serviceOption) {
                case 1:
                    if (emergency.fireBrigade == true) {
                        filteredServiceList.add(emergency);
                    }
                    break;
                case 2:
                    if (emergency.police == true) {
                        filteredServiceList.add(emergency);
                    }
                    break;
                case 3:
                    if (emergency.ambulance == true) {
                        filteredServiceList.add(emergency);
                    }
                    break;  
                default:
                    System.out.println("Service option not found. Please try again!");
            }
        }
        return filteredServiceList;
    }

    static void saveAndQuit() {
        System.out.println("<---Saving and quitting--->");
        System.out.println();
        // write current state information to file, whether complete or not write regardless
        
        writeToFile("Emergencies.csv", emergencies);
    }
}
