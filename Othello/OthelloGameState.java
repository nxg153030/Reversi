// An OthelloGameState represents the state of an Othello game at a given
// time. 

package Othello;

public class OthelloGameState
{
		// makeMove() places a tile in the given row and column on behalf of
		// the player whose turn it is, flipping any other tiles that should
		// be flipped as a result.
		public void makeMove(int row, int column, char tile){
			Othello.board[row][column] = tile;
		}
		
		// isTileEmpty() returns true if there are any empty tiles
		// left on the board.
		public boolean isTileEmpty(int row, int column){
			if(Othello.board[row][column] == '_')
				return true;
			else
				return false;
		}
		
		// This function checks to see whether the row and column entered by the user
		// are within bounds.
		public boolean isWithinBounds(int row, int column){
			if(((row < Othello.board.length) && (column <Othello.board.length)) && (row > -1 && column > -1))
				return true;
			else
				return false;
		}
	 
		// The function score keeps the score and displays it after each turn.
		public void score(char board[][]){
			int scoreB = 0, scoreW = 0;
			for(int i = 0; i < Othello.board.length; i++){
				for(int k = 0; k < Othello.board.length; k++){
					if(Othello.board[i][k] == 'B')
						scoreB++;
					else if(Othello.board[i][k] == 'W')
						scoreW++;
				}
			}
			System.out.println("Score: Black: "+scoreB+ ", White: "+scoreW);
		}
		
		// gameWinner prints the winner of the game.
		public void gameWinner(char board[][]){
			int scoreB = 0, scoreW = 0;
			for(int i = 0; i < Othello.board.length; i++){
				for(int k = 0; k < Othello.board.length; k++){
					if(Othello.board[i][k] == 'B')
						scoreB++;
					else if(Othello.board[i][k] == 'W')
						scoreW++;
				}
			}
			// Black wins
			if(scoreB > scoreW){
				if(Othello.sameTile == 'B'){
					System.out.println("Game over. No moves left for black.");
					System.out.println("Black wins!");
				}
				// White wins
				else{
					System.out.println("Game over. No moves left for white.");
					System.out.println("Black wins!");
				}
			}
			// Tie game
			else if (scoreB == scoreW){
				if(Othello.sameTile == 'B'){
					System.out.println("Game over. No moves left for black.");
					System.out.println("Draw!");
				}
				else{
					System.out.println("Game over. No moves left for white.");
					System.out.println("Draw!");
				}
			}
			// Tie game
			else{
				if(Othello.sameTile == 'B'){
					System.out.println("Game over. No moves left for black.");
					System.out.println("White wins!");
				}
				else{
					System.out.println("Game over. No moves left for white.");
					System.out.println("White wins!");
				}
			}		
		}
		
