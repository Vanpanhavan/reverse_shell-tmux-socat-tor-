public class UnorderedArray {
    private int[] arr;
    private int indexInsert = 0;

    public UnorderedArray(int size){
        arr = new int[size];
    }

    public void insert(int x){
        if (indexInsert < arr.length) {
            arr[indexInsert] = x; // insert: O(1)
            indexInsert += 1;
        }
        else
            throw new IllegalStateException("Array is full");
    }

    public void delete(int x){
        int indexDelete = find(x); // linear search: O(n)
        if (indexDelete != -1){
            arr[indexDelete] = arr[indexInsert - 1]; // swap: O(1)
            arr[indexInsert - 1] = 0;
            indexInsert--;
        }
        else
            throw new IllegalStateException("Cannot find " + x);

    }

    public int find(int x) {
        for(int i = 0; i < indexInsert; i++) { // linear search: O(n)
            if(arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int get(int index){
        if (index >= indexInsert || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return arr[index];
    }

    public int size() {
        return indexInsert;
    }

    public void reSize(int newSize){
        int[] newArr = new int[newSize];
        if (newSize >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
        }
        else {
            if(indexInsert > newSize) {
                indexInsert = newSize;
                for (int i = 0; i < newSize; i++) {
                    newArr[i] = arr[i];
                }
            }
            else {
                for (int i = 0; i < newSize; i++) {
                    newArr[i] = arr[i];
                }
            }
        }
        arr = newArr;
    }
}
