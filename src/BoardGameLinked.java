import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that represents a board with attributes boardLength and boardWidth
 * @author Brendan Bain 251086487
 *
 */
public class BoardGameLinked {
	private int boardLength;
	private int boardWidth;
	private SnakeLinked theSnake;
	private DoubleList<String>[] board;
	private String buffer = null;
	private BufferedReader in = null;
	int temprow, tempcol;
	
	/**
	 * constructor for BoardGameLinked. Sets objects on board from boardFile
	 * @param boardFile text file to set objects on board
	 */
	public BoardGameLinked(String boardFile) {
		//reads in the board dimensions and starting point of snake
		try {
			in = new BufferedReader(new FileReader(boardFile));
			buffer = in.readLine();								
			buffer = in.readLine();
			buffer = in.readLine();
			boardLength = Integer.parseInt(buffer); 
			buffer = in.readLine();
			boardWidth = Integer.parseInt(buffer);
			buffer = in.readLine();
			temprow = Integer.parseInt(buffer);
			buffer = in.readLine();
			tempcol = Integer.parseInt(buffer);
			theSnake = new SnakeLinked(temprow, tempcol);
	
			
			//makes matrix of size boardWidth and boardLength with all entries initialized to "empty"
			//board = (DoubleList<String>[])new Object[boardWidth];
			board = (DoubleList<String>[])new DoubleList[boardWidth];
			
			for (int i = 0; i < boardWidth; i++) {
				board[i] = new DoubleList<String>();
				for (int j = 0; j < boardLength; j++) {
					board[i].addData(j, "empty");
				}
			}
			
			//reads through the file to add objects to the board until the text file ends
			buffer = in.readLine();
			while (buffer != null) {
				temprow = Integer.parseInt(buffer);
				buffer = in.readLine();
				tempcol = Integer.parseInt(buffer);
				buffer = in.readLine();
				String tempString = buffer;
				board[temprow].setData(tempcol, tempString);
				buffer = in.readLine();	
			}	
		}
		catch (IOException e) {
			System.out.println("Cannot read file \'"+boardFile+"\'");
			System.exit(0);
		}		
	}	
	
	/**
	 * Method to get the object at position (row, col)
	 * @param row the target row
	 * @param col the target column
	 * @return the string stored at position (row, col)
	 * @throws InvalidPositionException
	 */
	public String getObject(int row, int col) throws InvalidPositionException{
		if (row < 0 | col < 0 | row >= boardWidth | col >= boardLength)
			throw new InvalidPositionException("Invalid position");
		
		return board[row].getData(col);
	}
	
	/**
	 * Method to set object at position (row, col) to newObject
	 * @param row the target row
	 * @param col the target column
	 * @param newObject the new object
	 * @throws InvalidPositionException
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException{
		if (row < 0 | col < 0 | row >= boardWidth | col >= boardLength)
			throw new InvalidPositionException("Invalid Position");
		
		board[row].setData(col, newObject);
	}
	
	/**
	 * Method to get the snake object
	 * @return the snake object
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}
	
	/**
	 * Method to get the length of the board
	 * @return the length of the board
	 */
	public int getLength() {
		return boardLength;
	}
	
	/**
	 * Method to get the width of the board
	 * @return the width of the board
	 */
	public int getWidth() {
		return boardWidth;
	}
}

