/**
 * Class to represent a two-directional list
 * @author Brendan Bain 251086487
 * @param <T> type of data to be stored in list
 */
public class DoubleList<T> {
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;
	
	/**
	 * Constructor of list. creates empty list
	 */
	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}
	
	/**
	 * Method to add data newData to the list in position index
	 * @param index the index in the list where the data is stored
	 * @param newData the data to be stored
	 * @throws InvalidPositionException
	 */
	public void addData(int index, T newData) throws InvalidPositionException{
		
		if (index > numDataItems || index < 0)
			throw new InvalidPositionException("Invalid position");
		
		DoubleNode<T> newNode = new DoubleNode<T>(newData);
		
		//adds node to the front of list
		if (index == 0) {
			if (numDataItems == 0) {		//if its empty
				head = newNode;
				rear = newNode;
				numDataItems++;
			}
			else {
				DoubleNode<T> curr = new DoubleNode<T>();
				curr = head;
				curr.setPrev(newNode);
				newNode.setNext(curr);
				head = newNode;
				numDataItems++;
			}
		}
		
		//adds node into the list
		else if (0 < index & index < numDataItems) {
			DoubleNode<T> curr = new DoubleNode<T>();
			curr = head;
			for (int i = 0; i < index; i++) 	//pointing to index position
				curr = curr.getNext();
			
			newNode.setPrev(curr.getPrev());
			newNode.setNext(curr);
			curr.getPrev().setNext(newNode);
			curr.setPrev(newNode);
			numDataItems++;
			
		}
		
		else if (index == numDataItems) {
			rear.setNext(newNode);
			newNode.setPrev(rear);
			rear = newNode;
			numDataItems++;
		}
	}
	
	/**
	 * Method to get data from the list in position index
	 * @param index the position of the node to return 
	 * @return data in the node at position index
	 * @throws InvalidPositionException
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException{
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid position");
		
		DoubleNode<T> curr = new DoubleNode<T>();
		curr = head;
		for (int i = 0; i < index; i++) 	//pointing to index position
			curr = curr.getNext();
		return curr;
	}	
	
	/**
	 * removes a node at position index
	 * @param index the position of the node to remove
	 * @throws InvalidPositionException
	 */
	public void removeData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid position");
		
		
		DoubleNode<T> curr = new DoubleNode<T>();
		curr = head;
		for (int i = 0; i < index; i++) 	//pointing to index position
			curr = curr.getNext();
		
		
		if (index == 0) { 					//delete head 
			if (numDataItems == 1) {
				head = null;
				rear = null;
			}
			else {
			curr.getNext().setPrev(null);
			head = curr.getNext();
			}
			numDataItems--;
		}
		
		else if (0 < index & index < numDataItems -1) { //delete inside
			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());
			numDataItems--;
		}
		
		else if (index == numDataItems -1) { //delete end
			curr.getPrev().setNext(null);
			rear = curr.getPrev();
		}
	}
	
	/**
	 * Method to get data from node at position index
	 * @param index the position of the node 
	 * @return the data inside the node at position index
	 * @throws InvalidPositionException
	 */
	public T getData(int index) throws InvalidPositionException{
		return getNode(index).getData();
	}

	/**
	 * Method to set data at position index to newData
	 * @param index the position of the node
	 * @param newData the data to be added to the node
	 * @throws InvalidPositionException
	 */
	public void setData(int index, T newData) throws InvalidPositionException{
		getNode(index).setData(newData);
	}
	
}
