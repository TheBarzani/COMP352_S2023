package tut6.BinaryTree;

// Checking if a binary tree is a full binary tree in Java

class fullBinTree {
    
    Node root;
  
    // Check for Full Binary Tree
    boolean isFullBinaryTree(Node node) {
  
        // Checking tree emptiness
        if (node == null)
        return true;
    
        // Checking the children
        if (node.leftChild == null && node.rightChild == null)
        return true;
    
        if ((node.leftChild != null) && (node.rightChild != null))
        return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));
    
        return false;
    }
  
    public static void main(String args[]) {
      fullBinTree tree = new fullBinTree();
      tree.root = new Node(1);
      tree.root.leftChild = new Node(2);
      tree.root.rightChild = new Node(3);
      tree.root.leftChild.leftChild = new Node(4);
      tree.root.leftChild.rightChild = new Node(5);
      tree.root.rightChild.leftChild = new Node(6);
      tree.root.rightChild.rightChild = new Node(7);
      tree.root.rightChild.rightChild.leftChild = new Node(8);
  
      if (tree.isFullBinaryTree(tree.root))
        System.out.print("The tree is a full binary tree");
      else
        System.out.print("The tree is not a full binary tree");
    }
  }