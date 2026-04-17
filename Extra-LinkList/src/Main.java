public class Main {

    public static void main(String[] args) {

        System.out.println("========== SINGLY LINKED LIST DIRECT TEST ==========");

        LinkedList<Integer> list = new LinkedList<>();

        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertLast(50);

        list.display();

        System.out.println("Insert at index test");
        list.insertAt(3, 35);
        list.display();

        System.out.println("Delete key 20");
        list.deleteKey(20);
        list.display();

        System.out.println("Delete first");
        list.deleteFirst();
        list.display();

        System.out.println("Delete last");
        list.deleteLast();
        list.display();

        System.out.println("Find 35 -> index = " + list.find(35));


        System.out.println("\n========== ITERATOR TEST (SINGLY LINKED LIST) ==========");

        Link<Integer> current = list.getFirst();

        ListIterator_LinkedList<Integer> iterator =
                new ListIterator_LinkedList<>(list, current);

        System.out.println("Iterator starting at first:");
        list.display();

        System.out.println("Move iterator forward twice");
        iterator.nextLink();
        iterator.nextLink();

        System.out.println("Insert BEFORE current (999)");
        iterator.insertBefore(999);
        list.display();

        System.out.println("Insert AFTER current (777)");
        iterator.insertAfter(777);
        list.display();

        System.out.println("Delete current");
        iterator.deleteCurrent();
        list.display();

        System.out.println("Move iterator until end");

        while (!iterator.atEnd()) {
            iterator.nextLink();
        }

        System.out.println("Insert AFTER last node (888)");
        iterator.insertAfter(888);
        list.display();

        System.out.println("Delete last using iterator");
        iterator.deleteCurrent();
        list.display();



        System.out.println("\n========== EDGE CASE TEST (SINGLY LIST) ==========");

        LinkedList<Integer> edgeList = new LinkedList<>();

        edgeList.insertFirst(1);
        edgeList.display();

        ListIterator_LinkedList<Integer> edgeIterator =
                new ListIterator_LinkedList<>(edgeList, edgeList.getFirst());

        System.out.println("Delete only node");
        edgeIterator.deleteCurrent();
        edgeList.display();

        System.out.println("Insert after on single node list");
        edgeList.insertFirst(10);
        edgeIterator = new ListIterator_LinkedList<>(edgeList, edgeList.getFirst());

        edgeIterator.insertAfter(20);
        edgeList.display();



        System.out.println("\n========== DOUBLY LINKED LIST DIRECT TEST ==========");

        DoublyLinkedList<Integer> dlist = new DoublyLinkedList<>();

        dlist.insertFirst(30);
        dlist.insertFirst(20);
        dlist.insertFirst(10);
        dlist.insertLast(40);
        dlist.insertLast(50);

        dlist.displayForward();

        System.out.println("InsertAt(2, 25)");
        dlist.insertAt(2, 25);
        dlist.displayForward();

        System.out.println("DeleteAt(3)");
        dlist.deleteAt(3);
        dlist.displayForward();

        System.out.println("Find 40 -> index = " + dlist.find(40));


        System.out.println("\n========== ITERATOR TEST (DOUBLY LINKED LIST) ==========");

        DoublyLink<Integer> dcurrent = dlist.getFirst();

        ListIterator_DoublyLinkedList<Integer> diter =
                new ListIterator_DoublyLinkedList<>(dlist, dcurrent);

        System.out.println("Move iterator forward twice");
        diter.nextLink();
        diter.nextLink();

        System.out.println("Insert BEFORE current (111)");
        diter.insertBefore(111);
        dlist.displayForward();

        System.out.println("Insert AFTER current (222)");
        diter.insertAfter(222);
        dlist.displayForward();

        System.out.println("Delete current");
        diter.deleteCurrent();
        dlist.displayForward();


        System.out.println("\n========== ITERATOR STRESS WALK ==========");

        diter.reset();

        while (!diter.atEnd()) {

            if (diter.getCurrent().data % 2 == 0) {
                diter.insertAfter(999);
            }

            diter.nextLink();
        }

        dlist.displayBackward();



        System.out.println("\n========== CRASH TESTS (UNCOMMENT TO TEST) ==========");

        //Test: insertAt huge index
//        list.insertAt(1000000, 999);

        // Test: iterator next on null
//         iterator.nextLink();
//         iterator.nextLink();
//         iterator.nextLink();
//         iterator.nextLink();
//         iterator.nextLink();
//         iterator.nextLink();

        // Test: deleteCurrent on empty list
//         LinkedList<Integer> empty = new LinkedList<>();
//         ListIterator_LinkedList<Integer> bad =
//                new ListIterator_LinkedList<>(empty, null);
//         bad.deleteCurrent();

        System.out.println("\n========== HARD TEST FINISHED ==========");

    }
}