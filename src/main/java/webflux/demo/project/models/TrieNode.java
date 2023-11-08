package webflux.demo.project.models;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TrieNode {
	private Map<Character, TrieNode> children;
	private boolean end;

	public TrieNode() {
		children = new HashMap<>();
		end = false;
	}
}
