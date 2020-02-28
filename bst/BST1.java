package bst;

import java.util.ArrayList;

class TreeNode {
    int value;
    TreeNode left=null;
    TreeNode right=null;
}

class BST1 {
    TreeNode root=null;

    TreeNode addNodeRec(TreeNode root, int n){
        if(root==null){
            root = new TreeNode();
            root.value=n;
        } else if(n < root.value) {
            root.left = addNodeRec(root.left, n);
        } else {
            root.right = addNodeRec(root.right, n);
        }
        return root;
    }

    TreeNode addNode(int n){
        root = addNodeRec(root, n);
        return root;
    }

    void inorderRec(TreeNode root, ArrayList<Integer> inorderArrLst){
        if(root!=null){
            inorderRec(root.left, inorderArrLst);
            inorderArrLst.add(root.value);
            inorderRec(root.right, inorderArrLst);
        }
    }

    ArrayList<Integer> inorder(){
        ArrayList<Integer> inorderArrLst = new ArrayList<Integer>();
        inorderRec(root, inorderArrLst);
        return inorderArrLst;
    }
}

