public class JLinkedList {
	private Node head;
	private Node tail;
	private int size = 0;

	private class Node {
		private Object data;
		private Node next;

		public Node(Object input) {
			this.data = input;
			this.next = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}
	}

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;

		if (head.next == null) {
			tail = head;
		}
	}

	public void addLast(Object input) {
		Node newNode = new Node(input);
		if (size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	public Node node(int index) {
		Node x = head;

		while (--index >= 0) {
			x = x.next;
		}

		return x;
	}

	public void add(int index, int value) {
		if (index == 0) {
			addFirst(value);
		} else {
			Node x = head;
			Node newNode = new Node(value);

			while (--index > 0) {
				x = x.next;
			}

			newNode.next = x.next;
			x.next = newNode;
			size++;

			if (newNode.next == null) {
				tail = newNode;
			}
		}
	}

	public String toString() {
		if (head == null) {
			return "[ ]";
		} else {
			Node tmp = head;
			String str = "[";

			while (tmp.next != null) {
				str += tmp.data + ", ";
				tmp = tmp.next;
			}
			str += tmp.data;

			return str + "]";
		}
	}

	public Object removeFirst() {
		Node tmp = head;
		head = tmp.next;

		Object returnVal = (Object) tmp.data;
		tmp = null;
		size--;

		return returnVal;
	}

	public int size() {
		return size;
	}

	public void remove(int idx) {
		Node tmp = head;

		while (--idx > 0) {
			tmp = tmp.next;
		}

		tmp.next = tmp.next.next;
		tmp = tmp.next;
		tmp = null;
	}

	public int indexOf(Object value) {
		Node tmp = head;
		int idx = 0;

		while (tmp.data != value) {
			tmp = tmp.next;
			idx++;

			if (tmp == null) {
				return -1;
			}
		}

		return idx;
	}

	public ListIterator listIterator() {
		return new ListIterator();
	}

	public class ListIterator {
		private Node next;
		private Node lastReturned;
		private int nextIndex;

		ListIterator() {
			next = head;
			nextIndex = 0;
		}

		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;

			return lastReturned.data;
		}

		public boolean hasNext() {
			return nextIndex < size();
		}

		public void add(Object input) {
			Node newNode = new Node(input);

			if (lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.next = next;
			}

			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		
		public void remove() {
			if(nextIndex == 0) {
				throw new IllegalStateException();
			}
			JLinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
}
