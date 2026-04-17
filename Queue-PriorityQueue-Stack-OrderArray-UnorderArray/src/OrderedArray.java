public class OrderedArray {
    private int[] arr;
    private int numElement = 0;

    public OrderedArray(int size){
        arr = new int[size];
    }

    public void insert(int x){
        int indexInsert;
        if ( numElement == arr.length){
            throw new IllegalStateException("Array is full");
        }
        else{
            indexInsert = searchForInsert(x);
            shiftForInsert(indexInsert, x);
            numElement++;
        }
    }

    private void shiftForInsert(int indexInsert, int x){
        for (int i = numElement; i > indexInsert; i--){
            arr[i] = arr[i - 1];
        }
        arr[indexInsert] = x;
    }

    private int searchForInsert(int x){
        int low = 0;
        int high = numElement - 1;
        while( low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else
                return mid;
        }
        return low;
    }

    public void delete(int x){
        int indexDelete = find(x);
        if(indexDelete != -1){
            for(int i = indexDelete; i < numElement - 1; i++){
                arr[i+1] = arr[i];
            }
            numElement--;
        }
        else{
            throw new IllegalStateException("Cannot find " + x);
        }
    }

    public int find(int x){
        int low = 0;
        int high = numElement - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(x > arr[mid]){
                low = mid + 1;
            }
            else if(x < arr[mid]){
                high = mid - 1;
            }
            else
                return mid;
        }
        return -1;
    }

    public int get(int index){
        if (index >= 0 && index < numElement) {
            return arr[index];
        }
        else{
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    public int size() {
        return numElement;
    }

    public void reSize(int newSize){
        int[] newArr = new int[newSize];
        if (newSize >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
        }
        else {
            if(numElement >= newSize) {
                numElement = newSize;
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
