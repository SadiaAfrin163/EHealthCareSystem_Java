
package ehealthcaresystem;

import static ehealthcaresystem.PatientRecord.classStage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DiagnosisInformation extends Application{
    
     //Create a class field of type Shape preferably static
    static Stage classStage = new Stage();
    
    public DiagnosisInformation(){}

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("E-Heathcare patient Diagnosis information System");

        //Grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text sceneTitle = new Text("Welcome To E-Health Care Management System");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        TextField admissionDate = new TextField();
        admissionDate.setPromptText("Date of Admission");
        TextField symptom = new TextField();
        symptom.setPromptText("Patien Symptom");
        TextField medicine = new TextField();
        medicine.setPromptText("Medicine");
        TextField ward = new TextField();
        ward.setPromptText("Ward");
        TextField doctor = new TextField("Enter Gender");
        doctor.setPromptText("Doctor name");
        TextField pfileNme = new TextField();
        pfileNme.setPromptText("Patient file name");
        
        grid.add(admissionDate, 0, 1);       
        grid.add(symptom, 0, 2);
        grid.add(medicine, 0, 3);
        grid.add(ward, 0, 4);
        grid.add(doctor, 0, 5);
        grid.add(pfileNme, 0, 6);
        

        
        Button enter = new Button();
        enter.setText("Enter");
        HBox ent = new HBox(10);
        ent.setAlignment(Pos.BOTTOM_RIGHT);
        ent.getChildren().add(enter);
        grid.add(ent, 1, 7);
        
        Button closeButton = new Button();
        closeButton.setText("Close");
        HBox cls = new HBox(10);
        cls.setAlignment(Pos.BOTTOM_RIGHT);
        cls.getChildren().add(closeButton);
        grid.add(cls, 1, 8);
        
        //Show sign in action event
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 9);
        
        //Onclik listener for register button
        enter.setOnAction((ActionEvent e) -> {
            String fileName = pfileNme.getText();
            String date = admissionDate.getText();
            String psymptom = symptom.getText();
            String pmedicine = medicine.getText();
            String pward = ward.getText();
            String pdoctor = doctor.getText();
            
            //Method recordInfo invoke to write in file
            recordInfo(fileName,date,psymptom,pmedicine,pward,pdoctor);
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Patient Information Recorded successfully");
        });
        
        //Handle the back button events
        closeButton.setOnAction((ActionEvent e) -> {
            classStage.close();
         });
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void recordInfo(String flname, String date, String psymptom, String pmedicine, String pward, String pdoctor){
        
         try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(flname+".txt");

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(date);
            bw.newLine();
            bw.write(psymptom);
            bw.newLine();
            bw.write((pmedicine));
            bw.newLine();
            bw.write(pward);
            bw.newLine();
            bw.write(pdoctor);
            bw.newLine();
            
            // Always close files.
            bw.close();
        }
        catch (IOException e){
        }
    }
    
}
