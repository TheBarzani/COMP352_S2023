package tut3.Stack;

class StackLL<T> {

    // Node: Auxillary Node class for LinkedList Implementation
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
	
	private Node<T> head;
	private int count;
	
	public StackLL() {
		head = null;
		count = 0;
	}
	
	public void push(T t) {
        Node<T> n = new Node<>(t);
		if(n != null) {
			n.setNext(head);
			head = n;
			count++;
		}
	}
	
	public T peek() {
		return head.data;
	}
	
	public T pop() {
		Node<T> k = head;
		if(head != null) {
			head = head.getNext();
			count--;
            return k.data;
		}
		else return null;
	}
	
	public int getCount() {
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		StackLL<Integer> stack = new StackLL<>();
		
		for(int i = 0; i < 9; i++) {
			stack.push(i);
		}
		
		System.out.println("Count: " + stack.getCount());
		
		Integer k;
		while((k = stack.pop()) != null) {
			System.out.println(k + " ");
		}

        System.out.println("Count: " + stack.getCount());
        System.out.println(stack.pop());
	}
}
