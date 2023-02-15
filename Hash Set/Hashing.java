import java.util.HashSet;
import java.util.Iterator;
public class Hashing{




    /**
     * @param args
     */
    public static void main(String args[]) {

        HashSet<Integer> set = new HashSet<>();
        

        // Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        set.add(4 );

        // search-contains
        if(set.contains(1)){
            System.out.println("exit");
        };

        if(!set.contains(6)){
            System.out.println("does not contain");
        }
        
        // Delete
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("remove working");
        }
        
        System.out.println(set.size());
        System.out.println(set);


        // iterator
        Iterator it = set.iterator();
        // hasnext
        while(it.hasNext()){
            // next
            System.out.println(it.next());
            
        }




        
    }
}