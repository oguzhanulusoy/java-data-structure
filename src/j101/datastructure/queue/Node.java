package j101.datastructure.queue;

/**
 * Node
 */
public class Node {
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
