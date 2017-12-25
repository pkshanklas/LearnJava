package com.example.dataStructures;

/**
 * Created by premkum3 on 12/25/2017.
 */
public interface QueueInterface<X> {
    public void enQueue(X item);
    public X deQueue();
    public boolean contains(X item);
    public X access(int position);
}
