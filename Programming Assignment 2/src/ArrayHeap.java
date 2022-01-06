import java.util.Arrays;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 2
 */

/**
 * Represents an ArrayHeap of PriorityQueueNode.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class ArrayHeap {
	private PriorityQueueNode[] myArray;
	private int myElemCount;
	
	/**
	 * Creates an empty ArrayHeap of size 128.
	 */
	public ArrayHeap() {
		myArray = new PriorityQueueNode[128];
		myElemCount = 0;
	}
	
	/**
	 * Adds a PriorityQueueNode to the ArrayHeap and heapify.
	 * @param theNode the PriorityQueueNode to be added
	 */
	public void addElement(final PriorityQueueNode theNode) {
		myElemCount++;
		
		// increase array size if more elements than space
		if (myElemCount > myArray.length) {
			PriorityQueueNode[] temp = myArray.clone();
			myArray = new PriorityQueueNode[myArray.length * 2];
			for (int i = 0; i < temp.length; i++) {
				myArray[i] = temp[i];
			}
		}
		
		myArray[myElemCount - 1] = theNode;
		int child = myElemCount - 1;
		int parent = (child - 1) / 2;
		while (child != parent) {
			if (myArray[child].compareTo(myArray[parent]) == -1) {
				PriorityQueueNode temp = myArray[parent];
				myArray[parent] = myArray[child];
				myArray[child] = temp;
			}
			child = parent;
			parent = (child - 1) / 2;
		}
	}
	
	/**
	 * Removes and returns minimum PriorityQueueNode inside ArrayHeap and heapify.
	 * @return minimum PriorityQueueNode inside ArrayHeap
	 */
	public PriorityQueueNode removeMin() {
		PriorityQueueNode min = new PriorityQueueNode(myArray[0].getElement()
								, myArray[0].getPriority());
		myArray[0] = myArray[myElemCount - 1];
		myArray[myElemCount - 1] = null;
		myElemCount--;
		int parent = 0;
		int leftChild = (parent * 2) + 1;
		int rightChild = (parent * 2) + 2;
		while (parent < myElemCount - 1) {
			PriorityQueueNode temp = myArray[parent];
			
			if (myArray[leftChild] == null || myArray[rightChild] == null) {
				if (myArray[leftChild] == null && myArray[rightChild] == null) {
					parent = myElemCount - 1;
					
				} else if (myArray[rightChild] != null
				&& myArray[rightChild].compareTo(myArray[parent]) == -1) {
					myArray[parent] = myArray[rightChild];
					myArray[rightChild] = temp;
					parent = rightChild;
					
				} else if (myArray[leftChild] != null
				&& myArray[leftChild].compareTo(myArray[parent]) == -1) {
					myArray[parent] = myArray[leftChild];
					myArray[leftChild] = temp;
					parent = leftChild;
				} else {
					parent = myElemCount - 1;
				}
				
			} else if (myArray[leftChild].compareTo(myArray[rightChild]) == -1
			&& myArray[leftChild].compareTo(myArray[parent]) == -1)  {
				myArray[parent] = myArray[leftChild];
				myArray[leftChild] = temp;
				parent = leftChild;
				
			} else if (myArray[rightChild].compareTo(myArray[leftChild]) == -1
			&& myArray[rightChild].compareTo(myArray[parent]) == -1)  {
				myArray[parent] = myArray[rightChild];
				myArray[rightChild] = temp;
				parent = rightChild;
			} else {
				parent = myElemCount - 1;
			}
			leftChild = (parent * 2) + 1;
			rightChild = (parent * 2) + 2;
		}
		return min;
	}
	
	public String toString() {
		return Arrays.deepToString(myArray);
	}
}