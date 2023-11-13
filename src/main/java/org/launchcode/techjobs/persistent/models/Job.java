package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
//Update the class definition of Job to extend AbstractEntity
public class Job extends AbstractEntity {
    //@Id
    //@GeneratedValue
    //private int id;
    //private String name;
    //private String employer;
    //private String skills;

    //replace the type of the field employer to be of type Employer
    //add @ManyToOne annotation to the updated field Employer
    @ManyToOne
    private Employer employer;

    //refactored to be list of Skill objects
    @ManyToMany
    private List<Skill> skills;

    public Job() {
    }

    // Initialize the id and value fields.
    //public Job(String anEmployer, String someSkills) {

    //refactor methods impacted from type change
    public Job(Employer employer, List<Skill> skills){
        super();
        this.employer = employer;
        this.skills = skills;
    }

    // Getters and setters.
    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmployer() {
//        return employer;
//    }
    //refactored getter and setter for new Employer type
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    // refactored getter and setter for new skills type
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}
