/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfjavafxmlapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DataProvider;
import model.Dog;

/**
 *
 * @author manue
 */
public class MFJavaFXMLApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Dog dog1 = new Dog(1, "Bulldog", 12, "Alert", 799.99, true, "Reads Minds");
        Dog dog2 = new Dog(2, "Doberman", 11, "Alert", 699.99, true, "Climbs");
        Dog dog3 = new Dog(3, "Anatolian Shepherd", 13, "Alert", 599.99, true, "Super Strength");
        Dog dog4 = new Dog(4, "Boxer", 12, "Alert", 589.99, true, "Teleportation");
        Dog dog5 = new Dog(5, "Alaskan Malamute", 12, "Alert", 299.99, true, "Crime Fighter");
        
        
        DataProvider.addAnimal(dog1);
        DataProvider.addAnimal(dog2);
        DataProvider.addAnimal(dog3);
        DataProvider.addAnimal(dog4);
        DataProvider.addAnimal(dog5);
        launch(args);   
    }
    
}
