package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CWSNumberDivider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <Integer> marksList= new ArrayList<Integer>();
        System.out.print("Enter the number to divide: ");
        int number = scanner.nextInt();
        System.out.print("Enter the number of parts: ");
        int numOfParts = scanner.nextInt();

        int[] thresholds = new int[numOfParts];
        int totalThreshold = 0;
        for (int i = 0; i < numOfParts; i++) {
            System.out.print("Enter the threshold for part " + (i + 1) + ": ");
            thresholds[i] = scanner.nextInt();
            totalThreshold += thresholds[i];
        }

        if (number <= 0 || totalThreshold <= 0) {
            System.out.println("Number and total threshold must be positive integers.");
            return;
        }

        if (totalThreshold < number) {
            System.out.println("Total threshold is too low to divide the number into the specified number of parts.");
            return;
        }

        int[] parts = new int[numOfParts];
        int remainingNumber = number;
        for (int i = 0; i < numOfParts - 1; i++) {
            parts[i] = Math.min(remainingNumber / (numOfParts - i), thresholds[i]);
            remainingNumber -= parts[i];
        }
        parts[numOfParts - 1] = remainingNumber;

        System.out.println("The number " + number + " is divided into " + numOfParts + " parts:");
        for (int i = 0; i < numOfParts; i++) {
            System.out.println("Part " + (i + 1) + ": " + parts[i]);
        }
    }
}

