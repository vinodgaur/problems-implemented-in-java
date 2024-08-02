import java.util.Arrays;

public class KclosestPoint {
    public static void main(String[] args) {
        int [][] close = kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
        //int [][] close = kClosest(new int[][]{{1,3},{-2,2}}, 1);
        System.out.println(close);
        for (int[] is : close) {
            for (int is2 : is) {
                    System.out.println(is2);
            }
        }

    }
    public static int[][] kClosest(int[][] points, int k) {
        int[][] close = new int[k][2];
        Arrays.sort(points, (a,b)->{
            int x = 0-a[0];
            int y = 0-a[1];

            int x2 = 0-b[0];
            int y2 = 0-b[1];

            int ad = (int) (Math.pow(x,2)+Math.pow(y,2));
            int bd = (int) (Math.pow(x2,2)+Math.pow(y2,2));

            return  ad - bd;
        });
        for(int i=0;i<k;i++){
            close[i] = points[i];
        }
        return close;       
    }
}
