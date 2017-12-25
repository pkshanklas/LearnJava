package com.example.algorithms;

import java.util.Collection;

/**
 * Created by premkum3 on 12/23/2017.
 */
public class Search {
    private int[] arr;
    private int key;

    public Search(int[] arr, int key) {
        this.arr = arr;
        this.key = key;
    }

    public int linearSearch() {
        for(int i=0; i<arr.length; i++) {
            if( arr[i]==key )   return i;
        }

        return -1;
    }

    public int jumpSearch() {
        int n = arr.length;

        int step = (int)Math.floor(Math.sqrt(n));

        int prev=0;
        while( arr[Math.min(step,n)-1] < key ) {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if( prev>=n )   return -1;
        }

        while( arr[prev]<key ) {
            prev++;

            if(prev == Math.min(step, n))
                return -1;
        }

        if( arr[prev]==key )
            return prev;

        return -1;
    }

    public int interPolationSearch() {
        int st=0, end=arr.length-1;

        while( st<=end && key>=arr[st] && key<=arr[end] ) {
            int pos = st + ( ((key-arr[st]) * (end-st))/( arr[end]-arr[st] ));

            if( arr[pos]>key ) end=pos-1;
            else if( arr[pos]<key ) st=pos+1;
            else return pos;
        }

        return -1;
    }

    public int binarySearch() {
        int st=0, end=arr.length-1;

        while( st<end ) {
            int mid = st+(end-st)/2;

            if( arr[mid]>key ) end=mid-1;
            else if( arr[mid]<key ) st=mid+1;
            else return mid;
        }

        return -1;
    }
}
