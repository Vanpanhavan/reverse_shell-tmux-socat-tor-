public class Stack<T> {
    private T[] arr;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int arraySize) {
        this.arr = (T[]) new Object[arraySize];
        this.top = 0;
    }
    public void push( T newItem){
        if (top == arr.length) {
            System.out.println("Stack is full");
        }
        else {
            arr[top] = newItem;
            top++;
        }
    }
    public T pop(){
        if (top == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        else{
            T popItem;
            top--;
            popItem = arr[top];
            arr[top] = null;
            return popItem;
        }
    }
    public T peek(){
        if (top == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        else{
            return arr[top-1];
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        for (int i = 0; i < top; i++) {
            sb.append(arr[i]);
            if (i < top - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public void display(){
        System.out.println(this.toString());
    }
}
