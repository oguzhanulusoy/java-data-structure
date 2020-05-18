package j101.datastructure.linkedlist;

/**
 * LinkedList
 */
public class LinkedList {

    Node FIRST, LAST;

    public LinkedList union(LinkedList list) {

        LinkedList unionList = new LinkedList();

        Node index = FIRST;

        if (index != null) {
            unionList.insertFirst(index.getData());
            index = index.getNext();
        }

        while (index != null) {
            unionList.insertLast(index.getData());
            index = index.getNext();
        }

        index = FIRST;

        Node indexOfList = list.FIRST;
        while (indexOfList != null) {
            if (!isContain(unionList, indexOfList.getData())) {
                unionList.insertLast(indexOfList.getData());
            }
            indexOfList = indexOfList.getNext();
        }

        return unionList;
    }

    public boolean isContain(LinkedList list, int data) {
        Node node = list.FIRST;

        while (node != null) {
            if (node.getData() == data) {
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    public LinkedList merge(LinkedList firstList, LinkedList secondList) {
        LinkedList newList = new LinkedList();

        if ((firstList != null) && (secondList == null)) {
            return firstList;
        }

        if ((secondList != null) && (firstList == null)) {
            return secondList;
        }

        if ((firstList != null) && (secondList != null)) {
            newList.FIRST = firstList.FIRST;
            newList.LAST = secondList.LAST;
            firstList.LAST.setNext(secondList.FIRST);
        }

        return newList;
    }

    public void insertLast(int data) {

        // Create new node with given data.
        Node newNode = new Node(data);

        // If there is no node in the list, newNode must be first element. Otherwise,
        // next node of the last element in the list must be newNode. Then,
        // newNode comes last node in the list.
        if (FIRST == null) {
            FIRST = newNode;
            LAST = newNode;
        } else {
            LAST.setNext(newNode);
            LAST = newNode;
        }
    }

    public void insertLast(Node node) {
        if (LAST == null) {
            FIRST = node;
            LAST = node;
        } else {
            LAST.setNext(node);
            LAST = node;
        }
    }


    public void deleteLast() {
        Node index = FIRST;
        Node previous = null;

        // To find second to last element in the list
        while (index != LAST) {
            previous = index;
            index = index.getNext();
        }

        // If the list size is 1, first element must be deleted
        if (previous == null) {
            FIRST = null;
        }

        // Otherwise, we know second to last element, it's next must be gone null
        // then, LAST must be replaced with previos
        else {
            previous.setNext(null);
            LAST = previous;
        }
    }

    public void insertFirst(Node node) {

        // If there is no any element
        if (LAST == null) {
            FIRST = node;
        } else {
            node.setNext(FIRST);
            FIRST = node;
        }
    }

    public void insertFirst(int data) {

        // Create new node with given data
        Node node = new Node(data);

        // If there is no any element
        if (LAST == null) {
            FIRST = node;
            LAST = node;
        } else {
            node.setNext(FIRST);
            FIRST = node;
        }
    }

    public void deleteFirst() {

        // If there is no any element
        if (FIRST == null) {
            LAST = null;
        } else {
            FIRST.setNext(FIRST.getNext());
        }
    }

    public int nodeCount() {
        Node index = FIRST;
        int count = 0;

        // Looping until end of the list
        while (index != null) {
            count++;
            index.setNext(index.getNext());
        }

        return count;
    }

    public LinkedList primes(int length) {
        boolean isPrime;
        LinkedList primeList = new LinkedList();
        Node node;

        for (int i = 2; i <= length; i++) {
            isPrime = true;
            for (int j = 2; j < length; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                node = new Node(i);
                primeList.insertLast(node.getData());
            }
        }

        return primeList;
    }

    public void insertSecond(Node node) {
        if (FIRST == null) {
            insertFirst(node.getData());
        } else if (FIRST.getNext() == null) {
            insertLast(node.getData());
        } else {
            node.setNext(FIRST.getNext());
            FIRST.setNext(node);
        }
    }

    public void display() {
        Node index = FIRST;
        String display = " ";

        while (index != null) {
            display += (index.getData() + " -> ");
            index = index.getNext();
        }
        display += " null";

        System.out.println(display);
    }
}