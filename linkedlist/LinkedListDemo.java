package linkedlist;

//import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinKedListCustom l = new LinKedListCustom();
        l.addNode(4);
        l.addNode(6);
        l.addNode(2);
        l.addNode(8);

        l.displayLinkedList();

        LinkedListNode curr = l.root;
        LinkedListNode next = l.root.point;
        LinkedListNode newRoot = reverseLinkedList(curr, next);
        l.root.point = null;
        l.root = newRoot;

        System.out.println("");
        l.displayLinkedList();
    }

    static LinkedListNode reverseLinkedList(LinkedListNode curr, LinkedListNode next) {
        while (next != null) {
            LinkedListNode temp = next.point;
            next.point = curr;
            curr = next;
            next = temp;
        }
        return curr;
    }
}
