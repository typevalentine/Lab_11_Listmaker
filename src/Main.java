import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String command = SafeInput.getRegExString(scanner, "Choose a command: ", "[AaDdIiPpQq]");

            switch (command.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?")) {
                        running = false;
                    }
                    break;
            }
        }
        System.out.println("System ending");
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print (i.e. display) the list");
        System.out.println("Q – Quit the program");
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add");
        list.add(item);
        System.out.println("Item added: " + item);
        printList();
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printList();
        int index = SafeInput.getRangedInt(scanner, "Enter the item number to delete", 1, list.size());
        String deletedItem = list.remove(index - 1);
        System.out.println("Item deleted: " + deletedItem);
        printList();
    }

    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding an item at position 1.");
        }
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to insert");
        int position = SafeInput.getRangedInt(scanner, "Enter position to insert at", 1, list.size() + 1);
        list.add(position - 1, item);
        System.out.println("Item inserted: " + item);
        printList();
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("\nCurrent List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}