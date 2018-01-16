package com.hackerrank.evandro.algorithms.implementation;

import java.util.Scanner;

/*A solution to https://www.hackerrank.com/challenges/encryption/problem challenge*/
public class Encryption {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int r = (int) Math.floor(Math.pow(input.length(), 0.5));

        int c = (int) Math.ceil(Math.pow(input.length(), 0.5));

        while (r * c < input.length()) {
            r++;
        }

        for (int i = 0; i < c; i++) {
            int k = i;
            for (int j = 0; j < r; j++) {
                if (k < input.length()) {
                    System.out.print(input.charAt(k));
                    k += c;
                }
            }
            System.out.print(" ");
        }
    }
}