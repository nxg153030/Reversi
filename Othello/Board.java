// class Board gets the boardSize from class Othello,
// creates the board and prints it using its methods createBoard()
// and printBoard()

package Othello;

public class Board {
	
		// createBoard creates an N*N othello board, N being an even number
		// It places two 'B' tiles and two 'W' tiles at the center of the board
		public char[][] createBoard(int row){	
			Othello.board = new char[row][row];
			for(int i = 0; i < row; i++){
				for(int k = 0; k < row; k++){
					Othello.board[i][k] = '_';
				}
			}
			Othello.board[(row/2)-1][(row/2)-1] = 'W';
			Othello.board[(row/2)-1][(row/2)] = 'B';
			Othello.board[(row/2)][(row/2)-1] = 'B';
			Othello.board[(row/2)][(row/2)] = 'W';
			return Othello.board;	
		}
			
		// printBoard prints out the elements of the 2D char array passed as a parameter.
		public void printBoard(char [][] board){
			for(int i = 0; i < board.length; i++){
				for(int k = 0; k < board.length; k++){
					System.out.print(board[i][k]+" ");
				}
				System.out.println();
			}
		}
}


