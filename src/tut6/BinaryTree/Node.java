package tut6.BinaryTree;

public class Node {
    int data;
    public Node leftChild, rightChild;
  
    Node(int item) {
    data = item;
    leftChild = rightChild = null;
    }

    int getData(){
        return this.data;
    }
}
