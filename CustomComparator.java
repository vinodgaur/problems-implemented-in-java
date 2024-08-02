import java.util.Arrays;
import java.util.List;

public class CustomComparator implements java.util.Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
       
    public static void main (String[] args) {
          List<String> names = Arrays.asList("Jan", "Tommy", "Jo", "Adam");
        names.sort(new CustomComparator());
        System.out.println(names); // [Tommy, Adam, Jan, Jo]
    }
}
