package tut6.BinarySearchTree;

class BST{ 
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
    BST(){ 
        root = null; 
    } 
    //delete a node from BST
    void deleteKey(int key) { 
        root = deleteRecursive(root, key); 
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
    void inorder() { 
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
}
class Main{
    public static void main(String[] args)  { 
       //create a BST object
        BST bst = new BST(); 
        /* BST tree example
              45 
           /     \ 
          10      90 
         /  \    /   
        7   12  50   */
        //insert data into BST
        bst.insert(45); 
        bst.insert(10); 
        bst.insert(7); 
        bst.insert(12); 
        bst.insert(90); 
        bst.insert(50);
        bst.insert(60); 
        //print the BST
        System.out.println("\nThe BST Created with input data (Left-root-right):"); 
        bst.inorder(); 
        
        //delete leaf node  
        System.out.println("\nThe BST after Delete 12 (leaf node):"); 
        bst.deleteKey(12); 
        bst.inorder(); 
        //delete the node with one child
        System.out.println("\nThe BST after Delete 90 (node with 1 child):"); 
        bst.deleteKey(90); 
        bst.inorder(); 
                 
        //delete node with two children  
        System.out.println("\nThe BST after Delete 45 (Node with two children):"); 
        bst.deleteKey(45); 
        bst.inorder(); 
        //search a key in the BST
        boolean ret_val = bst.search (50);
        System.out.println("\n\nKey 50 found in BST: " + ret_val );
        ret_val = bst.search (12);
        System.out.println("Key 12 found in BST: " + ret_val + "\n");
     } 
}

//Inspired by: https://www.softwaretestinghelp.com/binary-search-tree-in-java/
