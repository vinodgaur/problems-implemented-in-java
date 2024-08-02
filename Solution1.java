import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1 {
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int m = solution1.solution(new String[]{"co","dil","ity"});
        System.out.println(m);
    }

    int max = 0;
    public int solution(String[] A) {
        // Implement your solution here
        check(A);
        return max;
    }

    public void check(String[] A){
        List<String> list = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            String str = A[i];
            Set<Character> set = new HashSet<>();
            for(int j=0;j<str.length();j++){
                set.add(str.charAt(j));
            }

            if(set.size() == str.length()){
                list.add(str);
                if(max < str.length()){
                    max = str.length();
                }
            }
        }
        String[] B = list.toArray(String[]::new);

        for(int i=0;i<B.length;i++){
            List<String> list1 = new ArrayList<>();
            list1.add(B[0]+B[i]);
            

            String[] str1 = Arrays.copyOfRange(B,i+1,B.length);
            for (String str12 : str1) {
                list1.add(str12);
            }
            check(list1.toArray(String[]::new));

        }
    }
}