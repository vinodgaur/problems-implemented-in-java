import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        int m = task1.solution("29162", "10524");
        System.out.println(m);
    }

    public int solution(String S, String T) {
        // Implement your solution here
        char[] num1Arr = S.toCharArray();
        char[] num2Arr = T.toCharArray();

        int initialDiff = Math.abs(Integer.parseInt(new String(num1Arr)) - Integer.parseInt(new String(num2Arr)));
        List<SwapInfo> potentialSwaps = new ArrayList<>();
        for(int i=0;i< num1Arr.length;i++){
            for(int j=0;j < num2Arr.length; j++){
                swap(num1Arr, num2Arr, i, j);
                int newDiff = Math.abs(Integer.parseInt(new String(num1Arr)));
                int reduction = initialDiff - newDiff;
                potentialSwaps.add(new SwapInfo(reduction, i, j));
                swap(num1Arr, num2Arr, i,j);
            }
        }

        Collections.sort(potentialSwaps, new Comparator<SwapInfo>(){
            public int compare(SwapInfo s1, SwapInfo s2){
                return s2.reduction - s1.reduction;
            }
        });

        for(SwapInfo swap: potentialSwaps){
            if(swap.reduction < 0) break;
            swap(num1Arr, num2Arr, swap.index1, swap.index2);
            initialDiff-= swap.reduction;
        }

        return Math.abs(Integer.parseInt(new String(num1Arr)) - Integer.parseInt(new String(num2Arr)));
    }

    private static void swap(char[] num1, char[] num2, int i, int j){
        char temp = num1[i];
        num1[i] = num2[j];
        num2[j] = temp;
    }


}

class SwapInfo{
    int reduction;
    int index1;
    int index2;

    SwapInfo(int reduction, int index1, int index2){
        this.reduction = reduction;
        this.index1 = index1;
        this.index2 = index2;
    }
}
