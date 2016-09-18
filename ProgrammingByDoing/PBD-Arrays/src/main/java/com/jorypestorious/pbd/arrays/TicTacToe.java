package com.jorypestorious.pbd.arrays;

import java.util.Scanner;

public class TicTacToe {
    
    private static char[][] board = new char[3][3];
    private static int row;
    private static int column;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        initBoard();
        displayBoard();
        
        int turnCount = 0;
        char whosTurn = 'X';
        boolean winner = false;
        
        while (!winner) {
            turnCount++;
            whosTurn = (turnCount % 2 == 0) ? 'O' : 'X';
            
            getInput(whosTurn);
            
            displayBoard();
            
            winner = checkForWin(whosTurn, row, column); 
            if (turnCount == 9) winner = true;
        }
        
        if (checkForWin(whosTurn, row, column)) {
            System.out.println("'" + whosTurn + "' is the winner!");
        } else {
            System.out.println("The game is a tie.");
        }

    }
    
    public static void initBoard() {
        // fills up the board with blanks
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }
    
    public static void displayBoard() {
        System.out.println(""); 
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
        System.out.println(""); 
    }
    
//    public static void displayBoard2() {
//        System.out.println(""); 
//        for (int r = 0; r < 3; r++) {
//            System.out.print("\t" + r + " ");
//            for (int c = 0; c < 3; c++) {
//                System.out.print(board[r][c] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("\t  0 1 2 ");
//        System.out.println(""); 
//    }
    
    public static void getInput(char whosTurn) {
        Scanner scan = new Scanner(System.in);
        boolean correctInput = false;
        
        do {            
            System.out.print("'" + whosTurn + "', choose your location (row column): ");
            row = scan.nextInt();
            column = scan.nextInt();
            
            if (board[row][column] == ' ') {
                board[row][column] = whosTurn;
                correctInput = true;
            } else {
                System.out.println("\nThat position is taken.\n");
            }
        } while (!correctInput);
    }
    
//    inefficient
//    public static boolean checkForWin(char charToCheck) {
//        int countHorz = 0;
//        int countVert = 0;
//        int countDia1 = 0;
//        int countDia2 = 0;
//        
//        for (int i = 0; i < board.length; i++) {
//            
//            if (board[i][i] == ' ') {
//                continue;
//            } else {
//                for (int j = 0; j < board[i].length; j++) {
//                    if (board[i][j] == charToCheck) countHorz++;
//                }
//                
//                for (int j = 0; j < board[i].length; j++) {
//                    if (board[j][i] == charToCheck) countVert++;
//                }
//                
//                if (board[i][i] == charToCheck) countDia1++;
//                
//                if (board[2-i][i] == charToCheck) countDia2++;
//                
//                if (countHorz == 3 || countVert == 3 || countDia1 == 3 || countDia2 == 3) {
//                    return true;
//                } else {
//                    countHorz = 0;
//                    countVert = 0;
//                }
//            }
//            
//        }
//        
//        return false;
//    }
    
    public static boolean checkForWin(char charToCheck, int row, int column) {
        
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != charToCheck) break;
            if (i == board.length-1) return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != charToCheck) break;
            if (i == board.length-1) return true;
        }
        
        if (row == column) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != charToCheck) break;
                if (i == board.length-1) return true;
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length-1-i] != charToCheck) break;
            if (i == board.length-1) return true;
        }
        
        return false;
    }
    
}
