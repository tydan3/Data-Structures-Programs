import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 3
 */

/**
 * This represents a dictionary created from a given input text file.
 * @author Daniel Ty
 * @version Winter 2020
 *
 */
public class Dictionary {
	private ArrayList<String> myWords;
	
	/**
	 * Constructs dictionary of words from a text file.
	 * @param theFileName name of the file
	 * @throws FileNotFoundException file not found
	 */
	public Dictionary(String theFileName) throws FileNotFoundException {
		myWords = new ArrayList<String>();
		scan(myWords, theFileName);
	}
	
	/**
	 * Scans the file and adds its words to the list.
	 * @param myList list to be filled
	 * @param theFileName name of input file in "input files" folder
	 * @throws FileNotFoundException file not found
	 */
	private void scan(ArrayList<String> myList, String theFileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File("dictionary files\\" + theFileName));
		while (input.hasNextLine()) {
			String inputLine = input.nextLine();
			inputLine = inputLine.toLowerCase();
			myList.add(inputLine);
		}
		input.close();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getWords() {
		return (ArrayList<String>) myWords.clone();
	}
	
	/**
	 * Returns string representation of the dictionary, i.e., the words it contains.
	 * @return each word followed by \n
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (String s: myWords) {
			result.append(s + "\n");
		}
		return result.toString();
	}
}
