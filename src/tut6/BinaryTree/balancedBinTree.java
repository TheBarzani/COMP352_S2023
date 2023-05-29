package tut6.BinaryTree;


class balancedBinTree {
    Node root;
 
    /* Returns true if binary tree with root as root is
     * height-balanced */
    boolean isBalanced(Node node)
    {
        int lh; /* for height of leftChild subtree */
 
        int rh; /* for height of rightChild subtree */
 
        /* If tree is empty then return true */
        if (node == null)
            return true;
 
        /* Get the height of leftChild and rightChild sub trees */
        lh = height(node.leftChild);
        rh = height(node.rightChild);
 
        if (Math.abs(lh - rh) <= 1 && isBalanced(node.leftChild)
            && isBalanced(node.rightChild))
            return true;
 
        /* If we reach here then tree is not height-balanced
         */
        return false;
    }
 
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height
       is the number of nodes along the longest path from
       the root node down to the farthest leaf node.*/
    int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of
         leftChild height and rightChild heights */
        return 1
            + Math.max(height(node.leftChild),
                       height(node.rightChild));
    }
 
    public static void main(String args[])
    {
        balancedBinTree tree = new balancedBinTree();
        tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        tree.root.leftChild.leftChild.leftChild = new Node(8);
        
        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}