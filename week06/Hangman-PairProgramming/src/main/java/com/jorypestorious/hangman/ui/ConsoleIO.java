package com.jorypestorious.hangman.ui;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleIO {

    private final Scanner scan = new Scanner(System.in);
    private final DecimalFormat df = new DecimalFormat("0.00");

    //////////////////// Input //////////////////////    
    public String promptString(String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine();
        input = toTitleCase(input);
        return input;
    }

    public int promptInt(String prompt, int min, int max) {
        String errorMsg = "Enter a number between " + min + " and " + max + ": ";
        int input;
        System.out.print(prompt);

        do {
            while (!scan.hasNextInt()) {
                System.out.print(errorMsg);
                scan.next();
            }

            input = scan.nextInt();

            if (input > max || input < min) {
                System.out.print(errorMsg);
            }

        } while (input > max || input < min);

        clearBuffer();
        return input;
    }

    public double promptDouble(String prompt, double min, double max) {
        String errorMsg = "Enter a number between " + df.format(min) + " and " + df.format(max) + ": ";
        double input;
        System.out.print(prompt);

        do {
            while (!scan.hasNextDouble()) {
                System.out.print(errorMsg);
                scan.next();
            }

            input = scan.nextDouble();

            if (input > max || input < min) {
                System.out.print(errorMsg);
            }

        } while (input > max || input < min);

        clearBuffer();
        return input;
    }

    public LocalDate promptDate(String p) {
        System.out.print(p);
        String dateString;
        LocalDate date = null;

        while (date == null) {
            try {
                dateString = scan.nextLine();
                date = LocalDate.parse(dateString);
            } catch (DateTimeParseException e) {
                System.out.print("Date must be in format yyyy-mm-dd.\n"
                        + "Please re-enter: ");
            }
        }

        return date;
    }

    public LocalDate promptDate(String p, LocalDate min, LocalDate max) {
        LocalDate in = promptDate(p);

        while (in.compareTo(min) < 0 || in.compareTo(max) > 0) {
            System.out.print("Date must be between " + min.toString()
                    + " and " + max.toString() + ".\n"
                    + "Please re-enter: ");
            in = promptDate("");
        }

        return in;
    }

    private void clearBuffer() {
        scan.nextLine();
    }

    private String toTitleCase(String str) {
        str = str.toLowerCase().trim();
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();

            if (arr[i].length() > 0) {
                sb.append(Character.toUpperCase(arr[i].charAt(0)))
                        .append(arr[i].substring(1)).append(" ");
            }
        }

        return sb.toString().trim();
    }

    //////////////////// Output ////////////////////// 
    public void display(String str) {
        System.out.println(str);
    }

    public void displayNoNewLine(String str) {
        System.out.print(str);
    }

}
