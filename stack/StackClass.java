import java.util.ArrayList;

public class StackClass{

    // Stack implementation using linkedlist
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;

        }
    }


    static class Stack{
        public static Node head;

        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;


        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;

        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            return top;
        }

    }

     // stack implementation using arraylist
     static class _Stack{
         ArrayList<Integer> list = new ArrayList<>();

        public  boolean _isEmpty(){
            return list.size() == 0; 

        }
        //  push
        public  void push(int data){
            // if(_isEmpty()){
            // }
            list.add(data);

            //  list.add(data);
        }
        // pop
        public  int pop(){
            if(_isEmpty()){  
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);

            return top;
        }
        // peek
         public int peek(){
            if(_isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
            

            // return top;

        }

    }
    public static void main(String args[])  {

        Stack s = new Stack();
        s.push(2);
        s.push(5);
        s.push(100);
        s.push(500);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        _Stack a = new _Stack();
        a.push(2);
        a.push(15);
        a.push(10);
        a.push(50);

        while(!a._isEmpty()){
            System.out.println(a.peek());
            a.pop();
        }
        
    }

   
}