import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS{
    public static void main(String[] args) {
        TreeNode treenode = getTreeNode();
        bfs(treenode);
    }

    public static void bfs(TreeNode treenode){
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        queue.add(treenode);
        visited.add(treenode);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if(t!=null){
                System.out.println(t.val);

                if(!visited.contains(t.left)){
                    queue.add(t.left);
                    visited.add(t.left);
                }
                if(!visited.contains(t.right)){
                    queue.add(t.right);
                    visited.add(t.right);
                }
            }
        }
    }

    public static TreeNode getTreeNode(){
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        return treeNode;
    }
}