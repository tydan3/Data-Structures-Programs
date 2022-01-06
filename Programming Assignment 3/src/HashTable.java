import java.util.Arrays;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 3
 */

/**
 * This is the hash table.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class HashTable {
	private HashBucket[] myTable;
	private Dictionary myDictionary;
	private int myCollisions;
	
	public HashTable(Dictionary theDictionary) {
		myDictionary = theDictionary;
		
		/* size of hash table*/
		myTable = new HashBucket[997];
		
		myCollisions = 0;
		for (String word: myDictionary.getWords()) {
			insert(word);
		}
	}
	
	public HashBucket getAnagrams(String theWord) {
		Anagram a = new Anagram(theWord);
		String key = a.getKey();
		int hashCode = a.hashCode();
		
		// if table does not have bucket with given word's hashCode
		// return null
		if (myTable[hashCode] == null) {
			return null;
			
		// else if the word's key does matches the bucket's key
		// return that bucket
		} else if (myTable[hashCode].getKey().equals(key)) {
			return myTable[hashCode];
		
		// else iterate over linked buckets
		} else {
			HashBucket pointer = myTable[hashCode];
			while (pointer.next() != null) {
				// if key matches a linked bucket, return that bucket
				if (pointer.getKey().equals(key)) {
					return pointer;
				}
				pointer = pointer.next();
			}
		}
		// if no matching bucket found, return null
		return null;
	}
	
	private void insert(String theWord) {
		Anagram a = new Anagram(theWord);
		String word = a.getWord();
		String key = a.getKey();
		int hashCode = a.hashCode();
		
		// if table does not have bucket with given word's hashCode
		// make new bucket and insert word
		if (myTable[hashCode] == null) {
			myTable[hashCode] = new HashBucket(key);
			myTable[hashCode].add(word);
			
		// else if the word's key does not match the bucket's key
		// iterate over linked buckets
		} else if (!myTable[hashCode].getKey().equals(key)) {
			myCollisions++;
			HashBucket pointer = myTable[hashCode];
			while (pointer.next() != null) {
				// if key matches a linked bucket, insert and exit
				if (pointer.getKey().equals(key)) {
					pointer.add(word);
					return;
				}
				pointer = pointer.next();
			}
			
			// otherwise add a new bucket to end of linked buckets
			// insert word in new bucket
			pointer.setNext(new HashBucket(key));
			pointer.next().add(word);
			
		// else just insert word in bucket
		} else {
			myTable[hashCode].add(word);
		}
	}
	
	public int getCollisions() {
		return myCollisions;
	}
	
	public String toString() {
		return Arrays.deepToString(myTable);
	}
}
