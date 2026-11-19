package Homework7;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 3;

    public static void main(String[] args) {

        int[][] colors = new int[SIZE][SIZE];
        int[][] rotateColor = new int[SIZE][SIZE];

        Random random = new Random();

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        printArray(colors);

        System.out.println(
                "Выберите опцию:\n" +
                        "1. Повернуть матрицу на 90 градусов\n" +
                        "2. Повернуть матрицу на 180 градусов\n" +
                        "3. Повернуть матрицу на 270 градусов\n");

        String input = scan.nextLine();

        rotateColor = rotationArray(colors, Integer.parseInt(input));

        System.out.println();
        printArray(rotateColor);

    }

    public static int[][] rotationArray(int[][] original, int options) {
        int[][] array = new int[SIZE][SIZE];
        switch (options) {
            case 1:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        array[j][i] = original[SIZE - 1 - i][j];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        array[i][SIZE - 1 - j] = original[i][j];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        array[i][j] = original[j][SIZE - 1 - i];
                    }
                }
                break;
            default:
                break;
        }
        return array;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", array[i][j]);
            }
            System.out.println();
        }
    }
}
