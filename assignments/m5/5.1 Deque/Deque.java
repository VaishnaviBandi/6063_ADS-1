import java.util.*;
class Deque {
    public Operations queueObject;
    Deque() {
        queueObject = new Operations();
    }
    public boolean isEmpty() {
        if (queueObject.size == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return queueObject.size;
    }
    public void pushLeft(final int item) {
        queueObject.insertStart(item);
        print();
    }
    public void pushRight(final int item) {
        queueObject.insertEnd(item);
        print();
    }
    public void popLeft() {
        if (queueObject.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        queueObject.deleteStart();
        print();
    }
    public void popRight() {
        if (queueObject.size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        queueObject.deleteEnd();
        print();
    }
    public void print() {
        System.out.println(queueObject.print());
    }
}
class Node {
	public int data;
	public Node next;
	Node(int data) {
		this.data = data;
		next = null;
	}
	public void setAddress(Node a) {
		next = a;
	}
	public Node getAddress() {
		return next;
	}
	public int getData() {
		return data;
	}
}
class Operations {
	Node head;
	Node tail;
	int size;
	Operations() {
		size = 0;
	}

	public void insertStart(int e) {
		Node obj = new Node(e);
		if (head == null) {
			head = obj;
			tail = obj;
		} else {
		obj.setAddress(head);
		head = obj;
		}
		size++;
	}
	public void insertEnd(int e) {
		Node obj = new Node(e);
		if (head == null) {
			head = obj;
			tail = obj;
		} else {
		tail.setAddress(obj);
		tail = obj;
		}
		size++;
	}
	public void insertAfter(int a, int b) {
		Node obj = new Node(b);
		Node temp = head;
		while (temp != null) {
			temp = temp.getAddress();
			if (temp.getData() == a) {
				Node temp1 = temp.getAddress();
				temp.setAddress(obj);
				obj.setAddress(temp1);
				size++;
				break;
			}
		}
	}
	public void deleteStart() {
		Node temp = head;
		head = temp.next;
		size--;
	}
	public void deleteEnd() {
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.getAddress();
		}
		tail = temp;
		temp.next = null;
		size--;
	}
	public String print() {
		String str = "[";
		Node temp = head;
		if (size == 0) {
			return "[]";
		}
		if (size > 0) {
			while (temp.next != null) {
				str += temp.data + ", ";
				temp = temp.getAddress();
		}
		str += temp.data + "]";
	}
		return str;
	}
}