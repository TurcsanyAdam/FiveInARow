package com.fiveinarow;

import java.util.Scanner;

public class Game {
    private int[][] board = new int[][]{
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}
    };
    private int currentPlayer = 1;
    private int howMany = 3;

    public Game(){
        play();
    }

    public int[] getMove(){
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;

        System.out.print("Enter a row: ");
        row = scanner.nextInt();

        while(row > board.length || row < 0){
            System.out.print("Enter a row: ");
            row = scanner.nextInt();
        }

        System.out.print("Enter a column: ");
        column = scanner.nextInt();

        while(column > board[0].length || column < 0){
            System.out.print("Enter a column: ");
            column = scanner.nextInt();
        }
        int [] move = new int []{row-1,column-1};

        return move;
    }

    public void mark(int[] move, int currentPlayer){
        if(board[move[0]][move[1]] == 0){
            board[move[0]][move[1]] = currentPlayer;
        }
    }
    public boolean hasWon(int howMany, int currentPlayer){
        int counter = 0;
        for(int i = 0; i < board.length;i++){
            for(int x = 0; x < board[0].length;x++){
                if(board[i][x] == currentPlayer){
                    counter++;
                }
                else{
                    counter = 0;
                }
                if(counter == howMany){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isTie(){
        for(int i = 0; i < board.length;i++){
            for(int x = 0; x < board[0].length;x++){
                if(board[i][x] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void play(){
        while(true){
            printBoard();
            mark(getMove(),currentPlayer);
            if(hasWon(howMany,currentPlayer)){
                printResult(currentPlayer);
                break;
            }
            if(isTie()){
                printResult(0);
            }
            if(currentPlayer == 1){
                currentPlayer = 2;
            }
            else {
                currentPlayer = 1;
            }
        }
    }
    public void printBoard(){
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.printf("%5d ", board[i][j]);
            }
            System.out.println();
        }
    }
    public void printResult(int currentPlayer){
        if(currentPlayer == 0){
            System.out.println("Its a tie");

        }
        else{
            System.out.println("Player " + currentPlayer + "wins");
        }
    }
}
