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

import com.target.rest.model.Content;
import com.target.rest.service.ReviewService;


@RestController
@EnableAutoConfiguration
public class ContentController {

	@Autowired
	ReviewService reviewService;

	@RequestMapping(value = "/health")
	public ResponseEntity<String> getContentById() {
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	@RequestMapping(value = "/contents", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Content> getAllContents() {
		return reviewService.getAllContents();
	}

	@RequestMapping(value = "/contents/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Content> getContentById(@PathVariable("id") Long id) {
		return new ResponseEntity<Content>(reviewService.getContentById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contents", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Content> createContent(@RequestBody Content content) {
		
		//try {
			content = reviewService.validateAndCreateContent(content);
		//} catch {
			
		//}
		if(content == null) {
			return new ResponseEntity<Content>(content, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Content>(content, HttpStatus.OK);
		}
	}
	
}
