package tictactoegame;

import java.util.Scanner;

public class TicTacToe {
	
	//Prints the board:
	public static void printBoard(char[][] board) {
	//
		
		System.out.printf("%4d%5d%5d%n", 1,2,3);
		for (int i = 0; i < board.length; i++) { //row
			System.out.print(i+1);
			for (int j = 0; j < board.length; j++) { //column
				System.out.print(" " + board[i][j] + " ");
				if (j < board[i].length - 1)
					System.out.print(" | ");
			}
			if (i < board.length - 1) 
				System.out.printf("%n ----+-----+----%n");
		}
		
		System.out.println("");
		
	//	
	}
	
	
	//Gets player input:
	public static int[] getInput(int[] currentPlayer, char[] currentChar, int playerTurn, Scanner sc) {
	//
		int row, column;
		
		while (1 != 0) {
			System.out.println(" ");
			System.out.print("Player: " + currentPlayer[playerTurn] + " (" + currentChar[playerTurn] + ")" + " enter row (1-3): ");
			row = sc.nextInt() - 1;
			System.out.print("Player: " + currentPlayer[playerTurn] +  " (" + currentChar[playerTurn] + ")" + " enter column (1-3): ");
			column = sc.nextInt() - 1;
			
			if ((row >= 0 && row < 3)  && (column >= 0 && column < 3)) {
				break;
			} else {	
				System.out.printf("%nThats not on the board... Both inputs must be 1,2 or 3! Try again.%n");
			}
		}
		
		
		return new int[] {row, column};
		
	//
	}
	
	
	
	//Check if a won is found:
	
	public static boolean checkWin(char[][] board, char playerChar) {
	//
		
		//rows
		for (int i = 0;  i < 3; i++) {
			
			//check rows:
			if (board[i][0] == playerChar && board[i][1] == playerChar && board[i][2] == playerChar)
				return true;
			
			//check columns:
			if (board[0][i] == playerChar && board[1][i] == playerChar && board[2][i] == playerChar)
				return true;
		}
		
		
			//top left to bottom right diagonal:
			if (board[0][0] == playerChar && board[1][1] == playerChar && board[2][2] == playerChar)
				return true;
			
			//top right to bottom left diagonal:
			if (board[0][2] == playerChar && board[1][1] == playerChar && board[2][0] == playerChar)
				return true;
			
			return false;
		
	//
	}
	
	//Check if the board is full, a tie is reached:
	public static boolean boardFull(char[][] board) {
	//	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				if (board[i][j] == ' ')
					return false;
			}
			
			
		}
		
		return true;	
	//	
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[][] board = {
				{' ',' ',' '},
				{' ',' ',' '},
				{' ',' ',' '}
		};
		
		boolean gameOver = false;
		int[] currentPlayer = {1,2};
		char[] currentChar = {'X','O'};
		int playerTurn = 0; //0 or 1 for player 1 and player 2 respectively.
		
		while (!gameOver) {
			
			printBoard(board);
			
			
			//Get the users input.
			
			int[] move = getInput(currentPlayer, currentChar, playerTurn, sc);
			
			
			int row = move[0];
			int column = move[1];
			
			
			//Validate: The square is not taken already
			
			if (board[row][column] != ' ')
			{
				
				System.out.printf("%nThat spot's already spoken for... Pick another. %n%n");
				continue;
			}
				
			
			//Place the letter in decided spot.
			
			board[row][column] = currentChar[playerTurn];
			
			
			// Check for a win.
			if ( checkWin(board, currentChar[playerTurn]) ) {
				printBoard(board);
				System.out.print("Player: " + currentPlayer[playerTurn] + " wins!");
				gameOver = true;
			}
			
			// Check for a draw.
			if (boardFull(board))
			{	System.out.printf("%nHow disappointing... It's a draw.%n%n");
				printBoard(board);
				gameOver = true;
			}
			
			//change turns
			
			playerTurn = 1 - playerTurn;
			
			
			
			
		}
		
		
		sc.close();
		
		
		
		

	}
	

}
