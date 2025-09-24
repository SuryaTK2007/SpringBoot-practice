package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    private String username;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Item> items=new ArrayList<>(); 
    public User(){
    }
    public User(String username){
        this.username=username;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public List<Item> getItems(){
        return items;
    }
    public void setItems(List<Item> items){
        this.items=items;
    }
}
