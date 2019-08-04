/*
/*
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

Example
Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
return the node 11.

*/



public class MaximumAverageNode {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.root.left = new BinaryTreeNode(-5);
		tree.root.right = new BinaryTreeNode(11);
		tree.root.left.left = new BinaryTreeNode(1);
		tree.root.left.right = new BinaryTreeNode(2);
		tree.root.right.left = new BinaryTreeNode(4);
		tree.root.right.right = new BinaryTreeNode(-2);
		BinaryTreeNode tempNode = tree.root;
		int averageNode = Integer.MIN_VALUE, value = 0;
		while( tempNode.left != null) {
			BinaryTreeNode internaltempNode = tempNode;
			int sum = findSumOftheTree(internaltempNode.left);
			internaltempNode = tempNode;
			int height = findHeightOftheTree(internaltempNode.left);
			int avg = sum/height;
			if(averageNode < avg) {
				averageNode = avg;
				value = tempNode.left.data;
			}
			tempNode = tempNode.left.left;
		}
		 tempNode = tree.root;
		while( tempNode.right != null) {
			BinaryTreeNode internaltempNode = tempNode;
			int sum = findSumOftheTree(internaltempNode.right);
			internaltempNode = tempNode;
			int height = findHeightOftheTree(internaltempNode.right) ;
			int avg = sum/height;
			if(averageNode < avg) {
				averageNode = avg;
				value = tempNode.right.data;
			}
			tempNode = tempNode.right.right;
		}
		System.out.println(value);
		
	}
	
	private static int findSumOftheTree(BinaryTreeNode tree ) {
		if(tree.left == null || tree.right == null) {
			return tree.data;
		}
		return tree.data + findSumOftheTree(tree.left) + findSumOftheTree(tree.right);		
	}
	
	private static int findHeightOftheTree(BinaryTreeNode tree) {
		if(tree.left == null || tree.right == null) {
			return 0;
		}
		int left = findHeightOftheTree(tree.left) + 1;		
		int right = findHeightOftheTree(tree.right) +1;
		return left> right ? left : right ;
	}

	public static class BinaryTree {
		BinaryTreeNode root;
		
		public BinaryTree(int data) {
			root = new BinaryTreeNode(data);
		}
		
		public BinaryTree() 
	    { 
	        root = null; 
	    } 
	}
	
	public static class BinaryTreeNode{
		BinaryTreeNode left,right;
		int data;
		public BinaryTreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
		public BinaryTreeNode getLeft() {
			return left;
		}
		public void setLeft(BinaryTreeNode left) {
			this.left = left;
		}
		public BinaryTreeNode getRight() {
			return right;
		}
		public void setRight(BinaryTreeNode right) {
			this.right = right;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}	
		
	}

}
