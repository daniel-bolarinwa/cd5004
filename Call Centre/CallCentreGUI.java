// /**GUI for the Hostel application
//  *  @author Daniel Bolarinwa
//  */

// import java.text.NumberFormat;
// import javafx.application.Application;
// import javafx.application.Platform;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextArea;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.Background;
// import javafx.scene.layout.BackgroundFill;
// import javafx.scene.layout.Border;
// import javafx.scene.layout.BorderStroke;
// import javafx.scene.layout.BorderStrokeStyle;
// import javafx.scene.layout.BorderWidths;
// import javafx.scene.layout.CornerRadii;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;
// import javafx.scene.control.TextInputDialog;

// public class CallCentreGUI extends Application {
//     // WIDTH and HEIGHT of GUI stored as constants 
//     private final int WIDTH = 800;
//     private final int HEIGHT = 500;
//     // visual components
//     private Label headingLabel = new Label("Call Centre");
//     private Button recordButton = new Button("Record an emergency");
//     private Button updateButton = new Button("Update an emergency's details");
//     private Button archiveButton = new Button("Archive resolved emergencies");
//     private Button reportsButton =  new  Button("Generate emergency reports");
//     private Button saveAndQuitButton  = new Button("Save and Quit");

//     @Override
//     /** Initialises the screen 
//      *  @param stage:   The scene's stage 
//      */
//     public void start(Stage stage)
//     {
//         retrieveExistingEmergencyData();
            
//         // create four HBoxes
//         HBox roomDetails = new HBox (10);
//         HBox tenantButtons = new HBox(10);
//         HBox paymentDetails = new HBox(10);
//         HBox paymentButtons = new HBox(10);
//         // add components to HBoxes
//         roomDetails.getChildren().addAll(roomLabel1, roomField1, nameLabel, nameField);
//         tenantButtons.getChildren().addAll(	addButton, displayButton, removeButton, 
//                                                         saveAndQuitButton);
//         paymentDetails.getChildren().addAll(	roomLabel2, roomField2, monthLabel, monthField,
//                                                         amountLabel, amountField);
//         paymentButtons.getChildren().addAll(paymentButton, listButton);
//         // create VBox
//         VBox root = new VBox(10);
//         // add all components to VBox
//         root.getChildren().addAll(	headingLabel, roomDetails, tenantButtons, displayArea1,
//                                             paymentDetails, paymentButtons, displayArea2);
//         // create the scene
//         Scene scene = new Scene(root, Color.LIGHTBLUE);
            
//             // set font of heading
//         Font font = new Font("Calibri", 40);
//         headingLabel.setFont(font);
        
//             // set alignment of HBoxes
//         roomDetails.setAlignment(Pos.CENTER);
//         tenantButtons.setAlignment(Pos.CENTER);
//         paymentDetails.setAlignment(Pos.CENTER);
//         paymentButtons.setAlignment(Pos.CENTER);
//         // set alignment of VBox
//         root.setAlignment(Pos.CENTER);
            
//         // set minimum and maximum width of components 
//         roomField1.setMaxWidth(50);
//         roomField2.setMaxWidth(50);
            
//         roomDetails.setMinWidth(WIDTH);
//         roomDetails.setMaxWidth(WIDTH);
            
//         tenantButtons.setMinWidth(WIDTH);
//         tenantButtons.setMaxWidth(WIDTH);
            
//         paymentDetails.setMinWidth(WIDTH);
//         paymentDetails.setMaxWidth(WIDTH);
            
//         paymentButtons.setMinWidth(WIDTH);
//         paymentButtons.setMaxWidth(WIDTH);
            
//         root.setMinSize(WIDTH, HEIGHT);
//         root.setMaxSize(WIDTH, HEIGHT);
            
//         displayArea1.setMaxSize(WIDTH - 80, HEIGHT/5);
//         displayArea2.setMaxSize(WIDTH - 80, HEIGHT/5);
            
//         stage.setWidth(WIDTH);
//         stage.setHeight(HEIGHT);    

//         // customise the visual components
            
//         // customise the VBox border and background
//         BorderStroke style = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
//                                                         new CornerRadii(0), new BorderWidths(2) );
//         root.setBorder(new Border (style));
//         root.setBackground(Background.EMPTY);
                
//         // customise buttons
//         addButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, 
//                                         new CornerRadii(10), Insets.EMPTY)));
//         displayButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
//                                                 new CornerRadii(10), Insets.EMPTY)));
//         removeButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
//                                             new CornerRadii(10), Insets.EMPTY)));
//         saveAndQuitButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
//                                                     new CornerRadii(10), Insets.EMPTY)));
//         paymentButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
//                                                 new CornerRadii(10), Insets.EMPTY)));
//         listButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
//                                             new CornerRadii(10), Insets.EMPTY)));
            
//         // call private methods for button event handlers
//         addButton.setOnAction(e -> addHandler());
//         displayButton.setOnAction(e -> displayHandler() );
//         removeButton.setOnAction( e -> removeHandler());
//         paymentButton.setOnAction( e -> paymentHandler());
//         listButton.setOnAction( e -> listHandler());
//         saveAndQuitButton.setOnAction( e -> saveAndQuitHandler());
            
//         // configure the stage and make the stage visible
//         stage.setScene(scene);
//         stage.setTitle("Hostel Applicaton");
//         stage.setResizable(false); // see discussion below
//         stage.show();
//     }
// }
