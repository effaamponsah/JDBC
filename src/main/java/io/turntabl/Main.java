package io.turntabl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please enter the name of the search candidate: ");
            String name = scanner.nextLine();
            DB.search(name);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e);
        }

    }
}
