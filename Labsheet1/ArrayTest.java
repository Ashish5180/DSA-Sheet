
// Class representing a Static Array with fixed size
package Labsheet1;
class StaticArray {
    private int[] array; // Array to store elements
    private int count;   // Tracks the number of elements in the array

    // Constructor to initialize the array with a fixed size
    public StaticArray(int size) {
        array = new int[size];
        count = 0;
    }

    // Method to insert an element into the array
    public void insert(int value) {
        if (count < array.length) {
            array[count++] = value; // Insert value and increment count
        } else {
            System.out.println("Array is full"); // Error message if array is full
        }
    }

    // Method to delete an element from the array
    public void delete(int value) {
        for (int i = 0; i < count; i++) {
            if (array[i] == value) {
                // Shift elements left to delete the element
                for (int j = i; j < count - 1; j++) {
                    array[j] = array[j + 1];
                }
                count--; // Decrement count
                break; // Break once the element is found and deleted
            }
        }
    }

    // Method to traverse and return the elements in the array
    public int[] traverse() {
        int[] result = new int[count]; // Array to store current elements
        for (int i = 0; i < count; i++) {
            result[i] = array[i];
        }
        return result; // Return current elements
    }
}

// Class representing a Dynamic Array that can resize as needed
class DynamicArray {
    private int[] array; // Array to store elements
    private int count;   // Tracks the number of elements in the array
    private int capacity; // Current capacity of the array

    // Constructor to initialize the array with initial capacity
    public DynamicArray(int initialCapacity) {
        array = new int[initialCapacity];
        count = 0;
        capacity = initialCapacity;
    }

    // Method to insert an element into the array
    public void insert(int value) {
        if (count == capacity) {
            resize(); // Resize the array if capacity is full
        }
        array[count++] = value; // Insert value and increment count
    }

    // Method to resize the array when capacity is reached
    private void resize() {
        capacity *= 2; // Double the capacity
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, count); // Copy elements to new array
        array = newArray; // Assign new array to the existing reference
    }

    // Method to delete an element from the array
    public void delete(int value) {
        for (int i = 0; i < count; i++) {
            if (array[i] == value) {
                // Shift elements left to delete the element
                for (int j = i; j < count - 1; j++) {
                    array[j] = array[j + 1];
                }
                count--; // Decrement count
                break; // Break once the element is found and deleted
            }
        }
    }

    // Method to traverse and return the elements in the array
    public int[] traverse() {
        int[] result = new int[count]; // Array to store current elements
        for (int i = 0; i < count; i++) {
            result[i] = array[i];
        }
        return result; // Return current elements
    }
}



// Test class to verify StaticArray and DynamicArray operations
public class ArrayTest {
    public static void main(String[] args) {
        // Static Array Test
        StaticArray staticArray = new StaticArray(5); // Create StaticArray with fixed size
        staticArray.insert(1); // Insert element
        staticArray.insert(2); // Insert another element
        staticArray.delete(1); // Delete element 1
        System.out.println("Static Array After Operations: " + java.util.Arrays.toString(staticArray.traverse())); // Expected Output: [2]

        // Dynamic Array Test
        DynamicArray dynamicArray = new DynamicArray(1); // Create DynamicArray with initial capacity
        dynamicArray.insert(1); // Insert element
        dynamicArray.insert(2); // Insert another element, should trigger resize
        dynamicArray.delete(1); // Delete element 1
        System.out.println("Dynamic Array After Operations: " + java.util.Arrays.toString(dynamicArray.traverse())); // Expected Output: [2]
    }
}



