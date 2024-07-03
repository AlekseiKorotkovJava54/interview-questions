package telran.interviews;

import java.util.TreeSet;

public class AutoCompletion {
	
	TreeSet<String> wordsSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	
	public boolean addWord(String word) {
		return wordsSet.add(word);
	}
	public String [] getVariants(String prefix) {
		return wordsSet.subSet(prefix, prefix + Character.MAX_VALUE).toArray(String[]::new);
	}
}
