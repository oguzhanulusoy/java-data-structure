package j101.datastructure.stack;

import java.util.Arrays;

/**
 * Stack
 */
public class Stack {

    private Node[] array;
    private int top;
    private int size;

    public Stack(int size) {
        this.size = size;
        array = new Node[size];
        top = -1;
    }

    public Node top() {
        return array[top];
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Node node) {
        if (!isFull()) {
            top++;
            array[top] = node;
        }
    }

    public Node pop() {
        if (!isEmpty()) {
            top--;
            return array[top + 1];
        }
        return null;
    }

    public void display() {
        for (int i = array.length; i > 0; i--) {
            System.out.println(array[i].getData() + "\n");
        }
    }

    public Node[] getArray() {
        return array;
    }

    public void setArray(Node[] array) {
        this.array = array;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                ", top=" + top +
                ", size=" + size +
                '}';
    }
}
