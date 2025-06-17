package com.example.demo.JpaRespo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepo extends JpaRepository<Item, String> {

	Item findByName(String name);
}
