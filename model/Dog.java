/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author manue
 */
public class Dog extends Animal{
    
    //Sub-Class Field
    private String special;
    
    //Constructor
    public Dog(int id, String breed, int lifespan, String behaviour, double price, boolean vaccinated, String special) {
        //calling super constructor
        super(id, breed, lifespan, behaviour, price, vaccinated);
        this.special = special;
    }
 
    //Setter
    public void setSpecial(String special) {
        this.special = special;
    }
    
    //Getter
    public String getSpecial() {
        return special;
    }

   
    
}
