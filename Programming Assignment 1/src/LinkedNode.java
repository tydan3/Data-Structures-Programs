/**
 * Daniel Ty
 * TCSS 342 A - Winter 2020
 * Programming Assignment 1
 */

/**
 * Linked node that contains an integer.
 * @author Daniel Ty
 * @version Winter 2020
 * @param <Integer> Integer wrapper class
 */
public class LinkedNode<Integer> {
	private Integer myElement;
	private LinkedNode<Integer> myNext;
	
	/**
	 * Initializes empty linked node
	 */
	public LinkedNode() {
		this.myElement = null;
		this.myNext = null;	
	}
	
	/**
	 * Initializes linked node with given integer.
	 * @param theElement integer to be put into linked node
	 */
	public LinkedNode(final Integer theElement) {
		this.myElement = theElement;
		this.myNext = null;
	}
	
	/**
	 * Returns the linked node this node is pointing to.
	 * @return the next node
	 */
	public LinkedNode<Integer> getNext() {
		return myNext;
	}
	
	/**
	 * Sets the which node this node points to.
	 * @param theNode node to be pointed to
	 */
	public void setNext(final LinkedNode<Integer> theNode) {
		this.myNext = theNode;
	}
	
	/**
	 * Returns element inside this node.
	 * @return contained element
	 */
	public Integer getElement() {
		return myElement;
	}
	
	/**
	 * Sets the contained element to the passed in element.
	 * @param theElement the new element
	 */
	public void setElement(final Integer theElement) {
		this.myElement = theElement;
	}
	
}
