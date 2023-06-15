package tut9.RedBlackTrees;

// Implementing Red-Black Tree in Java
  
public class RedBlackTree {
  private Node root;
  private Node TNULL; // NULL leaf nodes (does not have a key but it has color)

  // Node class representing a node
  private class Node {
      int data;
      Node parent;
      Node left;
      Node right;
      int color;
  }

  // Constructor for the tree
  public RedBlackTree() {
      TNULL = new Node();
      TNULL.color = 0;
      TNULL.left = null;
      TNULL.right = null;
      root = TNULL;
  }



  //=======INSERTION=======
  /**
   * This insertion algorithm follows the following methodology:
   * 1. Node y is a NULL leaf and Node x is the root
   * 2. Traverse to the location for inserting
   * 3. Once a NULL leaf node is reached, insert the new Node
   * 4. Assign the parent of the NULL lead node as the parent of the new Node
   * 5. Assign the new Node to the left or right of its parent 
   * 6. Make the left and right child of the new Node NULL leaves
   * 7. Assign RED to the new Node
   * 8. InsertFix to maintain the balancing property if violated
   * 
   * (Newly inserted Nodes are always red to maintain property 4 & 5 (Refer to the 
   * accompanied slides.))
   * 
   * @param key The key to insert 
   */
  public void insert(int key) {

      // A simple insertion happens here until the end where the insertion is fixed 
      Node insertNode = new Node();
      insertNode.parent = null;
      insertNode.data = key;
      insertNode.left = TNULL;
      insertNode.right = TNULL;
      insertNode.color = 1;

      Node nil = null;
      Node curr = this.root;

      while (curr != TNULL) {
        nil = curr; // nil takes its parent
        if (insertNode.data < curr.data) {
          curr = curr.left;
        } else {
          curr = curr.right;
        }
      }

      insertNode.parent = nil; // Assign nil (parent of the leaf) as the parent of the new Node

      //Insert at the correct position relative to the parent
      if (nil == null) {
        root = insertNode;
      } else if (insertNode.data < nil.data) {
        nil.left = insertNode;
      } else {
        nil.right = insertNode;
      }

      if (insertNode.parent == null) {
        insertNode.color = 0;
        return;
      }// If inserted at the root

      if (insertNode.parent.parent == null) {
        return;
      } // If inserted at level 1, just return

      fixInsert(insertNode);
  }

  /**
   * This algorithm is used to fix any violations induced after insertion:
   * 1. If the parent of the inserted node is BLACK, then do nothing, else run in while loop
   * 2. If the parent is the left child of the grandparent then do the following
   *      a. If the color of the right child of the grandparent is RED, set the color of both children 
   *         of the grandparent as BLACK and the grandparent becomes RED
   *      b. The current Node (newNode) becomes grandparent and the while loop progresses
   *      c. Else,
   *          i. (Special Case) If the newNode is right child of its parent, then assign 
   *             the parent node to be the current Node (newNode), then do a left rotation on the newNode
   *          ii. Set the color of the parent as BLACK and the grandparent as RED, then do a right rotation
   *              on the grandparent
   * 3. Else,
   *      a. If the color of the right child of the grandparent is RED, set the color of both children 
   *         of the grandparent as BLACK and the grandparent becomes RED
   *      b. The current Node (newNode) becomes grandparent and the while loop progresses
   *      c. Else,
   *          i. (Special Case) If the newNode is left child of its parent, then assign 
   *             the parent node to be the current Node (newNode), then do a right rotation on the newNode
   *          ii. Set the color of the parent as BLACK and the grandparent as RED, then do a left rotation
   *              on the grandparent
   * 4. Set the root back to black in case it has changed
   * @param newNode The inserted node
   */

