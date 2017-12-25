package com.example.dataStructures;

/**
 * Created by premkum3 on 12/21/2017.
 */
public interface StackInterface<X> {

    public void push(X newItem);
    public X pop();
    public boolean contains(X item);
    public X access(X item);
    public int size();

}
