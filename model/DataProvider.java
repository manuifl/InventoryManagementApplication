/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author manue
 */
public class DataProvider {
  
    //All Animals
    private static ObservableList<Animal> allAnimals = FXCollections.observableArrayList();
    
    //Filtered Animals
    private static ObservableList<Animal> filteredAnimals = FXCollections.observableArrayList();
    
    
    public static void addAnimal(Animal animal)
    {
    allAnimals.add(animal);
    }
  
    public static ObservableList<Animal> getAllAnimals()
    {
        return allAnimals;
    }
    
    public static ObservableList<Animal> getAllFilteredAnimals()
    {
        return filteredAnimals;
    }
}