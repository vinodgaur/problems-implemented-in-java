import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        BinaryNode binaryTree = getBinaryTree();
        System.out.println(heightCalc(binaryTree, 1));
        System.out.println(heightCalc2(binaryTree));
        
        // int out = search(new int[]{-1,0,3,5,9,12},9);
        // System.out.println(out);

        // //final String str = "cba".chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        // char[] str1 = "cba".toCharArray();
        // Arrays.sort(str1);
        // String newS = String.valueOf(str1);
        // System.out.println(newS);

        // App app = new App();
        // int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
        // app.floodFill(arr, 1, 1, 2);

        // int[][] arr1 = {{0,0,0},{0,0,0}};
        // app.floodFill(arr1, 0, 0, 0);
    }

    public static int heightCalc(BinaryNode head, int count){
        //increasing height till bottom
        if(head==null)
            return count-1;
        int L1 = heightCalc(head.left, count+1);
        int L2 = heightCalc(head.right, count+1);
        if(L1>L2)
            return L1;
        return L2;
    }

    public static int heightCalc2(BinaryNode head){
        //calculating height from bottom
        if(head==null)
            return 0;
        int L1 = heightCalc2(head.left);
        int L2 = heightCalc2(head.right);
        return Math.max(L1, L2)+1;
    }

    public static BinaryNode getBinaryTree(){
        BinaryNode binaryNode = new BinaryNode(6);
        binaryNode.left = new BinaryNode(4);
        binaryNode.left.left = new BinaryNode(3);
        binaryNode.right = new BinaryNode(7);
        return binaryNode;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if(startColor == color)
            return image;

        ff(image, sr, sc, color, startColor);
        return image;
    }

    public void ff(int[][] image, int sr, int sc, int color, int oldColor){
        image[sr][sc] = color;
        if(sc-1 >=0 && image[sr][sc-1]==oldColor){
            ff(image, sr,sc-1,color, oldColor);
        }
        if(sc+1<image[sr].length && image[sr][sc+1] == oldColor){
            ff(image, sr,sc+1,color, oldColor);
        }

        //top
        if(sr-1 >=0 && image[sr-1][sc]==oldColor){
            ff(image, sr-1,sc, color, oldColor);
        }

        //bottom
        if(sr+1<image.length && image[sr+1][sc] == oldColor){
            ff(image, sr+1,sc, color, oldColor);
        }
    }

    public static void secMax(){
        List<Integer> list = List.of(3,6,9,8);
        Data data = new Data();
        list.forEach(val->{
            if(data.max < val){
                data.secMax = data.max;
                data.max = val;
            }
        });
        System.out.println(data.secMax);

        List<Integer> list2 = list.stream().filter(val->{
            return val < 108;
        }).map(val->{
            return val;
        }).sorted().collect(Collectors.toList());

        System.out.println(list2);
    }

    public static int search(int[] nums, int target) {
        
        int i=0, j=nums.length-1;

        while(i<=j){
            int mid = (i+j)/2;

            if(target == nums[mid])
                return mid;
            else if(target < nums[mid]){
                j = mid-1;
            } else{
                i=mid+1;
            }
        }
        return -1;
    }
}
