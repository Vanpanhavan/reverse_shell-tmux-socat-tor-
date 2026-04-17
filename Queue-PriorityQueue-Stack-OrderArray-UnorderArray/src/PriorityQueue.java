public class PriorityQueue<T> {
    private Node<T>[] arr;
    private int front;
    private int rear;
    private int numElement;
    private int arraySize;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int arraySize){
        if (arraySize <= 0) {
            throw new IllegalArgumentException("Array size must be positive");
        }
        this.arr = (Node<T>[]) new Node[arraySize];
        this.numElement = 0;
        this.arraySize = arraySize;
        this.front = 0;
        this.rear = -1;
    }
    public void insert(T newItem, int priorityValue){
        if (numElement == arraySize) {
            System.out.println("Queue is full");
        }
        else{
            Node<T> node = new Node<>();
            node.data = newItem;
            node.priority = priorityValue;
            int indexInsert = searchForInsert(arr, priorityValue);
            shiftInsertForInsert(indexInsert, node);
            numElement++;
            rear = (rear + 1) % arraySize;
        }
    }
    private int searchForInsert(Node<T>[] arr, int priorityValue){
        int low = 0;
        int high = numElement - 1;
        while( low <= high) {
            int mid = (low + high) / 2;
            if (arr[(mid + front) % arraySize].priority < priorityValue) {
                high = mid - 1;
            }
            else if (arr[(mid + front) % arraySize].priority > priorityValue) {
                low = mid + 1;
            }
            else
                return (mid + front) % arraySize;
        }
        return (low + front) % arraySize;
    }
    private void shiftInsertForInsert(int indexInsert, Node<T> node){
        for (int i = (numElement) + front; i > indexInsert; i--){
            arr[i%arraySize] = arr[(i - 1)%arraySize];
        }
        arr[indexInsert] = node;
    }
    public T remove(){
        T removeItem;
        if (numElement == 0){
            throw new IllegalStateException("Queue is empty");
        }
        else{
            removeItem = arr[front].data;
            arr[front] = null;
            front = (front + 1) % arraySize;
            numElement--;
            return removeItem;
        }
    }
    public T peekFront(){
        if (numElement == 0){
            throw new IllegalStateException("Queue is empty");
        }
        else{
            return arr[front].data;
        }
    }
    public T peekRear(){
        if (numElement == 0){
            throw new IllegalStateException("Queue is empty");
        }
        else{
            return arr[rear].data;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Priority Queue: [");
        for (int i = 0; i < numElement; i++) {
            sb.append(arr[(front + i)%arraySize].data).append("(").append(arr[(front + i)%arraySize].priority).append(")");
            if (i < numElement - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public void display(){
        System.out.println(toString());
    }
}

class Node<T>{
    T data;
    int priority;
}
