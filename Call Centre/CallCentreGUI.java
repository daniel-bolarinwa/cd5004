/**GUI for the Hostel application
 *  @author Daniel Bolarinwa
 */

import java.text.NumberFormat;
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

public class CallCentreGUI extends Application {
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
    private EmergencyList emergencies = new EmergencyList();

    @Override
    /** Initialises the screen 
     *  @param stage:   The scene's stage 
     */
    public void start(Stage stage) {
        FileManager.readFromFile("Emergencies.csv", emergencies);
        headingLabel.setFont(new Font("Calibri", 40));
            
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
        root.getChildren().addAll(headingLabel, recordButton, updateButton, archiveButton, reportsButton, saveAndQuitButton);
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

        HBox emergencyServicePane = new HBox(10);
        HBox callerDetailsPane = new HBox(10);
        HBox emergencyDetailsPane = new HBox(10);
        HBox saveEmergencyPane = new HBox(10);

        emergencyServicePane.getChildren().addAll(fireBrigade, ambulance, police);
        callerDetailsPane.getChildren().addAll(callerNameLabel, callerNameField, callerAgeLabel, callerAgeField, callerPhoneNumberLabel, callerPhoneNumberField);
        emergencyDetailsPane.getChildren().addAll(emergencyDescriptionLabel, emergencyDescriptionField, emergencyLocationLabel, emergencyLocationField);
        saveEmergencyPane.getChildren().addAll(reusableSaveButton);

        // set alignment of HBoxes
        emergencyServicePane.setAlignment(Pos.CENTER);
        callerDetailsPane.setAlignment(Pos.CENTER);
        emergencyDetailsPane.setAlignment(Pos.CENTER);
        saveEmergencyPane.setAlignment(Pos.CENTER);

        // add all components to VBox
        root.getChildren().addAll(emergencyServicePane, callerDetailsPane, emergencyDetailsPane, saveEmergencyPane);

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

        System.out.println("All emergencies which were in 'RESOLVED' status have now been archived");
        FileManager.writeToFile("Emergencies.csv", emergencies);
        // TODO: display pop up which informs the user of successful archival
    }

    private void generateReportsHandler() {
        // TODO: add logic
    }

    private void saveAndQuitHandler() {
        // TODO: implement pop up to confirm if user wants to quit
        
        // write current state information to file, whether complete or not write regardless
        FileManager.writeToFile("Emergencies.csv", emergencies);
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
