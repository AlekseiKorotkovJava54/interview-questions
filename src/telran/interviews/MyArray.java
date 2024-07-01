package telran.interviews;

import java.util.HashMap;

//all methods must have complexity O[1]
public class MyArray<T> {
 private int size;
 private T allValues;
 private HashMap<Integer, T> updatedValues = new HashMap<>();
	public void setAll(T value) {
		//all array's elements should be set with a given value
		updatedValues = new HashMap<>();
		allValues = value;
	}
	public void set(int index, T value) {
		//set new value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		checkIndex(index);
		updatedValues.put(index, value);
	}
	private void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
	}
	public T get(int index) {
		//returns a value at a given index
		//throws ArrayIndexOutOfBoundsException for incorrect index
		checkIndex(index);
		return updatedValues.getOrDefault(index, allValues);
	}
	public MyArray(int size) {
		//creates the Array object for a given size
		//with setting null's at each element
		this.size = size;
	}
}
