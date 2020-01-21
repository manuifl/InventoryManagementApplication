/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DataProvider;
import model.Dog;

/**
 * FXML Controller class
 *
 * @author manue
 */
public class CreateAnimalMenuController implements Initializable {

     @FXML
    private TextField animalIdTxt;

    @FXML
    private TextField breedTxt;

    @FXML
    private TextField lifespanTxt;

    @FXML
    private TextField behaviourTxt;

    @FXML
    private TextField priceTxt;

    @FXML
    private RadioButton vacYesRBtn;

    @FXML
    private RadioButton vacNoRBtn;

    
     Stage stage;
    Parent scene;
 //EVENT HANDLERS
    //back button
     @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will clear all text fields values, do you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.isPresent() && result.get() == ButtonType.OK)
        { 
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    @FXML
    void onActionSaveAnimal(ActionEvent event) throws IOException {

        try
        {
            //get the string value in the text field and assign it as an integer
            int id = Integer.parseInt(animalIdTxt.getText());
            //get the string value in the text field
            String breed = breedTxt.getText();
             //get the string value in the text field and assign it as an integer
            int lifespan = Integer.parseInt(lifespanTxt.getText());
            //get the string value in the text field
            String behaviour = behaviourTxt.getText();
            //get the string value in the text field and assign it as an double
            double price = Double.parseDouble(priceTxt.getText());

            boolean isVaccinated;
            String special = null;

            //check selected radio 
            if(vacYesRBtn.isSelected())
                isVaccinated = true;
            else
                isVaccinated = false;

            DataProvider.addAnimal(new Dog( id,  breed,  lifespan,  behaviour,  price,  isVaccinated,  special));

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
        
        catch(NumberFormatException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR, Empty or Invalid Value in Text Field");
            alert.setContentText("Please enter a valid value for each text field");
            alert.showAndWait();
            
            /*
           System.out.println("Please enter valid values");
           System.out.println("Exception: " + e);
           System.out.println(e.getMessage());
            */
        }
        
    /**
     * Initializes the controller class.
     */
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
}
