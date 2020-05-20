package j101.datastructure.run;

import j101.datastructure.stack.Node;
import j101.datastructure.stack.Stack;

import java.util.Random;
import java.util.Scanner;

/**
 * StackRun
 */
public class StackRun {

    // TODO: Call all Stack methods in StackRun class

    public static final int SIZE = 10;

    public static StringBuilder MENU;

    enum StackOptions {
        C0NSTRUCT,
        POP,
        PUSH,
        IS_EMPTY,
        IS_FULL,
        TOP,
        BREAK
    }

    public static void stackMenu() {

        MENU = new StringBuilder("\n\nStack options: \n\t");
        MENU.append(StackOptions.C0NSTRUCT + "\n\t");
        MENU.append(StackOptions.POP + "\n\t");
        MENU.append(StackOptions.PUSH + "\n\t");
        MENU.append(StackOptions.IS_EMPTY + "\n\t");
        MENU.append(StackOptions.IS_FULL + "\n\t");
        MENU.append(StackOptions.TOP + "\n\t");
        MENU.append(StackOptions.BREAK + "\n");
        MENU.append("Type an option: ");
        System.out.println(MENU);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        stackMenu();
        String choice = input.next();

        while (true) {
            if (choice.equals(StackOptions.C0NSTRUCT.toString())) {
                System.out.println("Constructor() is calling...");
                Stack stack = new Stack(SIZE);
                Node node;
                for (int i = 0; i < SIZE; i++) {
                    stack.push(node = new Node(random.nextInt()));
                }
                stack.display();
            }
        }
    }
}
