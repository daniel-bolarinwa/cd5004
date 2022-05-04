/**GUI for the Hostel application
 *  @author Daniel Bolarinwa
 */

// TODO: FORMAT DISPLAY EMERGENCY SO IT LOOKS NICE!!!
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class CallCentreGUI extends Application {
    // attributes
    private Map<String, Boolean> serviceMap = new HashMap<String, Boolean>();
    static EmergencyList emergencies = new EmergencyList();

    // visual components
    private Label headingLabel = new Label("Emergency Call Centre");
    private Button recordButton = new Button("Record an emergency");
    private Button updateButton = new Button("Update an emergency's details");
    private Button archiveButton = new Button("Archive resolved emergencies");
    private Button reportsButton = new Button("Generate emergency reports");
    private Button saveAndQuitButton = new Button("Save and Quit");
    private Button fireBrigade = new Button("Fire Brigade");
    private Button ambulance = new Button("Ambulance");
    private Button police = new Button("Police");
    private Button reusableSaveButton = new Button("Save");
    private Button returnToMenuButton = new Button("Return to Main Menu");
    private Label callerNameLabel = new Label("Caller Name");
    private TextField callerNameField = new TextField();
    private Label callerAgeLabel = new Label("Caller Age");
    private TextField callerAgeField = new TextField();
    private Label callerPhoneNumberLabel = new Label("Caller Phone Number");
    private TextField callerPhoneNumberField = new TextField();
    private Label emergencyDescriptionLabel = new Label("Emergency Description");
    private TextField emergencyDescriptionField = new TextField();
    private Label emergencyLocationLabel = new Label("Emergency Location");
    private TextField emergencyLocationField = new TextField();
    private Label updateCallerNameLabel = new Label("New Caller Name");
    private Label updateCallerAgeLabel = new Label("New Caller Age");
    private Label updateCallerPhoneNumberLabel = new Label("New Caller Phone Number");
    private Label updateEmergencyDescriptionLabel = new Label("New Emergency Description");
    private Label updateEmergencyLocationLabel = new Label("New Emergency Location");
    private Label emergencyIdLabel = new Label("ID (required, must specify!):");
    private TextField emergencyIdField = new TextField();
    private Label resolvedLabel = new Label("Mark as resolved:");
    private Button resolvedButton = new Button("Resolve");
    private Button pendingButton = new Button("Pending");
    private Button displayAllButton = new Button("All");
    private Button displayByResolvedButton = new Button("Resolved");
    private TextArea appConsole = new TextArea();
    private TextArea errorConsole = new TextArea();

    @Override
    /**
     * Initialises the screen
     * 
     * @param stage: The scene's stage
     */
    public void start(Stage stage) {
        headingLabel.setFont(new Font("Calibri", 40));
        appConsole.setMaxSize(400, 200);
        errorConsole.setMaxSize(400, 200);

        // event handler for all menu option
        recordButton.setOnAction(e -> recordEmergencyHandler(stage));
        updateButton.setOnAction(e -> updateEmergencyHandler(stage));
        archiveButton.setOnAction(e -> archiveEmergenciesHandler());
        reportsButton.setOnAction(e -> generateReportsHandler(stage));
        saveAndQuitButton.setOnAction(e -> saveAndQuitHandler());

        // set details of stage
        stage.setWidth(500);
        stage.setHeight(400);

        // create VBox
        VBox root = new VBox(10);
        // add all components to VBox
        root.getChildren().addAll(headingLabel, recordButton, updateButton, archiveButton, reportsButton, saveAndQuitButton, appConsole, errorConsole);
        // create the scene
        Scene scene = new Scene(root, Color.LIGHTBLUE);

        // set details of VBox
        root.setAlignment(Pos.CENTER);
        root.setMinSize(500, 400);
        root.setMaxSize(500, 400);

        // customise VBox
        root.setBorder(
                new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2))));
        root.setBackground(Background.EMPTY);

        // set alignment of buttons
        recordButton.setAlignment(Pos.CENTER);
        updateButton.setAlignment(Pos.CENTER);
        archiveButton.setAlignment(Pos.CENTER);
        reportsButton.setAlignment(Pos.CENTER);
        saveAndQuitButton.setAlignment(Pos.CENTER);

        // customise buttons
        recordButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        updateButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        archiveButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        reportsButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        saveAndQuitButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        // configure the stage and make the stage visible
        stage.setScene(scene);
        stage.setTitle("Emergency Call Centre");
        stage.setResizable(false);
        stage.show();
    }

    private void recordEmergencyHandler(Stage stage) {
        serviceMap.put("fire", false);
        serviceMap.put("ambulance", false);
        serviceMap.put("police", false);

        // reset console
        appConsole.setText("");
        errorConsole.setText("");

        // create VBox
        VBox root = new VBox(10);

        // reset details of stage
        stage.setWidth(800);
        stage.setHeight(500);

        // set details of VBox
        root.setAlignment(Pos.CENTER);
        root.setMinSize(800, 500);
        root.setMaxSize(800, 500);

        // customise VBox
        root.setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2))));
        root.setBackground(Background.EMPTY);

        reusableSaveButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        // create the scene
        Scene scene = new Scene(root, Color.LIGHTBLUE);

        // customise buttons
        fireBrigade.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        ambulance.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        police.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        reusableSaveButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        Label recordEmergencyHeader = new Label("Record Emergency");
        recordEmergencyHeader.setFont(new Font("Calibri", 40));
        Label serviceSubheader = new Label("Please specify the emergency services you need (you can select multiple):");

        HBox emergencyServicePane = new HBox(10);
        HBox callerDetailsPane = new HBox(10);
        HBox emergencyDetailsPane = new HBox(10);
        HBox saveEmergencyPane = new HBox(10);

        fireBrigade.setOnAction(e -> setFireService());
        ambulance.setOnAction(e -> setAmbulanceService());
        police.setOnAction(e -> setPoliceService());
        reusableSaveButton.setOnAction(e -> saveEmergency(stage));

        emergencyServicePane.getChildren().addAll(serviceSubheader, fireBrigade, ambulance, police);
        callerDetailsPane.getChildren().addAll(callerNameLabel, callerNameField, callerAgeLabel, callerAgeField, callerPhoneNumberLabel, callerPhoneNumberField);
        emergencyDetailsPane.getChildren().addAll(emergencyDescriptionLabel, emergencyDescriptionField, emergencyLocationLabel, emergencyLocationField);
        saveEmergencyPane.getChildren().addAll(reusableSaveButton);

        // set alignment of HBoxes
        emergencyServicePane.setAlignment(Pos.CENTER);
        callerDetailsPane.setAlignment(Pos.CENTER);
        emergencyDetailsPane.setAlignment(Pos.CENTER);
        saveEmergencyPane.setAlignment(Pos.CENTER);

        // add all components to VBox
        root.getChildren().addAll(recordEmergencyHeader, emergencyServicePane, callerDetailsPane, emergencyDetailsPane, saveEmergencyPane, appConsole, errorConsole);

        stage.setScene(scene);
        stage.setTitle("Emergency Call Centre");
        stage.setResizable(false);
        stage.show();
    }

    private void updateEmergencyHandler(Stage stage) {
        // create VBox
        VBox root = new VBox(10);

        // reset details of stage
        stage.setWidth(1000);
        stage.setHeight(700);

        // set details of VBox
        root.setAlignment(Pos.CENTER);
        root.setMinSize(1000, 700);
        root.setMaxSize(1000, 700);

        appConsole.setMaxSize(900, 200);
        errorConsole.setMaxSize(900, 200);

        // customise VBox
        root.setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2))));
        root.setBackground(Background.EMPTY);

        // create the scene
        Scene scene = new Scene(root, Color.LIGHTBLUE);

        Label updateEmergencyHeader = new Label("Update Emergency");
        updateEmergencyHeader.setFont(new Font("Calibri", 40));
        Label subHeader = new Label("Please enter the ID of the emergency you want to update alongside its new details (leave fields blank if no changes):");
        Label serviceSubheader = new Label("Please specify other emergency services which are needed for this emergency (you can select none or multiple):");

        HBox emergencyIdPane = new HBox(10);
        HBox emergencyServicePane = new HBox(10);
        HBox callerDetailsPane = new HBox(10);
        HBox emergencyDetailsPane = new HBox(10);
        HBox resolveEmergencyPane = new HBox(10);
        HBox saveEmergencyPane = new HBox(10);

        // customise buttons
        fireBrigade.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        ambulance.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        police.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        reusableSaveButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        fireBrigade.setOnAction(e -> setFireService());
        ambulance.setOnAction(e -> setAmbulanceService());
        police.setOnAction(e -> setPoliceService());
        reusableSaveButton.setOnAction(e -> saveUpdatedEmergency(stage));
        resolvedButton.setOnAction(e -> resolveEmergency());

        emergencyIdPane.getChildren().addAll(emergencyIdLabel, emergencyIdField);
        emergencyServicePane.getChildren().addAll(serviceSubheader, fireBrigade, ambulance, police);
        callerDetailsPane.getChildren().addAll(updateCallerNameLabel, callerNameField, updateCallerAgeLabel, callerAgeField, updateCallerPhoneNumberLabel, callerPhoneNumberField);
        emergencyDetailsPane.getChildren().addAll(updateEmergencyDescriptionLabel, emergencyDescriptionField, updateEmergencyLocationLabel, emergencyLocationField);
        resolveEmergencyPane.getChildren().addAll(resolvedLabel, resolvedButton);
        saveEmergencyPane.getChildren().addAll(reusableSaveButton);

        // set alignment of HBoxes
        emergencyIdPane.setAlignment(Pos.CENTER);
        emergencyServicePane.setAlignment(Pos.CENTER);
        callerDetailsPane.setAlignment(Pos.CENTER);
        emergencyDetailsPane.setAlignment(Pos.CENTER);
        resolveEmergencyPane.setAlignment(Pos.CENTER);
        saveEmergencyPane.setAlignment(Pos.CENTER);

        // add all components to VBox
        root.getChildren().addAll(updateEmergencyHeader, subHeader, emergencyIdPane, emergencyServicePane, callerDetailsPane, emergencyDetailsPane, resolveEmergencyPane, saveEmergencyPane, appConsole, errorConsole);

        // reset console
        displayEmergencies();
        stage.setScene(scene);
        stage.show();
    }

    private void archiveEmergenciesHandler() {
        for (Emergency emergency : emergencies.emergencyList) {
            if (emergency.status == Emergency.Status.RESOLVED) {
                emergencies.emergencyList.remove(emergency);
            }
        }

        appConsole.setText("All emergencies which had 'RESOLVED' status have now been archived");
    }

    private void generateReportsHandler(Stage stage) {
        // create VBox
        VBox root = new VBox(10);

        // reset details of stage
        stage.setWidth(800);
        stage.setHeight(500);

        // set details of VBox
        root.setAlignment(Pos.CENTER);
        root.setMinSize(800, 500);
        root.setMaxSize(800, 500);

        appConsole.setMaxSize(750, 350);
        errorConsole.setMaxSize(750, 50);

        // customise VBox
        root.setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2))));
        root.setBackground(Background.EMPTY);

        returnToMenuButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        // create the scene
        Scene scene = new Scene(root, Color.LIGHTBLUE);

        // customise buttons
        displayAllButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        fireBrigade.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        ambulance.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        police.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        pendingButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        displayByResolvedButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        returnToMenuButton.setBackground(
                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        Label generateReportHeader = new Label("Generate Report");
        generateReportHeader.setFont(new Font("Calibri", 40));
        Label reportFilterLabel = new Label("Choose how you would like to filter the report");

        HBox filterPane = new HBox(10);
        HBox saveEmergencyPane = new HBox(10);

        displayAllButton.setOnAction(e -> displayEmergencies());
        fireBrigade.setOnAction(e -> displayFireEmergencies());
        ambulance.setOnAction(e -> displayAmbulanceEmergencies());
        police.setOnAction(e -> displayPoliceEmergencies());
        pendingButton.setOnAction(e -> displayPendingEmergencies());
        displayByResolvedButton.setOnAction(e -> displayResolvedEmergencies());
        returnToMenuButton.setOnAction(e -> {
            errorConsole.setText("");
            appConsole.setText("");
            start(stage);
        });

        filterPane.getChildren().addAll(reportFilterLabel, displayAllButton, fireBrigade, ambulance, police, pendingButton, displayByResolvedButton);
        saveEmergencyPane.getChildren().addAll(returnToMenuButton);

        // set alignment of HBoxes
        filterPane.setAlignment(Pos.CENTER);
        saveEmergencyPane.setAlignment(Pos.CENTER);

        // add all components to VBox
        root.getChildren().addAll(generateReportHeader, filterPane, appConsole, errorConsole, saveEmergencyPane);

        // reset console
        appConsole.setText("");
        errorConsole.setText("");
        stage.setScene(scene);
        stage.setTitle("Emergency Call Centre");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Saves current state of emergency data records in the system
     * loads to csv for retrieval upon next execution of program
     */
    private void saveAndQuitHandler() {
        // write current state information to file, whether complete or not write
        // regardless
        FileManager.writeToFile("Emergencies.csv", emergencies);
        Platform.exit();
    }

    private void setFireService() {
        serviceMap.put("fire", true);
        fireBrigade.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
    }

    private void setAmbulanceService() {
        serviceMap.put("ambulance", true);
        ambulance.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
    }

    private void setPoliceService() {
        serviceMap.put("police", true);
        police.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
    }

    /**
     * Adds emergency to the global list of emergencies
     */
    private void saveEmergency(Stage stage) {
        int emergencyId = setEmergencyId();
        String nameEntered = callerNameField.getText();
        String ageEntered = callerAgeField.getText();
        String numberEntered = callerPhoneNumberField.getText();
        String descriptionEntered = emergencyDescriptionField.getText();
        String locationEntered = emergencyLocationField.getText();

        if (nameEntered.length() == 0 || ageEntered.length() == 0 || numberEntered.length() == 0 || descriptionEntered.length() == 0 || locationEntered.length() == 0) {
            errorConsole.setText("None of the fields should be empty! Please populate all fields appropriately");
        } else if (!nameEntered.matches("[a-zA-Z\\s]+")) {
            errorConsole.setText("Name should only contain alphabets/letters, please amend the name field!");
        } else if (!ageEntered.matches("[0-9]+") || Integer.parseInt(ageEntered) <= 0 || Integer.parseInt(ageEntered) >= 150) {
            errorConsole.setText("Age should only contain numbers and be betwwen 0 and 150, please amend the age field!");
        } else if (numberEntered.length() != 11 || !numberEntered.matches("[0-9]+")) {
            errorConsole.setText("Phone Number should only contain numbers and must have a length of 11, please amend the phone number field!");
        } else if (!locationEntered.matches("[a-zA-Z0-9\\s]+") || locationEntered.length() < 6 || locationEntered.length() > 8) {
            errorConsole.setText("Location must be a valid alphanumeric postcode with a length of 6-8, please amend the location field!");
        } else {
            Caller caller = new Caller(nameEntered, Integer.parseInt(ageEntered), numberEntered);
            Emergency emergency = new Emergency(emergencyId, descriptionEntered, locationEntered);
            emergency.setCallerDetails(caller);
            emergency.fireBrigade = serviceMap.get("fire");
            emergency.ambulance = serviceMap.get("ambulance");
            emergency.police = serviceMap.get("police");
            emergencies.emergencyList.add(emergency);
            appConsole.setText("Your emergency was successfully recorded!");
            errorConsole.setText("");
            start(stage);
        }
    }

    /**
     * Adds emergency to the global list of emergencies
     */
    private void saveUpdatedEmergency(Stage stage) {
        String id = "";
        String nameEntered = "";
        int ageEntered = 0;
        String numberEntered = "";
        boolean validator = true;

        if (emergencyIdField.getText().length() != 0) {
            if (!emergencyIdField.getText().matches("[0-9]+") || emergencies.getEmergencyByID(Integer.parseInt(emergencyIdField.getText())) == null) {
                errorConsole.setText("Emergency with ID (" + emergencyIdField.getText() + ") doesn't exist, please specify a valid ID!");
                validator = false;
            } else {
                id = emergencyIdField.getText();
            }
        } else {
            errorConsole.setText("Emergency with ID (" + emergencyIdField.getText() + ") doesn't exist, please specify a valid ID!");
            validator = false;
        }

        Emergency emergencyToUpdate = emergencies.getEmergencyByID(Integer.parseInt(id));

        if (serviceMap.get("fire") != null) {
            emergencyToUpdate.fireBrigade = serviceMap.get("fire");
        } else {
            emergencyToUpdate.fireBrigade = emergencyToUpdate.fireBrigade;
        }

        if (serviceMap.get("ambulance") != null) {
            emergencyToUpdate.ambulance = serviceMap.get("ambulance");
        } else {
            emergencyToUpdate.ambulance = emergencyToUpdate.ambulance;
        }

        if (serviceMap.get("police") != null) {
            emergencyToUpdate.police = serviceMap.get("police");
        } else {
            emergencyToUpdate.police = emergencyToUpdate.police;
        }

        if (emergencyDescriptionField.getText().length() != 0) {
            emergencyToUpdate.setDescription(emergencyDescriptionField.getText());
        }

        if (emergencyLocationField.getText().length() != 0 && 
            (!emergencyLocationField.getText().matches("[a-zA-Z0-9\\s]+") || 
            emergencyLocationField.getText().length() < 6 || 
            emergencyLocationField.getText().length() > 8)) {
            errorConsole.setText("Location must be a valid alphanumeric postcode with a length of 6-8, please amend the location field!");
            validator = false;
        } else {
            emergencyToUpdate.setLocation(emergencyLocationField.getText());
        }

        if (callerNameField.getText().length() != 0) {
            if (!callerNameField.getText().matches("[a-zA-Z\\s]+")) {
                errorConsole.setText("Name should only contain alphabets/letters, please amend the name field!");
                validator = false;
            } else {
                nameEntered = callerNameField.getText();
            }
        } else {
            nameEntered = emergencyToUpdate.getCallerDetails().getName();
        }

        if (callerAgeField.getText().length() != 0) {
            if (!callerAgeField.getText().matches("[0-9]+") || Integer.parseInt(callerAgeField.getText()) <= 0 || Integer.parseInt(callerAgeField.getText()) >= 150) {
                errorConsole.setText("Age should only contain numbers and be betwwen 0 and 150, please amend the age field!");
                validator = false;
            } else {
                ageEntered = Integer.parseInt(callerAgeField.getText());
            }
        } else {
            ageEntered = emergencyToUpdate.getCallerDetails().getAge();
        }

        if (callerPhoneNumberField.getText().length() != 0) {
            if (callerPhoneNumberField.getText().length() != 11 || !callerPhoneNumberField.getText().matches("[0-9]+")) {
                errorConsole.setText("Phone Number should only contain numbers and must have a length of 11, please amend the phone number field!");
                validator = false;
            } else {
                numberEntered = callerPhoneNumberField.getText();
            }
        } else {
            numberEntered = emergencyToUpdate.getCallerDetails().getPhoneNumber();
        }

        if (validator) {
            Caller caller = new Caller(nameEntered, ageEntered, numberEntered);
            emergencyToUpdate.setCallerDetails(caller);

            appConsole.setText("Your emergency was successfully updated!");
            errorConsole.setText("");

            start(stage);
        }
    }

    private void resolveEmergency() {
        String id = "";

        if (emergencyIdField.getText().length() != 0) {
            if (!emergencyIdField.getText().matches("[0-9]+") || emergencies.getEmergencyByID(Integer.parseInt(emergencyIdField.getText())) == null) {
                errorConsole.setText("Emergency with ID (" + emergencyIdField.getText() + ") doesn't exist so cannot be resolved, please specify a valid ID!");
            } else {
                id = emergencyIdField.getText();
            }
        } else {
            errorConsole.setText("Emergency with ID (" + emergencyIdField.getText() + ") doesn't exist, please specify a valid ID!");
        }

        Emergency emergencyToUpdate = emergencies.getEmergencyByID(Integer.parseInt(id));
        emergencyToUpdate.status = Emergency.Status.RESOLVED;

        appConsole.setText("Your emergency was successfully resolved!");
    }

    /**
     * dynamic auto incremental 'id' generation logic
     * This allows users to avoid having entering the same id accidentally for
     * diffrent emergencies
     * 
     * @return the newly generated id for the emergency that is currently being
     *         recorded
     */
    private int setEmergencyId() {
        if (emergencies.emergencyList.size() > 0) {
            return emergencies.emergencyList.get(emergencies.emergencyList.size() - 1).id + 1;
        }

        return 1;
    }

    /**
     * user friendly formatting for display report function
     */
    private void displayEmergencies() {
        appConsole.setText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                "ID,",
                "FireBrigadeRequired,",
                "PoliceRequired,",
                "AmbulanceRequired,",
                "Description,",
                "Location,",
                "DateRaised,",
                "Status,",
                "CallerDetails"));

        for (Emergency emergency : emergencies.emergencyList) {
            appConsole.appendText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                    emergency.id,
                    emergency.fireBrigade,
                    emergency.police,
                    emergency.ambulance,
                    emergency.getDescription(),
                    emergency.getLocation(),
                    emergency.dateRaised.toString(),
                    emergency.status.toString(),
                    emergency.callerDetails.displayCallerDetails()));
        }
    }

    private void displayFireEmergencies() {
        appConsole.setText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                "ID,",
                "FireBrigadeRequired,",
                "PoliceRequired,",
                "AmbulanceRequired,",
                "Description,",
                "Location,",
                "DateRaised,",
                "Status,",
                "CallerDetails"));

        for (Emergency emergency : emergencies.emergencyList) {
            if (emergency.fireBrigade == true) {
                appConsole.appendText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                        emergency.id,
                        emergency.fireBrigade,
                        emergency.police,
                        emergency.ambulance,
                        emergency.getDescription(),
                        emergency.getLocation(),
                        emergency.dateRaised.toString(),
                        emergency.status.toString(),
                        emergency.callerDetails.displayCallerDetails()));
            }
        }
    }

    private void displayAmbulanceEmergencies() {
        appConsole.setText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                "ID,",
                "FireBrigadeRequired,",
                "PoliceRequired,",
                "AmbulanceRequired,",
                "Description,",
                "Location,",
                "DateRaised,",
                "Status,",
                "CallerDetails"));

        for (Emergency emergency : emergencies.emergencyList) {
            if (emergency.ambulance == true) {
                appConsole.appendText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                        emergency.id,
                        emergency.fireBrigade,
                        emergency.police,
                        emergency.ambulance,
                        emergency.getDescription(),
                        emergency.getLocation(),
                        emergency.dateRaised.toString(),
                        emergency.status.toString(),
                        emergency.callerDetails.displayCallerDetails()));
            }
        }
    }

    private void displayPoliceEmergencies() {
        appConsole.setText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                "ID,",
                "FireBrigadeRequired,",
                "PoliceRequired,",
                "AmbulanceRequired,",
                "Description,",
                "Location,",
                "DateRaised,",
                "Status,",
                "CallerDetails"));

        for (Emergency emergency : emergencies.emergencyList) {
            if (emergency.police == true) {
                appConsole.appendText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                        emergency.id,
                        emergency.fireBrigade,
                        emergency.police,
                        emergency.ambulance,
                        emergency.getDescription(),
                        emergency.getLocation(),
                        emergency.dateRaised.toString(),
                        emergency.status.toString(),
                        emergency.callerDetails.displayCallerDetails()));
            }
        }
    }

    private void displayPendingEmergencies() {
        appConsole.setText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                "ID,",
                "FireBrigadeRequired,",
                "PoliceRequired,",
                "AmbulanceRequired,",
                "Description,",
                "Location,",
                "DateRaised,",
                "Status,",
                "CallerDetails"));

        for (Emergency emergency : emergencies.emergencyList) {
            if (emergency.status == Emergency.Status.PENDING) {
                appConsole.appendText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                        emergency.id,
                        emergency.fireBrigade,
                        emergency.police,
                        emergency.ambulance,
                        emergency.getDescription(),
                        emergency.getLocation(),
                        emergency.dateRaised.toString(),
                        emergency.status.toString(),
                        emergency.callerDetails.displayCallerDetails()));
            }
        }
    }

    private void displayResolvedEmergencies() {
        appConsole.setText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                "ID,",
                "FireBrigadeRequired,",
                "PoliceRequired,",
                "AmbulanceRequired,",
                "Description,",
                "Location,",
                "DateRaised,",
                "Status,",
                "CallerDetails"));

        for (Emergency emergency : emergencies.emergencyList) {
            if (emergency.status == Emergency.Status.RESOLVED) {
                appConsole.appendText(String.format("%-5s %-20s %-15s %-18s %-20s %-9s %-23s %-8s %-20s\n",
                        emergency.id,
                        emergency.fireBrigade,
                        emergency.police,
                        emergency.ambulance,
                        emergency.getDescription(),
                        emergency.getLocation(),
                        emergency.dateRaised.toString(),
                        emergency.status.toString(),
                        emergency.callerDetails.displayCallerDetails()));
            }
        }
    }

    public static void main(String[] args) {
        FileManager.readFromFile("Emergencies.csv", emergencies);
        launch(args);
    }
}
