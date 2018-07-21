package com.wxy.utils;

import java.util.Iterator;

/**
 * Created by Kode on 2018/7/20.
 */
public class MaxPQ<Key> implements Iterable<Key> {

    private Key[] pq;
    private int n;
    private Comparable<Key> comparator;
    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    public MaxPQ() {
        this(1);
    }

    private boolean less(int i, int j) {
        if (comparator == null) {
            return pq[i].
        }
    }
}
