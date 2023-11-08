package webflux.demo.project.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import webflux.demo.project.models.TrieNode;

/**
 * Demo service which solves Leetcode Problem 211. Design Add and Search Words
 * Data Structure
 * <a>https://leetcode.com/problems/design-add-and-search-words-data-structure/description/</a>
 */
@Service
public class WordDictionaryService {

	private TrieNode root;

	/**
	 * Constructor for the class.
	 */
	public WordDictionaryService() {
		root = new TrieNode();
	}

	/**
	 * Adds a word to the Trie.
	 * 
	 * @param word the word to add
	 */
	public TrieNode addWord(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			Map<Character, TrieNode> children = cur.getChildren();
			if (children.containsKey(c)) {
				// just move the cur pointer
				cur = children.get(c);
			} else {
				// add C to children, move curpointer
				TrieNode child = new TrieNode();
				children.put(c, child);
				cur = child;
			}
		}
		cur.setEnd(true);
		return root;
	}

	/**
	 * Searches the Trie for the word.
	 * 
	 * @param word word to search for
	 * @return {@code true} if the word can be found {@code false} otherwise.
	 */
	public boolean search(String word) {
		return searchHelper(root, word, 0);
	}

	/**
	 * Search helper method for searching the Trie.
	 * 
	 * @param cur   the current TrieNode
	 * @param word  the word
	 * @param index the index of the character we're looking at
	 * @return
	 */
	private boolean searchHelper(TrieNode cur, String word, int index) {
		if (word.length() == index) {
			return cur.isEnd();
		}
		char c = word.charAt(index);
		if (c == '.') {
			// recursively check
			for (TrieNode child : cur.getChildren().values()) {
				if (searchHelper(child, word, index + 1)) {
					return true;
				}
			}
			return false;
		} else {
			TrieNode child = root.getChildren().get(c);
			if (child == null) {
				return false;
			}
			return searchHelper(child, word, index + 1);
		}
	}
}
