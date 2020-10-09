package com.mindtree.superheroproject.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.superheroproject.entity.Comic;
import com.mindtree.superheroproject.entity.Superhero;
import com.mindtree.superheroproject.exception.ServiceException;
import com.mindtree.superheroproject.service.Superheroservice;

@RestController
@RequestMapping("/api")
public class Comiccontroller {
	@Autowired
	private Superheroservice superheroservice;

//insert all detail
	@PostMapping(value = "/postdata")
	public ResponseEntity<Map<String, Object>> adddata(@RequestBody Set<Comic> comic) {
		
		boolean isInserted = superheroservice.insertData(comic);

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "comic details");
		response.put("error", false);
		response.put("body", isInserted);
		response.put("time-stamp", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

//get super hero whose power is invisibility and flying
	@GetMapping(value = "/getpower")
	public Set<Superhero> getsuperhero() {
		Set<Superhero> superhero = superheroservice.getsuperheroes();
		return superhero;
	}

	// get total damage done by particular hero
	@GetMapping(value = "/totaldamage/{heroId}")
	public int totaldamage(@PathVariable int heroId) throws ServiceException {
		return superheroservice.totaldamagedone(heroId);
	}

}