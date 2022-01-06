import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Daniel Ty
 * TCSS 342 A - Winter 2020
 * Programming Assignment 1
 */

/**
 * Controller and tester for the program
 * @author Daniel Ty
 * @version Winter 2020
 */
public class Main {

	/**
	 * Driver method
	 * @param theArgs arguments
	 * @throws FileNotFoundException file not found
	 */
	public static void main(final String[] theArgs) throws FileNotFoundException {
		String inputFile = "random10000.txt";	// input file name
		int size = Integer.parseInt(inputFile.replaceAll("[\\D]", ""));	// Take number from file name as size
		LinkedNode<Integer> original = readValues(inputFile);
		displayList(original);
		displayList(Sorting.shellSort(original, size));
	}

	
	/**
	 * Reads values from a file and builds a linked list of integers.
	 * @param theFileName name of the file to be read
	 * @return head node of linked list
	 * @throws FileNotFoundException file not found
	 */
	private static LinkedNode<Integer> readValues(final String theFileName) throws FileNotFoundException {
		LinkedNode<Integer> head = null;
		LinkedNode<Integer> current = null;
		// create scanner for file from input folder
		Scanner input = new Scanner(new File("input//" + theFileName));
		System.out.println();
		while (input.hasNext()) {
			//create temp node with next integer
			LinkedNode<Integer> temp = new LinkedNode<Integer>(input.nextInt());
			if (head == null) {
				// make first node the head and current
				head = temp;
				current = temp;
			} else {
				// point current to temp, make temp new current
				current.setNext(temp);
				current = temp;
			}
		}
		input.close();
		return head;
	}
	
	/**
	 * Displays the contents of the linked list.
	 * @param theHead head node of linked list to display
	 */
	public static void displayList(final LinkedNode<Integer> theHead) {
		LinkedNode<Integer> curr = theHead;
		while(curr != null) {
			System.out.print(curr.getElement() + " ");
			curr = curr.getNext();
		}
		System.out.println();
	}
}
