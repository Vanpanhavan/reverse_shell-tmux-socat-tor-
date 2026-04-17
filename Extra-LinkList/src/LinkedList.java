public class LinkedList <T> {
    private Link <T> first;
    private Link <T> last;
    public LinkedList(){
        this.first = null;
        this.last = null;
    }
    public void insertFirst(T newItem){ // O(1)
        Link <T> newLink = new Link <T>();
        newLink.data = newItem;
        if (first == null) {
            first = newLink;
            last = newLink;
        }
        else {
            newLink.next = first;
            first = newLink;
        }
    }
    public void insertLast(T newItem){ // O(1)
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
    public void insertAt(int index, T newItem){ // O(n)
        int counter = 0;
        Link<T> current = first;
        if (index == 0){
            insertFirst(newItem);
        }
        else {
            while (counter < index - 1) {
                current = current.next;
                counter++;
                if (current == null) {
                    throw new IndexOutOfBoundsException("Index out of bounds");
                }
            }
            Link<T> newLink = new Link<T>();
            newLink.data = newItem;
            newLink.next = current.next;
            current.next = newLink;
            if (current == last){
                last = newLink;
            }
        }
    }
    public InsertResult_LinkedList<T> insertAfterCurrent(Link <T> current, Link <T> previous,  T newItem){ // O(1)
        InsertResult_LinkedList<T> result = new InsertResult_LinkedList<T>();
        Link <T> newLink = new Link <T>();
        newLink.data = newItem;
        if (last == null || current == null){
            throw new NullPointerException("list is empty or current is null");
        }
        else if (current == last){
            current.next = newLink;
            last = newLink;
        }
        else {
            newLink.next = current.next;
            current.next = newLink;
        }
        result.current = current;
        result.previous = previous;
        return result;
    }
    public InsertResult_LinkedList<T> insertBeforeCurrent(Link <T> current, Link <T> previous, T newItem){ // O(1)
        InsertResult_LinkedList<T> result = new InsertResult_LinkedList<T>();
        Link <T> newLink = new Link <T>();
        newLink.data = newItem;
        if (first == null){
            throw new NullPointerException("list is empty");
        }
        else if (current == first){
            previous = newLink;
            newLink.next = current;
            first = newLink;
        }
        else{
            previous.next = newLink;
            previous = newLink;
            newLink.next = current;
        }
        result.current = current;
        result.previous = previous;
        return result;
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
        }
        return true;
    }
    public boolean deleteLast(){ // O(n)
        Link<T> current = first;
        if (last == null){
            return false;
        }
        else if (first == last){
            first = null;
            last = null;
        }
        else {
            while (current.next != last) {
                current = current.next;
            }
            current.next = null;
            last = current;
        }
        return true;
    }
    public boolean deleteAt(int index){ // O(n)
        Link<T> current = first;
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
            last = current;
        }
        current.next = current.next.next;
        return true;
    }
    public boolean deleteKey(T key){ // O(n)
        Link<T> current = first;
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
                    }
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    public DeleteResult_LinkedList<T> deleteCurrent(Link <T> current, Link <T> privious){ // O(1)
        DeleteResult_LinkedList<T> result = new DeleteResult_LinkedList<T>();
        if (first == null){
            result.isDeleted = false;
        }
        else if (current == null){
            result.isDeleted = false;
        }
        else if (first == last){   // only one node
            first = null;
            last = null;
            current = null;
            privious = null;
            result.isDeleted = true;
        }
        else if (current == first){
            current = first.next;
            first = current;
            privious = null;
            result.isDeleted = true;
        }
        else if (current == last){
            privious.next = null;
            last = privious;
            result.isDeleted = true;
        }
        else {
            current = current.next;
            privious.next = current;
            result.isDeleted = true;
        }
        result.current = current;
        result.previous = privious;
        return result;
    }
    public int find(T key){ // O(n)
        int counter = 0;
        Link<T> current = first;
        while(current != null){
            if (current.data.equals(key)){
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }
    public Link <T> getFirst(){ // O(1)
        return first;
    }
    public boolean atEnd(Link <T> current){ // O(1)
        return current == last;
    }
    public Link <T> getPrevious(Link <T> current){ // O(n)
        Link <T> previous = first;
        while (previous != null){
            if (current == first){
                return null;
            }
            else if (previous.next == current){
                return previous;
            }
            else {
                previous = previous.next;
            }
        }
        throw new NullPointerException("current is null");
    }
    public boolean isEmpty(){ // O(1)
        return first == null;
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
    public void display(){ //O(1)
        System.out.println(toString());
    }
}


