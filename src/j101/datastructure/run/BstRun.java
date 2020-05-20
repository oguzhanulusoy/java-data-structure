package j101.datastructure.run;

import j101.datastructure.bst.BinarySearchTree;

import java.util.Random;
import java.util.Scanner;

/**
 * BstRun
 *
 * @author oppenheimer
 */
public class BstRun {

    // TODO: Call all Bst methods in BstRun class

    public static final int LENGTH = 10,
            IN_RANGE_SIZE = 10;

    public static StringBuilder MENU;

    enum BstOptions {
        SAMPLE,
        PRE_ORDER_TRAVERSAL,
        LEAF_COUNT,
        SINGLE_NODE_COUNT,
        DOUBLE_NODE_COUNT,
        SUM_LEAFS,
        FIND_MINIMUM,
        SEARCH,
        BREAK
    }

    public static void bstMenu() {

        MENU = new StringBuilder("\n\nBst options: \n\t");
        MENU.append(BstOptions.PRE_ORDER_TRAVERSAL + "\n\t");
        MENU.append(BstOptions.LEAF_COUNT + "\n\t");
        MENU.append(BstOptions.SINGLE_NODE_COUNT + "\n\t");
        MENU.append(BstOptions.DOUBLE_NODE_COUNT + "\n\t");
        MENU.append(BstOptions.SUM_LEAFS + "\n\t");
        MENU.append(BstOptions.FIND_MINIMUM + "\n\t");
        MENU.append(BstOptions.SEARCH + "\n\t");
        MENU.append(BstOptions.BREAK + "\n");
        MENU.append("Type an option: ");
        System.out.println(MENU);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int data = random.nextInt(IN_RANGE_SIZE);
        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < LENGTH; i++) {
            tree.insert(random.nextInt(IN_RANGE_SIZE));
        }
        System.out.println("Binary Search Tree is generated with " + LENGTH + " size.");

        bstMenu();
        String choice = input.next();

        while (true) {
            if (choice.equals(BstOptions.PRE_ORDER_TRAVERSAL.toString())) {
                tree.preorderTraversal();
            }

            if (choice.equals(BstOptions.LEAF_COUNT.toString())) {
                System.out.println(String.format("Leaf count={}", tree.leafCount(tree.getRoot())));
            }

            if (choice.equals(BstOptions.SINGLE_NODE_COUNT.toString())) {
                System.out.println(String.format("Single node count={}", tree.singleNodeCount(tree.getRoot())));
            }

            if (choice.equals(BstOptions.DOUBLE_NODE_COUNT.toString())) {
                System.out.println(String.format("Double node count={}", tree.doubleNodeCount(tree.getRoot())));
            }

            if (choice.equals(BstOptions.SUM_LEAFS.toString())) {
                System.out.println(String.format("Sum leafs={}", tree.sumLeafsRecursively()));
            }

            if (choice.equals(BstOptions.FIND_MINIMUM.toString())) {
                System.out.println(String.format("Minimum={}", tree.findMinimum()));
            }

            if (choice.equals(BstOptions.SEARCH.toString())) {
                int searchValue = random.nextInt(IN_RANGE_SIZE);
                System.out.println(String.format("Searching value={}", searchValue));
                if (tree.search(searchValue).equals(null)) {
                    System.out.println(String.format("{} not found!", searchValue));
                } else {
                    System.out.println(String.format("{} found!", searchValue));
                }
            }

            if (choice.equals(BstOptions.BREAK.toString())) {
                System.out.println("Breaking...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
