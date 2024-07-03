package telran.interviews;

import java.util.LinkedList;

public class MyStackInt {
	
	LinkedList<Integer> stack = new LinkedList<Integer>();
	LinkedList<Integer> maxElement = new LinkedList<Integer>();

	public void push(int num) {
		stack.addLast(num);
		if(maxElement.isEmpty() || num>=maxElement.getLast()) maxElement.add(num);
	}
	
	public int pop() {
		int removed = stack.removeLast();
		if(removed == maxElement.getLast()) maxElement.removeLast();
		return removed;
	}
	
	public int peek() {
		return stack.getLast();
	}
	
	public boolean isEmpty() {
		return stack.size() == 0;
	}
	
	public int getMaxElement() {
		return maxElement.getLast();
	}
}
