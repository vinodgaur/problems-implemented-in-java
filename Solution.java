import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solution {
    public static void main(String[] args) {
        System.out.println("started...!");
        Solution solution = new Solution();
        //int result = solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        //System.out.println(result);

        //int leng = lengthOfLongestSubstring("qrsvbspk");
        //System.out.println(leng);

        //System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        //System.out.println(threeSum(new int[]{0,0,0}));

        //System.out.println(levelOrder(getTreeNode()));
        //int[][] data = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        //int[][] data = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        //int[][] data = {{1,4},{2,4},{3,1},{3,2}};
        //int[][] data = {{0,1},{1,0}};
        //System.out.println(solution.canFinish(2, data));

        int[] arr = {1,4,3};
        int out = solution.smallestNotInArray(arr);
        System.out.println(out);
    }

    public int smallestNotInArray(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        return 4;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] a: prerequisites){
            if(a[0] == a[1])
                return false;
            if(adj.containsKey(a[1])){
                List<Integer> list = adj.get(a[1]);
                list.add(a[0]);
            } else{
                List<Integer> arr = new ArrayList<>();
                arr.add(a[0]);

                adj.put(a[1], arr);
            }
        }

        Set<Integer> visited = new HashSet<>();

        Set<Integer> keys = adj.keySet();
        for(int key: keys){
            if(!visited.contains(key)){
                Boolean b = dfs(adj, key, visited);
                if(!b)
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> adj, Integer key, Set<Integer> visited){
        if(key==null) 
            return true;
        else if(visited.contains(key)){
            return false;
        }
        else {
            visited.add(key);
            List<Integer> nodes = adj.get(key);
            if(nodes !=null){ 
                for(Integer n: nodes){
                    Boolean b = dfs(adj, n, visited);
                    if(!b)
                        return false;
                }
            }
        }
        return true;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<List<TreeNode>> q = new LinkedList<>();
        q.add(List.of(root));
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(q.size()!=0){
            List<TreeNode> node = q.poll();
            List<Integer> r = node.stream().map(n->n.val).collect(Collectors.toList());
            result.add(r);
            
            List<TreeNode> list1 = new ArrayList<TreeNode>();
            for(TreeNode n: node){
                if(n.left!=null)
                    list1.add(n.left);
                if(n.right!=null)
                    list1.add(n.right);
            }
            if(list1.size()>0)
                q.add(list1);
        }
        return result;
    }

    public static TreeNode getTreeNode(){
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        return treeNode;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int s=0, e=nums.length-1;
        Arrays.sort(nums);

        while(s<e){
            int r = nums[e]+nums[s];

            if(r<0){
                for(int i=e-1;nums[i]>=0;i--){
                    if(r+nums[i]==0)
                        set.add(Arrays.asList(nums[s],nums[e],nums[i]));
                }
                s++;
            } else {
                for(int i=s+1;nums[i]<=0;i++){
                    if(r+nums[i]==0)
                        set.add(Arrays.asList(nums[s],nums[e],nums[i]));
                }
                e--;
            }
        }
        
        return new ArrayList<>(set);
    }



    public static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                        list.sort((a,b)->a-b);

                        if(!set.contains(list)){
                            set.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> set = new LinkedList<>();
        int count = 0;
        int max = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                count++;
            } else {
                if(count > max) max = count;
                Character ch = set.poll();
                while(ch!=null && ch!=arr[i]){
                    ch = set.poll();
                }
                set.add(arr[i]);// adding element in last
                count = set.size();
            }
        }
        if(count > max) max = count;
        return max;
    }
    
        public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && nums[i]>sum){
                sum = nums[i];
            } else {
                int count = 0;
                for(int j=i;j<nums.length;j++){
                    count+=nums[j];
                    if(count>sum){
                        sum=count;
                        i=j;
                    } else if(count < 0){
                        if(count > sum){
                            sum = count;
                        }
                        i=j;
                        break;
                    } else 
                        i=j;
                }
                
            }
        }
        return sum;
    }
}