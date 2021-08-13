/**
 * A class that represents a set of coordinates with attributes row and column
 * @author Brendan Bain 251086487
 *
 */

public class Position {
	private int positionRow, positionColumn;
	
	
	/**
	 * constructor for Position. Reads in row and col
	 * and creates a Position object with coordinates row and col
	 * @param boardFile text file to be read in. Contains coordinates for objects to be placed on the board
	 */
	public Position (int row, int col) {
		positionRow = row;
		positionColumn = col;	
	}
	
	/**
	 * returns the row component of the Position object 
	 * @return the row of object Position
	 */
	public int getRow() {
		return positionRow;
	}
	
	/**
	 * returns the column component of the Position object
	 * @return the column of object 
	 */
	public int getCol() {
		return positionColumn;
	}
	
	/**
	 * sets the new row component of the Position object to newRow 
	 * @param newRow the new row component of Position
	 */
	public void setRow(int newRow) {
		positionRow = newRow;
	}
	
	/**
	 * sets the new column component of the Position object to newCol
	 * @param newCol the new column component of Position
	 */
	public void setCol(int newCol) {
		positionColumn = newCol;
	}
	
	/**
	 * The equals method to check whether two Position objects have the same row and column
	 * @param otherPosition
	 * @return true or false whether the two positions are equal
	 */
	public boolean equals(Position otherPosition) {
		if (this.positionRow == otherPosition.positionRow && this.positionColumn == otherPosition.positionColumn)
			return true;
		return false;
	}

}
