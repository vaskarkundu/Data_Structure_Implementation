class LL{
    String data;
    Node head;
    private int size;
    LL(){
        this.size = 0;
    }

    class Node{
        String data;
        Node next;
        Node head;

        Node(String data){
            this.data = data;
            this.next = null;  
            size++;
        }
    }

    // add liskList - first 
    public void addFast(String data){
        Node newNode = new Node(data);

        if(head== null){
            head = newNode;
            return;

        }
        newNode.next = head;
        head = newNode;
    }

    // add - last;
    public void addLast(String data){
        Node newNode = new Node(data);

        if(head== null){
            head = newNode;

        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;

        }
        currNode.next = newNode;
    }

    // print
    public void printList(){

        if(head == null){
            System.out.println("LinkList is empty");
            return;
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("Null");

    }

    // delete First
    public void deleteFirst(){
        if(head== null){
            System.out.println("this list is empty");
            return;
        }
        size--;
        head = head.next;

    }

    // delete last
    public void deleteLast(){
        if(head== null){
            System.out.println("This list is empty");
            return;

        }
        size--;
        if(head.next == null){
            head = null;
            return;

        }
        Node currNode = head.next;
        Node lastNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
            lastNode = lastNode.next;

        }
       
        lastNode.next = null;
    }


    // size
    public int getSize(){
        return size;
    }

    // reverse iteraton
    public void reverseIterate(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;

    }

    // reverse recursive
    public Node reverseeRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
       Node newHead = reverseeRecursive(head.next);
       head.next.next = head;
       head.next = null;

       return newHead;



    }



    public static void main(String args[]) {

        LL list = new LL();
        list.addFast("4");
        list.addFast("3");
        list.addFast("2");
        list.addFast("1");
        
        
        list.printList();
        System.out.println( list.getSize() );
        // list.reverseIterate();
        list.head = list.reverseeRecursive(list.head);
        list.printList();
        
        
    }
}