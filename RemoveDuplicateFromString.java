import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class RemoveDuplicateFromString {

    AtomicInteger sum = new AtomicInteger();

    public RemoveDuplicateFromString() {
    }

    public static void main(String[] args)
    {
        try {
        RemoveDuplicateFromString t = new RemoveDuplicateFromString();
            t.process();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void process(){
        String s = "vinodgaurvinod";
        Set<Character> set = new HashSet();
        boolean[] arr = new boolean[255];
        for(char c: s.toCharArray()){
            int i = (int)c;
            arr[i] = true;

            //set code
            set.add(c);
        }
        for(int i=0; i<arr.length;i++){
            if(arr[i])
                System.out.print((char)i);
        }
        System.out.println();
        for(char c: set){
            System.out.print(c);
        }

    }

}

