package j101.datastructure.heap;

/**
 * Heap
 * @author oppenheimer
 */
public class Heap {

    HeapNode[] heap;
    int elementNumber;

    public Heap(int size) {
        heap = new HeapNode[size];
        elementNumber = 0;
    }

    public boolean isEmpty() {
        return elementNumber == 0;
    }

    public HeapNode findMaximum() {
        if (elementNumber == 0) {
            return null;
        }
        return heap[0];
    }

    public HeapNode deleteMaximum() {
        if (isEmpty()) {
            return null;
        } else {
            HeapNode index;
            index = heap[0];
            heap[0] = heap[elementNumber - 1];
            bubbleDown(0);
            elementNumber--;
            return index;
        }
    }

    public void heapSort() {
        HeapNode[] sort = new HeapNode[elementNumber];
        HeapNode[] copy = new HeapNode[elementNumber];

        for (int i = 0; i < elementNumber; i++) {
            copy[i] = heap[i];
        }
        for (int i = 0; i < elementNumber; i++) {
            sort[i] = deleteMaximum();
        }
        this.heap = copy;
    }

    private void bubbleDown(int index) {
        int left = 2 * index + 1, right = 2 * index + 2;

        while ((left < elementNumber && heap[index].getData() < heap[left].getData())
                || (right < elementNumber && heap[index].getData() < heap[right].getData())) {

            if (right >= elementNumber || heap[left].getData() > heap[right].getData()) {
                swapNode(index, left);
                index = left;
            } else {
                swapNode(index, right);
                index = right;
            }
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    private void swapNode(int from, int to) {
        HeapNode tempNode = heap[from];
        heap[from] = heap[to];
        heap[to] = tempNode;
    }

    public void insert(HeapNode node) {
        elementNumber++;
        heap[elementNumber - 1] = node;
        bubbleUp(elementNumber - 1);
    }

    public void insert(int key, int data) {
        HeapNode newNode = new HeapNode(key, data);
        heap[elementNumber++] = newNode;
        int index = elementNumber - 1, parent = ((index - 1) / 2);

        while (parent >= 0 && heap[parent].getData() < heap[index].getData()) {
            swapNode(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void bubbleUp(int index) {
        int parent = (index - 1 / 2);
        while (parent >= 0 && heap[parent].getData() < heap[index].getData()) {
            swapNode(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    public int search(int key) {
        for (int i = 0; i < elementNumber; i++) {
            if (heap[i].getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    public HeapNode search(int key, String overload) {
        for (int i = 0; i < elementNumber; i++) {
            if (heap[i].getKey() == key) {
                return heap[i];
            }
        }
        return null;
    }

    public void update(int index, int data) {
        int currentData = heap[index].getData();
        heap[index].setData(data);

        if (currentData > data) {
            bubbleDown(index);
        } else {
            bubbleUp(index);
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < elementNumber; i++) {
            result += heap[i].getKey();
        }
        return result;
    }
}
