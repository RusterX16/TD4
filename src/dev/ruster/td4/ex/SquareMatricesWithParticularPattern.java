package dev.ruster.td4.ex;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public record SquareMatricesWithParticularPattern(Scanner scan) {

    public SquareMatricesWithParticularPattern(@NotNull final Scanner scan) {
        this.scan = scan;

        for(int[] row : diagonal()) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
    }

    public int scanN() {
        int n;

        do {
            System.out.print("Saisir n : ");
            n = scan.nextInt();
        } while(n < 0);

        return n;
    }

    public int @NotNull [][] sorted() {
        int n = scanN();
        int[][] matrix = new int[n][n];
        int count = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                count++;
                matrix[i][j] = count;
            }
        }
        return matrix;
    }

    public int @NotNull [][] coil() {
        int n = scanN();
        int[][] matrix = new int[n][n];
        int count = 0;

        for(int i = 0; i < matrix.length; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < matrix[i].length; j++) {
                    count++;
                    matrix[i][j] = count;
                }
            } else {
                for(int j = matrix[i].length - 1; j >= 0; j--) {
                    count++;
                    matrix[i][j] = count;
                }
            }
        }
        return matrix;
    }

    public int @NotNull[][] diagonal() {
        int n = scanN();
        int[][] matrix = new int[n][n];
        int count = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i == j) {
                    count++;
                    matrix[i][j] = count;
                }
            }
        }

        return matrix;
    }
}