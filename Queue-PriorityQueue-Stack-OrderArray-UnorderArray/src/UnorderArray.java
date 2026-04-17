/**
 * UnorderedArray represents a dynamically resizing array
 * that stores key-value pairs without maintaining any sorted order.
 *
 * Elements are inserted at the end of the array in O(1) time
 * (amortized), and searching is performed using linear search.
 *
 * This structure is suitable when insertion speed is prioritized
 * over search efficiency.
 */
public class UnorderArray<V, K extends Comparable<K>> {
    private Entry<V, K>[] arr;
    private int numElements;

    /**
     * Constructor to initialize the UnorderedArray with a given size.
     * @param size the initial size of the array
     */
    @SuppressWarnings("unchecked")
    public UnorderArray(int size) {
        arr = (Entry<V, K>[]) new Entry[size];
        numElements = 0;
    }

    /**
     * Inserts a key-value pair at the end of the array.
     *
     * @param value the value to store
     * @param anchor the key associated with the value
     * Time Complexity: O(1) amortized; O(n) if resizing is needed
     */
    public void insert(V value, K anchor) {
        Entry <V,K> entry = new Entry<>(value, anchor);
        // If array is full, resize it
        if (numElements == arr.length) {
            resize(arr.length * 2);
        }
        // Insert at the next available position
        arr[numElements] = entry;
        numElements++;
    }

    /**
     * Deletes the first occurrence of elements from the array.
     * Time Complexity: O(n) where n is the number of elements
     * @param anchor is a value used to find index of elements to delete
     * @return true if the element was found and deleted, false otherwise
     */
    public boolean delete(K anchor) {
        // Find the index of the element to delete
        int index = find(anchor);

        // If element not found, return false
        if (index == -1) {
            return false;
        }

        // Shift all elements after the deleted element one position to the left
        for (int i = index; i < numElements - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Mark the last position as null and decrement count
        arr[numElements - 1] = null;
        numElements--;
        return true;
    }

    /**
     * Searches for an element in the array using linear search.
     * Time Complexity: O(n) where n is the number of elements
     * @param anchor is a value used to find index of elements
     * @return the index of the element if found, -1 otherwise
     */
    public int find(K anchor) {
        for (int i = 0; i < numElements; i++) {
            if (arr[i] != null && compare(arr[i].anchor, anchor) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retrieves the element at the given index.
     * Time Complexity: O(1)
     * @param index the index of the element to retrieve
     * @return the element at the given index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public V get(int index) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return arr[index].value;
    }

    /**
     * Returns the current number of elements in the array.
     * Time Complexity: O(1)
     * @return the number of elements currently in the array
     */
    public int size() {
        return numElements;
    }

    /**
     * Resizes the array to a new size. Elements outside the new size are discarded.
     * Time Complexity: O(n) where n is the minimum of old and new size
     * @param newSize the new size of the array
     */
    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        Entry <V, K>[] newArr = (Entry<V, K>[]) new Entry[newSize];

        // Copy elements from old array to new array
        int copyLength = Math.min(numElements, newSize);
        for (int i = 0; i < copyLength; i++) {
            newArr[i] = arr[i];
        }

        // Update the number of elements if the new size is smaller
        if (newSize < numElements) {
            numElements = newSize;
        }

        arr = newArr;
    }

    private int compare(K a, K b){
        return a.compareTo(b);
    }
}



