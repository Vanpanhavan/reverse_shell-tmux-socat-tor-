public class Queue <T> {
    private Link <T> first;
    private Link <T> last;
    public Queue(){
        this.first = null;
        this.last = null;
    }
    public void insert(T newItem){ // O(1)
        Link <T> newLink = new Link <T>();
        newLink.data = newItem;
        if (first == null) {
            first = newLink;
            last = newLink;
        }
        else {
            last.next = newLink;
            last = newLink;
        }
    }
    public T remove(){ // O(1)
        if (first == null){
            throw new RuntimeException("Queue is empty");
        }
        else if (first == last){
            T data = first.data;
            first = null;
            last = null;
            return data;
        }
        else{
            T data = first.data;
            first = first.next;
            return data;
        }
    }
    public T peekFront(){ // O(1)
        if (first == null){
            throw new RuntimeException("Queue is empty");
        }
        else{
            return first.data;
        }
    }
    public T peekRear(){ // O(1)
        if (last == null){
            throw new RuntimeException("Queue is empty");
        }
        else{
            return last.data;
        }
    }
    public String toString(){ // O(n)
        Link<T> current = first;
        StringBuilder sb = new StringBuilder();
        sb.append("List: [");
        while (current != null) {
            sb.append(current.data);
            if (current == last) {
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

