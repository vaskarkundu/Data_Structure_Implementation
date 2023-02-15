// Implementation of circular queue using array

public class CircularQueue {
    static class Queue{
        static int arr[];
         int size;
        static int rear = -1;
        static int front = -1;

        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public boolean isFull(){
            return (rear+1)% size == front;
        }

        // enqueue 0(1)
        public void add(int data){
            if(isFull()){
                System.out.println("full queue");
                return;
            }
            // add 1st element
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear]=data;
        }

        // dequeue - 0(1)
        public int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int result = arr[front];
            // single elment conditions
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front + 1) % size;
            }
        
            return result;
            
        }

        // peek- 0(1)

        public int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
        

        }


    }
    public static void main(String args[]) {

        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        


        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

         
    }
    
}
