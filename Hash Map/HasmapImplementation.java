// hashmap internally implement by java

import java.util.*;
public class HasmapImplementation {
    // @SuppressWarnings("Unchecked")
    static class HashMap<K, V> { 
        private class Node {
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
            }
        }

        private int n; // n = nodes
        private int N; // N = buckets
    
        private LinkedList<Node> buckets[]; // N = buckets.length
        private HasmapImplementation.HashMap<String, Integer> map;
        @SuppressWarnings("Unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();

            }
        }

        private int hashfunction(K key){
            // bucket index must have 0 to N-1
            int bi = key.hashCode();
           return Math.abs(bi) % N;

        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];

            for(int i= 0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }


            }
            return -1;

        }

        // have to write rehash fun here and start again
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i = 0; i<N*2; i++){
                buckets[i]= new LinkedList<>();
            }

            for(int i = 0; i<oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }

        // put
        public void put (K key, V value){
            int bi = hashfunction(key);
            int di = searchInLL(key,bi); // data index
            if(di == -1){ //key doesn't exits
              buckets[bi].add(new Node(key , value));
              n++;

            }else{//key exits
                Node node = buckets[bi].get(di);
                node.value = value;

            }

            double lambda = (double)n/N;
            if(lambda > 2){
                rehash();
            }



        }

        // get()
        public V get(K key){
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if(di== -1){
              return null;

            }else{
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        // containsKey()
        public boolean containsKey(K key){
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if(di== -1){
              return false;

            }else{
                
                return true;
            }

        }

        // remove
        public V remove(K key){
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if(di== -1){
              return null;

            }else{
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }

        }

        // isEmpty
        public boolean isEmpty(){
            return n==0;
        }

        // keySet
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i<buckets.length; i++){//bi
                LinkedList<Node> ll = buckets[i];

                for(int j = 0; j<ll.size(); j++){//di
                    Node node =ll.get(j);
                    keys.add(node.key);
                }

            }
            return keys;
        }

        public static void main(String args[]){
            HashMap<String, Integer> map = new HashMap<>();
            map.put("Bangladesh",16);
            map.put("USA",35);
            map.put("India",130);
            map.put("China",150);
            map.put("Australia",5);
        }

       
        ArrayList<String> keys = map.keySet();
        for(int i = 0; i<keys.size(); i++){
            System.out.println(keys.get(i)+ "" + map.get(keys.get(i)));
        }

    }
    
}}
