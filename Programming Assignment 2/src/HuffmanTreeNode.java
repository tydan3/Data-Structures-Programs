
public class HuffmanTreeNode {
	private char myChar;
	private int myFreq;
	private HuffmanTreeNode myLeft;
	private HuffmanTreeNode myRight;
	
	/**
	 * Constructs a node of the passed in character and frequency.
	 * @param theChar the character 
	 * @param theFreq the frequency
	 */
	public HuffmanTreeNode(char theChar, int theFreq) {
		myChar = theChar;
		myFreq = theFreq;
		myLeft = null;
		myRight = null;
	}
	
	/**
	 * Constructs a node whose frequency is the sum of two passed in nodes.
	 * The passed in nodes are to be the children of the constructed node.
	 * @param theLeft HuffmanTreeNode the left child
	 * @param theRight HuffmanTreeNode the right child
	 */
	public HuffmanTreeNode(HuffmanTreeNode theLeft, HuffmanTreeNode theRight) {
		myFreq = theLeft.getFreq() + theRight.getFreq();
		myLeft = theLeft;
		myRight = theRight;
	}
	
	public char getChar() {
		return myChar;
	}
	
	public int getFreq() {
		return myFreq;
	}
	
	public void setLeft(HuffmanTreeNode theLeft) {
		myLeft = theLeft;
	}
	
	public HuffmanTreeNode getLeft() {
		return myLeft;
	}
	
	public void setRight(HuffmanTreeNode theRight) {
		myRight = theRight;
	}
	
	public HuffmanTreeNode getRight() {
		return myRight;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("" + myFreq + " ");
		result.append(myChar + " ");
//		result.append(myLeft + " " + myRight + " ]");
		return result.toString();
	}
}
