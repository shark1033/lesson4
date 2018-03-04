package com.java.newprject.lesson4.main;

import javafx.css.Size;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean check(char symb) {


        return true;
    }


    public static boolean checkWin1(char symb) {
        int diaganal = 0;
        int diagonal2 = 0;
        int firstRaw = 0;
        int secondRaw = 0;
        int thirdRaw = 0;
        int forthRaw = 0;
        int fifthRaw = 0;
        int firstColumn = 0;
        int secondColumn = 0;
        int thirdColumn = 0;
        int forthColumn = 0;
        int fifthColumn = 0;
        //if(symb==DOT_O) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j && map[i][j] == symb) {
                    diaganal++;
                    //firstRaw++;
                    //firstColumn++;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (SIZE - 1 - i == j && map[i][j] == symb) {
                    diagonal2++;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) { //lines
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb && i == 0) {
                    firstRaw++;
                } else if (map[i][j] == symb && i == 1) {
                    secondRaw++;
                } else if (map[i][j] == symb && i == 2) {
                    thirdRaw++;
                } else if (map[i][j] == symb && i == 3) {
                    forthRaw++;
                } else if (map[i][j] == symb && i == 4) {
                    fifthRaw++;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) { //column not ready
            for (int j = 0; j < SIZE; j++) {
                if (j == 1 && i == 0 && map[i][j] == symb) {
                    firstRaw++;
                    firstColumn++;
                } else if (j == 2 && i == 0 && map[i][j] == symb) {
                    firstRaw++;
                    secondColumn++;

                }
            }
        }

        return true;
    }
}