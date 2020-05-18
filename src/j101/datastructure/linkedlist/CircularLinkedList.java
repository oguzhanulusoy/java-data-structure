package j101.datastructure.linkedlist;

/**
 * CircularLinkedList
 */
public class CircularLinkedList {

    DoubleNode first;

    public CircularLinkedList() {
        first = null;
    }

    public void insertFirst(DoubleNode node) {

        if (first == null) {
            node.setNext(node);
            node.setNext(node);
        } else {
            node.setNext(first);
            node.setPrevious(first.getPrevious());
            first.getPrevious().setNext(node);
            node.setPrevious(node);
        }
        first = node;
    }

    public void deleteFirst() {
        if (first.getNext() == first) {
            first = null;
        } else {
            first.getPrevious().setNext(first.getNext());
            first.getNext().setPrevious(first.getPrevious());
            first = first.getNext();
        }
    }

}