  // Balance the node after insertion
  private void fixInsert(Node newNode) {
      Node uncle;
      while (newNode.parent.color == 1) {
          if (newNode.parent == newNode.parent.parent.left) {
              uncle = newNode.parent.parent.right;
      
              if (uncle.color == 1) {
                  uncle.color = 0;
                  newNode.parent.color = 0;
                  newNode.parent.parent.color = 1;
                  newNode = newNode.parent.parent;
              } else {
                  if (newNode == newNode.parent.right) {
                      newNode = newNode.parent;
                      leftRotate(newNode);
                  }
                  newNode.parent.color = 0;
                  newNode.parent.parent.color = 1;
                  rightRotate(newNode.parent.parent);
              }
          } else {

              uncle = newNode.parent.parent.left;
              if (uncle.color == 1) {
                  uncle.color = 0;
                  newNode.parent.color = 0;
                  newNode.parent.parent.color = 1;
                  newNode = newNode.parent.parent;
              } else {
                  if (newNode == newNode.parent.left) {
                      newNode = newNode.parent;
                      rightRotate(newNode);
                  }
                  newNode.parent.color = 0;
                  newNode.parent.parent.color = 1;
                  leftRotate(newNode.parent.parent);
              }

          }

          if (newNode == root) {
              break;
          }
      }
      root.color = 0;
  }


  //=======DELETION=======
  // Wrapper for the deleteNode
  public void delete(int data) {
      deleteNode(this.root, data);
  }

  // Helper method to delete on a subtree node
  private void deleteNode(Node node, int key) {
      Node nodeToDelete = TNULL;
      Node temp, copy;

      // Find the node containining the Key and assign it to the nodeToDelete
      while (node != TNULL) {
          if (node.data == key) {
              nodeToDelete = node;
          }
      
          if (node.data <= key) {
              node = node.right;
          } else {
              node = node.left;
          }
      }

      if (nodeToDelete == TNULL) {
          System.out.println("Couldn't find key in the tree");
          return;
      }

      copy = nodeToDelete; // Make a copy of the node to be deleted
      int originalColor = copy.color; // Make a copy of the original color as well

      // The left child is NULL, then promote its right child to become the parent
      if (nodeToDelete.left == TNULL) {
          temp = nodeToDelete.right;
          rbTransplant(nodeToDelete, nodeToDelete.right);
      } 
      // Else promote the left child, if the right child is NULL
      else if (nodeToDelete.right == TNULL) {
          temp = nodeToDelete.left;
          rbTransplant(nodeToDelete, nodeToDelete.left);
      } 
      // If both children are not NULL do the following
      else {
          // Get the minimum of the right subtree and make a copy
          copy = minimum(nodeToDelete.right);

          // Save the color of the minimum
          originalColor = copy.color;

          // temporarily make a copy of the right right child of the minimum
          temp = copy.right;

          // Case: the minimum is the child of the node to delete 
          if (copy.parent == nodeToDelete) {
              // Make sure minimum is the parent of its right child
              temp.parent = copy;
          } else {
              // Tansplant the minimum with its right children
              rbTransplant(copy, copy.right);
              copy.right = nodeToDelete.right;
              copy.right.parent = copy;
          }

          // Transplant the node to be deleted with the configured minimum (copy)
          rbTransplant(nodeToDelete, copy);
          copy.left = nodeToDelete.left;
          copy.left.parent = copy;
          copy.color = nodeToDelete.color;
      }

      // if the the original color was black, fix the deletion for property 4
      if (originalColor == 0) {
          fixDelete(temp);
      }
  }


  // Multiple rotations happen similar to the insertion,
  // This is best explained through performing the instructions 
  // Balance the tree after deletion of a node
  private void fixDelete(Node x) {
    Node s;
    while (x != root && x.color == 0) {
      if (x == x.parent.left) {
        s = x.parent.right;
        if (s.color == 1) {
          s.color = 0;
          x.parent.color = 1;
          leftRotate(x.parent);
          s = x.parent.right;
        }

        if (s.left.color == 0 && s.right.color == 0) {
          s.color = 1;
          x = x.parent;
        } else {
          if (s.right.color == 0) {
            s.left.color = 0;
            s.color = 1;
            rightRotate(s);
            s = x.parent.right;
          }

          s.color = x.parent.color;
          x.parent.color = 0;
          s.right.color = 0;
          leftRotate(x.parent);
          x = root;
        }
      } else {
        s = x.parent.left;
        if (s.color == 1) {
          s.color = 0;
          x.parent.color = 1;
          rightRotate(x.parent);
          s = x.parent.left;
        }

        if (s.right.color == 0 && s.right.color == 0) {
          s.color = 1;
          x = x.parent;
        } else {
          if (s.left.color == 0) {
            s.right.color = 0;
            s.color = 1;
            leftRotate(s);
            s = x.parent.left;
          }

          s.color = x.parent.color;
          x.parent.color = 0;
          s.left.color = 0;
          rightRotate(x.parent);
          x = root;
        }
      }
    }
    x.color = 0;
  }

