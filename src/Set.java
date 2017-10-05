/**
 * The Set class keeps track of the visited cells.
 * 
 * @author fiorfe
 * 
 */
public class Set<E> {

	Node<E> head;
	Node<E> cursor;

	int manyItems;

	/**
	 * No-arg constructor. It sets its fields to null and 0.
	 * 
	 */
	public Set() {

		head = null;
		cursor = null;

		manyItems = 0;
	}

	/**
	 * This method should check to make sure that the input argument is not
	 * already in the Set. If the input argument is already in the set, there is
	 * nothing to be done. Otherwise, add the input argument to the Set.
	 * 
	 * @param item
	 */
	public void enter(E item) {

		if (!isElement(item)) {

			head = new Node<E>(item, head);

			manyItems++;
		}
	}

	/**
	 * This method checks if an input argument is present in the Set.
	 * 
	 * @param item
	 */
	public boolean isElement(E item) {

		cursor = head;

		while (!isEmpty() && hasNext()) {

			if (item.equals(cursor.data)) {

				return true;
			}

			cursor = cursor.link;
		}

		return false;
	}

	/**
	 * This method checks if the Set is empty.
	 * 
	 * @return head == null
	 * 
	 */
	public boolean isEmpty() {

		return head == null;
	}

	/**
	 * This method checks if the Set has items.
	 * 
	 * @return cursor
	 * 
	 */
	public boolean hasNext() {

		return (cursor != null);
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