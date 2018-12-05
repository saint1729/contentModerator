package com.target.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.target.rest.model.Objectionable;
import com.target.rest.service.ObjectionableService;



@RestController
@EnableAutoConfiguration
public class ObjectionableController {

	@Autowired
	ObjectionableService objectionableService;

	@RequestMapping(value = "/objectionables", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Objectionable> getAllObjectionables() {
		return objectionableService.getAllObjectionables();
	}

	@RequestMapping(value = "/objectionables/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Objectionable> getObjectionableById(@PathVariable("id") Long id) {
		return new ResponseEntity<Objectionable>(objectionableService.getObjectionableById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/objectionables", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Objectionable> createObjectionable(@RequestBody Objectionable objectionable) {
		
		objectionable = objectionableService.addObjectionablePhrase(objectionable);
		
		if(objectionable == null) {
			return new ResponseEntity<Objectionable>(objectionable, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Objectionable>(objectionable, HttpStatus.OK);
		}
	}


}
