import java.util.List;

public class Filter{
    public static void main(String[] args) {
        // return element who are starting with 1
        List<Integer> list = List.of(23,12,14);
        List<Integer> list2 = list.stream().filter(val->{
            String str = String.valueOf(val);
            if(str.charAt(0) == '1')
                return true;
            return false;
        }).toList();

        System.out.println(list2);
    }
}