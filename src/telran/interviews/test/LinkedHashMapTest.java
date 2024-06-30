package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
class LinkedHashMapTest {
LinkedHashMap<Integer, Integer> map;
@SuppressWarnings("serial")
@BeforeEach
void setUp() {
	map = new 
			LinkedHashMap<>(10, 0.75f, true) {
		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
			return size() > 3;
		}
	};
	map.put(1, 1);
	map.put(2, 4);
	map.put(3,  9);
}
	@Test
	void accessOrderTest() {
		Integer[] expected = {2, 3, 1};
		map.get(1);
		assertArrayEquals(expected,
				map.keySet().toArray(Integer[]::new));
	}
	@Test
	void removingEldestTest() {
		Integer[] expected = {2, 3, 4};
		map.put(4,  16);
		assertArrayEquals(expected,
				map.keySet().toArray(Integer[]::new));
	}
	@Test
	void removingEldestWithUpdatingAccessOrder() {
		Integer[] expected = {3, 1, 4};
		map.get(1);
		map.put(4,  16);
		assertArrayEquals(expected,
				map.keySet().toArray(Integer[]::new));
	}

}
