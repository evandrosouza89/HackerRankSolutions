package com.hackerrank.evandro.algorithms.graphtheory;

import java.util.Scanner;

/*A solution to https://www.hackerrank.com/challenges/journey-to-the-moon/problem challenge*/
public class JourneyToTheMoon {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int i = scan.nextInt();

        int astronautCountry[] = new int[n];
        int countriesCount[] = new int[n];

        for (int j = 0; j < astronautCountry.length; j++) {
            astronautCountry[j] = -1;
        }

        for (int j = 0; j < i; j++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (a > b) {
                int aux = a;
                a = b;
                b = aux;
            }

            if (astronautCountry[a] == -1 && astronautCountry[b] == -1) {
                countriesCount[a] += 2;
                astronautCountry[a] = a;
                astronautCountry[b] = a;
            } else if (astronautCountry[a] > -1 && astronautCountry[b] == -1) {
                countriesCount[astronautCountry[a]]++;
                astronautCountry[b] = astronautCountry[a];
            } else if (astronautCountry[a] == -1 && astronautCountry[b] > -1) {
                countriesCount[astronautCountry[b]]++;
                astronautCountry[a] = astronautCountry[b];
            } else {
                if (astronautCountry[a] < astronautCountry[b]) {
                    countriesCount[astronautCountry[a]] += countriesCount[astronautCountry[b]];
                    countriesCount[astronautCountry[b]] = 0;
                    int aux = astronautCountry[b];
                    for (int u = 0; u < astronautCountry.length; u++) {
                        if (astronautCountry[u] == aux) {
                            astronautCountry[u] = astronautCountry[a];
                        }
                    }
                } else if (astronautCountry[b] < astronautCountry[a]) {
                    countriesCount[astronautCountry[b]] += countriesCount[astronautCountry[a]];
                    countriesCount[astronautCountry[a]] = 0;
                    int aux = astronautCountry[a];
                    for (int u = 0; u < astronautCountry.length; u++) {
                        if (astronautCountry[u] == aux) {
                            astronautCountry[u] = astronautCountry[b];
                        }
                    }
                }
            }
        }

        scan.close();

        long sameCountryCombinations = 0;
        for (int j = 0; j < countriesCount.length; j++) {
            if (countriesCount[j] > 0) {
                sameCountryCombinations = sameCountryCombinations + combinations(countriesCount[j]);
            }
        }

        System.out.println(combinations(n) - sameCountryCombinations);
    }

    public static long combinations(int n) {
        long r = 1;
        long d;
        for (d = 1; d <= 2; d++) {
            r *= n--;
            r /= d;
        }
        return r;
    }
}
