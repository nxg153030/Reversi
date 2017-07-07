/* 
 * Class Othello contains the method play() where the game is played.
 * play() calls itself recursively each turn until the game ends, that is, as long as there are any valid moves left.
 */
package Othello;
import java.util.Scanner;
import java.util.Random;

public class Othello {
	
	// The required variables for Othello
	// board, sameTile and oppTile are defined as static because 
	// the same instances of the variables are needed through all the classes of the game.
	static char [][] board = null; 
	static char sameTile; // sameTile represents the current player
	static char oppTile; // oppTile represents the opposition player, if black plays, white's the oppTile and vice-versa.
	static boolean playerVsComputer = false;
	static boolean playerVsplayer = false;
	static boolean computerVsComputer = false;
	static boolean playerTurn = false;
	static boolean computerTurn = false;
	OthelloGameState gameState = new OthelloGameState();
	Board gameBoard = new Board();
	
	// Constructor initializes the size of the board
	Othello(int boardSize){	
		Othello.board = gameBoard.createBoard(boardSize);
	}
	
	// As the name of the function suggests, play() runs the game
	// and is played in player vs player, computer vs computer or player vs computer mode.
	public void play(int row, int column, char playerTileColor){
	
	// play only if game is not over
	if(!gameState.gameIsOver()){	
		// valid move check
		if(gameState.isValidMove(row, column, playerTileColor)){
		int counter;
		boolean returnValue = false;
		if(playerTileColor == 'W'){
			sameTile = 'W';
			oppTile = 'B';
		}
		else{
			sameTile = 'B';
			oppTile = 'W';
		}
		
		//Going down
		counter = 1;
		// error trap to make sure it is possible to go down only if the
		// row is less than 2 less than board length
		if(gameState.isWithinBounds(row, column)){
			if(row < (board.length-2)){
				while((gameState.isWithinBounds(row+counter, column)) && (board[row+counter][column] == oppTile)){
					counter++;
				}
			}
		}
		
		if(gameState.isWithinBounds(row+counter, column)){
			if((counter > 1) && (board[row+counter][column] == sameTile)){
				for(int i = row+counter; i >= row; i--){
					gameState.makeMove(i, column, sameTile);
				}
			}
		}
		else if(gameState.isWithinBounds(row+counter, column) && ((counter > 1) && (board[row+counter][column] == '_')))
			returnValue = false;
		else
			returnValue = false;
				
		//Going up
	    //counter keeps count of the tiles to be converted
		counter = 1;
		
		// error trap to make sure it is possible to go up only if the
		// row is greater than 1
		if(gameState.isWithinBounds(row, column)){
			if(row > 1){
				while((gameState.isWithinBounds(row-counter, column)) && (board[row-counter][column] == oppTile)){
					counter++;
				}
			}
		}
		
		if(gameState.isWithinBounds(row-counter, column)){
			if((counter > 1) && (board[row-counter][column] == sameTile)){
				for(int i = (row-counter); i <= row; i++){
					gameState.makeMove(i, column, sameTile);
				}
			}
		}		
		else if(gameState.isWithinBounds(row-counter, column) && ((counter > 1) && (board[row-counter][column] == '_')))
			returnValue = false;
		else
			returnValue = false;
		
		//Going to the left
		counter = 1;
		
		// error trap to make sure it is possible to go left only if the
		// column is greater than 1
		if(gameState.isWithinBounds(row, column)){
			if(column > 1){
				while((gameState.isWithinBounds(row, column-counter)) && (board[row][column-counter] == oppTile)){
					counter++;
				}
			}
		}
		
		if(gameState.isWithinBounds(row, column-counter)){
			if((counter > 1) && (board[row][column-counter] == sameTile)){
				for(int i = column-counter; i <= column; i++)
					gameState.makeMove(row, i, sameTile);
			}
		}		
		else if(gameState.isWithinBounds(row, column-counter) && ((counter > 1) && (board[row][column] == '_')))
			returnValue = false;
		else
			returnValue = false;
			
		//Going to the right
		counter = 1;
		
		// error trap to make sure it is possible to go right if the
		// column is less than 2 less than the board length
		if(gameState.isWithinBounds(row, column)){
			if(column < (board.length -2)){
				while((gameState.isWithinBounds(row, column+counter)) && (board[row][column+counter] == oppTile)){
					counter++;	
				}
			}
		}
		
		if(gameState.isWithinBounds(row, column+counter)){
			if((counter > 1) && (board[row][column+counter] == sameTile)){
				for(int i = (column+counter); i >= column; i--){
					gameState.makeMove(row, i, sameTile);
				}	
			}
		}			
		else if(gameState.isWithinBounds(row, column+counter) && ((counter > 1) && (board[row][column] == '_')))
			returnValue = false;
		else
			returnValue = false;
		
		//Diagonal right up
		counter = 1;
		
		// error trap to make sure it is possible to go diagonally up to the right only if the
		// row is greater than 1 and the column is 2 less than the board length
		if(gameState.isWithinBounds(row, column)){
			if((row > 1) && (column < board.length - 2)){
				while((gameState.isWithinBounds(row-counter, column+counter)) && (board[row-counter][column+counter] == oppTile)){
					counter++;
				}
			}
		}
		
		if(gameState.isWithinBounds(row-counter, column+counter)){
			if((counter > 1) && (board[row-counter][column+counter] == sameTile)){
				for(int i = (column+counter), k = (row-counter); (i >= column && k <= row); i--, k++)
					gameState.makeMove(k, i, sameTile);
			}
		}		
		else if(gameState.isWithinBounds(row-counter, column+counter) && ((counter > 1) && (board[row][column] == '_')))
			returnValue = false;
		else
			returnValue = false;
		
		
		//Diagonal left down
		counter = 1;
		
		// error trap to make sure it is possible to go diagonally down to the left only if the
		// row is less than 2 less than board length and the column is greater than 1
		if(gameState.isWithinBounds(row, column)){
			if((row < board.length-2) && (column > 1)){
				while((gameState.isWithinBounds(row+counter, column-counter)) && (board[row+counter][column-counter] == oppTile)){
						counter++;
				}
			}
		}
		if(gameState.isWithinBounds(row+counter, column-counter)){
			if((counter > 1) && (board[row+counter][column-counter] == sameTile)){
				for(int i = (column-counter), k = (row+counter); (i <= column && k >= row); i++, k--)
					gameState.makeMove(k, i, sameTile);
			}
		}					
		else if(gameState.isWithinBounds(row+counter, column-counter) && ((counter > 1) && (board[row][column] == '_')))
			returnValue = false;
		else
			returnValue = false;
		
		//Diagonal right down
		counter = 1;
		
		// error trap to make sure it is possible to go diagonally down to the right only if the
		// row and column are 2 less than the board length
		if(gameState.isWithinBounds(row, column)){
			if((row < board.length-2) && (column < board.length-2)){
				while((gameState.isWithinBounds(row+counter, column+counter)) && (board[row+counter][column+counter] == oppTile)){
					counter++;
				}
			}
		}
		
		if(gameState.isWithinBounds(row+counter, column+counter)){
			if((counter > 1) && (board[row+counter][column+counter] == sameTile)){
				for(int i = (column+counter), k = (row+counter); (i >= column && k >= row); i--, k--)
					gameState.makeMove(k, i, sameTile);
			}
		}							
		else if(gameState.isWithinBounds(row+counter, column+counter) && ((counter > 1) && (board[row][column] == '_')))
			returnValue = false;
		else
			returnValue = false;
		
		//Diagonal left up
		counter = 1;
		
		// error trap to make sure it is possible to go diagonally up to the left only if the
		// row and column are greater than 1
		if(gameState.isWithinBounds(row, column)){
			if(row > 1 && column > 1){
				while((gameState.isWithinBounds(row-counter, column-counter)) && (board[row-counter][column-counter] == oppTile)){
					counter++;
				}
			}
		}
		
		if(gameState.isWithinBounds(row-counter, column-counter)){
			if((counter > 1) && (board[row-counter][column-counter] == sameTile)){
				for(int i = (column-counter), k = (row-counter); (i <= column && k <= row); i++, k++)
					gameState.makeMove(k, i, sameTile);
			}
		}								
		else if(gameState.isWithinBounds(row-counter, column-counter) && ((counter > 1) && (board[row][column] == '_')))
			returnValue = false;
		else
			returnValue = false;
				
		gameBoard.printBoard(Othello.board);
		gameState.score(Othello.board);
				
		// PLAYER VS COMPUTER	
		if(playerVsComputer == true){	
			
			if(sameTile == 'B')
				System.out.println("White's turn.");
			else
				System.out.println("Black's turn.");
		
		
		if(computerTurn){
			if(!gameState.gameIsOver()){
				int row1 = (int)(Math.random()*board.length);
				int column1 = (int)(Math.random()*board.length);
				
				if(sameTile == 'B')
					sameTile = 'W';
				else if(sameTile == 'W')
					sameTile = 'B';			
				
				while(!gameState.gameIsOver() && !gameState.isValidMove(row1, column1, sameTile)){
					 row1 = (int)(Math.random()*board.length);
					column1 = (int)(Math.random()*board.length);
				}
				
				computerTurn = false;
				playerTurn = true;
				
				if(sameTile == 'B')
					System.out.println("Success! Black move at ("+row1+", "+column1+")");
				else
					System.out.println("Success! White move at ("+row1+", "+column1+")");
				
				play(row1, column1, sameTile);
			}
			
			else{
				gameBoard.printBoard(Othello.board);
				gameState.score(Othello.board);
				gameState.gameWinner(Othello.board);
			}
			
		}
		else{
			
			if(!gameState.gameIsOver()){
			System.out.println("Enter row: ");
			int row1 = new Scanner(System.in).nextInt();
			
			System.out.println("Enter column: ");
			int column1 = new Scanner(System.in).nextInt();
			
			if(sameTile == 'B')
				sameTile = 'W';
			else if(sameTile == 'W')
				sameTile = 'B';
			
			while(!gameState.gameIsOver() && !gameState.isValidMove(row1, column1, sameTile)){
				System.out.println("Invalid move. Enter row: ");
				 row1 = new Scanner(System.in).nextInt();
				 
				 System.out.println("Enter column: ");
				column1 = new Scanner(System.in).nextInt();
			}
			
			if(sameTile == 'B')
				System.out.println("Success! Black move at ("+row1+", "+column1+")");
			else
				System.out.println("Success! White move at ("+row1+", "+column1+")");
			
			playerTurn = false;
			computerTurn = true;
			
			play(row1, column1, sameTile);
		}	
			else{
				gameBoard.printBoard(Othello.board);
				gameState.score(Othello.board);
				gameState.gameWinner(Othello.board);
			}
	}								
		
}			
		// COMPUTER VS COMPUTER
		if(computerVsComputer){
				
			if(sameTile == 'B')
				System.out.println("White's turn.");
			else
				System.out.println("Black's turn.");
		
				int row1 = (int)(Math.random()*board.length);
				int column1 = (int)(Math.random()*board.length);
				
				if(sameTile == 'B')
					sameTile = 'W';
				else
					sameTile = 'B';
					
				
				while(!gameState.gameIsOver() && !gameState.isValidMove(row1, column1, sameTile)){
					 row1 = (int)(Math.random()*board.length);
					column1 = (int)(Math.random()*board.length);
				}
				
				if(sameTile == 'B')
					System.out.println("Success! Black move at ("+row1+", "+column1+")");
				else
					System.out.println("Success! White move at ("+row1+", "+column1+")");
					
				play(row1, column1, sameTile);
			
	}
		
		// PLAYER VS PLAYER
		if(playerVsplayer){
			if(!gameState.gameIsOver()){	
				if(sameTile == 'B')
					System.out.println("White's turn.");
				else
					System.out.println("Black's turn.");
			
				System.out.println("Enter row: ");
				int row1 = new Scanner(System.in).nextInt();
				
				System.out.println("Enter column: ");
				int column1 = new Scanner(System.in).nextInt();
				
				if(sameTile == 'B')
					sameTile = 'W';
				else
					sameTile = 'B';
					
				while(!gameState.gameIsOver() && !gameState.isValidMove(row1, column1, sameTile)){
					System.out.println("Invalid move. Enter row: ");
					 row1 = new Scanner(System.in).nextInt();
					 
					 System.out.println("Enter column: ");
					column1 = new Scanner(System.in).nextInt();
				}	
				play(row1, column1, sameTile);
			}
			else{
				gameBoard.printBoard(Othello.board);
				gameState.score(Othello.board);
				gameState.gameWinner(Othello.board);
			}
			
			
		}
	}	
		
		// Error trap for invalid move for computer vs computer
		else if(computerVsComputer) {
			
			int row1 = (int)(Math.random()*board.length);
			int column1 = (int)(Math.random()*board.length);
			
			while(!gameState.gameIsOver() && !gameState.isValidMove(row1, column1, sameTile)){
				 row1 = (int)(Math.random()*board.length);
				column1 = (int)(Math.random()*board.length);
			}
			
			if(sameTile == 'B')
				System.out.println("Success! Black move at ("+row1+", "+column1+")");
			else
				System.out.println("Success! White move at ("+row1+", "+column1+")");
							
			play(row1, column1, sameTile);
		}
		
		// Error trap for invalid move for player vs player	
		else if(playerVsplayer) {
			System.out.println("Invalid move. Enter row: ");
			int row1 = new Scanner(System.in).nextInt();		
			System.out.println("Enter column: ");
			int column1 = new Scanner(System.in).nextInt();
					
			play(row1, column1, sameTile);
		}

		// Error trap for invalid move for player vs computer
		else if(playerVsComputer) {
				System.out.println("Invalid move. Enter row: ");
				int row1 = new Scanner(System.in).nextInt();		
				System.out.println("Enter column: ");
				int column1 = new Scanner(System.in).nextInt();
				
				while(!gameState.gameIsOver() && !gameState.isValidMove(row1, column1, sameTile)){
					System.out.println("Invalid move. Enter row: ");
					 row1 = new Scanner(System.in).nextInt();	 
					 System.out.println("Enter column: ");
					column1 = new Scanner(System.in).nextInt();
				}				
				play(row1, column1, sameTile);
		}
	}
	else{
		gameBoard.printBoard(Othello.board);
		gameState.score(Othello.board);
		gameState.gameWinner(Othello.board);
	}
  }						
}
	



		



