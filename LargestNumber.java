import java.util.*;
import java.util.stream.Stream;

public class LargestNumber {
    public static void main(String[] args) {
        largest(new String[]{"3","30","34","5","9"});
    }

    public static void largest(String[] str){
        Comparator<String> comp = (x,y)->{
            return (x+y).compareTo(y+x);
        };

        Arrays.sort(str, comp.reversed());
        System.out.println(Stream.of(str).toList());
    }
}
