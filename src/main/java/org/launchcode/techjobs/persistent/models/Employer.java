package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Add @Entity annotation
@Entity
public class Employer extends AbstractEntity {
    //Add the field for location with validation that ensures it is not empty and has a reasonable length
    @NotNull
    @Size(min = 2, max = 100)
    private String location;

    //Add no arg constructor for hibernate to create an object
    public Employer() {}

    //public accessor methods w/ getter and setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
