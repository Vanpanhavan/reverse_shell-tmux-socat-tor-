public class DoublyLinkedList <T> {
    private DoublyLink <T> first;
    private DoublyLink <T> last;
    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
    }
    public void insertFirst(T newItem){ // O(1)
        DoublyLink <T> newLink = new DoublyLink<>();
        newLink.data = newItem;
        if (first == null) {
            first = newLink;
            last = newLink;
        }
        else {
            newLink.next = first;
            first.previous = newLink;
            first = newLink;
        }
    }
    public void insertLast(T newItem){ // O(1)
        DoublyLink <T> newLink = new DoublyLink <T>();
        newLink.data = newItem;
        if (first == null) {
            first = newLink;
            last = newLink;
        }
        else {
            newLink.previous = last;
            last.next = newLink;
            last = newLink;
        }
    }
    public void insertAt(int index, T newItem){ // O(n)
        int counter = 0;
        DoublyLink<T> current = first;
        if (index == 0){
            insertFirst(newItem);
        }
        else {
            while (counter < index - 1) {
                current = current.next;
                counter++;
                if (current == null) {
                    throw new IndexOutOfBoundsException("My Index out of bounds");
                }
            }
            DoublyLink<T> newLink = new DoublyLink<T>();
            newLink.data = newItem;
            newLink.next = current.next;
            newLink.previous = current;
            if (current == last){
                last = newLink;
                current.next = newLink;
            }
            else {
                current.next.previous = newLink;
                current.next = newLink;
            }
        }
    }
    public boolean deleteFirst(){ // O(1)
        if (first == null){
            return false;
        }
        else if (first == last){
            first = null;
            last = null;
        }
        else{
            first = first.next;
            first.previous = null;
        }
        return true;
    }
    public boolean deleteLast(){ // O(1)
        if (last == null){
            return false;
        }
        else if (first == last){
            first = null;
            last = null;
        }
        else{
            last = last.previous;
            last.next = null;
        }
        return true;
    }
    public boolean deleteAt(int index){ // O(n)
        DoublyLink<T> current = first;
        int counter = 0;
        if (index == 0){
            return deleteFirst();
        }
        else if (first == null){
            return false;
        }
        else {
            while (counter < index - 1) {
                current = current.next;
                counter++;
                if (current == last) {
                    return false;
                }
            }
        }
        if (current.next == last){
            current.next = null;
            last = current;
        }
        else {
            current.next = current.next.next;
            current.next.previous = current;
        }
        return true;
    }
    public boolean deleteKey(T key){ // O(n)
        DoublyLink<T> current = first;
        if (first == null){
            return false;
        }
        else if (first.data.equals(key)) {
            return deleteFirst();
        }
        else {
            while (current.next != null) {
                if (current.next.data.equals(key)) {
                    if (current.next == last){
                        current.next = null;
                        last = current;
                    }
                    else {
                        current.next = current.next.next;
                        current.next.previous = current;
                    }
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    public int find(T key){ // O(n)
        int counter = 0;
        DoublyLink<T> current = first;
        while(current != null){
            if (current.data.equals(key)){
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }
    public boolean isEmpty(){ // O(1)
        return first == null;
    }
    public String toString() { // O(n)
        DoublyLink<T> current = first;
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
    public void displayForward() { // O(n)
        System.out.println(toString());
    }
    public void displayBackward(){ // O(n)
        DoublyLink<T> current = last;
        StringBuilder sb = new StringBuilder();
        sb.append("List: [");
        while (current != null) {
            sb.append(current.data);
            if (current == first) {
                break;
            }
            sb.append(", ");
            current = current.previous;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}

