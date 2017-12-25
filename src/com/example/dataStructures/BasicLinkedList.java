package com.example.dataStructures;

/**
 * Created by premkum3 on 12/25/2017.
 */
public class BasicLinkedList<X> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        first = last = null;
        nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public void add(X item) {

        if( first==null ) {
            first = new Node(item);
            last = first;
        }
        else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last=newLastNode;
        }

        nodeCount++;
    }

    public void insert(X item, int position) {
        if( size() < position ) {
            throw new IllegalStateException("position is out of bound");
        }

        Node currNode = first;
        for(int i=1; i<position && currNode!=null; i++) {
            currNode = currNode.getNextNode();
        }

        Node newNode = new Node(item);
        Node nextNode = currNode.getNextNode();
        currNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }

    public X remove() {
        if( first==null ) {
            throw new IllegalStateException("list is empty");
        }

        X nodeItem = first.getNodeItem();

        first=first.getNextNode();
        nodeCount--;

        return nodeItem;
    }

    public X removeAt(int position) {
        if( first==null || size()<position) {
            throw new IllegalStateException("list is empty");
        }

        Node currNode = first;
        Node prevNode = first;

        for(int i=1; i<position && currNode!=null; i++) {
            prevNode = currNode;
            currNode = currNode.getNextNode();
        }

        X nodeItem = currNode.getNodeItem();
        prevNode.setNextNode(currNode.getNextNode());

        nodeCount--;

        return nodeItem;
    }

    public X get(int position) {
        if( first==null ) {
            throw new IllegalStateException("list is empty");
        }

        Node currNode = first;
        for(int i=0; i<size() && currNode!=null; i++) {
            if( i==position )
                return currNode.getNodeItem();

            currNode = currNode.getNextNode();
        }

        return null;
    }

    public int find(X item){
        if( first==null ) {
            throw new IllegalStateException("list is empty");
        }

        Node currNode = first;
        for(int i=0; i<size() && currNode!=null; i++) {
            if( currNode.getNodeItem().equals(item) ) {
                return i;
            }

            currNode = currNode.getNextNode();
        }

        return -1;
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();

        Node currNode = first;
        while( currNode!=null ) {
            contents.append(currNode.getNodeItem());
            currNode = currNode.getNextNode();
        }

        return contents.toString();
    }

    public class Node {
        private X nodeItem;
        private Node nextNode;

        public Node(X item) {
            this.nodeItem = item;
            this.nextNode = null;
        }

        public X getNodeItem() {
            return nodeItem;
        }

        public void setNodeItem(X nodeItem) {
            this.nodeItem = nodeItem;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
