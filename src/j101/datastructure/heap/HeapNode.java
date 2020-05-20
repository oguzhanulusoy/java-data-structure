package j101.datastructure.heap;

/**
 * HeapNode
 * @author oppenheimer
 */
public class HeapNode {

    private int data;
    private int key;

    public HeapNode(int data, int name) {
        this.setData(data);
        this.setKey(name);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
