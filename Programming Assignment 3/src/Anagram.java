
/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 3 
 */

/**
 * This represents an anagram made of a word and its key.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class Anagram {
	private String myWord;
	private String myKey;
	
	/**
	 * Constructs a anagram with the given word.
	 * @param theWord the word
	 */
	public Anagram(String theWord) {
		myWord = theWord;
		char[] key = myWord.toCharArray();
		// create key using merge sort on word
		sort(key, 0, key.length - 1);
		myKey = String.copyValueOf(key);
	}
	
	/**
	 * Returns the word.
	 * @return the word
	 */
	public String getWord() {
		return myWord;
	}
	
	/**
	 * Returns the key.
	 * @return the key
	 */
	public String getKey() {
		return myKey;
	}
	
	@Override
	public boolean equals(Object theOther) {
		boolean result = false;
		if (theOther instanceof Anagram) {
			Anagram other = (Anagram) theOther;
			if (other.getWord().equals(this.getWord()) 
			&& other.getKey().equals(this.getKey())) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		int result = computeHash(myWord);
		
		/* compared my against String api's hashing function
		 * by using each on the same table with the same dictionary
		 * and recording the number of collisions. This is done for
		 * several different hash table sizes (chosen sizes are prime).
		 * Uncomment line 70 to use String API's hashing function.
		 * The recordings can be seen in hash testing.*/
		
		result = Math.abs(result) % 997;				// my hashing function
		//result = Math.abs(myWord.hashCode()) % 997;	// String api's hashing function
		
		return result;
	}
	
	/**
	 * Returns String representation of anagram in the form of its word and key.
	 * @return "word:" + myWord + " key:" + myKey
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("word:");
		result.append(myWord);
		result.append(" key:");
		result.append(myKey);
		return result.toString();
	}
	
	private int computeHash(String theString) {
		int result = 0;
		// sum square of chars in word
		for (char c: theString.toCharArray()) {
			//String square = "" + (c * c);
			//char[] squareToArray = square.toCharArray();
			int x = c;
			result += x;
		}
		return result;
	}
	
    /**
     * MergeSorts a char array.
     * @param theArray the array
     * @param theFirst the first index of the array
     * @param theLast the last index of the array
     */
    private void sort(char[] theArray, int theFirst, int theLast) { 
        if (theFirst < theLast) { 
            int mid = (theFirst + theLast) / 2; 
            sort(theArray, theFirst, mid); 
            sort(theArray, mid + 1, theLast); 
            merge(theArray, theFirst, mid, theLast); 
        } 
    }
	
	/**
	 * The merge part of MergeSort.
	 * @param theArray the array
	 * @param theFirst the first index
	 * @param theMiddle the middle index
	 * @param theLast the last index
	 */
    private void merge(char[] theArray, int theFirst, int theMiddle, int theLast) { 
        int leftSize = theMiddle - theFirst + 1; 
        int rightSize = theLast - theMiddle;
        
        char Left[] = new char[leftSize]; 
        char Right[] = new char[rightSize]; 
        for (int i = 0; i < leftSize; i++) 
            Left[i] = theArray[theFirst + i]; 
        for (int j = 0; j < rightSize; j++) 
            Right[j] = theArray[theMiddle + 1 + j];
        
        int i = 0;
        int j = 0; 
        int k = theFirst; 
        while (i < leftSize && j < rightSize) { 
            if (Left[i] <= Right[j]) { 
                theArray[k] = Left[i]; 
                i++; 
            } else { 
                theArray[k] = Right[j]; 
                j++; 
            } 
            k++; 
        } 
        
        while (i < leftSize) { 
            theArray[k] = Left[i]; 
            i++; 
            k++; 
        } 
        while (j < rightSize) { 
            theArray[k] = Right[j]; 
            j++; 
            k++; 
        } 
    } 	

}
