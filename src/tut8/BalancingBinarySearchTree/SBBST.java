package tut8.BalancingBinarySearchTree;

/*
 *  Java Program to Implement Self Balancing Binary Search Tree
 */
 
import java.util.Scanner;
 
 /* Class Node */
class Node
{    
    Node left, right;
    int data;
    int height;

    /* Constructor */
    public Node()
    {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }
    /* Constructor */
    public Node(int n)
    {
        left = null;
        right = null;
        data = n;
        height = 0;
    }     
}

/* Class SBBST */
class SBBST
{
    private Node root;     

    /* Constructor */
    public SBBST()
    {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }

    /* Make the tree logically empty */
    public void clear()
    {
        root = null;
    }
    /* Function to insert data */
    public void insert(int data)
    {
        root = insert(data, root);
    }
    /* Function to get height of node */
    private int height(Node t )
    {
        return t == null ? -1 : t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    /* Function to insert data recursively */
    private Node insert(int x, Node t)
    {
        if (t == null)
            t = new Node(x);
        else if (x < t.data)
        {
            t.left = insert( x, t.left );
            if (height( t.left ) - height( t.right ) == 2)
                if (x < t.left.data)
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if (x > t.data)
        {
            t.right = insert( x, t.right );
            if (height( t.right ) - height( t.left ) == 2)
                if (x > t.right.data)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
        ;  // Duplicate; do nothing
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    /* Rotate binary tree node with left child */     
    private Node rotateWithLeftChild(Node k2)
    {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private Node rotateWithRightChild(Node k1)
    {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
    * with its right child; then node k3 with new left child */
    private Node doubleWithLeftChild(Node k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
    * with its left child; then node k1 with new right child */      
    private Node doubleWithRightChild(Node k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }    
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(Node r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }
    private boolean search(Node r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.data;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(Node r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node r)
    {
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }     

    public static void main(String[] args)
    {            
        Scanner myScan = new Scanner(System.in);
        /* Creating object of SBBST */
        SBBST sbbst = new SBBST(); 
        System.out.println("Self-Balancing Binary Search Tree Test\n");          
        char ch;
        
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\nSelf-Balancing Binary Search Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear tree");
 
            int choice = myScan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                sbbst.insert( myScan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ sbbst.search( myScan.nextInt() ));
                break;                                          
            case 3 : 
                System.out.println("Nodes = "+ sbbst.countNodes());
                break;     
            case 4 : 
                System.out.println("Empty status = "+ sbbst.isEmpty());
                break;     
            case 5 : 
                System.out.println("\nTree Cleared");
                sbbst.clear();
                break;         
            default : 
                System.out.println("Wrong Entry \n "); 
                break;   
            }
            /*  Display tree  */  
            System.out.print("\nPost order : ");
            sbbst.postorder();
            System.out.print("\nPre order : ");
            sbbst.preorder();
            System.out.print("\nIn order : ");
            sbbst.inorder();
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = myScan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}

// Inspired by: https://www.sanfoundry.com/java-program-implement-self-balancing-binary-search-tree/ 