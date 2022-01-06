import java.util.HashMap;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 2
 */

/**
 * 
 * @author Daniel Ty
 * @version Winter 2020
 */
public class HuffmanTree {
	private PriorityQueue myQueue;
	private HuffmanFrequencyTable myTable;
	private HuffmanTreeNode treeHead; 
	private int mySize;
	
	/**
	 * Constructs a Huffman Tree given a Huffman frequency table.
	 * @param theTable the frequency table
	 */
	public HuffmanTree(final HuffmanFrequencyTable theTable) {
		myTable = theTable;
		myQueue = new PriorityQueue();
		char[] order = myTable.getOrder();
		HashMap<Character, Integer> map = myTable.getMap();
		// fill in priority queue
		for (int i = 0; i < order.length; i++) {
			HuffmanTreeNode hNode = new HuffmanTreeNode(order[i], map.get(order[i]));
			myQueue.addElement(hNode, hNode.getFreq());
			mySize++;
		}
		
		// create tree
		while (myQueue.getSize() >= 2) {
			HuffmanTreeNode leftChild = myQueue.removeNext();
			HuffmanTreeNode rightChild = myQueue.removeNext();
			HuffmanTreeNode temp = new HuffmanTreeNode(leftChild, rightChild);
			myQueue.addElement(temp, temp.getFreq());
		}
		treeHead = myQueue.removeNext();
		
	}
	
	/**
	 * Returns the head of the tree.
	 * @return the head of the tree
	 */
	public HuffmanTreeNode getTreeHead() {
		return treeHead;
	}
	
	public PriorityQueue getQueue() {
		return myQueue;
	}
	
	public int getSize() {
		return mySize;
	}
	
}
