public class Main {

    public static void main(String[] args) {

        System.out.println("===== STACK TEST =====");

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display(); // expect [30, 20, 10]

        System.out.println("Peek: " + stack.peek());

        System.out.println("Pop: " + stack.pop());
        stack.display();

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        stack.display();

        // ---------- ERROR TEST ----------
        // Uncomment to test empty stack exception

//         System.out.println(stack.pop());
//         System.out.println(stack.peek());


        System.out.println("\n===== QUEUE TEST =====");

        Queue<Integer> queue = new Queue<>();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        queue.display(); // expect [1,2,3,4]

        System.out.println("Front: " + queue.peekFront());
        System.out.println("Rear: " + queue.peekRear());

        System.out.println("Remove: " + queue.remove());
        queue.display();

        System.out.println("Remove: " + queue.remove());
        System.out.println("Remove: " + queue.remove());
        System.out.println("Remove: " + queue.remove());

        queue.display();

        // ---------- ERROR TEST ----------
        // Uncomment to test empty queue

//         System.out.println(queue.remove());
//         System.out.println(queue.peekFront());
//         System.out.println(queue.peekRear());


        System.out.println("\n===== LINKED LIST TEST =====");

        LinkedList<Integer> list = new LinkedList<>();

        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(15);

        list.display();

        list.deleteFirst();
        list.display();

        list.deleteFirst();
        list.deleteFirst();

        list.display();

        // ---------- ERROR TEST ----------
        // Uncomment to test delete on empty list

//         list.deleteFirst();


        System.out.println("\n===== DOUBLY LINKED LIST TEST =====");

        DoublyLinkedList<Integer> dlist = new DoublyLinkedList<>();

        dlist.insertFirst(100);
        dlist.insertFirst(200);
        dlist.insertFirst(300);

        dlist.displayForward();
        dlist.displayBackward();

        dlist.deleteFirst();
        dlist.displayForward();

        dlist.deleteFirst();
        dlist.deleteFirst();

        dlist.displayForward();

        // ---------- ERROR TEST ----------
        // Uncomment if deleteFirst throws error when empty

//         dlist.deleteFirst();



        System.out.println("\n===== STRESS TEST =====");

        Stack<Integer> stressStack = new Stack<>();

        for(int i=0;i<10000;i++){
            stressStack.push(i);
        }

        for(int i=0;i<10000;i++){
            stressStack.pop();
        }

        System.out.println("Stress stack finished");


        Queue<Integer> stressQueue = new Queue<>();

        for(int i=0;i<10000;i++){
            stressQueue.insert(i);
        }

        for(int i=0;i<10000;i++){
            stressQueue.remove();
        }

//        Queue<Integer> q = new Queue<>();
//
//        for(int i=0;i<100000;i++){
//            q.insert(i);
//        }
//
//        for(int i=0;i<50000;i++){
//            q.remove();
//        }
//
//        for(int i=100000;i<150000;i++){
//            q.insert(i);
//        }
//
//        q.display();

        System.out.println("Stress queue finished");

        System.out.println("\nAll tests completed.");
    }
}
