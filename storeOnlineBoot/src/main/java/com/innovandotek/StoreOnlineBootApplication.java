package com.innovandotek;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.innovandotek.model.Category;
import com.innovandotek.repository.CategoryRepository;

@SpringBootApplication
public class StoreOnlineBootApplication {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostConstruct
	public void init()
	{
		Category category = new Category();
		category.setCode("TEC");
		category.setName("Tecnologia");
		categoryRepository.save(category);
		
		category = new Category();
		category.setCode("HOG");
		category.setName("Hogar");
		categoryRepository.save(category);
	}

	public static void main(String[] args) {
		SpringApplication.run(StoreOnlineBootApplication.class, args);
	}
}
