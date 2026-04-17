public class Queue <T> {
    private T[]  arr;
    private int front;
    private int rear;
    private int numElement;
    private int arraySize;

    @SuppressWarnings("unchecked")
    public Queue(int arraySize){
        if (arraySize <= 0) {
            throw new IllegalArgumentException("Array size must be positive");
        }
        this.arraySize = arraySize;
        this.arr = (T[]) new Object[arraySize];
        this.front = 0;
        this.rear = -1;
    }
    public void insert(T newItem){
        if (numElement == arraySize) {
            System.out.println("Queue is full");
        }
        else {
            rear = (rear + 1) % arraySize;
            arr[rear] = newItem;
            numElement++;
        }
    }
    public T remove(){
        T removeItem;
        if (numElement == 0){
            throw new IllegalStateException("Queue is empty");
        }
        else{
            removeItem = arr[front];
            arr[front] = null;
            front = (front + 1)%arraySize;
            numElement--;
            return removeItem;
        }
    }
    public T peekFront(){
        if (numElement == 0){
            throw new IllegalStateException("Queue is empty");
        }
        else{
            return arr[front];
        }
    }
    public T peekRear(){
        if (numElement == 0){
            throw new IllegalStateException("Queue is empty");
        }
        else{
            return arr[rear];
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        for (int i = 0; i < numElement; i++) {
            sb.append(arr[(front + i)%arraySize]);
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
