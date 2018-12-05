package com.target.rest.model;

import java.util.HashMap;
import java.util.Map;


public class TrieNode {

	
	private Map<Character, TrieNode> children;
	private boolean endOfWord;
    
    public TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }

    public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

	
    public void insert(TrieNode root, String word) {
        
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.getChildren().get(c);
            if(node == null) {
                node = new TrieNode();
                current.getChildren().put(c, node);
            }
            current = node;
        }
        
        current.endOfWord = true;
    }
    
    public boolean search(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null) {
                return false;
            }
            current = node;
        }
        
        return current.endOfWord == true;
    }
    
    public void delete(TrieNode root, String word) {
        delete(root, word, 0);
    }
    
    public boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()) {
            if(current.endOfWord != true) {
                return false;
            }
            current.endOfWord = false;
            
            return current.children.size() == 0;
        }
        
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if(node == null) {
            return false;
        }
        
        boolean deleteNode = delete(node, word, index+1);
        
        if(deleteNode == true) {
            current.children.remove(c);
            return current.children.size() == 0;
        }
        
        return false;
    }


	
	
}
