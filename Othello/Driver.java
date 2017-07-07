// Driver class holds the main method 
// and calls an instance of the Othello class which in turn, invokes
// instances of all the other classes.

package Othello;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	// initialize scanner object
		
		// User input for board size
		System.out.println("Please enter the size of the board(N*N dimension) : ");
		int boardSize = scanner.nextInt();
		
		// Board size cannot be less than 4
		// Ask user to re-enter board size if a size less than 4 is entered.
		while(boardSize < 4){
			System.out.println("Board size cannot be less than 4. Please enter a valid board size: ");
			boardSize = new Scanner(System.in).nextInt();
		}	
		// Initialize Othello and Board objects
		Othello game = new Othello(boardSize);
		Board gameBoard = new Board();
		
		// Ask user to choose one of the three options:
		// 1) Player vs Player; 2) Player Computer; 3) Computer vs Computer
		System.out.println("Choose one from the following. Enter the corresponding index: \n");	
		System.out.println("1. Player vs Player");
		System.out.println("2. Player vs Computer");
		System.out.println("3. Computer vs Computer");		
		int index = scanner.nextInt();
		
		// use switch statements to capture user input
		switch(index){
		case 1: System.out.println("Player vs Player it is then.");
				Othello.playerVsplayer = true;
				break;
		case 2: System.out.println("Player vs Computer it is then.");
				Othello.playerVsComputer = true;
				break;
		case 3: System.out.println("Computer vs Computer it is then.");
				Othello.computerVsComputer = true;
				break;
		}
		
		// Black always plays first
		final char player = 'B';
		gameBoard.printBoard(Othello.board);
		Othello.sameTile = player;							
		System.out.println("Black's turn.");
		
		// Player vs Player mode
		if(Othello.playerVsplayer){
			// User input for row and column
			System.out.println("Enter row: ");
			int row = scanner.nextInt();
			System.out.println("Enter column: ");
			int column = scanner.nextInt();
			
			// Create othelloMove object initialized with the user entered row and column values
			OthelloMove othelloMove = new OthelloMove(row,column);
			game.play(othelloMove.getRow(), othelloMove.getColumn(), Othello.sameTile);		
		}
		
		// Player vs Computer mode
		if(Othello.playerVsComputer){
			// User input for row and column, user always plays first
			System.out.println("Enter row: ");
			int row = scanner.nextInt();
			System.out.println("Enter column: ");
			int column = scanner.nextInt();
			Othello.computerTurn = true; 
			
			// Create othelloMove object initialized with the user entered row and column values
			OthelloMove othelloMove = new OthelloMove(row,column);
			game.play(othelloMove.getRow(), othelloMove.getColumn(), Othello.sameTile);		
		}
	
		// Computer vs Computer mode
		if(Othello.computerVsComputer){
			int row = (int)(Math.random()*boardSize); // use the math.random function to generate row and column
			int column = (int)(Math.random()*boardSize);
			
			// Create othelloMove object initialized with the computer entered row and column values
			OthelloMove othelloMove = new OthelloMove(row,column);
			game.play(othelloMove.getRow(), othelloMove.getColumn(), Othello.sameTile);
		}	
		// close scanner
		scanner.close();
	}
}