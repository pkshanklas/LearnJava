package com.example.dataStructures;

import java.util.Comparator;

public class BinarySearchTree <X extends Comparable<X>> {
    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int height() {
        return getHeight(this.root);
    }

    private int getHeight(Node node) {
        if(node == null)    return 0;
        else if(node.getLeft() != null)
            return 1 + getHeight(node.getLeft());
        else
            return 1 + getHeight(node.getRight());
    }

    public boolean delete(X item) {
        boolean deleted = false;

        Node node = getNode(item);
        if(node.getRight() == null && node.getLeft() == null) {
            unlink(node, null);
            deleted = true;
        }
        else if(node.getRight() == null && node.getLeft() != null) {
            unlink(node, node.getLeft());
            deleted = true;
        }
        else if(node.getRight() != null && node.getLeft() == null) {
            unlink(node, node.getRight());
            deleted = true;
        }
        else {
            Node child = node.getLeft();
            while(child.getLeft() != null && child.getRight() != null) {
                child = child.getRight();
            }

            child.getParent().setRight(null);

            child.setRight(node.getRight());
            child.setLeft(node.getLeft());

            unlink(node, child);
            deleted = true;
        }

        if(deleted)
            this.size--;

        return deleted;
    }

    private void unlink(Node currNode, Node newNode) {
        if(currNode == this.root) {
            newNode.setRight(currNode.getRight());
            newNode.setLeft(currNode.getLeft());
            this.root = newNode;
        }
        else if(currNode.getParent().getRight() == currNode) {
            currNode.getParent().setRight(newNode);
        }
        else {
            currNode.getParent().setLeft(newNode);
        }
    }

    public void add(X item) {
        Node node = new Node(item);

        if(this.root == null) {
            this.root = node;
            this.size++;
        }
        else {
            insert(this.root, node);
        }
    }

    public boolean contains(X item) {
        return (getNode(item) != null );
    }

    private Node getNode(X item) {
        Node currNode = this.root;

        while(currNode != null) {
            if(currNode.getItem().compareTo(item) == 0)
                return currNode;
            else if( currNode.getItem().compareTo(item) > 0 )
                currNode = currNode.getRight();
            else
                currNode = currNode.getLeft();
        }

        return null;
    }

    private void insert(Node parent, Node child) {

        //If the child item is less than the parent item
        //append in the left side of tree
        if( child.getItem().compareTo(parent.getItem()) < 0 ) {
            if( parent.getLeft() != null ) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            }
            else {
                insert(parent.getLeft(), child);
            }
        }

        //If the child item is greater than the parent item
        //append in the right side of tree
        if( child.getItem().compareTo(parent.getItem()) > 0 ) {
            if( parent.getRight() != null ) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            }
            else {
                insert(parent.getRight(), child);
            }
        }

    }

    public class Node {
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.parent = null;
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

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }

}
