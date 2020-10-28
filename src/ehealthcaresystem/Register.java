
package ehealthcaresystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
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

public class Register extends Application{
    
    TextField userTextField = new TextField();
    PasswordField pwBox = new PasswordField();
    
    private Formatter x;
    
    public Register(){
    
    }
    
    public void openFile() {
        
        try{
            x = new Formatter("Register.txt");
        }
        catch(Exception e){
            System.out.println("An Error Occurred");
        }
    }

    //Create a class field of type Shape preferably static
    static Stage classStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("E-Heathcare Register System");

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
        Button reg = new Button();
        reg.setText("Register");
        HBox rg = new HBox(10);
        rg.setAlignment(Pos.BOTTOM_RIGHT);
        rg.getChildren().add(reg);
        grid.add(rg, 1, 4);
        
        //Show sign in action event
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        //Onclik listener for register button
        reg.setOnAction((ActionEvent e) -> {
            userRegister();
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Register Successfull");
        });
        
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void userRegister() {
         try (BufferedWriter bw = new BufferedWriter(new FileWriter("Register.txt", true))) {
            bw.write(userTextField.getText());
            bw.newLine();
            bw.write(pwBox.getText());
            bw.newLine();
            
            bw.close();
        }
        catch (IOException e){
        }
    }
}
    
