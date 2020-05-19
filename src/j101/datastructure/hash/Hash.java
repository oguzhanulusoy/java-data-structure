package j101.datastructure.hash;

/**
 * Hash
 * @author oppenheimer
 */
public class Hash {

    private int size;
    private int elementNumber;
    public Node[] table;
    public boolean[] isDeleted;

    public Hash(int size) {
        this.setSize(size);
        table = new Node[size];
        isDeleted = new boolean[size];
        this.setElementNumber(0);
    }

    public int function(int key) {
        return key % getSize();
    }

    public void insert(int key) {
        int index = function(key);
        Node newNode = new Node(key);

        while(!table[index].equals(null) && !isDeleted[index]) {
            index = (index + 1) % 7;
        }

        table[index] = newNode;
        isDeleted[index] = false;
        this.setElementNumber(this.getElementNumber() + 1);

        /* If elementNumber is greater than our condition, we must increase the size of table. */
        if(elementNumber > size / 2) {
            rehash();
        }
    }

    /* If elementNumber is greater than our condition, we must increase the size of table.
    * New hash table must be created with 'size*2' length, then existing nodes are to be transfered
    * onto this new hash table. Then, this table must be replaced new hashmap. */
    public void rehash() {
        Hash rehashedTable = new Hash(size * 2);

        for (int index = 0; index < size; index++) {
            if (!table[index].equals(null) && !isDeleted[index]) {
                rehashedTable.insert(table[index].getData());
            }
        }
        this.table = rehashedTable.table;
        size *= 2;
        this.isDeleted = rehashedTable.isDeleted;
    }

    public Node delete(int key) {
        int index = function(key);

        while (!table[index].equals(null) && table[index].getData() != key) {
            index = (index + 1) % this.getSize();
        }

        if (!table[index].equals(null)) {
            isDeleted[index] = true;
            this.setElementNumber(this.getElementNumber() - 1);
        }
        return table[index];
    }

    public Node search(int key) {
        int index = function(key);

        while ((!table[index].equals(null) && table[index].getData() != key)
                || (!table[index].equals(null) && table[index].getData() == key && isDeleted[index])) {
            index = (index + 1) % 7;
        }

        return table[index];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getElementNumber() {
        return elementNumber;
    }

    public void setElementNumber(int elementNumber) {
        this.elementNumber = elementNumber;
    }
}