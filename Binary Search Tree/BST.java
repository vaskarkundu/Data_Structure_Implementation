// import javax.lang.model.util.ElementScanner14;

public class BST{


    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
         }

     }

     

     public static Node insert(Node root, int val){
        
        if(root == null){
           root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }

        else{
            root.right = insert(root.right, val);
        }

        return root;

         
     }

     public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
     }
     

    //  search - 0(H)
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data > key){
            return search(root.left, key);

        }else if(root.data == key){
            return true;

        }else{
            return search(root.right, key);
        }
    }

    // delete

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right,val);

        }
        else{
            // no child
            if(root.left == null & root.right == null){
                return null; 

            }
            // one child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
                
            }

            // two children

            Node Is = inorderSuccessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right, Is.data);


        }

        return root;

    }

    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;

    }

    // print in range

    public static void printInRange(Node root,int X,int Y){
        if(root == null){
            return;
        }
        if(root.data >=X  && root.data <= Y){
            printInRange(root.right, X, Y);
            System.out.println(root.data+ " ");
            printInRange(root.left, X, Y);
        }
        else if(root.data >= Y){
            printInRange(root.right, X, Y);
        }else{
            printInRange(root.left, X, Y);
        }
    }
      

    public static void main(String args[]) {
        int values[]= {8,5,3,1,4,6,10,11,14};

        Node root = null;

        for(int i = 0; i<values.length; i++){
           root = insert(root, values[i]);
        
        }
        delete(root, 4 );
        inOrder(root);
        System.out.println();

        if(search(root, 5 )){
            System.out.println("found");
        }else{
            System.out.println("not found");
        };

        printInRange(root, 3, 12);

       
        
    }
}








    