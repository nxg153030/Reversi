/*
 * OthelloMove stores the row and column 
 * and returns them using its getter methods: getRow() and getColumn()
 */

package Othello;
public class OthelloMove
{
	private int row;
	private int col;
	
	public OthelloMove(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return col;
	}	
}
