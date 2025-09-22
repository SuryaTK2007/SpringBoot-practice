package com.example.demo;
//import org.springframework.stereotype.Indexed;
//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
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
    public String getDescription(String description){
        return this.description=description;
    }
}
