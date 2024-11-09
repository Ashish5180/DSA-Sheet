// String Operations Implementation:
package Labsheet1;


import java.util.HashMap;
import java.util.Map;

// Class for various string operations
class StringOperations {
    // Method to concatenate two strings
    public String concatenate(String str1, String str2) {
        return str1 + str2; // Concatenate and return the result
    }

    // Method to get a substring of a string
    public String substring(String str, int start, int end) {
        return str.substring(start, end); // Return the substring from start to end index
    }

    // Method to compare two strings for equality
    public boolean compare(String str1, String str2) {
        return str1.equals(str2); // Return true if strings are equal, false otherwise
    }

    // Function to calculate the frequency of each character in a string
    public Map<Character, Integer> characterFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>(); // Map to store character frequencies
        for (char ch : str.toCharArray()) { // Loop through each character in the string
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1); // Increment the character count
        }
        return frequencyMap; // Return the map containing character frequencies
    }
}

// Test class to verify StringOperations methods
public class StringOperationsTest {
    public static void main(String[] args) {
        StringOperations operations = new StringOperations(); // Create instance of StringOperations

        // Test concatenation
        String concatResult = operations.concatenate("hello", "world");
        System.out.println("Concatenation Result: " + concatResult); // Expected Output: "helloworld"

        // Test substring
        String substringResult = operations.substring("hello", 3, 5);
        System.out.println("Substring Result: " + substringResult); // Expected Output: "lo"

        // Test comparison
        boolean comparisonResult = operations.compare("hello", "world");
        System.out.println("Comparison Result: " + comparisonResult); // Expected Output: false

        // Test character frequency
        Map<Character, Integer> frequencyResult = operations.characterFrequency("hello");
        System.out.println("Character Frequency Result: " + frequencyResult); // Expected Output: {h=1, e=1, l=2, o=1}
    }
}
