/**
 * Daniel Ty
 * TCSS 342 A - Winter 2020
 * Programming Assignment 1
 */

/**
 * Provides sorting algorithms.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class Sorting {
	private static int exch = 0;
	private static int comp = 0;
	
	/**
	 * Takes in linked list, bubble-sorts the list, then returns its head.
	 * @param theHead head of list to be sorted
	 * @param theSize size of list to be sorted
	 * @return head of newly sorted list
	 */
	public static LinkedNode<Integer> bubbleSort(final LinkedNode<Integer> theHead, final int theSize) {		
		LinkedNode<Integer> head = theHead;
		LinkedNode<Integer> dummy = new LinkedNode<Integer>();
		dummy.setNext(head);
		LinkedNode<Integer> previous = dummy;
		LinkedNode<Integer> current = dummy.getNext();
		
		for (int outer = theSize - 1; outer > 0; outer--) {
			for(int inner = 0; inner < outer; inner++) {
				comp++;
				if (current.getElement() > current.getNext().getElement()) {
					// swap current and the node after it
					previous.setNext(current.getNext());
					current.setNext(current.getNext().getNext());
					previous.getNext().setNext(current);
					// move previous forward one
					previous = previous.getNext();
				
					exch++;
				} else {
					// move previous and current forward one
					previous = previous.getNext();
					current = current.getNext();
				}
				
			}
			previous = dummy;
			current = dummy.getNext();			
		}
		return dummy.getNext();
	}
	
	/**
	 * Takes in linked list, shell-sorts the list, then returns its head.
	 * @param theHead head of list to be sorted
	 * @param size size of list
	 * @return head of newly sorted list
	 */
	public static LinkedNode<Integer> shellSort(LinkedNode<Integer> theHead, int size) {
		long startTime = System.nanoTime();
		LinkedNode<Integer> head = theHead;
		LinkedNode<Integer> dummy = new LinkedNode<Integer>();
		dummy.setNext(head);
		LinkedNode<Integer> previous1 = dummy;
		LinkedNode<Integer> current1 = head;
		LinkedNode<Integer> previous2 = dummy;
		LinkedNode<Integer> current2 = head;
		
		// find highest k in (3^k - 1)/2 whose result is less than size
		int k = 0;
		while ((Math.pow(3, k) - 1) / 2 <= size) {
			k++;
		}
		k--;

		// use k and increment minus 1 each iteration
		for (int i = k; i > 0; i--) {
			// make gap between pointer nodes equal (3^i - 1)/2
			for (int j = 0; j <= (Math.pow(3, i) - 1) / 2; j++) {
				previous2 = previous2.getNext();
				current2 = current2.getNext();
			}
			while (current2 != null) {
				comp++;
				if (current1.getElement() > current2.getElement()) {
					// swap current1 and current2
					previous2.setNext(current1);
					previous1.setNext(current2);
					LinkedNode<Integer> temp = current1.getNext();
					current1.setNext(current2.getNext());
					current2.setNext(temp);
					// current1 is ahead of current2 now.
					// Switch pointers for current1 and current2
					LinkedNode<Integer> temp2 = current1;
					current1 = current2;
					current2 = temp2;
					exch++;
				}
				// move all pointers forward one
				previous1 = current1;
				current1 = current1.getNext();
				previous2 = current2;
				current2 = current2.getNext();
				
			}
			// reset pointers
			previous1 = dummy;
			current1 = dummy.getNext();
			previous2 = dummy;
			current2 = dummy.getNext();
		}
		// finish the sort with bubble
		LinkedNode<Integer> result = bubbleSort(dummy.getNext(), size);
		System.out.println("comp: " + comp + " " + "exch: " + exch);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " nanosecs"); 
		return result;
	}	

}
