/**GUI for the Hostel application
 *  @author Daniel Bolarinwa
 */

// TODO: ADD EXTENSIVE INPUT VALIDATION IF I HAVE TIME!!!
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
import javafx.scene.control.TextInputDialog;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class CallCentreGUI extends Application {
    // attributes
    private Map<String, Boolean> serviceMap = new HashMap<String, Boolean>();
    private EmergencyList emergencies = new EmergencyList();

    // visual components
    private Label headingLabel = new Label("Emergency Call Centre");
    private Button recordButton = new Button("Record an emergency");
    private Button updateButton = new Button("Update an emergency's details");
    private Button archiveButton = new Button("Archive resolved emergencies");
    private Button reportsButton =  new  Button("Generate emergency reports");
    private Button saveAndQuitButton  = new Button("Save and Quit");
    private Button fireBrigade = new Button("Fire Brigade");
    private Button ambulance = new Button("Ambulance");
    private Button police = new Button("Police");
    private Button reusableSaveButton = new Button("Save");
    private Label callerNameLabel = new Label("Caller Name");
    private TextField callerNameField =  new TextField();
    private Label callerAgeLabel = new Label("Caller Age");
    private TextField callerAgeField =  new TextField();
    private Label callerPhoneNumberLabel = new Label("Caller Phone Number");
    private TextField callerPhoneNumberField =  new TextField();
    private Label emergencyDescriptionLabel = new Label("Emergency Description");
    private TextField emergencyDescriptionField =  new TextField();
    private Label emergencyLocationLabel = new Label("Emergency Location");
    private TextField emergencyLocationField =  new TextField();
    private TextArea appConsole  = new TextArea();

    @Override
    /** Initialises the screen 
     *  @param stage:   The scene's stage 
     */
    public void start(Stage stage) {
        FileManager.readFromFile("Emergencies.csv", emergencies);
        headingLabel.setFont(new Font("Calibri", 40));
        appConsole.setMaxSize(400, 200);
            
        // event handler for all menu option
        recordButton.setOnAction( e -> recordEmergencyHandler(stage));
        updateButton.setOnAction( e -> updateEmergencyHandler());
        archiveButton.setOnAction( e -> archiveEmergenciesHandler());
        reportsButton.setOnAction( e -> generateReportsHandler());
        saveAndQuitButton.setOnAction( e -> saveAndQuitHandler());

        // set details of stage
        stage.setWidth(500);
        stage.setHeight(400);

        // create VBox
        VBox root = new VBox(10);
        // add all components to VBox
        root.getChildren().addAll(headingLabel, recordButton, updateButton, archiveButton, reportsButton, saveAndQuitButton, appConsole);
        // create the scene
        Scene scene = new Scene(root, Color.LIGHTBLUE);

        // set details of VBox
        root.setAlignment(Pos.CENTER);
        root.setMinSize(500, 400);
        root.setMaxSize(500, 400);    

        // customise VBox
        root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2))));
        root.setBackground(Background.EMPTY);

        // set alignment of buttons
        recordButton.setAlignment(Pos.CENTER);
        updateButton.setAlignment(Pos.CENTER);
        archiveButton.setAlignment(Pos.CENTER);
        reportsButton.setAlignment(Pos.CENTER);
        saveAndQuitButton.setAlignment(Pos.CENTER);

        // customise buttons
        recordButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        updateButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        archiveButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        reportsButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        saveAndQuitButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        // configure the stage and make the stage visible
        stage.setScene(scene);
        stage.setTitle("Emergency Call Centre");
        stage.setResizable(false);
        stage.show(); 
    }

    private void recordEmergencyHandler(Stage stage) {
        // TODO: add logic
        serviceMap.put("fire", false);
        serviceMap.put("ambulance", false);
        serviceMap.put("police", false);

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
        root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(2))));
        root.setBackground(Background.EMPTY);

        reusableSaveButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        // create the scene
        Scene scene = new Scene(root, Color.LIGHTBLUE);

        // customise buttons
        fireBrigade.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        ambulance.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        police.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));
        reusableSaveButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(10), Insets.EMPTY)));

        Label recordEmergencyHeader = new Label("Please specify your emergency's details");
        recordEmergencyHeader.setFont(new Font("Calibri", 40));
        Label serviceSubheader = new Label("Please specify the emergency services you need (you can select multiple):");

        HBox emergencyServicePane = new HBox(10);
        HBox callerDetailsPane = new HBox(10);
        HBox emergencyDetailsPane = new HBox(10);
        HBox saveEmergencyPane = new HBox(10);

        fireBrigade.setOnAction(e -> setFireService());
        ambulance.setOnAction(e -> setAmbulanceService());
        police.setOnAction(e -> setPoliceService());
        reusableSaveButton.setOnAction(e -> saveEmergency());

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
        root.getChildren().addAll(recordEmergencyHeader, emergencyServicePane, callerDetailsPane, emergencyDetailsPane, saveEmergencyPane, appConsole);

        // reset console
        appConsole.setText("");
        stage.setScene(scene);
        stage.setTitle("Emergency Call Centre");
        stage.setResizable(false);
        stage.show();
    }

    private void updateEmergencyHandler() {
        // TODO: add logic
    }

    private void archiveEmergenciesHandler() {
        for(Emergency emergency: emergencies.emergencyList) {
            if (emergency.status == Emergency.Status.RESOLVED) {
                emergencies.emergencyList.remove(emergency);
            }
        }

        appConsole.setText("All emergencies which were in 'RESOLVED' status have now been archived");
        FileManager.writeToFile("Emergencies.csv", emergencies);
        // TODO: display pop up which informs the user of successful archival
    }

    private void generateReportsHandler() {
        // TODO: add logic
    }

    /** Saves current state of emergency data records in the system
     *  loads to csv for retrieval upon next execution of program
     */
    private void saveAndQuitHandler() {
        // TODO: implement pop up to confirm if user wants to quit
        
        // write current state information to file, whether complete or not write regardless
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

    /** Adds emergency to the global list of emergencies
     */
    private void saveEmergency() {
        int emergencyId = setEmergencyId();
        String nameEntered =  callerNameField.getText();
        String ageEntered =  callerAgeField.getText();
        String numberEntered =  callerPhoneNumberField.getText();
        String descriptionEntered =  emergencyDescriptionField.getText();
        String locationEntered =  emergencyLocationField.getText();

        if (nameEntered.length() == 0 || ageEntered.length() == 0 || numberEntered.length() == 0 || descriptionEntered.length() == 0 || locationEntered.length() == 0) {
            appConsole.setText("None of the fields should be empty! Please populate all fields appropriately");
        } else {
            Caller caller = new Caller(nameEntered, Integer.parseInt(ageEntered), numberEntered);
            Emergency emergency = new Emergency(emergencyId, descriptionEntered, locationEntered);
            emergency.setCallerDetails(caller);
            emergency.fireBrigade = serviceMap.get("fire");
            emergency.ambulance = serviceMap.get("ambulance");
            emergency.police = serviceMap.get("police");
            emergencies.emergencyList.add(emergency);
            FileManager.writeToFile("Emergencies.csv", emergencies);
            appConsole.setText("Your emergency was successfully recorded!");
        }

        // TODO: add reset to main menu upon completion feature
    }

    /** dynamic auto incremental 'id' generation logic
     *  This allows users to avoid having entering the same id accidentally for diffrent emergencies
     * @return the newly generated id for the emergency that is currently being recorded
     */
    private int setEmergencyId() {
        if (emergencies.emergencyList.size() > 0) {
            return emergencies.emergencyList.get(emergencies.emergencyList.size() -1).id + 1;
        }

        return 1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
