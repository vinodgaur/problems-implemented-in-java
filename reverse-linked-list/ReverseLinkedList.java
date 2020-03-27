class ReverseLinkedList{
	Node root = null;
	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.addNode(5);
		rll.addNode(3);
		rll.addNode(8);

		rll.print();

		Node newRoot = rll.reverse(rll.root,rll.root.next);
		rll.root.next = null;
		rll.root = newRoot;

		rll.print();
	}

	void addNode(int n){
		if(this.root == null){
			this.root = new Node(n);
		} else {
			Node temp = this.root;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = new Node(n);
		}
	}

	void print(){
		Node temp = this.root;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	Node reverse(Node a, Node b){
		if(a!=null && b==null){
			return a;
		} else {
			Node temp = b.next;
			b.next = a;
			return reverse(b, temp);
		}
	}
}