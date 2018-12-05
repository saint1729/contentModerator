package com.target.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.rest.model.Objectionable;
import com.target.rest.repository.ObjectionableRepository;

@Service
public class ObjectionableServiceImpl implements ObjectionableService {

	@Autowired
	private ObjectionableRepository objectionableRepository;
	
	
	public List<Objectionable> getAllObjectionables() {
		return objectionableRepository.findAll();		
	}
	
	public Objectionable getObjectionableById(Long id) {
		Optional<Objectionable> objectionable = objectionableRepository.findById(id);
		
		if(!objectionable.isPresent()) {
			throw new RuntimeException("Id not found");
		}
		
		return objectionable.get();
	}
	
	public Objectionable addObjectionablePhrase(Objectionable objectionable) {

		Objectionable savedObjectionable = objectionableRepository.save(objectionable);
		
		return savedObjectionable;
		
	}

	
}
