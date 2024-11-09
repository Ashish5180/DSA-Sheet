// 2.	String Pattern Matching and Compression
package Labsheet2;

// Class containing methods for string pattern matching and compression algorithms
class StringAlgorithms {

    // Method to perform KMP pattern matching
    public int KMPSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern); // Compute the longest prefix-suffix array for the pattern
        int i = 0; // Pointer for text
        int j = 0; // Pointer for pattern

        // Traverse through the text to search for the pattern
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; // Move to the next character in the text
                j++; // Move to the next character in the pattern
            }
            if (j == pattern.length()) { // Pattern found
                return i - j; // Return the starting index of the match
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) { // If characters don't match
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS array to skip characters in pattern
                } else {
                    i++; // Otherwise, move to the next character in the text
                }
            }
        }
        return -1; // Pattern not found, return -1
    }

    // Method to compute the longest prefix-suffix (LPS) array for the pattern
    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0; // Length of the previous longest prefix-suffix
        int i = 1; // Start from the second character

        // Compute the LPS array
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length; // Store the length of the longest prefix-suffix
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Use the previous LPS to skip
                } else {
                    lps[i] = 0; // No prefix-suffix match
                    i++;
                }
            }
        }
        return lps; // Return the computed LPS array
    }

    // Method to perform Run Length Encoding (RLE) compression
    public String runLengthEncoding(String input) {
        StringBuilder encoded = new StringBuilder(); // StringBuilder to store the encoded string
        int count = 1; // Initialize the count of the first character

        // Traverse through the string to encode it
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++; // Increment the count for consecutive same characters
            } else {
                encoded.append(count).append(input.charAt(i - 1)); // Append count and character
                count = 1; // Reset the count for the new character
            }
        }
        encoded.append(count).append(input.charAt(input.length() - 1)); // Append the last character and its count
        return encoded.toString(); // Return the RLE encoded string
    }
}

// Test class to verify StringAlgorithms methods
public class StringAlgorithmsTest {
    public static void main(String[] args) {
        StringAlgorithms algorithms = new StringAlgorithms(); // Create instance of StringAlgorithms

        // Test KMP pattern matching
        int kmpResult = algorithms.KMPSearch("abxabcabcaby", "abcaby");
        System.out.println("KMP Pattern Matching Result: " + kmpResult); // Expected Output: 6

        // Test Run Length Encoding
        String rleResult = algorithms.runLengthEncoding("aaabbbcccaaa");
        System.out.println("Run Length Encoding Result: " + rleResult); // Expected Output: "3a3b3c3a"
    }
}
