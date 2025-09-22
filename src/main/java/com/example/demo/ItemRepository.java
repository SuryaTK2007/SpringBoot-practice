package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface now has methods like findAll(), findById(), save(), deleteById(), etc.
public interface ItemRepository extends JpaRepository<Item, Long>{
    // By extending JpaRepository, we get a ton of database methods for free!
    // We specify <Item, Long> because it's a repository for our "Item" entity,
    // and the type of its ID is "Long".
}
