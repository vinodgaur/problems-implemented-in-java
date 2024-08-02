//copperpod digital - interview round 3 question

public class Test {
    //arr = [3,4] // random numbers [10, 9, 3, 8, 11,7,13,5,20]
    //no repating number
    //length of the longest ascending subsequence of an array

    // 3,8,11,13,20 = 5 
    static int max = 0;
    public static void main(String[] args) {
        //int[] arr = {10,9,3,8,11,7,13,5,20};
        int[] arr = {20, 11, 7, 9, 8, 6, 5, 4, 10, 2, 13};
        
        int i=0,j= arr.length-1;

        max = findMax(i,j,arr);
        System.out.println("max length = "+max);
        
    }

    public static int findMax(int i, int j, int[] arr){
        int len = checkSeq(i,j,arr);
        if(len > max) max = len;

        if(i<j && j-i>max){
            findMax(i+1,j,arr);
            findMax(i,j-1,arr);
        }
        return max;
    }

    public static int checkSeq(int i, int j, int[] arr){
        int s = arr[i], e = arr[j];
        if(s>e)
            return 0; // because desc pattern

        int count = 2;
        for(int k=i+1;k<j;k++){
            if(s<arr[k] && arr[i]<e){
                count++;
                s = arr[k];
            }
       }
       return count;
    }
}
