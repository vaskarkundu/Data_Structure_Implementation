// Implementation of queue using collection fremwork

import java.util.*;
public class QueueC {

    public static void main(String args[]) {

        // Queue<Integer> q = new LinkedList<>(); 
        Queue<Integer> q = new ArrayDeque<>(); 

        // Note** : Interface object is not possible in java. Queue is an interface which is implenented by LinkedList and ArrayDeque Class in java
        q.add(1);
        q.add(2);
        q.add(100);
        q.add(50);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove(); 
        }
        
    }
    
}
