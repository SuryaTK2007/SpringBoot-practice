package com.example.demo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Item(){
    }
    public Item(String description){
        this.description=description;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getDescription(){
        return this.description;
    } 
    public void setDescription(String description){
        this.description=description;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }
}
