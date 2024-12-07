public class Tree2 {
    
    class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static void InOrder(Node root){

        if(root == null)return;
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

     public static Double(Node root, Node temp){

        if(root == null) return;
        Double(root.left, temp.left);
        Double(root.right, temp.right);

           Node newNode = new Node(root.data);
           newNode.left = root.left;
            root.left = newNode;

     }


    public static void main(String args[]){
          
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        Node temp = root;
         
        InOrder(root);
        Double(root, temp);
        InOrder( temp);
    }
}
