public class IsBST {
    public static void main(String[] args) {
        BinaryNode binaryNode = getBinaryNode();        

        boolean result = isBst(binaryNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(result);
    }

    public static Boolean isBst(BinaryNode root, int min, int max){
        if(root == null)
            return true;
        else 
            return min < root.data && root.data<max && isBst(root.left, min, root.data) 
            && isBst(root.right, root.data, max);
    }

    public static BinaryNode getBinaryNode(){
        BinaryNode root = new BinaryNode(118);
        root.left = new BinaryNode(4);
        root.left.left = new BinaryNode(3);
        root.left.right = new BinaryNode(6);

        root.right = new BinaryNode(12);
        root.right.left = new BinaryNode(10);
        root.right.right = new BinaryNode(15);
        return root;
    }
}
