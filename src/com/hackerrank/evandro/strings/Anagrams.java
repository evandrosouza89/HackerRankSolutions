package com.hackerrank.evandro.strings;

import java.util.Scanner;

/*A solution to https://www.hackerrank.com/challenges/java-anagrams/problem challenge*/
public class Anagrams {

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length() || a == null || b == null) {
            return false;
        }

        char[] aToChar = a.toLowerCase().toCharArray();

        char[] bToChar = b.toLowerCase().toCharArray();

        int[] aCharCount = new int[26];
        int[] bCharCount = new int[26];

        for (char c : aToChar) {
            aCharCount[((int) c) - 97]++;
        }

        for (char c : bToChar) {
            bCharCount[((int) c) - 97]++;
        }

        for (int i = 0; i < aCharCount.length; i++) {
            if (aCharCount[i] != bCharCount[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}