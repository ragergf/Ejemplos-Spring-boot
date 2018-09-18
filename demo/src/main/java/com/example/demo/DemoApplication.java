package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@PostConstruct
	public void init()
	{
		List<Team> list = new ArrayList<>();
		Team team = new Team();		
		team.setLocation("Harlem");
		team.setName("Globetrotters");
		list.add(team);
		
		team = new Team();
		team.setLocation("Washington");
		team.setName("Generals");
		list.add(team);
		
		teamRepository.save(list);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
