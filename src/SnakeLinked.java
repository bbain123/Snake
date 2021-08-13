/**
 * Class to represent a snake made of a list of positions that has attributes snakeLength
 * @author Brendan Bain 251086487
 */
public class SnakeLinked {
	int snakeLength;
	DoubleList<Position> snakeBody = new DoubleList<Position>();
	
	/**
	 * Constructor for SnakeLinked. Sets snakes position to position (row, col)
	 * @param row the target row
	 * @param col the target column
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody.addData(0, new Position(row, col));
	}
	
	/**
	 * Method to get the length of the snake
	 * @return the length of the snake
	 */
	public int getLength() {
		return snakeLength;
	}
	
	/**
	 * Method to get the position of the snake body at position index 
	 * @param index the index of the snake body 
	 * @return the position of snake body at index
	 */
	public Position getPosition(int index) {
		if (index < 0 | index >= snakeLength)
			return null;
		else 
			return snakeBody.getData(index);
	}
	
	/**
	 * Method to check if snakeBody is on position pos
	 * @param pos the position being checked
	 * @return True if snakeBody is on position pos, false otherwise. 
	 */
	public boolean snakePosition (Position pos) {
		for (int i = 0; i < snakeLength; i ++) {
			if (snakeBody.getData(i).equals(pos))
				return true;
		}
		return false;
	}
	
	/**
	 * Method to get the position of the snake head if it were to move in the direction specified by direction
	 * @param direction the direction the snake would hypothetically move in
	 * @return The hypothetical position of the snake head one unit in the direction of direction
	 */
	public Position newHeadPosition(String direction) {
		Position returnPosition = new Position(0,0);
		if (direction.equals("right")) 
		    returnPosition = new Position(snakeBody.getData(0).getRow(), snakeBody.getData(0).getCol() + 1);
		else if (direction.equals("left"))
			returnPosition = new Position(snakeBody.getData(0).getRow(), snakeBody.getData(0).getCol() - 1);
		else if (direction.equals("up"))
			returnPosition = new Position(snakeBody.getData(0).getRow() - 1, snakeBody.getData(0).getCol());
		else if (direction.equals("down"))
			returnPosition = new Position(snakeBody.getData(0).getRow() + 1, snakeBody.getData(0).getCol());
		
		return returnPosition;
	}
	
	/**
	 * Moves the snake one unit in the direction specified by direction
	 * @param direction the direction the snake moves
	 */
	public void moveSnakeLinked(String direction) {
		for (int i = snakeLength-1; i > 0; i--) {
			snakeBody.setData(i, new Position(snakeBody.getData(i-1).getRow(), snakeBody.getData(i-1).getCol()));
		}
		snakeBody.setData(0, newHeadPosition(direction));
	}
	
	/**
	 * Shrinks the snake by one unit off the tail of the snake
	 */
	public void shrink() {
		snakeBody.removeData(snakeLength - 1);
		snakeLength--;
	}
	
	/**
	 * Grows the snake one unit in the direction specified by direction
	 * @param direction the direction the snake moves
	 */
	public void grow(String direction) {
		snakeBody.addData(snakeLength, new Position(0,0));
		for (int i = snakeLength; i > 0; i--) {  
			snakeBody.setData(i, new Position(snakeBody.getData(i-1).getRow(), snakeBody.getData(i-1).getCol()));
		}
		
		snakeBody.setData(0, newHeadPosition(direction));
		snakeLength++;
	}
	
}
