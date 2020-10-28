
package ehealthcaresystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogIn extends Application{
   
    TextField userTextField = new TextField();
    PasswordField pwBox = new PasswordField();
  

    
    //Create a class field of type Shape preferably static
    static Stage classStage = new Stage();
    
    public LogIn(){
    
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        classStage = primaryStage;
        primaryStage.setTitle("E-Heathcare Log In System");

        //Grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text sceneTitle = new Text("Welcome To E-Health Care Management System");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        grid.add(pwBox, 1, 2);
        //Log in button and registration button;
        Button login = new Button();
        login.setText("LogIn");
        HBox lg = new HBox(10);
        lg.setAlignment(Pos.BOTTOM_RIGHT);
        lg.getChildren().add(login);
        grid.add(lg, 1, 4);
        
        //Show sign in action event
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        //Onclik listener for register button
        login.setOnAction((ActionEvent e) -> {
            userLogIn();
            //userLogIn(userName1,password,pathToFile);
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Log In Successfull");
        });
        
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void userLogIn(){
        //BufferedReader br = null;
        String userName = userTextField.getText();
        String password = pwBox.getText();
        boolean grantAccess = false;
        File f = new File("F:\\\\SUMMER 2020\\\\CSE 215L\\\\EHealthCareSystem\\\\Register.txt");
        try{
            Scanner read = new Scanner(f);
            
            while(read.hasNextLine()){
                if(read.nextLine().equals(userName)){
                  if(read.nextLine().equals(password)){ 
                     grantAccess=true; 
                     read.close();
                     break;
                  }
                }
            }
            if(grantAccess) {
                
                ChooseManu.displayMenu("E-Heathcare System Menu","1  >> Add New Patient Record ","2  >> Add Diagnosis Information ","3  >> Bill");
               
              }
                
            else {
                System.exit(0);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
