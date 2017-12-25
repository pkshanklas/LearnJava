package com.example.dataStructures;

/**
 * Created by premkum3 on 12/21/2017.
 */
public class BasicStack<X> implements StackInterface<X>{
    private X[] data;
    private int stackPointer;

    public BasicStack() {
        this.data = (X[]) new Object[1000];
        this.stackPointer = 0;
    }

    @Override
    public void push(X newItem) {
        if( stackPointer==999 ) {
            throw new IllegalStateException("Stack is already full");
        }

        data[stackPointer++] = newItem;
    }

    @Override
    public X pop() {
        if( stackPointer==0 ) {
            throw new IllegalStateException("Stack has no data");
        }

        return data[--stackPointer];
    }

    @Override
    public boolean contains(X item) {
        boolean found = false;

        for(int i=0; i<stackPointer; i++) {
            if(data[i].equals(item)) {
                found = true;
                break;
            }
        }

        return found;
    }

    @Override
    public X access(X item) {
        while( stackPointer>0 ) {
            X tmpItem = pop();
            if( tmpItem.equals(item) )
                return tmpItem;
        }

        throw new IllegalStateException("Item is not found on the stack" + item);
    }

    @Override
    public int size() {
        return stackPointer;
    }
}
