import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

/**
 * Daniel Ty
 * TCSS 342 A
 * Programming Assignment 2
 */

/**
 * Tests HuffmanFrequencyTable, Decoder, and Encoder.
 * @author Daniel Ty
 * @version Winter 2020
 */
public class Tester {

	/**
	 * Main driver method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		// INPUT STRING
		String input = "Huffman coding is an algorithm devised by David A. Huffman of MIT in 1952.";
		
		HuffmanFrequencyTable table = new HuffmanFrequencyTable(input);
		HuffmanTree tree = new HuffmanTree(table);
		Encoder enc = new Encoder(tree.getTreeHead(), input);
		Decoder dec = new Decoder(tree.getTreeHead(), enc.getCode());
		
		System.out.println("% java Tester " + input);
		System.out.println("======================================");		
		System.out.println("char\tfrequency\tcode\n--------------------------------------");
		HashMap<Character, String> codeMap = enc.getMap();
		StringBuilder result = new StringBuilder();
		int bitsBefore = 0;
		for(char c: table.getOrder()) {
			result.append(c + "\t");
			result.append(table.getMap().get(c) + "\t\t");
			result.append(codeMap.get(c) + "\n");
			
			bitsBefore += table.getMap().get(c) * 8;
		}
		System.out.println(result);
		System.out.println("======================================");
		System.out.println("Encoded bit stream:");
		System.out.println(enc.getCode());
		System.out.println("Total number of bits without Huffman coding (8-bits per character):");
		System.out.println(bitsBefore);		
		int bitsAfter = enc.getCode().length();
		System.out.println("Total number of bits with Huffman coding: "  + bitsAfter);
		BigDecimal beforeBD = new BigDecimal(bitsBefore);
		BigDecimal afterBD = new BigDecimal(bitsAfter);
		System.out.println("Compression Ratio: " +  beforeBD.divide(afterBD, 2, RoundingMode.HALF_UP));
		System.out.println("Decoded String: " + dec.getDecoded());

	}

}
