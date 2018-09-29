class LinkedList {

	class Node {
		public int digit;
		public Node address;
		Node(int element) {
			this.digit = element;
		}
		public int getDigit() {
			return this.digit;
		}
		public void setAddress(final Node address1) {
			this.address = address1;
		}
		public Node getAddress() {
			return this.address;
		}
	}
	private int size = 0;
	Node head;
	Node tail;
	public void addEnd(final int item) {
		if (size == 0) {
			head = new Node(item);
			tail = head;
			head.setAddress(null);
			size++;
			return;
		}
		Node temp = new Node(item);
		temp.setAddress(null);
		tail.setAddress(temp);
		tail = temp;
		size++;
	}
	public int removeEnd() {
		if (head == null) return 0;
		if (size == 1) {
			int data = head.getDigit();
			head = null;
			tail = null;
			return data;
		}
		Node temp = head;
		while (temp.getAddress().getAddress() != null) {
			temp = temp.getAddress();
		}
		int data = temp.getAddress().getDigit();
		temp.setAddress(null);
		tail = temp;
		size--;
		return data;
	}
	public String toString() {
		Node temp = head;
		String str = "";
		while (temp.getAddress() != null) {
			str += temp.getDigit();
			temp = temp.getAddress();
		}
		return str + temp.getDigit();
	}
	public int getSize() {
		return this.size;
	}
	public void addBeg(final int item) {
		if (size == 0) {
			head = new Node(item);
			head.setAddress(null);
			tail = head;
			size++;
			return;
		}
		Node temp = new Node(item);
		temp.setAddress(head);
		head = temp;
		size++;
	}
}
