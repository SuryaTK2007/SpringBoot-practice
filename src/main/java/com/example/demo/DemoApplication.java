package com.example.demo;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@SpringBootApplication
public class DemoApplication {
	private final ItemRepository itemRepository;
	public DemoApplication(ItemRepository itemRepository){
		this.itemRepository=itemRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/items")
	public List<Item> getItems(){
		return itemRepository.findAll();
	}
	@PostMapping("/items")
	public Item addItem(@Valid @RequestBody Item item){
		return itemRepository.save(item);
	}
	@DeleteMapping("/items/{id}")
	public String deleteItem(@PathVariable Long id){
		itemRepository.deleteById(id);
		return "Item with id " + id + " has been deleted.";
	}
}
