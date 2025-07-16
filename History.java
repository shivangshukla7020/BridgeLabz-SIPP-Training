package core;

public class History {
	private class Node {
		String link;
		Node prev;
		Node next;

		Node(String link) {
			this.link = link;
		}
	}

	private Node head;
	private Node tail;

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(String link) {
		Node n = new Node(link);
		if (isEmpty()) {
			head = tail = n;
		} else {
			n.next = head;
			head.prev = n;
			head = n;
		}
	}

	public void addLast(String link) {
		Node n = new Node(link);
		if (isEmpty()) {
			head = tail = n;
		} else {
			n.prev = tail;
			tail.next = n;
			tail = n;
		}
	}

	public String getFirst() {
		return head != null ? head.link : null;
	}

	public String getLast() {
		return tail != null ? tail.link : null;
	}

	public String popFirst() {
		if (isEmpty()) return null;
		String link = head.link;

		if (head == tail) { // only one node
			head = tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}

		return link;
	}

	public String popLast() {
		if (isEmpty()) return null;
		String link = tail.link;

		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}

		return link;
	}

	public void showHistory() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.link + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void open(String link) {
		Node temp = head;

		while (temp != null && !temp.link.equals(link))
			temp = temp.next;

		if (temp == null) {
			System.out.println("No page found!");
			return;
		}

		System.out.println("Welcome to : " + temp.link);

		if (temp == head) return;

		if (temp == tail) {
			tail = temp.prev;
			tail.next = null;
		} else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}

		temp.prev = null;
		temp.next = head;
		head.prev = temp;
		head = temp;
	}

	public String popLink(String link) {
		Node temp = head;

		while (temp != null && !temp.link.equals(link))
			temp = temp.next;

		if (temp == null) {
			System.out.println("No link found!");
			return null;
		}

		if (temp == head) {
			popFirst();
		} else if (temp == tail) {
			popLast();
		} else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}

		System.out.println("Removed : " + link);
		return link;
	}

	public static void main(String[] args) {
		History hs = new History();

		hs.addFirst("a.com");
		hs.addFirst("b.com");
		hs.addFirst("c.com");
		hs.addFirst("d.com");

		hs.showHistory();  

		hs.popFirst();     
		hs.showHistory();  

		hs.open("a.com");  
		hs.showHistory();
	}
}