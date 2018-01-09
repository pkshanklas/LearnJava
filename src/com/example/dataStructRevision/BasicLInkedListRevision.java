package com.example.dataStructRevision;

import com.example.dataStructures.BasicLinkedList;

/**
 * Created by premkum3 on 1/6/2018.
 */
public class BasicLInkedListRevision<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLInkedListRevision() {
        first = null;
        last = null;
        nodeCount = 0;
    }



    public int size() {
        return nodeCount;
    }

    public void add(X item) {
        Node newNode = new Node(item);

        if( last == null ) {
            first = last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }

        nodeCount++;
    }

    public void insert(X item, int position) {
        if( size()<position ) {
            throw new IllegalStateException("position is out of bound");
        }

        Node newNode = new Node(item);

        Node currNode = first;
        for(int i=1; i<position-1 && currNode!=null; i++ ) {
            currNode = currNode.getNextNode();
        }

        newNode.setNextNode(currNode.getNextNode());
        currNode.setNextNode(newNode);

        nodeCount++;
    }

    public X remove() {
        if( first == null ) {
            throw new IllegalStateException("list is empty");
        }

        X nodeItem = first.getNodeItem();
        first = first.getNextNode();

        nodeCount--;

        return nodeItem;
    }

    public X removeAt(int position) {
        if( size()<position ) {
            throw new IllegalStateException("position is out of bound");
        }

        Node currNode = first;
        for(int i=1; i<position-1 && currNode!=null; i++) {
            currNode = currNode.getNextNode();
        }

        X nodeItem = currNode.getNextNode().getNodeItem();
        currNode.setNextNode(currNode.getNextNode().getNextNode());

        nodeCount--;

        return nodeItem;

    }

    public Node get(X item) {
        if( first == null ) {
            throw new IllegalStateException("list is empty");
        }

        Node currNode = first;
        while( currNode != null ) {
            if( currNode.getNodeItem().equals(item) ) {
                return currNode;
            }
            currNode = currNode.getNextNode();
        }

        return null;
    }

    public int find(X item) {
        if( first == null ) {
            throw new IllegalStateException("list is empty");
        }

        Node currNode = first;
        for(int i=0; i<size() && currNode != null; i++) {
            if( currNode.getNodeItem().equals(item) )
                return i;

            currNode = currNode.getNextNode();
        }

        return -1;
    }

    public void reverse(){
        last = first;

        Node current = first, next, prev;
        prev = null;
        while(current != null) {
            next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
        }

        first = prev;
    }

    public void printReverse() {
        printReverseUtil(first);
    }

    private void printReverseUtil(Node head) {
        if(head == null)
            return;

        printReverseUtil(head.getNextNode());

        System.out.println(head.getNodeItem());
    }

    public void reverseRec(){
        last = first;
        first = reverseRecUtil(first);
    }

    private Node reverseRecUtil(Node head) {
        if( head==null ) {
            return null;
        }
        reverseRecUtil(head.getNextNode());
        Node q = head.getNextNode();
        q.setNextNode(head);
        head.setNextNode(null);
        return head;
    }

    public class Node {
        private X nodeItem;
        private Node next;

        public Node(X nodeItem) {
            this.nodeItem = nodeItem;
            this.next = null;
        }

        public void setNodeItem(X item) {
            this.nodeItem = item;
        }

        public X getNodeItem() {
            return nodeItem;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }

        public Node getNextNode() {
            return next;
        }

    }
}
