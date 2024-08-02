import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromString{
    public static void main(String[] args) {
        String str = removeDuplicateFromStringOpt("geeksforgeeks");
        System.out.println(str);
    }

    public static String removeDuplicateFromString(String str2){
        char[] str = str2.toCharArray();
        if(str.length <=1)
            return String.valueOf(str);

        
        int index = 1;
        for(int i=1;i<str.length;i++){
            int j=-1;
            boolean f = false;
            while (++j<=index) {
                if(str[j]==str[i]){
                    f = true;
                    break;
                }
            }
            if(!f)
                str[index++] = str[i];
        }

        char[] str1 = Arrays.copyOf(str, index);
        return String.valueOf(str1);
    }

    public static String removeDuplicateFromStringOpt(String str2){
        char[] str = str2.toCharArray();
        if(str.length <=1)
            return String.valueOf(str);

        
        int index = 1;
        Set<Character> set = new HashSet<>();
        set.add(str[0]);

        for(int i=1;i<str.length;i++){
            boolean f = false;
            if(set.contains(str[i])){
                f = true;
            }
            if(!f){
                str[index++] = str[i];
                set.add(str[i]);
            }
        }

        char[] str1 = Arrays.copyOf(str, index);
        return String.valueOf(str1);
    }
}