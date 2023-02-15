import java.util.*;

public class BinaryTreeYT{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{

        static int idx = -1;
       
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;

            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
            

        }
   
    }

     //    preOrder traversal
     public static void preOrder(Node root){

        if(root == null){
            return;
        }

        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Inorder Trevarsal - 0(n)

    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
        
    }

      // postorder Trevarsal- 0(n)

      public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
        
    }
    // Level Order traversal - 0(n)
     public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }

            }else{
                System.out.println(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);

                }
                if(currNode.right != null){
                    q.add(currNode.right);

                }

                
            }
           
        }
     }

    // count nodes - 0(n)
     public static int countNodes(Node root){

        if(root == null){
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;

     }
    // sumofNode - 0(n  )
     public static int sumOfNodes(Node root){

        if(root == null){
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;

     }

    //  Height of tree- 0(n)
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int maxhieght = Math.max(leftHeight, rightHeight) + 1;

        return maxhieght;


    }

    // /**
    //  * @param args
    //  */
    public static void main(String args[]) {

        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes); 

        //  preOrder(root);
        // inOrder(root);
        // postOrder(root);
        //  levelOrder(root);    
        // countNodes(root);  
        System.out.println(countNodes(root));  
        System.out.println(sumOfNodes(root)); 
        System.out.println(heightOfTree(root)); 
        
    }
}