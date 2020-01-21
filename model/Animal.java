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
public abstract class Animal {
    
    //Fields
    private int id;
    private String breed;
    private int lifespan;
    private String behaviour;
    private double price;
    private boolean vaccinated;

    //Constructor
    public Animal(int id, String breed, int lifespan, String behaviour, double price, boolean vaccinated) {
        this.id = id;
        this.breed = breed;
        this.lifespan = lifespan;
        this.behaviour = behaviour;
        this.price = price;
        this.vaccinated = vaccinated;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
    
    
    //Getters
    public int getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public int getLifespan() {
        return lifespan;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }
    
    
}
