public class DoubleHashing <T> extends HashTable<T> {
    public DoubleHashing(int size) {
        super(size);
    }
    public void insert(String key, T value) {
        int index = super.hashFunction(key);
        int indexInsert = findForInsert(index, key);
        super.arr.insert(indexInsert, key, value);
    }
    public void delete(String key){
        int index = super.hashFunction(key);
        int indexDelete = findForSearch_Delete(index, key);
        super.arr.delete(indexDelete);
    }
    public void search(String key){
        int index = super.hashFunction(key);
        int indexFind = findForSearch_Delete(index, key);
        System.out.println("key " + key + " Found");
    }
    private int findForInsert(int index, String key){
        Node<T>[] array = super.arr.getArr();
        while (array[index] != null && array[index].value != null && !(array[index].key.equals("DELETED"))) {
            index = (index + SecondaryHashFunction(key))%super.arr.getLength();
            if (super.arr.fullArray())
                throw new IllegalStateException("Array is full");
        }
        return index;
    }
    private int findForSearch_Delete(int index, String key){
        Node<T>[] array = super.arr.getArr();
        int counter = 0;
        if (array[index] == null){
            throw new IllegalStateException("Not Found");
        }
        while (counter < super.arr.getLength() && !(array[index].key.equals(key))) {
            index = (index + SecondaryHashFunction(key))%super.arr.getLength();
            counter++;
            if (counter == super.arr.getLength())
                throw new IllegalStateException("Not Found");
        }
        return index;
    }
    private int SecondaryHashFunction(String key){
        return 7 - (Math.abs(key.hashCode())%7);
    }
}
