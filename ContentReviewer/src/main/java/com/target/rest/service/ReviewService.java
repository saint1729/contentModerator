package com.target.rest.service;

import java.util.List;

import com.target.rest.model.Content;

public interface ReviewService {
	
	public List<Content> getAllContents();
    public Content getContentById(Long id);
    public Content validateAndCreateContent(Content content);
    
}
