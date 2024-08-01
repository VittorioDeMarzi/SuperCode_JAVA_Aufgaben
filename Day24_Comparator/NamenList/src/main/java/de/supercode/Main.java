package de.supercode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();

        System.out.println("ADD NAMES TO THE LIST");
        System.out.println("Enter END: quit the application");
        System.out.println("Enter LIST: print out the list of names");
        System.out.println("================================================");
        System.out.println("Enter a name you want to add to the list: ");

        while(true) {
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                for (Character c : name.toCharArray()) {
                    if (!Character.isLetter(c)) {
                        System.out.println("Input is not a name");
                        break;
                    }
                }
                if ("END".equals(name)) {
                    System.out.println("Application will terminate");
                    printList(nameList);
                    break;
                }
                if ("LIST".equals(name)) {
                    printList(nameList);
                    continue;
                }
                if (nameList.contains(name)) {
                    System.out.println();
                    System.out.println("****Name is already in the List. Enter another name****");
                    continue;
                }

                nameList.add(name);
            }
        }
        scanner.close();
    }

    private static void printList(ArrayList<String> nameList) {
        System.out.println("================================================");
        if (nameList.isEmpty()) System.out.println("No names listed in the list yet. Add something first!");
        else {
            System.out.println("List of Names:");
            for (String name : nameList) {
                System.out.println(name);
            }
            System.out.println("================================================");
        }
    }
}