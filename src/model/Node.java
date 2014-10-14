package model;

import javax.swing.tree.DefaultMutableTreeNode;

public class Node {
	private Node left;
	private Node right;
	private String name;
	private boolean isLeaf;

	public Node() {
		left = null;
		right = null;
		name = "";
		isLeaf = true;
	}

	public Node(String name, Node left, Node right){
		this.left = left;
		this.right = right;
		this.name = name;
	}
	
	public DefaultMutableTreeNode makeSubTree(Node top) {
		DefaultMutableTreeNode nodeTree = null;

        nodeTree = new DefaultMutableTreeNode(top.getName());
        if (!top.isLeaf) {
	        nodeTree.add(makeSubTree(top.getLeft()));
	        nodeTree.add(makeSubTree(top.getRight()));
        }
        return nodeTree;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public DefaultMutableTreeNode makeTree() {
        DefaultMutableTreeNode nodeTree = null;

        nodeTree = new DefaultMutableTreeNode(name);
        if (!isLeaf) {
	        nodeTree.add(makeSubTree(left));
	        nodeTree.add(makeSubTree(right));
        }
        return nodeTree;
    }
}
