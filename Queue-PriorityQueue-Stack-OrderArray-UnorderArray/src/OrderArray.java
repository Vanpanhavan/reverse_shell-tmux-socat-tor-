/**
 * OrderedArray represents a dynamically resizing array
 * that maintains elements in sorted order based on their key (anchor).
 *
 * Elements are inserted in their correct sorted position
 * using comparison logic, ensuring the array remains ordered.
 *
 * Searching is performed using binary search for O(log n) time,
 * while insertion and deletion require shifting elements (O(n)).
 */

public class OrderArray<V, K extends Comparable<K>> {
    private Entry<V, K>[] arr;
    private int numElements;

    /**
     * Constructor to initialize the OrderedArray with a given size.
     * @param size the initial size of the array
     */
    @SuppressWarnings("unchecked")
    public OrderArray(int size) {
        arr = (Entry<V, K>[]) new Entry[size];
        numElements = 0;
    }

    /**
     * Inserts a key-value pair into the array while maintaining sorted order
     * according to the anchor key.
     *
     * @param value the value to store
     * @param anchor the key used to determine the element's position
     * Time Complexity: O(n) due to shifting elements
     */
    public void insert(V value, K anchor) {
        Entry <V,K> entry = new Entry<>(value, anchor);
        // If array is full, resize it
        if (numElements == arr.length) {
            resize(arr.length * 2);
        }

        // Find the correct position to insert the element in sorted order
        int insertPos = 0;
        for (int i = 0; i < numElements; i++) {
            if (compare(arr[i].anchor, entry.anchor) > 0) {
                insertPos = i;
                break;
            }
            insertPos = i + 1;
        }

        // Shift all elements from insertPos onwards one position to the right
        for (int i = numElements; i > insertPos; i--) {
            arr[i] = arr[i - 1];
        }

        // Insert the element at the correct position
        arr[insertPos] = entry;
        numElements++;
    }

    /**
     * Deletes the first occurrence of elements from the array.
     * Time Complexity: O(n) where n is the number of elements
     * @param anchor is a value used to find index of elements to delete
     * @return true if the element was found and deleted, false otherwise
     */
    public boolean delete(K anchor) {
        // Find the index of the element to delete using binary search
        int index = binarySearch(anchor);

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
     * Searches for an element by anchor key using binary search.
     *
     * @param anchor the key to search for
     * @return the index of the element if found, -1 otherwise
     * Time Complexity: O(log n)
     */
    public int find(K anchor) {
        return binarySearch(anchor);
    }

    /**
     * Performs binary search on the sorted array.
     * Time Complexity: O(log n) where n is the number of elements
     * @param anchor the value used to find index of elements
     * @return the index of the element if found, -1 otherwise
     */
    private int binarySearch(K anchor) {
        int low = 0;
        int high = numElements - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (compare(arr[mid].anchor, anchor) == 0) {
                return mid;
            } else if (compare(arr[mid].anchor, anchor) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
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

