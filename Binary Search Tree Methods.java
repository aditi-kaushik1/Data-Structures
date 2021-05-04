/* Exercises
1- Implement a method to calculate the size of a binary tree. 
Solution: Tree.size() 
2- Implement a method to count the number of leaves in a binary tree. 
Solution: Tree.countLeaves() 
3- Implement a method to return the maximum value in a binary search 
tree using recursion. 
Solution: Tree.max() 
4- Implement a method to check for the existence of a value in a binary 
tree using recursion. Compare this method with the find() method. The 
find() method does the same job using iteration. 
Solution: Tree.contains() 
5- Implement a method to check to see if two values are siblings in a 
binary tree. 
Solution: Tree.areSibling() 6- Implement a method to return the ancestors of a value in a 
List<Integer>. 
Solution: Tree.getAncestors() */

package com.codewithaditi;

import java.util.*;

public class Tree {
	private class Node {
		int value;
		Node leftChild;
		Node rightChild;

		Node(int value) {
			this.value = value;
		}
	}

	Node root;

	public void insert(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		while (true) {
			if (value < current.value) {
				if (current.leftChild == null) {
					current.leftChild = newNode;
					break;
				}
				current = current.leftChild;
			} else {
				if (current.rightChild == null) {
					current.rightChild = newNode;
					break;
				}
				current = current.rightChild;
			}
		}
	}

	public boolean get(int value) {
		Node current = root;
		while (current != null) {
			if (value == current.value)
				return true;
			else if (value < current.value)
				current = current.leftChild;
			else
				current = current.rightChild;
		}
		return false;
	}

