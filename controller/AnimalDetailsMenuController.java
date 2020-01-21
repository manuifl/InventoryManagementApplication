/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Animal;
import model.Dog;

/**
 * FXML Controller class
 *
 * @author manue
 */
public class AnimalDetailsMenuController implements Initializable {

     @FXML
    private Label animalIdLbl;

    @FXML
    private Label breedLbl;

    @FXML
    private Label lifespanLbl;

    @FXML
    private Label behaviourLbl;

    @FXML
    private Label priceLbl;

    @FXML
    private Label vacLbl;

    @FXML
    private Label specialLbl;
    
    
    Stage stage;
    Parent scene;
    //EVENT HANDLERS
    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {
        
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/DisplayAnimalMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
       
    }
    
    public void sendAnimal(Animal dog)
    {
        animalIdLbl.setText(String.valueOf(dog.getId()));
        breedLbl.setText(dog.getBreed());
        lifespanLbl.setText(String.valueOf(dog.getLifespan()));
        priceLbl.setText(String.valueOf(dog.getPrice()));
        behaviourLbl.setText(dog.getBehaviour());
        
        if(dog.isVaccinated())
            vacLbl.setText("Yes");
        else
             vacLbl.setText("No");
        
        if(dog instanceof Dog)
            specialLbl.setText(((Dog) dog).getSpecial());
       
            
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
