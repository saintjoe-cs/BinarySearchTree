package edu.saintjoe.cs.brianc.binarytree;

public class BinarySearchTree {
	
	public class Node {
		int x;

		Node left;
		Node right;
		Node parent;

		// Constructor to save us some time
		Node (int value) {
			this.x = value;
			this.right = this.left = null;
			}
		}
		
	int n = 0; // Number of nodes allocated
	// Root of the tree
	Node r;
		
	// The "null" node is called nil
	Node nil;

	Node newNode(int x) {
		Node u = new Node(x);
		n++;
		return u;
		} // end newNode
	
	int depth(Node u) {
		int d = 0;
		while (u != r) {
			u = u.parent;
			d++;
		}
		return d;
	}// end depth()
		
	int size(Node u) {
		if (u == nil) return 0;
		return 1 + size(u.left) + size(u.right);
		} // end size()
		
	int height(Node u) {
		if (u == nil) return -1;
		return 1 + Math.max(height(u.left), height(u.right));
		} // end height

	void traverse(Node u) {
		if (u == nil) return;
		System.out.println(u.x);
		// Commented-out code allows us to see external nodes too
		// System.out.print("Left: ");
		traverse(u.left);
		// System.out.print("Right: ");
		// System.out.println(u.x);
		traverse(u.right);
		// System.out.println(u.x);
	} // end traverse()
		
	// Book code requires find() to return an Object
	Integer find(int x) {
		Node p = r, q = nil;
		while (p != nil) {
			int comp = compare(x, p.x);
			if (comp < 0) {
				q = p;
				p = p.left;
			} else if (comp > 0) {
				p = p.right;
			} else {
				return Integer.valueOf(p.x);
			} // end if
		} // end while
		return q == nil ? null : Integer.valueOf(q.x);
	}// end find()
	
	Integer findEQ(int x) {
		Node u = r;
		while (u != nil) {
		int comp = compare(x, u.x);
		if (comp < 0)
			u = u.left;
		else if (comp > 0)
			u = u.right;
		else
			return Integer.valueOf(u.x);
			}
		return null;
		}

	boolean add(int x) {
		Node p = findLast(x);
		return addChild(p, new Node(x));
		} // end add()
		
	boolean addChild(Node p, Node u) {
		if (p == nil) {
			r = u; // inserting into empty tree
		} else {
			int comp = compare(u.x, p.x);
			if (comp < 0) {
			 p.left = u;
			} else if (comp > 0) {
				p.right = u;
			} else {
				return false; // u.x is already in the tree
				}
		u.parent = p;
		}
		n++;
		return true;
	} // end addChild()

	Node findLast(int x) {
		Node w = r, prev = nil;
		while (w != nil) {
			prev = w;
			int comp = compare(x, w.x);
			if (comp < 0) {
				w = w.left;
			} else if (comp > 0) {
				w = w.right;
			} else {
				return w;
				}
			}
			return prev;
			} // end findLast
		
	int compare (int x, int y) {
		if (x == y)
			return 0;
		return x > y?1:-1;
	} // end compare

	void splice(Node u) {
		Node s, p;
		if (u.left != nil) {
			s = u.left;
		} else {
			s = u.right;
			}
		if (u == r) {
			r = s;
			p = nil;
		} else {
			p = u.parent;
		if (p.left == u) {
			p.left = s;
		} else {
			p.right = s;
			}
		}
		if (s != nil) {
			s.parent = p;
		}
		n--;
	} // end splice()

	void remove(Node u) {
		if (u.left == nil || u.right == nil) {
			splice(u);
		} else {
			Node w = u.right;
		while (w.left != nil)
			w = w.left;
		u.x = w.x;
		splice(w);
		}
	} // end remove()
} // end BinaryTree class
