package com.target.rest.service;

import java.util.List;

import com.target.rest.model.Objectionable;

public interface ObjectionableService {

	public List<Objectionable> getAllObjectionables();
	public Objectionable getObjectionableById(Long id);
	public Objectionable addObjectionablePhrase(Objectionable objectionable);
    
}
