public class Stack<T> {
    private Link <T> first;

    public Stack() {
        this.first = null;
    }
    public void push( T newItem){ // O(1)
        Link <T> newLink = new Link <T>();
        newLink.data = newItem;
        if (first == null) {
            first = newLink;
        }
        else {
            newLink.next = first;
            first = newLink;
        }
    }
    public T pop(){ // O(1)
        if (first == null){
            throw new RuntimeException("Stack is empty");
        }
        else{
            T data = first.data;
            first = first.next;
            return data;
        }
    }
    public T peek(){ // O(1)
        if (first == null){
            throw new RuntimeException("Stack is empty");
        }
        else{
            return first.data;
        }
    }
    public String toString(){ // O(n)
        Link<T> current = first;
        StringBuilder sb = new StringBuilder();
        sb.append("List: [");
        while (current != null) {
            sb.append(current.data);
            if (current.next == null) {
                break;
            }
            sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public void display(){ // O(n)
        System.out.println(toString());
    }
}

