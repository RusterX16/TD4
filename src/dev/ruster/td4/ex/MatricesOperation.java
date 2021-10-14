package dev.ruster.td4.ex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public record MatricesOperation(Scanner scan) {

    public MatricesOperation(@NotNull final Scanner scan) {
        this.scan = scan;

        int[][] matrix = add(
                new int[][]{{1, 4, 9}, {2, -7, 13}, {54, -34, 0}},
                new int[][]{{3, 4, 86}, {-43, -11, 0}, {23, 23, 34}});
        System.out.println("Add : " + Arrays.deepToString(matrix));
        System.out.println("Sum : " + sum(new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 3}
        }));
        System.out.println(nullRow(new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        }));
        System.out.println(containsMultipleNullElements(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {1, 1, 0}
        }));
        System.out.println(Arrays.deepToString(multiply(
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6}},
                new int[][]{
                        {7, 8},
                        {9, 10},
                        {11, 12}}
        )));

        System.out.println();
    }

    @Contract(pure = true)
    public int[][] add(int @NotNull [][] matrix_1, int @NotNull [][] matrix_2) {
        for(int i = 0; i < matrix_1.length; i++) {
            for(int j = 0; j < matrix_1[i].length; j++) {
                matrix_1[i][j] += matrix_2[i][j];
            }
        }
        return matrix_1;
    }

    @Contract(pure = true)
    public int sum(int @NotNull [][] matrix) {
        int sum = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i == j || matrix.length - i - 1 == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    @Contract(pure = true)
    public int getNullElementsCount(int @NotNull [][] matrix) {
        int count = 0;

        for(int[] col : matrix) {
            for(int value : col) {
                if(value == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean containsNullElement(int @NotNull [][] matrix) {
        boolean contains = false;

        for(int[] col : matrix) {
            for(int value : col) {
                if(value == 0) {
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }

    public int nullRow(int @NotNull [][] matrix) {
        int nullRow = 0;

        for(int i = 0; i < matrix.length; i++) {
            int counter = 0;

            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    counter++;
                }
            }
            if(counter > nullRow) {
                nullRow = (i + 1);
            }
        }
        return nullRow;
    }

    public boolean containsMultipleNullElements(int @NotNull [][] matrix) {
        boolean containsMultipleNullElements = false;

        for(int[] col : matrix) {
            int count = 0;

            for(int value : col) {
                if(value == 0) {
                    count++;

                    if(count > 1) {
                        containsMultipleNullElements = true;
                    }
                }
            }
        }
        return containsMultipleNullElements;
    }

    @Contract(pure = true)
    public int @NotNull [][] multiply(int @NotNull [][] matrix_1, int @NotNull [][] matrix_2) {
        int[][] matrix = new int[0][];

        for(int i = 0; i < Math.max(matrix_1.length, matrix_2.length); i++) {
            matrix = new int
                    [Math.max(matrix_1.length, matrix_2.length)]
                    [Math.max(matrix_1[i].length, matrix_2[i].length)];
        }

        for(int[] row : matrix) {
            Arrays.fill(row, 0);
        }

        /*
        matrix[0][0] = matrix_1[0][0] * matrix_2[0][0]
                     + matrix_1[0][1] * matrix_2[1][0]
                     + matrix_1[0][2] * matrix_2[2][0];

        matrix[0][1] = matrix_1[0][0] * matrix_2[0][1]
                     + matrix_1[0][1] * matrix_2[1][1]
                     + matrix_1[0][2] * matrix_2[2][1];

        matrix[1][0] = matrix_1[1][0] * matrix_2[0][0]
                     + matrix_1[1][1] * matrix_2[1][0]
                     + matrix_1[1][2] * matrix_2[2][0];

        matrix[1][1] = matrix_1[1][0] * matrix_2[0][1]
                     + matrix_1[1][1] * matrix_2[1][1]
                     + matrix_1[1][2] * matrix_2[2][1];
        */

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += matrix_1[i][j] * matrix_2[j][i];
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix_1[i][j] * matrix_2[j][i];
            }
        }

        for(int i = 0; i < matrix_1.length; i++) {
            for(int j = 0; j < matrix_2.length; j++) {
                matrix[i][j] = matrix_1[i][j] * matrix_2[j][i];
            }
        }
        return matrix;
    }
}