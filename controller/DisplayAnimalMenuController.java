/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Animal;
import model.DataProvider;
import model.Dog;

/**
 * FXML Controller class
 *
 * @author manue
 */
public class DisplayAnimalMenuController implements Initializable {

    @FXML
    private TextField searchBarTxt;
    
    @FXML
    private TableView<Animal> animalTableView;

    @FXML
    private TableColumn<Animal, Integer> animalIdCol;

    @FXML
    private TableColumn<Animal, String> breedCol;

    @FXML
    private TableColumn<Animal, Integer> lifespanCol;

    @FXML
    private TableColumn<Animal, Double> priceCol;
    
     

    Stage stage;
    Parent scene;
    
    
    
   //SEARCH FUNCTION 
    public boolean search(int id)
    {
        
    for(Animal dog : DataProvider.getAllAnimals())
     {
         if(dog.getId() == id)
             return true;
     } 
    
    return false;
    }
    
    
    public boolean update(int id, Animal animal)
    {
      int index = -1;
      
      for(Animal dog : DataProvider.getAllAnimals())
      {
       index++;
       
       if(dog.getId() == id)
       {
          DataProvider.getAllAnimals().set(index, animal);
          return true;
       }  
       
      }
      
      return false;
    }
    
    
    public boolean delete(int id) 
    {
        for(Animal dog : DataProvider.getAllAnimals())
     {
         if(dog.getId() == id)
             return DataProvider.getAllAnimals().remove(dog);
     } 
        return false;
    }
    
    
    
    public Animal selectAnimal(int id)
    {
        for(Animal dog : DataProvider.getAllAnimals())
        {
            if(dog.getId() == id)
                return dog;
        }
        
        return null;
    }
    
    public ObservableList<Animal> filter(String breed)
    {
        //FIRST Check if filtered list has content and clear it to avoid copies each time we call a filter
        if(!(DataProvider.getAllFilteredAnimals().isEmpty()))
            DataProvider.getAllFilteredAnimals().clear();
        
        //GO THROUGH ALL ANIMALS
        for(Animal dog : DataProvider.getAllAnimals())
        {
            //IF there is a match, add them to the filter list
            if(dog.getBreed().contains(breed))//HERE
                DataProvider.getAllFilteredAnimals().add(dog);
        }
        
        //If there are no matches after going through the list then display all animals instead of none
         if(DataProvider.getAllFilteredAnimals().isEmpty())
             return DataProvider.getAllAnimals();
         else
             return DataProvider.getAllFilteredAnimals();
    }
    /**
     * Initializes the controller class.
     */
    
    @FXML
    void onActionDisplaySearchResults(ActionEvent event) {

        animalTableView.setItems(filter(searchBarTxt.getText()));
        //System.out.println(searchBarTxt.getText());
           
    }
    
    @FXML
    void onActionDisplayAnimalDetailsMenu(ActionEvent event) throws IOException {
       
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/AnimalDetailsMenu.fxml"));
        loader.load();
        
        AnimalDetailsMenuController ADMController = loader.getController();
        ADMController.sendAnimal(animalTableView.getSelectionModel().getSelectedItem());
        
      
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
        
    }

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {
        
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        animalTableView.setItems(DataProvider.getAllAnimals());
        
        //TESTING FILTER
       //animalTableView.setItems(filter("A"));
        
        animalIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        breedCol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        lifespanCol.setCellValueFactory(new PropertyValueFactory<>("lifespan"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        
        
        //TESTING SEARCH FUNCTION
        /*
        if(search(4))
            System.out.println("Match!");
        else
            System.out.println("No Match!");
        */
        
        
        //TESTING UPDATE FUNCTION
         /*
        if(update(5, new Dog(5, "Great Dane", 11, "Friendly", 799.99, true, "Super Strength")))
            System.out.println("Update Succesfull");
        else
            System.out.println("Update Failed");
        */
         
        //TESTING DELETE FUNCTION
         /*
         if(delete(5))
             System.out.println("Update Succesfull");
         else
             System.out.println("No Match Found to Delete");
        */
         
        //Testing Highlight Animal
        //animalTableView.getSelectionModel().select(selectAnimal(3));
         
    }    
    

    
    
}
