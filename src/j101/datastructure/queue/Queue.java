package j101.datastructure.queue;

import java.util.Arrays;

public class Queue {

    private Node array[];
    private int first;
    private int last;
    private int size;

    public Queue(int size) {
        this.size = size;
        array = new Node[size];
        first = 0;
        last = 0;
    }

    public boolean isFull() {
        if (first == (last + 1) % size) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (first == last) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(Node node) {
        if (!isFull()) {
            array[last] = node;
            last = (last + 1) % node.getData();
        }
    }

    public Node dequeue() {
        Node result;
        if (!isEmpty()) {
            result = array[first];
            first = (first + 1) % result.getData();
            return result;
        }
        return null;
    }

    public Node[] getArray() {
        return array;
    }

    public void setArray(Node[] array) {
        this.array = array;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "array=" + Arrays.toString(array) +
                ", first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }
}
