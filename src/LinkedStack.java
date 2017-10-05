import java.util.*;

/**
 * The LinkedStack class keeps track of previously visited cells that may
 * eventually lead to the finishing cell.
 * 
 * @author fiorfe
 * 
 */
public class LinkedStack<E> {

	private Node<E> top;

	int manyItems;

	/**
	 * No-arg constructor. It sets its fields to null and 0.
	 * 
	 */
	public LinkedStack() {

		top = null;

		manyItems = 0;
	}

	/**
	 * This method adds an item to the Stack.
	 * 
	 * @param item
	 * 
	 */
	public void push(E item) {

		top = new Node<E>(item, top);

		manyItems++;
	}

	/**
	 * This method deletes an item from the Stack.
	 * 
	 * @return answer
	 * 
	 */
	public E pop() {

		E answer;

		if (top == null)
			throw new EmptyStackException();

		answer = top.data;

		top = top.link;

		manyItems--;

		return answer;
	}

	/**
	 * This method returns the data from top.
	 * 
	 * @return top.data
	 * 
	 */
	public E peek() {

		if (top == null)
			throw new EmptyStackException();

		return top.data;
	}

	/**
	 * This method checks if the Stack is empty.
	 * 
	 */
	public boolean isEmpty() {

		return top == null;
	}

	/**
	 * This method returns the Stack size.
	 * 
	 * @return manyItems
	 */
	public int size() {

		return manyItems;
	}

	/**
	 * This inner class represents an individual node.
	 * 
	 */
	private class Node<E> {

		private E data;
		private Node<E> link;

		/**
		 * Constructor. It creates a new node.
		 * 
		 * @param initialData
		 *            , initialLink
		 * 
		 */
		public Node(E initialData, Node<E> initialLink) {

			data = initialData;
			link = initialLink;
		}
	}
}