	public void traversePreorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		traversePreorder(root.leftChild);
		traversePreorder(root.rightChild);
	}

	public void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.leftChild);
		System.out.print(root.value + " ");
		inorder(root.rightChild);
	}

	public void postorder(Node root) {
		if (root == null)
			return;
		postorder(root.leftChild);
		postorder(root.rightChild);
		System.out.print(root.value + " ");
	}

	// PostOrder traversal used
	public int height(Node root) {
		if (root == null)
			return -1;
		if (root.leftChild == null && root.rightChild == null)
			return 0;
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	// O(log(n))
	public int minimum(Node root) {
		if (root == null)
			return -1;
		else if (root.leftChild == null)
			return root.value;
		else
			return minimum(root.leftChild);
	}

	public int max(Node root) {
		if (root == null)
			throw new IllegalArgumentException();
		else if (root.rightChild == null)
			return root.value;
		else
			return max(root.rightChild);
	}

	public int findMinIterative(Node root) {
		Node current = root;
		if (root == null)
			return -1;
		while (current.leftChild != null)
			current = current.leftChild;
		return current.value;
	}

	public int findMaxIterative(Node root) {
		Node current = root;
		if (root == null)
			throw new IllegalStateException();
		while (current.rightChild != null)
			current = current.rightChild;
		return current.value;
	}

	// O(n)
	public int findMinInBinaryTree(Node root) {
		// If it is leaf, then store it's value.
		if (root.leftChild == null && root.rightChild == null)
			return root.value;
		int left = root.leftChild != null ? findMinInBinaryTree(root.leftChild) : Integer.MAX_VALUE;
		int right = root.rightChild != null ? findMinInBinaryTree(root.rightChild) : Integer.MAX_VALUE;

		return Math.min(Math.min(left, right), root.value);
	}

	public boolean equals(Tree tree) {
		if (tree == null)
			return false;
		return equals(root, tree.root);
	}

	// PreOrder traversal is used.
	private boolean equals(Node first, Node second) {
		if (first == null && second == null)
			return true;

		else if (first != null && second != null)
			return first.value == second.value && equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);

		// One is null and the other is not null
		else
			return false;
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// PreOrder traversal
	private boolean isBinarySearchTree(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.value < min || root.value > max)
			return false;
		return isBinarySearchTree(root.leftChild, min, root.value - 1)
				&& isBinarySearchTree(root.rightChild, root.value + 1, max);
	}

	public void swapRoot() {
		Node temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
	}

	public List<Integer> nodesAtkDistance(Node root, int distance) {
		List<Integer> list = new ArrayList<>();
		nodesAtkDistance(root, distance, list);
		return list;
	}

	private void nodesAtkDistance(Node root, int distance, List<Integer> list) {
		if (root == null)
			return;

		if (distance == 0)
			list.add(root.value);

		nodesAtkDistance(root.leftChild, distance - 1, list);
		nodesAtkDistance(root.rightChild, distance - 1, list);
	}

	public void levelOrderTraversal() {
		int height = height1(root);
		for (int distance = 0; distance <= height; distance++) {
			System.out.println(nodesAtkDistance(root, distance));
		}
	}

	public int height1(Node root) {
		if (root == null)
			return -1;
		if (root.leftChild == null && root.rightChild == null)
			return 0;
		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	public boolean isLeaf(Node x) {
		return x.leftChild == null && x.rightChild == null;
	}

	public int size(Node root) {
		if (root == null)
			return 0;
		return 1 + size(root.leftChild) + size(root.rightChild);
	}

	public int countLeaves(Node root) {
		if (root == null)
			return 0;
		else if (root.leftChild == null && root.rightChild == null)
			return 1;
		return countLeaves(root.leftChild) + countLeaves(root.rightChild);
	}

	// O(n)
	public boolean contains(Node root, int x) {
		if (root == null)
			return false;
		else if (root.value == x)
			return true;
		return contains(root.leftChild, x) || contains(root.rightChild, x);
	}

	// O(log(n))
	public boolean containsIt(Node root, int x) {
		if (root == null)
			return false;
		Node current = root;
		while (current != null) {
			if (current.value == x)
				return true;
			else if (x < current.value)
				current = current.leftChild;
			else
				current = current.rightChild;
		}
		return false;
	}

	public boolean areSiblings(int x1, int x2) {
		if(!contains(root, x1) || !contains(root, x2))
			return false;
		int small = Math.min(x1, x2);
		int large = Math.max(x1, x2);
		Node current = root;
		while(current != null) {
			if(large < current.value)
				current = current.leftChild;
			else if(small > current.value)
				current = current.rightChild;
			else {
				if(current.leftChild.value == small && current.rightChild.value == large)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	List<Integer> list = new ArrayList<>();

	public List<Integer> ancestors(Node root, int x) {
		if (!contains(root, x))
			return list;
		Node current = root;
		while(current != null) {
			if(current.value == x)
				return list;
			else if(x < current.value) {
				list.add(current.value);
				current = current.leftChild;
			}
			else {
				list.add(current.value);
				current = current.rightChild;
			}
		}
		return list;
	}
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------

package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(7);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(8);
		tree.insert(10);
//		System.out.println(tree.nodesAtkDistance(tree.root, 2));
//		System.out.println("***************************");
//		tree.levelOrderTraversal();
//		System.out.println(tree.isLeaf(tree.root));
		//System.out.println(tree.size(tree.root));
		//System.out.println("No. of leaves : " + tree.countLeaves(tree.root));
		//System.out.println("The tree contains 100 : " + tree.containsIt(tree.root, 100));
		System.out.println(tree.ancestors(tree.root,10));
		System.out.println(tree.areSiblings(10, 70));
		
		//tree.swapRoot();
		//System.out.println("Validate :" + tree.isBinarySearchTree());
//		System.out.println(tree.get(10));
//		System.out.println(fact(3));
//		tree.traversePreorder(tree.root);
//		System.out.println("Preorder traversal");
//		tree.inorder(tree.root);
//		System.out.println("Inorder traversal");
//		tree.postorder(tree.root);
//		System.out.println("Postorder traversal");
//		System.out.println(tree.height(tree.root));
//		System.out.println(tree.findMinInBinaryTree(tree.root));
		
		//Tree tree2 = new Tree();
		//tree2.insert(7);
//		tree2.insert(4);
//		tree2.insert(9);
//		tree2.insert(1);
//		tree2.insert(6);
//		tree2.insert(8);
//		tree2.insert(10);
		
		//System.out.println(tree.equals(null));
	}
	
	public static int fact(int x) {
		if(x == 0)
			return 1;
		if(x < 0)
			throw new IllegalStateException();
		int ans = 1;
		for(int i = x; i > 0; i--) {
			ans *= i;
		}
		return ans;
	}
	
	public static int factRec(int x) {
		if(x == 1 || x == 0)
			return 1;
		return x * factRec(x-1);
	}
}
