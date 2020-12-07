package Models;

import java.util.Scanner;

public class ConsoleInput {

    public String readConsoleInput(Field[][] fields) {

        boolean check = false;
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (!check) {
            System.out.println("f - put or take off a flag, o - open a cell + coordinates e.g. f15, t48, o75");

            input = scan.next();
            check = checkConsoleInput(fields, input);
        }

        return input;
    }

    public boolean checkConsoleInput(Field[][] fields, String input) {
        if (input.length() == 3 && (input.charAt(0) == 'f' || input.charAt(0) == 'o')
                && parseInt(input.substring(1, 2)) != -1
                && parseInt(input.substring(1, 2)) < fields.length
                && parseInt(input.substring(2)) != -1
                && parseInt(input.substring(2)) < fields[0].length) {
            return true;
        } else {
            System.out.println("Wrong input.");
            return false;
        }
    }

    private int parseInt(String numberText) {
        try {
            return Integer.parseInt(numberText);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}
