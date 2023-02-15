// Implement queue using linkedlist



public class QueueLinkedList{

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Queue{

        static Node head = null;
        static Node tail = null;
        


        public boolean isEmpty(){
            return head == null && tail == null;
        }


        // enqueue 0(1)
        public void add(int data){
           Node newNode = new Node(data);
        //    add first node
        if(tail == null){
            tail = head = newNode;
            return;
        }
           tail.next = newNode;
           tail = newNode;

        }

        // dequeue - 0(1)
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
           int result = head.data;
        //    single linkedlist;
        if(head == tail){
            // tail = null
             tail = null;
        }
           head = head.next;
        
            return result;
            
        }

        // peek- 0(1)

        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return head.data;
        

        }


    }
    public static void main(String args[]) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
       
        q.add(5);
        
        q.add(6);
        


        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

         
    }
   
}