  // Transplanting method that puts a node v in place of the node u 
  private void rbTransplant(Node u, Node v) {
    if (u.parent == null) {
      root = v;
    } else if (u == u.parent.left) {
      u.parent.left = v;
    } else {
      u.parent.right = v;
    }
    v.parent = u.parent;
  }


  public void leftRotate(Node x) {
      Node y = x.right;
      x.right = y.left;
      if (y.left != TNULL) {
        y.left.parent = x;
      }
      y.parent = x.parent;
      if (x.parent == null) {
        this.root = y;
      } else if (x == x.parent.left) {
        x.parent.left = y;
      } else {
        x.parent.right = y;
      }
      y.left = x;
      x.parent = y;
  }

  public void rightRotate(Node x) {
      Node y = x.left;
      x.left = y.right;
      if (y.right != TNULL) {
          y.right.parent = x;
      }
      y.parent = x.parent;
      if (x.parent == null) {
          this.root = y;
      } else if (x == x.parent.right) {
          x.parent.right = y;
      } else {
          x.parent.left = y;
      }
      y.right = x;
      x.parent = y;
  }
    
  // AUXILLIARY Methods
  private void printHelper(Node root, String indent, boolean last) {
    if (root != TNULL) {
      System.out.print(indent);
      if (last) {
        System.out.print("R----");
        indent += "   ";
      } else {
        System.out.print("L----");
        indent += "|  ";
      }

      String sColor = root.color == 1 ? "RED" : "BLACK";
      System.out.println(root.data + "(" + sColor + ")");
      printHelper(root.left, indent, false);
      printHelper(root.right, indent, true);
    }
  }

  // Preorder helper method
  private void preOrderHelper(Node node) {
      if (node != TNULL) {
          System.out.print(node.data + (node.color == 1 ? "R" : "B") + " " );
          preOrderHelper(node.left);
          preOrderHelper(node.right);
      }
  }

  // Inorder helper method
  private void inOrderHelper(Node node) {
      if (node != TNULL) {
          inOrderHelper(node.left);
          System.out.print(node.data + (node.color == 1 ? "R" : "B") + " ");
          inOrderHelper(node.right);
      }
  }

  // Post order helper method
  private void postOrderHelper(Node node) {
      if (node != TNULL) {
          postOrderHelper(node.left);
          postOrderHelper(node.right);
          System.out.print(node.data + (node.color == 1 ? "R" : "B") + " ");
      }
  }


  public void preorder() {
    preOrderHelper(this.root);
  }

  public void inorder() {
    inOrderHelper(this.root);
  }

  public void postorder() {
    postOrderHelper(this.root);
  }

  public Node minimum(Node node) {
    while (node.left != TNULL) {
      node = node.left;
    }
    return node;
  }

  public Node maximum(Node node) {
    while (node.right != TNULL) {
      node = node.right;
    }
    return node;
  }

  public Node successor(Node x) {
    if (x.right != TNULL) {
      return minimum(x.right);
    }

    Node y = x.parent;
    while (y != TNULL && x == y.right) {
      x = y;
      y = y.parent;
    }
    return y;
  }

  public Node predecessor(Node x) {
    if (x.left != TNULL) {
      return maximum(x.left);
    }

    Node y = x.parent;
    while (y != TNULL && x == y.left) {
      x = y;
      y = y.parent;
    }

    return y;
  }

  public void printTree() {
    printHelper(this.root, "", true);
  }

  public Node getRoot() {
      return this.root;
  }

    // Search the tree helper method
  private Node searchTreeHelper(Node node, int key) {
      if (node == TNULL || key == node.data) {
          return node;
      }

      if (key < node.data) {
          return searchTreeHelper(node.left, key);
      }
      return searchTreeHelper(node.right, key);
  }

  public Node searchTree(int k) {
    return searchTreeHelper(this.root, k);
  }

  public static void main(String[] args) {
    RedBlackTree bst = new RedBlackTree();
    bst.insert(3);
    bst.insert(2);
    bst.insert(4);
    bst.insert(1);
    bst.printTree();

    bst.preorder();
  }
}

  // Code semi-inspired by: https://www.programiz.com/dsa/red-black-tree 