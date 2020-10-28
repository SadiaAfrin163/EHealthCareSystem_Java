
package ehealthcaresystem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EHealthCareSystem extends Application{
    
    Button login, reg;

    public static void main(String[] args) {
       
       launch(args);    
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("E-Heathcare System");

        //Grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text sceneTitle = new Text("Welcome To E-Health Care Management System");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        //Log in button and registration button;
        login = new Button();
        login.setText("LogIn");
        HBox lg = new HBox(10);
        lg.getChildren().add(login);
        grid.add(lg, 0, 1);
        reg = new Button();
        reg.setText("Register");
        HBox regs = new HBox(10);
        regs.getChildren().add(reg);
        grid.add(regs, 0, 2);
        //Show sign in action event
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        //Handle the log in button events
        login.setOnAction((ActionEvent e) -> {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Move To Log In Activity");
            LogIn login1 = new LogIn();
            try {
                login1.start(LogIn.classStage);
            }catch (Exception ex) {
                Logger.getLogger(EHealthCareSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Handle the register button events
        reg.setOnAction((ActionEvent e) -> {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Move To Register Activity");
            Register register = new Register();
            try {
                register.start(Register.classStage);
            } catch (Exception ex) {
                Logger.getLogger(EHealthCareSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
