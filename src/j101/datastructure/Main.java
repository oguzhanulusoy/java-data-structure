package j101.datastructure;
import j101.datastructure.run.BstRun;
import j101.datastructure.run.LinkedListRun;
import j101.datastructure.run.StackRun;

import java.awt.*;
import java.util.Scanner;

/**
 * Main for all data structure
 */
public class Main {

    enum MenuOptions {
        LINKEDLIST,
        STACK,
        BST,
        QUEUE,
        HASH,
        BREAK
    }

    public static void displayMenu()  {

        StringBuilder MENU = new StringBuilder("\n\nMenu options: \n\t");
        MENU.append(MenuOptions.LINKEDLIST + "\n\t");
        MENU.append(MenuOptions.STACK + "\n\t");
        MENU.append(MenuOptions.BST + "\n\t");
        MENU.append(MenuOptions.QUEUE + "\n\t");
        MENU.append(MenuOptions.HASH + "\n\t");
        MENU.append(MenuOptions.BREAK + "\n");
        MENU.append("Type an option: ");
        System.out.println(MENU);
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        displayMenu();
        String choice = input.next();

        while (true) {
            if (choice.equals(MenuOptions.LINKEDLIST.toString())) {
                LinkedListRun.main(args);
            }

            if (choice.equals(MenuOptions.STACK.toString())) {
                StackRun.main(args);
            }

            if (choice.equals(MenuOptions.BST.toString())) {
                BstRun.main(args);
            }

            if (choice.equals(MenuOptions.QUEUE.toString())) {
                //QueueRun.main(args);
            }

            if (choice.equals(MenuOptions.HASH.toString())) {
                //HashRun.main(args);
            }

            if (choice.equals(MenuOptions.BREAK.toString())) {
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }

            displayMenu();
            choice = input.next();
        }

    }
}
