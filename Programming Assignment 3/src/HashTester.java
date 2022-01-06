import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 3
 */


/* Explanation for hashing function:
 * I tested if my hashing function operated better that O(log n) by comparing it with
 * String API's hashCode(). I did this by using each hashing function on the same dictionary 
 * with the same table and recording the number of collisions. This is done for several 
 * different hash table sizes (chosen sizes are prime). When comparing the number of collisions,
 * my function had less and less collisions than String API's hashing function as the table sizes
 * increased. This proves my function is faster because less collisions means that my function
 * will not go through as much chaining (the collision method I used) and as such will have a faster
 * time complexity. 
 * The collision recordings can be seen in "hash testing.txt".
 */



/**
 * This is the tester and driver class of the program.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class HashTester {

	/**
	 * This is the driver method.
	 * @param args the arguments
	 * @throws FileNotFoundException file not found
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		/* Input file names here */
		String dictionaryFileName = "words.txt";
		String inputFileName = "input.txt";
		String outputFileName = "output.txt";
		
		Dictionary dictionary = new Dictionary(dictionaryFileName);
		HashTable table = new HashTable(dictionary);
		createOutputFile(table, inputFileName, outputFileName);
		System.out.println("collisions: " + table.getCollisions());
	}
	
	/**
	 * This creates an output file.
	 * @param theHashTable the hash table
	 * @param theInputFileName the name of the input file
	 * @param theOutputFileName the name of the output file
	 * @throws FileNotFoundException file not found
	 */
	private static void createOutputFile(HashTable theHashTable, String theInputFileName
	, String theOutputFileName) throws FileNotFoundException {
		Scanner inputFile = new Scanner(new File("input files\\" + theInputFileName));
		PrintStream outputFile = new PrintStream(new File("output files\\" + theOutputFileName)); 
		while (inputFile.hasNext()) {
			String word = inputFile.next();
			word = word.toLowerCase();
			HashBucket anagrams = theHashTable.getAnagrams(word);
			// if bucket is null or bucket only contains the word itself,
			// print the word followed by 0
			if (anagrams == null || 
			anagrams.getSize() == 1
			&& anagrams.getBucket().contains(word)) {
				outputFile.println(word + " 0");
				
			// else if bucket contains the word
			} else if (anagrams.getBucket().contains(word)) {
				outputFile.println(word + " " + (anagrams.getSize() - 1) + " " + anagrams.toStringExclude(word));
				
			} else {
				outputFile.println(word + " " + anagrams.getSize() + " " + anagrams.toStringExclude(word));

			}
		}
		inputFile.close();
	}
}
