import java.util.*;

class Tree1{

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


     int ind = -1;
    public   Node BuildTree(int a[]){
        ind++;
        if(a[ind] == -1) return null;

        Node newNode = new Node(a[ind]);
        newNode.left = BuildTree(a);
        newNode.right = BuildTree(a);
        return newNode;
    }

    // preOrder = root --> left --> right

     public void preOrder(Node root){

        if(root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
     }


    // inOrder  = left --> root --> right
     
    public void inOrder(Node root){

        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    // postOrder = left --> right --> root

    public void postOrder(Node root){

        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

       // height
       public int height(Node root){

        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right))+1; 
       }


       // number of node

       public int Count(Node root){
        if(root == null) return 0;
        return Count(root.left) + Count(root.right) + 1;
       }
       // sum of allt he node'
       public int Sum(Node root){          
         if(root == null) return 0;
         return Sum(root.left)+Sum(root.right)+root.data;
       }
       // diameter of node
       // 

       public int Diameter(Node root){

          if(root == null) return 0;
          int ans = 0;
           ans = Math.max(ans,(height(root.left)+height(root.right)+1));
          return ans;

       }

       // level Order

       public void Level_Order(Node root){
        // using queue
         Queue<Node> q = new LinkedList<>(); 
         // storing element in queue
         q.add(root);
         // storing element in queue as null for next line
         q.add(null);
       
         // base case if no element is there.
         if(root == null) return;

         // run the while loop until q.isEmpty()
         while(!q.isEmpty()){
            // storing the current node of queue and remove element
          Node cur = q.remove();
           
          // below code used for printing the nextLine
            if(cur == null) {
                System.out.println(" ");
                // if the queue is Empty , it means that there is no element
                if(q.isEmpty()){
                    break;
                }
                // if queue not empty then add null , for printing next line
                else{
                    q.add(null);
                }
            }
            else{
            System.out.print(cur.data+" ");
            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
     }
           

 }



// diameter = longest connected node. which can be height, rh+lh+1

public int diameter(Node root){

    if(root == null) return 0;

    int l_d = diameter(root.left);
    int l_h = height(root.left);
    int r_d = diameter(root.right);
    int r_h = height(root.right);

    int ans = l_h + r_h+1;
    return Math.max(ans, Math.max(l_d,r_d));    
}

class Info{

    int h;
    int d;

    Info(int h,int d){
        this.h = h;
        this.d = d;
    }
}

public Info Opti_d(Node root){
    if( root == null){
       return new Info(0,0);
    }
    
    Info left = Opti_d(root.left);
    Info right = Opti_d(root.right);

    int ht = Math.max(left.h, right.h)+1;
    int dia = Math.max( Math.max(left.d, right.d) , left.h+right.h+1);
    return new Info(ht,dia);
}




 public void TopVeiw(Node root){

  HashMap<Integer,Integer> map = new HashMap<>();
 map.put(0,root.data);

 while(!map.isEmpty()){

   

 }



 }

    public static void main(String args[]){
        int a[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        //       1
 //          2         3   
 //      4      5          6

 // lets try to make the build tree function

       Tree1 tree = new Tree1();
       Node n = tree.BuildTree(a);
      
      System.out.println(n.data);
      System.out.println(tree.Count(n));
      System.out.println(tree.Sum(n));
      System.out.println(tree.height(n));
      System.out.println(tree.diameter(n));
      System.out.println("LevelOrder");
      tree.Level_Order(n);

      
    }
}