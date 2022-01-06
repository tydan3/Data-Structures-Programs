import java.util.HashMap;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 2
 */

/**
 * Represents a Huffman Frequency Table
 * @author Daniel Ty
 * @version Winter 2020
 */
public class HuffmanFrequencyTable {
	private HashMap<Character, Integer> myMap;
	private char[] myOrder;
	private String myInput;
	
	public HuffmanFrequencyTable(String theInput) {
		myMap = new HashMap<Character, Integer>();
		myInput = theInput;
		char[] inputArray = myInput.toCharArray();
		for (char x : inputArray) {
			if (!myMap.containsKey(x)) {
				myMap.put(x, 1);
			} else {
				myMap.put(x, myMap.get(x) + 1);
			}
		}
		
		myOrder = new char[myMap.size()];
		int orderIndex = 0;
		for (int i = 0; i < inputArray.length; i++) {
			boolean contains = false;
			for (int j = i - 1; j >= 0; j--) {
				if (!contains) {
					contains = inputArray[i] == inputArray[j];
				}
			}
			if (!contains || i == 0) {
				myOrder[orderIndex] = inputArray[i];
				orderIndex++;
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<Character, Integer> getMap() {
		return (HashMap<Character, Integer>) myMap.clone();
	}
	
	public char[] getOrder() {
		return myOrder.clone();
	}
	
	public String getInput() {
		return myInput;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("char\tfrequency\n");
		result.append("-----------------\n");
		for(char x: myOrder) {
			result.append(x + "\t");
			result.append(myMap.get(x) + "\n");
		}
		return result.toString();
	}
}
