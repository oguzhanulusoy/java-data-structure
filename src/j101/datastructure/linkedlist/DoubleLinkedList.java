package j101.datastructure.linkedlist;

public class DoubleLinkedList {

    DoubleNode first;
    DoubleNode last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(DoubleNode node) {
        if (last == null) {
            last = node;
        } else {
            first.setPrevious(node);
            node.setNext(first);
            first = node;
        }
    }

    public void insertLast(DoubleNode node) {
        if (first == null) {
            first = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
    }

    public void deleteFirst() {
        first = first.getNext();
        if (first == null) {
            last = null;
        } else {
            first.setPrevious(null);
        }
    }

    public void deleteLast() {
        last = last.getPrevious();
        if (last == null) {
            first = null;
        } else {
            last.setNext(null);
        }
    }

    public void deleteMiddle(DoubleNode node) {
        node.getNext().setPrevious(node.getPrevious());
        node.getPrevious().setNext(node.getNext());
    }

}
