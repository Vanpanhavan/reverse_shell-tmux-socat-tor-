public class ListIterator_LinkedList<T> {
    Link <T> current;
    Link <T> previous;
    LinkedList <T> iterator;
    public ListIterator_LinkedList(LinkedList <T> iterator, Link <T> l){
        this.current = l;
        this.previous = iterator.getPrevious(current);
        this.iterator = iterator;
    }
    public void reset(){ // O(1)
        current = iterator.getFirst();
        previous = null;
    }
    public boolean atEnd(){ // O(1)
        return iterator.atEnd(current);
    }
    public Link <T> getCurrent(){ // O(1)
        return current;
    }
    public void nextLink(){ // O(1)
        if (current != null) {
            previous = current;
            current = current.next;
        }
    }
    public void insertBefore(T newItem){ // O(1)
        InsertResult_LinkedList <T> result = iterator.insertBeforeCurrent(current, previous, newItem);
        previous = result.previous;
        current = result.current;
    }
    public void insertAfter(T newItem){ // O(1)
        InsertResult_LinkedList <T> result = iterator.insertAfterCurrent(current, previous, newItem);
        previous = result.previous;
        current = result.current;
    }

    public boolean deleteCurrent(){ // O(1)
        DeleteResult_LinkedList <T> result = iterator.deleteCurrent(current, previous);
        boolean isDeleted = result.isDeleted;
        current = result.current;
        previous = result.previous;
        return isDeleted;
    }
}