		// isValidMove() returns true if the given row, column and tile represent
		// a valid move on behalf of the player whose turn it is, false if
		// not.
		public boolean isValidMove(int row, int column, char playerTileColor){
			
			int counter;
			int validMoveCounter = 0;
			boolean returnValue = false;
			if(playerTileColor == 'W'){
				Othello.sameTile = 'W';
				Othello.oppTile = 'B';
			}
			else{
				Othello.sameTile = 'B';
				Othello.oppTile = 'W';
			}
			
			if(isWithinBounds(row, column) && isTileEmpty(row, column)){
			//Going down
			counter = 1;
			// error trap to make sure it is possible to go down only if the
			// row is less than 2 less than Othello.board length
			if(isWithinBounds(row, column)){
				if(row < (Othello.board.length-2)){
					while((isWithinBounds(row+counter, column)) && (Othello.board[row+counter][column] == Othello.oppTile)){
						counter++;
					}
				}
			}
			
			if(isWithinBounds(row+counter, column)){
				if((counter > 1) && (Othello.board[row+counter][column] == Othello.sameTile)){
					validMoveCounter++;
				}
			}
			else if(isWithinBounds(row+counter, column) && ((counter > 1) && (Othello.board[row+counter][column] == '_')))
				returnValue = false;
			else
				returnValue = false;
				
			//Going up
		    //counter keeps count of the tiles to be converted
			counter = 1;
			
			// error trap to make sure it is possible to go up only if the
			// row is greater than 1
			if(isWithinBounds(row, column)){
				if(row > 1){
					while((isWithinBounds(row-counter, column)) && (Othello.board[row-counter][column] == Othello.oppTile)){
						counter++;
					}
				}
			}
			if(isWithinBounds(row-counter, column)){
				if((counter > 1) && (Othello.board[row-counter][column] == Othello.sameTile)){
					
					validMoveCounter++;
				}
			}		
						
			else if(isWithinBounds(row-counter, column) && ((counter > 1) && (Othello.board[row-counter][column] == '_')))
				returnValue = false;
			else
				returnValue = false;
			
			//Going to the left
			counter = 1;
			
			// error trap to make sure it is possible to go left only if the
			// column is greater than 1
			if(isWithinBounds(row, column)){
				if(column > 1){
					while((isWithinBounds(row, column-counter)) && (Othello.board[row][column-counter] == Othello.oppTile)){
						counter++;
					}
				}
			}
			if(isWithinBounds(row, column-counter)){
				if((counter > 1) && (Othello.board[row][column-counter] == Othello.sameTile)){
					validMoveCounter++;
				}
			}		
			else if(isWithinBounds(row, column-counter) && ((counter > 1) && (Othello.board[row][column] == '_')))
				returnValue = false;
			else
				returnValue = false;
					
			//Going to the right
			counter = 1;
			
			// error trap to make sure it is possible to go right if the
			// column is less than 2 less than the Othello.board length
			if(isWithinBounds(row, column)){
				if(column < (Othello.board.length -2)){
						
					while((isWithinBounds(row, column+counter)) && (Othello.board[row][column+counter] == Othello.oppTile)){
						counter++;
					}
				}
			}
			if(isWithinBounds(row, column+counter)){
				if((counter > 1) && (Othello.board[row][column+counter] == Othello.sameTile)){
					validMoveCounter++;
				}
			}			
			else if(isWithinBounds(row, column+counter) && ((counter > 1) && (Othello.board[row][column] == '_')))
				returnValue = false;
			else
				returnValue = false;
			
			//Diagonal right up
			counter = 1;
			
			// error trap to make sure it is possible to go diagonally up to the right only if the
			// row is greater than 1 and the column is 2 less than the Othello.board length
			if(isWithinBounds(row, column)){
				if((row > 1) && (column < Othello.board.length - 2)){
					while((isWithinBounds(row-counter, column+counter)) && (Othello.board[row-counter][column+counter] == Othello.oppTile)){
						counter++;
					}
				}
			}
			if(isWithinBounds(row-counter, column+counter)){
				if((counter > 1) && (Othello.board[row-counter][column+counter] == Othello.sameTile)){
					validMoveCounter++;
				}
			}		
			else if(isWithinBounds(row-counter, column+counter) && ((counter > 1) && (Othello.board[row][column] == '_')))
				returnValue = false;
			else
				returnValue = false;
			
			
			//Diagonal left down
			counter = 1;
			
			// error trap to make sure it is possible to go diagonally down to the left only if the
			// row is less than 2 less than Othello.board length and the column is greater than 1
			if(isWithinBounds(row, column)){
				if((row < Othello.board.length-2) && (column > 1)){
					while((isWithinBounds(row+counter, column-counter)) && (Othello.board[row+counter][column-counter] == Othello.oppTile)){
						counter++;
					}
				}
			}
			if(isWithinBounds(row+counter, column-counter)){
				if((counter > 1) && (Othello.board[row+counter][column-counter] == Othello.sameTile)){
					validMoveCounter++;
				}
			}					
			else if(isWithinBounds(row+counter, column-counter) && ((counter > 1) && (Othello.board[row][column] == '_')))
				returnValue = false;
			else
				returnValue = false;
			
			//Diagonal right down
			counter = 1;
			
			// error trap to make sure it is possible to go diagonally down to the right only if the
			// row and column are 2 less than the Othello.board length
			if(isWithinBounds(row, column)){
				if((row < Othello.board.length-2) && (column < Othello.board.length-2)){
					while((isWithinBounds(row+counter, column+counter)) && (Othello.board[row+counter][column+counter] == Othello.oppTile)){
						counter++;
					}
				}
			}
			if(isWithinBounds(row+counter, column+counter)){
				if((counter > 1) && (Othello.board[row+counter][column+counter] == Othello.sameTile)){
					validMoveCounter++;
				}
			}							
			else if(isWithinBounds(row+counter, column+counter) && ((counter > 1) && (Othello.board[row][column] == '_')))
				returnValue = false;
			else
				returnValue = false;
						
			//Diagonal left up
			counter = 1;
			
			// error trap to make sure it is possible to go diagonally up to the left only if the
			// row and column are greater than 1
			if(isWithinBounds(row, column)){
				if(row > 1 && column > 1){
					while((isWithinBounds(row-counter, column-counter)) && (Othello.board[row-counter][column-counter] == Othello.oppTile)){
						counter++;
					}
				}
			}
			if(isWithinBounds(row-counter, column-counter)){
				if((counter > 1) && (Othello.board[row-counter][column-counter] == Othello.sameTile)){
					validMoveCounter++;
				}
			}								
			else if(isWithinBounds(row-counter, column-counter) && ((counter > 1) && (Othello.board[row][column] == '_')))
				returnValue = false;
			else
				returnValue = false;
		}
			
			if(validMoveCounter > 0)
				returnValue = true;
			else 
				returnValue = false;
			
			return returnValue;
			
		}
		
		// gameIsOver checks if there are any valid moves left for either player
		public boolean gameIsOver(){
				
			boolean returnValue = false;
			outerloop:
			for(int i = 0; i < Othello.board.length; i++){
				for(int k = 0; k < Othello.board.length; k++){
					if((isTileEmpty(i,k) && isValidMove(i, k, Othello.sameTile))){
						returnValue = false;
						break outerloop;
					}
					else
						returnValue = true;	
				}
			}
				return returnValue;
		}
}
