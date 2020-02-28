package linkedlist;

class LinkedListNode{
    int data;
    LinkedListNode(int n){
        this.data = n;
    }
    LinkedListNode point = null;
}

public class LinKedListCustom {
    LinkedListNode root = null;

    void addNode(int n){

        if(this.root == null){
            this.root = new LinkedListNode(n);
        } else {
            LinkedListNode temp = this.root;
            while(temp.point!=null){
                temp = temp.point;
            }
            temp.point = new LinkedListNode(n);
        }

    }

    void displayLinkedList(){
        LinkedListNode temp = this.root;
        while(temp!=null){
            System.out.print(temp.data+ ", ");
            temp= temp.point;
        }
    }
}
