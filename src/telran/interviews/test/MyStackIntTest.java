package telran.interviews.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyStackInt;

public class MyStackIntTest {
	
	MyStackInt stack = new MyStackInt();
	Random random = new Random();
	
	@BeforeEach
	void setUp() {
		random.ints().limit(100).forEach(n -> stack.push(n));
	}
	
	@Test
	void pushTest() {

	}
	
	@Test
	void popTest() {
		
	}
	
	@Test
	void peekTest() {
		
	}
	
	@Test
	void isEmptyTest() {
		assertTrue(new MyStackInt().isEmpty());
		assertFalse(stack.isEmpty());
	}
	
	@Test
	void getMaxElementTest() {
		
	}
}
