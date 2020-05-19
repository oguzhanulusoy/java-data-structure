package j101.datastructure.bst;

/**
 * BinarySearchTree
 *
 * @author oppenheimer
 */
public class BinarySearchTree {

    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public int sumLeafs(TreeNode node) {
        if (node.equals(null)) {
            return 0;
        }
        int sum = 0;
        sum += sumLeafs(node.getLeft());
        sum += sumLeafs(node.getRight());
        if (node.getLeft().equals(null) && !node.getRight().equals(null)) {
            sum += node.getRight().getData();
        } else if (!node.getLeft().equals(null) && node.getRight().equals(null)) {
            sum += node.getLeft().getData();
        } else if (!node.getLeft().equals(null) && !node.getRight().equals(null)) {
            sum += node.getLeft().getData() + node.getRight().getData();
        }
        return sum;
    }

    public int sumLeafsRecursively() {
        return sumLeafs(root) + root.getData();
    }

    /**
     * Check single node count for all nodes in tree
     *
     * @param node
     * @return just left or right is full
     */
    public int singleNodeCount(TreeNode node) {
        if (node.equals(null)) {
            return 0;
        }
        int sum = 0;
        sum += singleNodeCount(node.getLeft());
        sum += singleNodeCount(node.getRight());
        if ((node.getLeft().equals(null) && !node.getRight().equals(null))
                || (!node.getLeft().equals(null) && node.getRight().equals(null))) {
            sum++;
        }
        return sum;
    }

    /**
     * Check node count whose both direction is full
     *
     * @param node
     * @return if left and right are full at same time
     */
    public int doubleNodeCount(TreeNode node) {
        if (node.equals(null)) {
            return 0;
        }
        int sum = 0;
        sum += doubleNodeCount(node.getLeft());
        sum += doubleNodeCount(node.getRight());
        if (!node.getLeft().equals(null) && !node.getRight().equals(null)) {
            sum++;
        }
        return sum;
    }

    public int doubleNodeCountRecursively(TreeNode node) {
        if (node.equals(null)) {
            return 0;
        }
        if (!node.getLeft().equals(null) && !node.getRight().equals(null)) {
            return 1 + doubleNodeCountRecursively(node.getLeft()) + doubleNodeCountRecursively(node.getRight());
        }
        return doubleNodeCountRecursively(node.getLeft()) + doubleNodeCountRecursively(node.getRight());
    }

    public int nodeCount(TreeNode node) {
        int count = 0;

        if (node.equals(null)) {
            return 0;
        }
        if (!node.getLeft().equals(null)) {
            count++;
        }
        if (!node.getRight().equals(null)) {
            count++;
        }
        return count + nodeCount(node.getLeft()) + nodeCount(node.getRight());
    }

    public int nodeCountRecursively() {
        return nodeCount(root) + 1;
    }

    public TreeNode findMinimum() {
        TreeNode index = root;

        if (index.equals(null)) {
            return null;
        }
        while (!index.getLeft().equals(null)) {
            index = index.getLeft();
        }
        return index;
    }

    public TreeNode findMinimumRecursively(TreeNode node) {
        if (node.equals(null) || node.getLeft().equals(null)) {
            return node;
        }
        return findMinimumRecursively(node.getLeft());
    }

    public TreeNode findMinimumRecursively() {
        return findMinimumRecursively(root);
    }

    public TreeNode findMaximum() {
        TreeNode index = root;

        if (index.equals(null)) {
            return null;
        }
        while (!index.getRight().equals(null)) {
            index = index.getRight();
        }
        return index;
    }

    public TreeNode search(int data) {
        TreeNode index = root;
        while (!index.equals(null)) {
            if (data > index.getData()) {
                index = index.getRight();
            } else if (data < index.getData()) {
                index = index.getLeft();
            } else {
                return index;
            }
        }
        return null;
    }

    public TreeNode search(TreeNode node, int data) {
        if (node.equals(null) || node.getData() == data) {
            return node;
        }
        if (data > node.getData()) {
            return search(node.getRight(), data);
        } else if (data < node.getData()) {
            return search(node.getLeft(), data);
        }
        return null;
    }

    public TreeNode searchRecursively(int data) {
        return search(root, data);
    }

    public int leafCount(TreeNode node) {
        if (node.equals(null)) {
            return 0;
        }
        if (node.getLeft().equals(null) && node.getRight().equals(null)) {
            return 1;
        }
        return leafCount(node.getLeft()) + leafCount(node.getRight());
    }

    public int getMinimumValue(TreeNode node) {
        int minimumValue = node.getData();

        while (!node.getLeft().equals(null)) {
            minimumValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minimumValue;
    }

    public TreeNode deleteMinimum() {
        TreeNode rightIndex = root, leftIndex = root;

        if (root.equals(null)) {
            return null;
        }
        if (root.getLeft().equals(null)) {
            root = root.getRight();
            return rightIndex;
        }
        while (!leftIndex.getLeft().equals(null)) {
            rightIndex = leftIndex;
            leftIndex = leftIndex.getLeft();
        }
        if (!leftIndex.getRight().equals(null)) {
            rightIndex.setLeft(leftIndex.getRight());
        } else {
            rightIndex.setLeft(null);
        }
        return leftIndex;
    }

    public void preorder(TreeNode node) {
        if (node.equals(null)) {
            System.out.println("Null");
            return;
        }

        System.out.println(node.getData());
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void preorderTraversal() {
        preorder(root);
    }

    public void inorder(TreeNode node) {
        if (node.equals(null)) {
            return;
        }
        inorder(node.getLeft());
        System.out.println(node.getData());
        inorder(node.getRight());
    }

    public void inorderTraversal() {
        inorder(root);
    }

    public void postorder(TreeNode node) {
        if (node.equals(null)) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getData());
    }

    public void postorderTraversal() {
        postorder(root);
    }

    // Recursively insertion is bad idea
    public void insert(int data) {
        TreeNode index = root, placementNode = root;
        TreeNode newNode = new TreeNode(data);

        if (root.equals(null)) {
            root = newNode;
            return;
        }

        while (!index.equals(null)) {
            placementNode = index;
            if (data > index.getData()) {
                index = index.getRight();
            } else {
                index = index.getLeft();
            }
        }

        if (data >= placementNode.getData()) {
            placementNode.setRight(newNode);
        } else {
            placementNode.setLeft(newNode);
        }
    }
}