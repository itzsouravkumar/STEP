import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    
    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class AutocompleteSystem {
    private TrieNode root;
    private Map<String, Integer> frequencyMap;

    public AutocompleteSystem() {
        root = new TrieNode();
        frequencyMap = new HashMap<>();
    }

    public void updateFrequency(String query) {
        frequencyMap.put(query, frequencyMap.getOrDefault(query, 0) + 1);
        insertToTrie(query);
    }

    private void insertToTrie(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public List<String> search(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return new ArrayList<>();
            }
        }
        
        List<String> results = new ArrayList<>();
        findAllWords(current, new StringBuilder(prefix), results);
        
        // Sort based on frequency
        results.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        
        // Return top 10
        return results.size() > 10 ? results.subList(0, 10) : results;
    }
    
    private void findAllWords(TrieNode node, StringBuilder currentWord, List<String> results) {
        if (node.isEndOfWord) {
            results.add(currentWord.toString());
        }
        
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            currentWord.append(entry.getKey());
            findAllWords(entry.getValue(), currentWord, results);
            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }

    public static void main(String[] args) {
        AutocompleteSystem autocomplete = new AutocompleteSystem();
        System.out.println("Adding searches...");
        autocomplete.updateFrequency("java tutorial");
        autocomplete.updateFrequency("javascript");
        autocomplete.updateFrequency("javascript tutorial");
        autocomplete.updateFrequency("java download");
        for(int i=0; i<4; i++) autocomplete.updateFrequency("java tutorial"); 
        for(int i=0; i<2; i++) autocomplete.updateFrequency("javascript");

        List<String> results = autocomplete.search("jav");
        System.out.println("search(\"jav\") ->");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i+1) + ". \"" + results.get(i) + "\" (" + autocomplete.frequencyMap.get(results.get(i)) + " searches)");
        }
        
        System.out.println("updateFrequency(\"java 21 features\")");
        autocomplete.updateFrequency("java 21 features");
        autocomplete.updateFrequency("java 21 features");
        autocomplete.updateFrequency("java 21 features");
        System.out.println("Frequency configured.");
    }
}
