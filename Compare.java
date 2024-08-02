import java.util.Arrays;
import java.util.List;

public class Compare implements Comparable<Compare> {
    private int age;

    Compare(int age){
        this.age = age;
    }

    @Override
    public int compareTo(Compare o) {
        // TODO Auto-generated method stub
        return this.age - o.age;
    }
    
    public static void main(String[] args) {
        Compare[] comps = new Compare[2];
        comps[0] = new Compare(8);
        comps[1]  = new Compare(5);
        
        Arrays.sort(comps);
        for (Compare compare : comps) {
            System.out.println(compare.age);
        }
        
    }
}

