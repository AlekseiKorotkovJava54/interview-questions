package telran.interviews;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;
public class InterviewQuestions {
public static void displayOccurrences(String [] strings) {
	HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
	TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
	displayOccurrences(treeMapOccurrences);
}
public static void displayOccurrencesStream(String[] strings) {
	Arrays.stream(strings)
	.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
	.entrySet().stream().sorted((e1, e2) -> {
		int res = Long.compare(e2.getValue(), e1.getValue());
		return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
	}).forEachOrdered(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
}

private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
	treeMapOccurrences.entrySet().forEach(e -> {
		e.getValue().forEach(str -> System.out.printf("%s => %d\n",str, e.getKey()));
	});
}

private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
	TreeMap<Integer, TreeSet<String>> result =
			new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
	mapOccurrences.entrySet()
	.forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>() ).add(e.getKey()));
	
	return result;
}

private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
	HashMap<String, Integer> result = new HashMap<>();
	for(String str: strings) {
		result.merge(str, 1, Integer::sum);
	}
	return result;
}
static public boolean isSum2(int [] array, int sum) {
	//returns true if a given array contains two numbers, the summing of which
	//equals a given 'sum' value
	//complexity O[N] only one pass over the elements
	HashSet<Integer> helper = new HashSet<>();
	int index = 0;
	while(index < array.length && !helper.contains(sum - array[index])) {
		helper.add(array[index++]);
	}
	return index < array.length;
}
static public int getMaxWithNegativePresentation(int [] array) {
	//returns maximal positive value for which exists negative one with the same abs value
	//if no pair of positive and negative values with the same abs value the method returns -1
	//complexity O[N] only one pass over the elements
	int maxRes = -1;
	HashSet<Integer> helper = new HashSet<>();
	for(int num: array) {
		if(helper.contains(-num)) {
			maxRes = Math.max(maxRes, Math.abs(num));
		} else {
			helper.add(num);
		}
	}
	return maxRes;
}
public static Map<Integer, Integer> getMapSquares(List<Integer> numbers) {
	Map<Integer, Integer> res = numbers.stream()
			.collect(Collectors.toMap(n -> n, n -> n * n, (v1, v2) -> v1,
					LinkedHashMap::new));
	return res;
}

public static boolean isAnagram(String word, String anagram) {
	boolean res;
	if(word.equals(anagram) || word.length() != anagram.length()) {
		res = false;
	}
	else {
		Map<Character, Long> wordMap = word.toLowerCase().chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		anagram.toLowerCase().chars().mapToObj(c -> (char) c).forEach(c -> wordMap.computeIfPresent(c, (k, v) -> v > 1 ? v - 1 : null));
		
		res = wordMap.isEmpty();
	}
	return res;
}		

public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory, List<LocalDate> dates) {
	TreeMap<LocalDate, String> rolesHistoryMap = rolesHistory.stream()
			.collect(Collectors.toMap(DateRole::date, DateRole::role,(existing, replacement) -> existing, TreeMap::new));
	
	return dates.stream().map(d -> {
		Entry<LocalDate, String> role = rolesHistoryMap.floorEntry(d);
		return role == null ? new DateRole(d, null) : new DateRole(d, role.getValue()) ;
	}).collect(Collectors.toList());
}

public static void displayDigitsStatistics() {
	new Random().ints(1000000, 0, Integer.MAX_VALUE).flatMap(i -> Integer.toString(i).chars()).map(c -> c - '0').boxed()
	.collect(Collectors.groupingBy(i -> i, Collectors.counting()))
	.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
	.forEachOrdered(e -> System.out.printf("%d -> %d\n", e.getKey(), e.getValue()));
;}

}
