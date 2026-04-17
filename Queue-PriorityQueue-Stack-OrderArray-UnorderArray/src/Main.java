import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list.deleteAt(1));
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertAt(4, 40);
        System.out.println(list.deleteFirst());
        System.out.println(list.deleteLast());
        list.insertFirst(50);
        System.out.println(list.deleteAt(3));
        System.out.println(list.find(10));

        System.out.println(list.toString());

        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        list1.insertFirst(10);
        list1.insertFirst(20);
        list1.insertAt(2, 30);

        System.out.println(list1.deleteAt(5));
        System.out.println(list1.toString());
        list1.displayBackward();

        int counter = 0;
        int num1 = 0;
        int num2 = 0;
        while(true){
            if (counter == 0){
                num1 = 0;
            }
            else if (counter == 1){
                num2 = 1;
            }
            else {
                int result = num1 + num2;
            }

        }


    }
}
