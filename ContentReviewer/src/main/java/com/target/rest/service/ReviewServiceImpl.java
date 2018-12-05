package com.target.rest.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.rest.model.Content;
import com.target.rest.repository.ContentRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ContentRepository contentRepository;

	public Content getContentById(Long id) {
		Optional<Content> content = contentRepository.findById(id);
		
		if(!content.isPresent()) {
			throw new RuntimeException("Id not found");
		}
		
		return content.get();
	}

	@Override
	public List<Content> getAllContents() {
		return contentRepository.findAll();
	}
	
	
	public Content validateAndCreateContent(Content content) {
		
		List<String> blocked = Arrays.asList("alpha", "beta", "gamma", "delta");
		
		Set<String> hs = new HashSet<>(blocked);
		
//		if(content.getComment().contains("Alpha")) {
//			return null;
//		} else {
//			
//			Content savedContent = contentRepository.save(content);
//			
//			return savedContent;
//		}
		
		String comment = content.getComment();
		
		String[] words = comment.split(" ");
		
		
		for(String word:words) {
			if(hs.contains(word.toLowerCase())) {
				throw new RuntimeException("Objectionable content is present");
			}
		}
		
		Content savedContent = contentRepository.save(content);
		
		return savedContent;
		
		
		
	}
	
	
	
}
