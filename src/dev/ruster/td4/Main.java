package dev.ruster.td4;

import dev.ruster.td4.ex.MagicSquare;
import dev.ruster.td4.ex.MatricesOperation;
import dev.ruster.td4.ex.SquareMatricesWithParticularPattern;

import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.print("Choisi un exercice : ");
            int choice = scan.nextInt();

            switch(choice) {
                case 0 -> {
                    System.out.println("Merci ! A bientôt");
                    System.exit(0);
                }
                case 1 -> new MatricesOperation(scan);
                case 2 -> new MagicSquare(scan);
                case 3 -> new SquareMatricesWithParticularPattern(scan);
            }
        }
    }
}