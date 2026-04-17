public class ListIterator_DoublyLinkedList<T> {
    DoublyLink <T> current;
    DoublyLinkedList <T> iterator;
    public ListIterator_DoublyLinkedList(DoublyLinkedList <T> iterator, DoublyLink <T> l){
        this.current = l;
        this.iterator = iterator;
    }
    public void reset(){ // O(1)
        current = iterator.getFirst();
    }
    public boolean atEnd(){ // O(1)
        return iterator.atEnd(current);
    }
    public DoublyLink <T> getCurrent(){ // O(1)
        return current;
    }
    public void nextLink(){ // O(1)
        if (current != null){
            current = current.next;
        }
    }
    public void insertBefore(T newItem){ // O(1)
        InsertResult_DoublyLinkList <T> result = iterator.insertBeforeCurrent(current, newItem);
        current = result.current;
    }
    public void insertAfter(T newItem){ // O(1)
        InsertResult_DoublyLinkList <T> result = iterator.insertAfterCurrent(current, newItem);
        current = result.current;
    }

    public boolean deleteCurrent(){ // O(1)
        DeleteResult_DoublyLinkedList <T> result = iterator.deleteCurrent(current);
        boolean isDeleted = result.isDeleted;
        current = result.current;
        return isDeleted;
    }
}

