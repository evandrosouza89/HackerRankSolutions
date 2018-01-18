package com.hackerrank.evandro.algorithms.greedy;

import java.util.Scanner;

/*A solution to https://www.hackerrank.com/challenges/pylons/problem challenge*/
public class GoodlandElectricity {

    private static int pylons(int k, int[] arr) {
        int pylons = 0;
        k--;
        int i = k;
        int last = i;

        while (i < arr.length) {
            if (arr[i] == 1) {
                pylons++;
                last = i;
                i += 2 * k + 1;
            } else {
                i--;
                if (i < 0 || i == last) {
                    return -1;
                }
            }
        }

        if (arr.length - last - 1 > k) {
            i = arr.length - 1;
            while (arr[i] == 0) {
                i--;
            }
            if (i <= last) {
                return -1;
            } else {
                pylons++;
            }
        }

        return pylons;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int result = pylons(k, arr);
        System.out.println(result);
        in.close();
    }
}