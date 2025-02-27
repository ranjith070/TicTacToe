package com.copy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		char[][] board = new char[3][3];
		for(int row =0;row<board.length;row++) {
			for(int col =0; col<board.length;col++) {
				board[row][col]=' ';
				
			}
		}
		char player = 'X';
		boolean Winner = false;
		Scanner scanner = new Scanner(System.in);
		while(!Winner) {
			showBoard(board);
			System.out.println("ENTER ROW AND COL VALUES BETWEEN O - 2");
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			if(board[row][col]==' ' && (row >=0 && row<3) && (col >=0 && col<3)) {
				board[row][col]=player;
				Winner = checkWinner(board,player);
				if(Winner) {
					System.out.println("PLAYER "+player+" HAS WON THE GAME");
				}
				else {
					if (player=='X') {
						player = 'O';
					}
					else {
						player ='X';
					}
				}
			}else {
				System.out.println("INVALID NUMBER PLEASE ENTER BETWEEN 0 - 2");
			}
		}showBoard(board);
	}
	public static void showBoard(char[][] board) {
		for(int row =0;row<board.length;row++) {
			for(int col =0; col<board.length;col++) {
				
				System.out.print(board[row][col] +" |");
			}System.out.println();
		}
	}
	public static boolean checkWinner(char[][] board,char player) {
		for(int row =0;row<board.length;row++) {
			if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
				System.out.println("rows of the player "+ player +" has won");
				return true;
			}
		}
		for(int col =0;col<board.length;col++) {
			if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
				System.out.println("col of the player "+ player +" has won");
				return true;
				
			}
		}
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
			return true;
		}
		if(board[0][2]==player && board[1][1]==player && board[2][0]==player) {
			return true;
		}
		return false;
	}

}
