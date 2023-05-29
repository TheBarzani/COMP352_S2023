package tut6.GenericTree;

// Java Program illustrating Generic Trees
import java.util.ArrayList;
 
public class gTree {
    
    Node root; //A pointer pointing to the root of the tree
    Node curPtr; // This could be used as a navigtion pointer 

    // Simple constructor
    gTree(int data){
        root = new Node(data);
    }

    // Definition of each node
    private class Node {
        int data;
        ArrayList<Node> children; // Each Node can have as many nodes it needs
     
        Node(int data)
        {
            this.data = data;
            this.children = new ArrayList<Node>();
        }
    }
}

/**
 * This program is not complete as it requires auxiliary methods
 * to give it complementary functionality.
 */
