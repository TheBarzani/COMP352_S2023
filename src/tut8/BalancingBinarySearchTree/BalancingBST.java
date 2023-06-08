package tut8.BalancingBinarySearchTree;

import java.util.ArrayList;

/**
 * A terrible implementation of Self-Balancing BST but
 * it serves the purpose. 
 */

class BalancingBST{ 

    //node class that defines BST node
    class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    } 
    // BST root node 
    Node root; 
  
   // Constructor for BST =>initial empty tree
    BalancingBST(){ 
        root = null; 
    } 

    //delete a node from BST
    void deleteKey(int key) { 
        root = deleteRecursive(root, key);
        root = balanceBST(root); 
    } 
   
    //recursive delete function
    Node deleteRecursive(Node root, int key)  { 
        //tree is empty
        if (root == null)  return root; 
   
        //traverse the tree
        if (key < root.key)     //traverse left subtree 
            root.left = deleteRecursive(root.left, key); 
        else if (key > root.key)  //traverse right subtree
            root.right = deleteRecursive(root.right, key); 
        else  { 
            // node contains only one child
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            root.key = minValue(root.right); 
   
            // Delete the inorder successor 
            root.right = deleteRecursive(root.right, root.key); 
        } 
        return root; 
    } 
   
    int minValue(Node root)  { 
        //initially minval = root
        int minval = root.key; 
        //find minval
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
   
    // insert a node in BST 
    void insert(int key)  { 
        root = insertRecursive(root, key);
        root = balanceBST(root);  
    } 
   
    //recursive insert function
    Node insertRecursive(Node root, int key) { 
          //tree is empty
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insertRecursive(root.left, key); 
        else if (key > root.key)    //insert in the right subtree
            root.right = insertRecursive(root.right, key); 
          // return pointer
        return root; 
    } 
 
    // method for inorder traversal of BST 
    void printInorder() { 
        inorderRecursive(root); 
    } 
   
    // recursively traverse the BST  
    void inorderRecursive(Node root) { 
        if (root != null) { 
            inorderRecursive(root.left); 
            System.out.print(root.key + " "); 
            inorderRecursive(root.right); 
        } 
    } 
     
    boolean search(int key)  { 
        root = searchRecursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
    //recursive insert function
    Node searchRecursive(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key) 
            return root; 
        // val is greater than root's key 
        if (root.key > key) 
            return searchRecursive(root.left, key); 
        // val is less than root's key 
        return searchRecursive(root.right, key); 
    }
    
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;
    
        /* first print data of node */
        System.out.print(node.key + " ");
    
        /* then recur on leftChild subtree */
        printPreorder(node.left);
    
        /* now recur on rightChild subtree */
        printPreorder(node.right);
    }
    
    // Wrappers over above recursive functions
    void printPreorder() { printPreorder(root); }

    
    /* Given a binary tree, print its nodes according to the
        "bottom-up" postorder traversal. */
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on leftChild subtree
        printPostorder(node.left);

        // then recur on rightChild subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }
    
    // Wrappers over above recursive functions
    void printPostorder() { printPostorder(root); }   


    /* Traverse and store nodes in an Array */
    private void BSTtoArray(Node root, ArrayList<Node> arr) {
        if (root == null) return;
        // Store nodes in Inorder
        BSTtoArray(root.left, arr);
        arr.add(root);
        BSTtoArray(root.right, arr);
    }

    /* Construct binary tree from an array. */
    private Node buildBinTree(ArrayList<Node> arr, int start, int end) {
        if (start > end) return null;
        /* set to the middle element. */
        int mid = (start + end) / 2;
        Node n = arr.get(mid);

        /* Construct left and right subtress. */
        n.left = buildBinTree(arr, start, mid - 1);
        n.right = buildBinTree(arr, mid + 1, end);
        return n;
    }

    /* Convert an unbalanced BST to a balanced BST */
    public Node balanceBST(Node root) {
        /* Store nodes of BST in sorted order. */
        ArrayList<Node> arr = new ArrayList<>();
        BSTtoArray(root, arr);
        /* Constructs Balanced BST from the array. */
        int n = arr.size();
        return buildBinTree(arr, 0, n - 1);
    }

}

class Main{
    public static void main(String[] args)  { 
       //create a BST object
        BalancingBST bst = new BalancingBST(); 
        /* BST tree example
              45 
           /     \ 
          10      90 
         /  \    /   
        7   12  50   */
        //insert data into BST
        bst.insert(1); 
        bst.insert(2); 
        bst.insert(3); 
        bst.insert(4); 
        bst.insert(5); 
        bst.insert(6);
        bst.insert(8); 
        //print the BST
        System.out.println("\nThe BST Created with input data (Left-root-right):"); 
        bst.printInorder(); 
        
        System.out.println(
            "\nPreorder traversal of binary tree is ");
        bst.printPreorder();
        
        System.out.println(
            "\nPostorder traversal of binary tree is ");
        bst.printPostorder();

        System.out.println("\n");

     } 
}

//Inspired by: https://www.softwaretestinghelp.com/binary-search-tree-in-java/
