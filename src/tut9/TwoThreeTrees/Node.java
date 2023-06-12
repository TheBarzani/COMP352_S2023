package tut9.TwoThreeTrees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node {
	List<Integer> vals = new LinkedList<Integer>();
	List<Node> children = new LinkedList<Node>();

	
	Node(Integer val) {
		vals.add(val);
	}
	
	Node(Integer val, Node left, Node right) {
		vals.add(val);
		children.add(left);
		children.add(right);
	}

	public Node add(Integer val) {
		if(children.isEmpty()) {
			//we're at a leaf, so we add it to the node, then re-sort 'cause we're lazy
			vals.add(val);
			Collections.sort(vals);
		} else {
			Node potentiallySplit = null;
			int i = 0;
			//Figure out which child we need to add to (the ith child)
			for(; i < vals.size() && val.compareTo(vals.get(i)) != -1; ++i) {}
			
			//Add to that child and get the returned node, which is potentially promoted
			potentiallySplit = children.get(i).add(val);
			
			//If it's different from what it was, it's promoted and we need to re-integrate that
			if( children.get(i) != potentiallySplit) {
				//Add a new value at the ith position since something was promoted
				vals.add(i,potentiallySplit.vals.get(0));
				//Remove the old single child
				children.remove(i);
				//Add the two replacement children
				children.addAll(i, potentiallySplit.children);
			}
		
		}
		
		//If we're too big, we need to promote something, otherwise we just return ourself
		return vals.size() > 2?split():this;
	}

	/*
	 * This node has three vals and four children
	 * Promote the middle val to a new node with the
	 * appropraite corresponding two children
	 */
	private Node split() {
		Node left = null, right = null;
		if(children.isEmpty()) {
			left = new Node(vals.get(0));
			right = new Node(vals.get(2));
		} else {
			left = new Node(vals.get(0), 
				children.get(0), 
				children.get(1));
			right = new Node(vals.get(2), 
				children.get(2), 
				children.get(3));
		}
		Integer toPromote = vals.get(1);
		Node newNode = new Node(toPromote, left, right);
		return newNode;
	}	
	
	@Override
	public String toString() {
		return "\t" + vals + " " + children;
	}
	
}

// Source: Dr. Stuart Thiel's implementation
