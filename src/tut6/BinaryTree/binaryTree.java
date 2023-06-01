package tut6.BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

// Java program for showing a binary tree
 
class binaryTree {
    // Root of Binary Tree
    Node root;
 
    binaryTree() { root = null; }
 
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;
 
        /* first recur on leftChildChild child */
        printInorder(node.leftChild);
 
        /* then print the data of node */
        System.out.print(node.data + " ");
 
        /* now recur on rightChild child */
        printInorder(node.rightChild);
    }
 
    // Wrappers over above recursive functions
    void printInorder() { printInorder(root); }
 
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;
    
        /* first print data of node */
        System.out.print(node.data + " ");
    
        /* then recur on leftChild subtree */
        printPreorder(node.leftChild);
    
        /* now recur on rightChild subtree */
        printPreorder(node.rightChild);
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
        printPostorder(node.leftChild);

        // then recur on rightChild subtree
        printPostorder(node.rightChild);

        // now deal with the node
        System.out.print(node.data + " ");
    }
   
    // Wrappers over above recursive functions
    void printPostorder() { printPostorder(root); }    

    /*function to insert element in binary tree */
    void insert(int key)
    {
        
        if (root == null) {
            root = new Node(key);
            return;
        }

        Node temp = root;
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.leftChild == null) {
                temp.leftChild = new Node(key);
                break;
            }
            else
                q.add(temp.leftChild);
 
            if (temp.rightChild == null) {
                temp.rightChild = new Node(key);
                break;
            }
            else
                q.add(temp.rightChild);
        }
    }    
  
    void delete(int key){
        delete(root, key);
    }

    // Function to delete deepest
    // element in binary tree
    void deleteDeepest(Node root, Node delNode)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
 
        Node temp = null;
 
        // Do level order traversal until last node
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.rightChild != null) {
                if (temp.rightChild == delNode) {
                    temp.rightChild = null;
                    return;
                }
                else
                    q.add(temp.rightChild);
            }
 
            if (temp.leftChild != null) {
                if (temp.leftChild == delNode) {
                    temp.leftChild = null;
                    return;
                }
                else
                    q.add(temp.leftChild);
            }
        }
    }
 
    // Function to delete given element
    // in binary tree
    void delete(Node root, int key)
    {
        if (root == null)
            return;
 
        if (root.leftChild == null && root.rightChild == null) {
            if (root.data == key) {
                root = null;
                return;
            }
            else
                return;
        }
 
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;
 
        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.data == key)
                keyNode = temp;
 
            if (temp.leftChild != null)
                q.add(temp.leftChild);
 
            if (temp.rightChild != null)
                q.add(temp.rightChild);
        }
 
        if (keyNode != null) {
            int x = temp.data;
            this.deleteDeepest(root, temp);
            keyNode.data = x;
        }
    }

    public boolean isBST(Node node, int minKey, int maxKey)
    {
        // base case
        if (node == null) {
            return true;
        }
 
        // if the node's value falls outside the valid range
        if (node.data < minKey || node.data > maxKey) {
            return false;
        }
 
        // recursively check left and right subtrees with an updated range
        return isBST(node.leftChild, minKey, node.data) &&
            isBST(node.rightChild, node.data, maxKey);
    }
 
    // Function to determine whether a given binary tree is a BST
    public void isBST()
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("The tree is a BST.");
        }
        else {
            System.out.println("The tree is not a BST!");
        }
    }
    
    // Driver code
    public static void main(String[] args)
    {
        binaryTree tree = new binaryTree();
        tree.root = new Node(3);
        tree.root.leftChild = new Node(1);
        tree.root.rightChild = new Node(4);
        tree.root.leftChild.leftChild = new Node(0);
        tree.root.leftChild.rightChild = new Node(2);
        

        // Function call
        System.out.println(
            "\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println(
            "\nPreorder traversal of binary tree is ");
        tree.printPreorder();
        
        System.out.println(
            "\nPostorder traversal of binary tree is ");
        tree.printPostorder();
        System.out.println();
        tree.isBST();

        System.out.println();
        // Inserting new elements and checking the tree
        System.out.println("\n\nInserting 2 new elements...");
        tree.insert(12);
        tree.insert(13);
        System.out.println(
            "Inorder traversal of binary tree is ");
        tree.printInorder(); 
        
        System.out.println("\n\ndeleteing an element...");
        tree.delete(12);
        System.out.println(
            "Inorder traversal of binary tree is ");
        tree.printInorder(); 
        System.out.println();
        tree.isBST();

    }
}
