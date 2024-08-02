import java.util.*;

public class Persist1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("testuser",45);
        map.put("demouser",30);
        map.put("devuser",75);
        map.put("qauser",67);
        map.put("produser",32);

        List<Map.Entry<String, Integer>> arr = new ArrayList<>(map.entrySet());

        Collections.sort(arr, (a,b)->a.getValue()-b.getValue());

        arr.forEach(v->{
            System.out.println(v.getKey());
        });
    }
    
}

class Data1 {
    Integer num;
    String value;

    Data1(String v, Integer num) {
        //TODO Auto-generated constructor stub
        this.num = num;
        this.value = v;
    }
    
}
