import java.util.*;

public class Persis {
    public static void main(String[] args) {
        String[] arr = new String[]{ "test", "j2ee", "sett", "e2ej", "world", "enam", "name", "aenm" };

        Map<String, List<String>> map = new HashMap<>();

        for(String str: arr){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String sortedStr = String.valueOf(ch);

            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(str);
            } else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr,list);
            }
        }

        map.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        }) ;
        System.out.println("done");
    }


}
