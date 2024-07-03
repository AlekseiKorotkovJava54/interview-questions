package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeSetTests {
TreeSet<Integer> treeSet;
Integer[]numbers = {10, -20, 30, -100, 80, 35, 200};
@BeforeEach
void setUp() {
	treeSet = new TreeSet<>(List.of(numbers));
}
	@Test
	void subsetTest() {
		Set<Integer> set = treeSet.subSet(10, true, 40, false);
		Integer[]expected = {30, 35, 10};
		runTest(expected, set);
	}
	@Test
	void subsetAsViewAddTest() {
		Set<Integer> set = treeSet.subSet(0, true, 50, true);
		set.add(20);
		Integer[] expected = {10, -20, 30, -100, 80, 35, 200, 20, 50};
		set.add(50);
		runTest(expected, treeSet);
	}
	void subsetAsViewRemoveTest() {
		Set<Integer> set = treeSet.subSet(0, true, 50, true);
		set.clear();
		Integer[]expected = { -20, -100, 80,  200};
		runTest(expected, treeSet);
	}
	void subsetAsCopyTest() {
		List<Integer> list = treeSet.stream().filter(n -> n >= 0 && n <= 50)
				.toList();
		TreeSet<Integer> set = new TreeSet<>(list);
		Integer[]expected = {10,  30,  35};
		runTest(expected, set);
		
		
	}
	private void runTest(Integer[] expected, Set<Integer> set) {
		Arrays.sort(expected);
		Integer[]actual = set.toArray(Integer[]::new);
		assertArrayEquals(expected, actual);
	}

}
