import java.util.ArrayList;
import java.util.LinkedList;

class Node {
    int data;
    Node left = null;
    Node right = null;
}

class BST {
    Node root = null;

    public static void main(String[] args) {
        BST b = new BST();
        b.root = b.add(5, b.root);
        b.root = b.add(8, b.root);
        b.root = b.add(4, b.root);
        b.root = b.add(6, b.root);
        b.root = b.add(7, b.root);
        b.inorder(b.root);
        System.out.println("");
        b.bfs();
    }

    Node add(int n, Node root) {
        if (root == null) {
            root = new Node();
            root.data = n;
        } else if (n < root.data) {
            root.left = add(n, root.left);
        } else {
            root.right = add(n, root.right);
        }
        return root;
    }

    void inorder(Node root) {
        if (root.left != null) inorder(root.left);
        System.out.print(root.data);
        if (root.right != null) inorder(root.right);
    }

    void bfs() {
        //push root into queue
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(this.root);
        //while queue is not empty
        while (q.size() > 0) {
            //take element from queue
            Node n = q.poll();
            System.out.println(n.data);
            //push it's child to queue
            if(n.left!=null) q.add(n.left);
            if(n.right!=null) q.add(n.right);
        }
    }
}