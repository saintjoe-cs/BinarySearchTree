package edu.saintjoe.cs.brianc.binarytree;

public class TestBinarySearchTree {
	public static void main(String[] args) {
		Integer result;
		BinarySearchTree t = new BinarySearchTree();
		// t.buildTestTree();
		// This block does the same as buildTestTree
		t.add(100);
		t.add(90);
		t.add(85);
		t.add(87);
		t.add(95);
		t.add(110);
		t.add(105);
		t.add(120);
		t.add(125);
		System.out.println("Depth: " + t.depth(t.r));
		System.out.println("Size: " + t.size(t.r));
		System.out.println("Height: " + t.height(t.r));
		System.out.println("Traversing: ");
		t.traverse(t.r);
		
		// Example of running find(x)
		if ((result = t.find(102)) != null) 
			// It was there
			System.out.println("Got " + result.intValue());
		else
			System.out.println("Value not found");
		if (t.add(115))
			t.traverse(t.r);
		t.remove(t.findLast(115));
		System.out.println("Now removed 115!!");
		t.traverse(t.r);
		System.out.println("Adding 130");
		t.add(130);
		t.traverse(t.r);
	}
}
