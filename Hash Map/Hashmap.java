import java.util.HashMap;
import java.util.Map;

public class Hashmap{


    public static void main(String args[]) {
        // key(Country), value(population)
        HashMap<String, Integer> map = new HashMap<>();

        // insertion
        map.put("Bangladesh",16);
        map.put("US",30);
        map.put("China",150);
        System.out.println(map);

        map.put("China",180);
        System.out.println(map);
        

        // Search
        if(map.containsKey("China")){
            System.out.println("key is present in the map");
        }else{
            System.out.println("key is not present in the map");
        }

        // get function
        System.out.println(map.get("China")); 
        System.out.println(map.get("Ban"));

        // int arr[]={12,15,18};
        // for(int val:arr){
        //     System.out.println(val);

        // }

        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        
    }
}