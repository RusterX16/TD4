package dev.ruster.td4.ex;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public record MagicSquare(Scanner scan) {

    public MagicSquare(Scanner scan) {
        this.scan = scan;

        for(int[] row : magicSquare()) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    /*
    public int @NotNull [][] magicSquare() {
        int n;

        do {
            System.out.print("Dimensions : ");
            n = scan.nextInt();
        } while(n % 2 == 0);

        int[][] array = new int[n][n];
        int last = array.length - 1;
        int row = 0;
        int col = last / 2;
        int z = 1;

        Arrays.stream(array).forEach(it -> Arrays.fill(it, 0));
        System.out.println(Arrays.deepToString(array));
        array[row][col] = z;

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.println("z = " + z);
                if(i == 0 && j == 0) {
                    z++;
                    array[array.length - 1][array[i].length - 1] = z;
                    continue;
                }
                if(array[j][i] == 0) {
                    z++;
                    array[j][i] = z;
                }
            }
        }

        return array;
    }
    */

    public int @NotNull [][] magicSquare() {
        int n;

        do {
            System.out.print("Saisir n : ");
            n = scan.nextInt();
        } while(n < 0 || n % 2 == 0);

        int[][] matrix = new int[n][n];
        int last = matrix.length - 1;
        int col = last / 2;
        int row = 0;
        int z = 1;

        Arrays.stream(matrix).forEach(it -> Arrays.fill(it, 0));
        matrix[row][col] = z;

        while(z < Math.pow(matrix.length, 2)) {
            row = row <= 0 ? last : row - 1;
            col = col >= last ? 0 : col + 1;

            if(matrix[row][col] != 0) {
                for(int i = 0; i < 2; i++) {
                    row = row >= last ? 0 : row + 1;
                }
                col = col <= 0 ? last : col - 1;
            }
            z++;
            matrix[row][col] = z;
        }

        return matrix;
    }
}