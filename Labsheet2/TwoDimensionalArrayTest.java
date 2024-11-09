// 1.	Multi-dimensional Array Implementation
package Labsheet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Class to handle operations on a two-dimensional array
class TwoDimensionalArray {
    private List<List<Integer>> matrix; // 2D list to store the matrix

    // Constructor to initialize the matrix
    public TwoDimensionalArray() {
        matrix = new ArrayList<>(); // Initialize an empty 2D list
    }

    // Method to insert a new row into the matrix
    public void insertRow(int[] row) {
        List<Integer> newRow = new ArrayList<>(); // Convert array to list for insertion
        for (int val : row) {
            newRow.add(val); // Add each element to the new row
        }
        matrix.add(newRow); // Add the row to the matrix
    }

    // Method to insert a new column into the matrix
    public void insertColumn(int[] column) {
        for (int i = 0; i < column.length; i++) {
            if (i >= matrix.size()) {
                matrix.add(new ArrayList<>()); // Add new empty row if it doesn’t exist
            }
            matrix.get(i).add(column[i]); // Add column element to each row
        }
    }

    // Method to delete a row from the matrix
    public void deleteRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < matrix.size()) { // Check if index is valid
            matrix.remove(rowIndex); // Remove row at the specified index
        }
    }

    // Method to traverse the matrix and return it as a 2D list
    public List<List<Integer>> traverse() {
        return matrix; // Return the current state of the matrix
    }

    // Static method to find the transpose of a given matrix
    public static List<List<Integer>> transposeMatrix(List<List<Integer>> original) {
        List<List<Integer>> transposed = new ArrayList<>(); // Create a list for the transposed matrix
        for (int i = 0; i < original.get(0).size(); i++) {
            List<Integer> newRow = new ArrayList<>(); // Create new row for transposed matrix
            for (List<Integer> row : original) {
                newRow.add(row.get(i)); // Add each element to new row
            }
            transposed.add(newRow); // Add row to transposed matrix
        }
        return transposed; // Return the transposed matrix
    }
}

// Test class to verify TwoDimensionalArray methods
public class TwoDimensionalArrayTest {
    public static void main(String[] args) {
        TwoDimensionalArray array = new TwoDimensionalArray(); // Create instance of TwoDimensionalArray

        // Test insertRow
        array.insertRow(new int[]{1, 2}); // Insert a row [1, 2]
        System.out.println("After inserting row [1, 2]: " + array.traverse()); // Expected Output: [[1, 2]]

        // Test insertColumn
        array.insertColumn(new int[]{3, 4}); // Insert a column [3, 4]
        System.out.println("After inserting column [3, 4]: " + array.traverse()); // Expected Output: [[1, 2, 3], [3, 4]]

        // Test deleteRow
        array.deleteRow(0); // Delete row at index 0
        System.out.println("After deleting row at index 0: " + array.traverse()); // Expected Output: [[3, 4]]

        // Test transposeMatrix
        List<List<Integer>> matrixToTranspose = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        List<List<Integer>> transposedMatrix = TwoDimensionalArray.transposeMatrix(matrixToTranspose);
        System.out.println("Transpose of [[1, 2], [3, 4]]: " + transposedMatrix); // Expected Output: [[1, 3], [2, 4]]
    }
}
