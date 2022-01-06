import java.util.HashMap;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 2
 */

/**
 * Encodes a given string using the head node of given HuffmanTree.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class Encoder {
	private HashMap<Character, String> myMap;
	private HuffmanTreeNode myHead;	
	private String myCode;
	
	public Encoder(HuffmanTreeNode theHead, String theString) {
		myMap = new HashMap<Character, String>();
		myHead = theHead;
		traverse(myHead, "");
		StringBuilder result = new StringBuilder();
		for (char x: theString.toCharArray()) {
			result.append(myMap.get(x)); 
		}
		myCode = result.toString();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<Character, String> getMap() {
		return (HashMap<Character, String>) myMap.clone();
	}
	
	/**
	 * Returns the coded string.
	 * @return the coded string.
	 */
	public String getCode() {
		return myCode;
	}
	
	private void traverse(HuffmanTreeNode theNode, String theString) 
    { 
        // recursive base case: left and right are null  
        if (theNode.getLeft() == null && theNode.getRight() == null) { 
            myMap.put(theNode.getChar(), theString);
        } else {
	        // left add "0" to the code. 
	        // right add "1" to the code. 
	        traverse(theNode.getLeft() , theString + "0"); 
	        traverse(theNode.getRight(), theString + "1"); 
        }
    }
 }
