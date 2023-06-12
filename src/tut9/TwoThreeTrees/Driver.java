package tut9.TwoThreeTrees;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoThreeTree tree = new TwoThreeTree();
		tree.add(10);
		System.out.println(tree.root);
		tree.add(20);
		System.out.println(tree.root);
		tree.add(15);
		System.out.println(tree.root);
		tree.add(12);
		System.out.println(tree.root);
		tree.add(11);
		System.out.println(tree.root);
		tree.add(21);
		System.out.println(tree.root);
		tree.add(22);
		System.out.println(tree.root);
	}

}

// Source: Dr. Stuart Thiel's implementation
