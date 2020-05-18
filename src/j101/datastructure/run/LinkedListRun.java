package j101.datastructure.run;
import j101.datastructure.linkedlist.Node;
import j101.datastructure.linkedlist.LinkedList;
import java.util.Random;
import java.util.Scanner;

// Just single linkedlist is here
public class LinkedListRun {

    public static final int LENGTH = 10,
                            IN_RANGE_SIZE = 10;

    public static StringBuilder MENU;

    enum LinkedListOptions {
        SAMPLE,
        UNION,
        IS_CONTAIN,
        MERGE,
        INSERT_LAST,
        DELETE_LAST,
        INSERT_FIRST,
        DELETE_FIRST,
        NODE_COUNT,
        PRIMES,
        INSERT_SECOND,
        BREAK
    }

    /**
     * LinkedList implementations here
     */
    public static void linkedListMenu()  {

        MENU = new StringBuilder("\n\nLinkedList options: \n\t");
        MENU.append(LinkedListOptions.UNION + "\n\t");
        MENU.append(LinkedListOptions.IS_CONTAIN + "\n\t");
        MENU.append(LinkedListOptions.MERGE + "\n\t");
        MENU.append(LinkedListOptions.INSERT_LAST + "\n\t");
        MENU.append(LinkedListOptions.DELETE_LAST + "\n\t");
        MENU.append(LinkedListOptions.INSERT_FIRST + "\n\t");
        MENU.append(LinkedListOptions.DELETE_FIRST + "\n\t");
        MENU.append(LinkedListOptions.NODE_COUNT + "\n\t");
        MENU.append(LinkedListOptions.PRIMES + "\n\t");
        MENU.append(LinkedListOptions.INSERT_SECOND + "\n\t");
        MENU.append(LinkedListOptions.BREAK + "\n");
        MENU.append("Type an option: ");
        System.out.println(MENU);
    }

    // Rename method name as main
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        linkedListMenu();
        String choice = input.next();

        System.out.println("Generating a LinkedList with random data...");
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < LENGTH; i++) {
            int data = random.nextInt(IN_RANGE_SIZE);
            linkedList.insertFirst(data);
        }
        linkedList.display();
        System.out.println("A linkedList with " + LENGTH + " length is created");

        while (true) {
            if (choice.equals(LinkedListOptions.DELETE_FIRST.toString())) {
                System.out.println("DeleteFirst() is calling...");
                linkedList.deleteFirst();
                linkedList.display();
            }

            if (choice.equals(LinkedListOptions.DELETE_LAST.toString())) {
                System.out.println("DeleteLast() is calling...");
                linkedList.deleteLast();
                linkedList.display();
            }

            if (choice.equals(LinkedListOptions.INSERT_SECOND.toString())) {
                System.out.println("InsertSecond() is calling...");
                Node newNode = new Node(random.nextInt(IN_RANGE_SIZE));
                linkedList.insertSecond(newNode);
                linkedList.display();
            }

            if (choice.equals(LinkedListOptions.PRIMES.toString())) {
                System.out.println("Primes() is calling...");
                linkedList.primes(LENGTH).display();
            }

            if (choice.equals(LinkedListOptions.MERGE.toString())) {
                System.out.println("Merge() is calling...");
                System.out.println("Generating another LinkedList with random data...");
                LinkedList secondLinkedList = new LinkedList();
                for (int i = 0; i < LENGTH; i++) {
                    int data = random.nextInt(IN_RANGE_SIZE);
                    secondLinkedList.insertFirst(data);
                }

                System.out.println("Generated LinkedList is here: ");
                secondLinkedList.display();

                System.out.println("Existing LinkedList is here: ");
                linkedList.display();

                linkedList.merge(linkedList, secondLinkedList).display();
                linkedList.display();
            }

            if (choice.equals(LinkedListOptions.NODE_COUNT.toString())) {
                System.out.println("NodeCount() is calling...");
                int nodeCount = linkedList.nodeCount();
                System.out.println("Node count: " + nodeCount);
            }

            if (choice.equals(LinkedListOptions.INSERT_LAST.toString())) {
                System.out.println("InsertLast() is calling...");
                linkedList.insertLast(random.nextInt(IN_RANGE_SIZE));
                linkedList.display();
            }

            if (choice.equals(LinkedListOptions.BREAK.toString())) {
                System.out.println("Breaking...");
                break;
            }

            linkedListMenu();
            choice = input.next();
        }
    }
}
