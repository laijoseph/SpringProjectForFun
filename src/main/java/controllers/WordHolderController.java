package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.TrieNode;
import service.WordDictionaryService;

@RestController
@RequestMapping("/dictionary")
@ComponentScan
public class WordHolderController {

	@Autowired
	public WordHolderController(WordDictionaryService wordDictionaryService) {
		this.wordDictionaryService = wordDictionaryService;
	}

	private WordDictionaryService wordDictionaryService;
	
	@PutMapping("/add")
	public TrieNode addWord(@RequestParam String word) {
	    return wordDictionaryService.addWord(word);
	}

}
