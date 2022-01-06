
/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 2
 */

/**
 * Decodes a given string using the head node of given HuffmanTree.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class Decoder {
	String myDecoded;
	
	public Decoder(HuffmanTreeNode theHead, String theCode) {
		myDecoded = Decode(theHead, theCode);		
	}
	
	/**
	 * Returns the decoded string.
	 * @return the decoded string.
	 */
	public String getDecoded() {
		return myDecoded;
	}
	
	private String Decode(HuffmanTreeNode theHead, String theCode) {
		StringBuilder result = new StringBuilder();
		HuffmanTreeNode pointer = theHead;
		for (char c: theCode.toCharArray()) {
			if (c == '0') {
				pointer = pointer.getLeft();
			} else if (c == '1') {
				pointer = pointer.getRight();
			}
			if (pointer.getLeft() == null && pointer.getRight() == null) {
				result.append(pointer.getChar());
				pointer = theHead;
			}
		}
		return result.toString();
	}
}
