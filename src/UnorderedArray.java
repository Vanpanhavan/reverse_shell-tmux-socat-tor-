public class UnorderedArray <T> {
    private Node<T>[] arr;
    private int numEle = 0;

    public UnorderedArray (int size){
        arr = (Node<T>[]) new Node[size];
    }

    public void insert(int index, String key, T value){ // insert: O(1)
        Node <T> node = new Node<T>();
        node.value = value;
        node.key = key;
        arr[index] = node;
        numEle += 1;
    }

    public void delete(int index){ // linear search: O(n)
        arr[index].value = null;
        arr[index].key = "DELETED";
        numEle--;
    }

    public boolean fullArray(){
        return numEle == arr.length;
    }

    public int getLength(){
        return arr.length;
    }
    public Node<T>[] getArr(){
        return arr;
    }
}
