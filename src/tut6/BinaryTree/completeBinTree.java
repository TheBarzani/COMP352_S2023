package tut6.BinaryTree;

class completeBinTree {
    Node root;
  
    // Count the number of nodes
    int countNumNodes(Node root) {
      if (root == null)
        return (0);
      return (1 + countNumNodes(root.leftChild) + countNumNodes(root.rightChild));
    }
  
    // Check for complete binary tree
    boolean checkComplete(Node root, int index, int numberNodes) {
  
      // Check if the tree is empty
      if (root == null)
        return true;
  
      if (index >= numberNodes)
        return false;
  
      return (checkComplete(root.leftChild, 2 * index + 1, numberNodes)
          && checkComplete(root.rightChild, 2 * index + 2, numberNodes));
    }
  
    public static void main(String args[]) {
      completeBinTree tree = new completeBinTree();
  
      tree.root = new Node(1);
      tree.root.leftChild = new Node(2);
      tree.root.rightChild = new Node(3);
      tree.root.leftChild.rightChild = new Node(5);
      tree.root.leftChild.leftChild = new Node(4);
      tree.root.rightChild.leftChild = new Node(6);
  
      int node_count = tree.countNumNodes(tree.root);
      int index = 0;
  
      if (tree.checkComplete(tree.root, index, node_count))
        System.out.println("The tree is a complete binary tree");
      else
        System.out.println("The tree is not a complete binary tree");
    }
  }
