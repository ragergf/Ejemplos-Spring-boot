package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;


@RestController
public class TeamController {

	@Autowired TeamRepository teamRepository;
	
	@RequestMapping("/teams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}
	
	@RequestMapping(value="/teams/{id}",  method = RequestMethod.GET, produces = "application/json")
	public Team getTeam(@PathVariable Long id){
		return teamRepository.findOne(id);
	}
}
	
