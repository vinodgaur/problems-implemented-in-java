package bst;

import java.util.ArrayList;

public class BST1Demo{
    public static void main(String[] args) {
        BST1 bs = new BST1();
        bs.addNode(60);
        bs.addNode(20);
        bs.addNode(30);
        bs.addNode(40);
        bs.addNode(50);

        System.out.println(bs.inorder());

        BST1 bs2 = new BST1();
        bs2.addNode(50);
        bs2.addNode(40);
        bs2.addNode(70);
        bs2.addNode(10);
        bs2.addNode(80);

        System.out.println(bs2.inorder());

        //merge two sorted array
        ArrayList<Integer> inorderMerged = mergeTwoSortedArray(bs.inorder(), bs2.inorder());
        System.out.println(inorderMerged);

        BST1 bsMerged = inorderToBst(inorderMerged);

        System.out.println(bsMerged.inorder());
    }

    static BST1 inorderToBst(ArrayList<Integer> inorderMerged){
        BST1 bsMerged = new BST1();
        bsMerged.root = inorderToBstRec(inorderMerged, 0, inorderMerged.size()-1, bsMerged.root);
        return bsMerged;
    }

    static TreeNode inorderToBstRec(ArrayList<Integer> inorderMerged, int l, int r, TreeNode root){
        if(l>r){
            return null;
        }
        //take mid
        int mid = (l+r)/2;
        //assign mid value to node
        root = new TreeNode();
        root.value = inorderMerged.get(mid);
        root.left = inorderToBstRec(inorderMerged, l, mid-1, root);
        root.right = inorderToBstRec(inorderMerged,mid+1, r, root);

        return root;
    }

    static ArrayList<Integer> mergeTwoSortedArray(ArrayList<Integer> a1, ArrayList<Integer> a2){
        int i=0, j=0;
        ArrayList<Integer> mergedArrList = new ArrayList<Integer>();
        while(i < a1.size() && j < a2.size()){
            if(a1.get(i) < a2.get(j)){
                mergedArrList.add(a1.get(i));
                i++;
            } else {
                mergedArrList.add(a2.get(j));
                j++;
            }
        }

        while(i < a1.size()){
            mergedArrList.add(a1.get(i++));
        }

        while(j < a2.size()){
            mergedArrList.add(a2.get(j++));
        }

        return mergedArrList;
    }
}
