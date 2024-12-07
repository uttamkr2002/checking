import java.util.*;
public class Tree3 {
    

    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
            right = null;
            left = null;
        }
    }
    
     static int i = -1;
    public static Node Create_Tree(int a[]){
          i++;
         if(a[i] == -1) return null;
         Node root = new Node(a[i]);
         root.left = Create_Tree(a);
         root.right = Create_Tree(a);
         return root;          
    }


    public static void tree_Print(Node root){
       // inorder.
        if(root == null) return;
        tree_Print(root.left);
        System.out.print(root.data + " ");
        tree_Print(root.right);
    }

    public static void level_Order(Node root){

        // we will take a queue
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(q.isEmpty()){

           // check whether q.pop is null or not
           Node temp = q.remove();

           if(temp == null) {
              // lets go to next line
              System.out.println();
              if(q.isEmpty()) return;
              q.add(null);
           }
           else{
            System.out.print(temp.data + " ");
             if(temp.left != null) q.add(temp.left);
             if(temp.right != null) q.add(temp.right);
           }

        }
    }

    public static void main(String args[]){

        int a[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
         Node root = Create_Tree(a);
         tree_Print(root);
         System.out.println("The root is:- "+root.data); 
         level_Order(root);

    }
}
