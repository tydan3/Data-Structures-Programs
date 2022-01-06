import java.util.ArrayList;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 3
 */

/**
 * This represents a bucket in the hash table.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class HashBucket {
	private ArrayList<String> myBucket;
	private String myKey;
	private HashBucket myNext;
	
	public HashBucket(String theKey) {
		myKey = theKey;
		myBucket = new ArrayList<String>();
		myNext = null;
	}
	
	
	public void add(String theWord) {
		myBucket.add(theWord);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getBucket() {
		return (ArrayList<String>) myBucket.clone();
	}
	
	
	public String getKey() {
		return myKey;
	}
	
	public void setNext(HashBucket theNext) {
		myNext = theNext;
	}
	
	public HashBucket next() {
		return myNext;
	}
	
	public int getSize() {
		return myBucket.size();
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(myKey);
		result.append(" ");
		result.append(myNext);
//		for (String s: myBucket) {
//			result.append(" ");
//			result.append(s);
//		}
		return result.toString();
	}
	
	public String toStringExclude(String theWord) {
		StringBuilder result = new StringBuilder();
		for (String s: myBucket) {
			if (!s.equals(theWord)) {
				result.append(s);
				result.append(" ");
			}
		}
		return result.toString();
	}


}
