
package ehealthcaresystem;

import static ehealthcaresystem.LogIn.classStage;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ChooseManu {

    private static void patientRecord()  {
        PatientRecord pr = new PatientRecord();
        try {
                pr.start(PatientRecord.classStage);
            }catch (Exception ex) {
                Logger.getLogger(EHealthCareSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private static void diagnosisInfo() {
        DiagnosisInformation pr = new DiagnosisInformation();
        try {
                pr.start(DiagnosisInformation.classStage);
            }catch (Exception ex) {
                Logger.getLogger(EHealthCareSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private static void bill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void isInt(TextField optTextField, String text) {
        try{
            int input = Integer.parseInt(optTextField.getText());
            selectOption(input);
        }catch(NumberFormatException e){
        
        }
    }
      
    public ChooseManu() {
    
    }
    
    public static void displayMenu(String title, String op1, String op2, String op3) {
         Stage window = new Stage();
         window.initModality(Modality.APPLICATION_MODAL);
         window.setTitle(title);
         window.setHeight(600);
         window.setWidth(600);
         
         Label label1 = new Label();
         label1.setText(op1);
         Label label2 = new Label();
         label2.setText(op2);
         Label label3 = new Label();
         label3.setText(op3);
         
        //Label ChooseOpt = new Label("Choose Option:");
        final TextField optTextField = new TextField("Enter your option");
        
         //Back button and enter button;
        Button closeButton = new Button("Back");
        Button enter = new Button("Enter");
        
        //Handle the back button events
        closeButton.setOnAction((ActionEvent e) -> {
            window.close();
         });
        
        //Handle the register button events
        enter.setOnAction((ActionEvent e) -> {
            isInt(optTextField,optTextField.getText());                        
        });
         
         VBox layout = new VBox(10);
         layout.getChildren().addAll(label1,label2,label3, optTextField, closeButton,enter);
         layout.setAlignment(Pos.CENTER);
         
         Scene scene = new Scene(layout);
         window.setScene(scene);
         window.showAndWait();
         
    }
    
    public static void selectOption(int input) {
        
        //if inputed choice is other than given choice
        switch(input)
        {
        case 1: patientRecord();
        break;
        case 2: diagnosisInfo();
        break;
        case 3: bill();
        break;       
        case 6: exit();
        break;
        default: 
          break;
        }
       
    }

       
}
