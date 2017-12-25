package com.example.dataStructures;

import java.util.IllegalFormatCodePointException;

/**
 * Created by premkum3 on 12/25/2017.
 */
public class BasicQueue<X> implements QueueInterface<X>{
    private X[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(1000);
        this.front=-1;
        this.end=-1;
    }

    public BasicQueue(int size) {
        data = (X[])new Object[size];
    }

    public int size() {
        if( front==-1 && end==-1)
            return 0;
        else
            return end-front+1;
    }

    @Override
    public void enQueue(X item) {
        if( (end+1)%data.length == front ) {
            throw new IllegalStateException("the Queue is full");
        }
        else if( size()==0 ) {
            front++;
            end++;
            data[end]=item;
        }
        else {
            end++;
            data[end]=item;
        }
    }

    @Override
    public X deQueue() {
        X item=null;

        if( size()==0 ) {
            throw new IllegalStateException("the queue is empty");
        }
        else if( front==end ) {
            item=data[front];
            data[front]=null;
            front=end=-1;
        }
        else {
            item=data[front];
            data[front]=null;
            front++;
        }

        return item;
    }

    @Override
    public boolean contains(X item) {
        boolean found=false;

        if( size()==0 ) {
            return found;
        }

        for(int i=front; i<end; i++) {
            if( data[i].equals(item) ) {
                found=true;
                break;
            }
        }

        return found;
    }

    @Override
    public X access(int position) {
        X item= null;

        if( size()==0 || position > size() ) {
            throw new IllegalStateException("queue is empty or the position is out of bound");
        }

        int trueIndex=0;
        for(int i=front; i<end; i++) {
            if( trueIndex==position ) {
                return data[i];
            }
            trueIndex++;
        }

        throw new IllegalStateException("could not get position in queue " + position);
    }
}
