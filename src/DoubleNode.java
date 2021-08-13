/**
 * Representation of a two-directional node system
 * @author Brendan Bain 251086487
 * @param <T> type of data to be stored in DoubleNode
 */

public class DoubleNode<T> {
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	private T data;
	
	/**
	 * constructor of DoubleNode. Creates a new empty system
	 */
	public DoubleNode() {
		next = null;
		prev = null;
	}
	
	/**
	 * Constructor of DoubleNode. Creates a new system with one node storing newData
	 * @param newData item to be stored in node
	 */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}
	
	/**
	 * Method to return the next node in the system
	 * @return the next node in the system
	 */
	public DoubleNode<T> getNext(){
		return next;
	}
	
	/**
	 * Method to return the previous node in the system
	 * @return the previous node in the system
	 */
	public DoubleNode<T> getPrev(){
		return prev;
	}
	
	/**
	 * Method to return the data stored in node
	 * @return the data stored in node
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Method to set the next node in the system
	 * @param nextNode the node to be set as the next node
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}
	
	/**
	 * Method to set the previous node in the system
	 * @param prevNode the node to be set as the previous node
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}
	
	/**
	 * Method to set the data in node
	 * @param newData the data to be stored in node
	 */
	public void setData (T newData) {
		data = newData;
	}
	
}
