package j101.datastructure;
import j101.datastructure.run.LinkedListRun;

import java.util.Scanner;

/**
 * Main for all data structure
 */
public class Main {

    enum MenuOptions {
        LINKEDLIST,
        BREAK
    }

    public static void displayMenu()  {

        StringBuilder MENU = new StringBuilder("\n\nMenu options: \n\t");
        MENU.append(MenuOptions.LINKEDLIST + "\n\t");
        // Replace here new item
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
