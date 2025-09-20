package com.hbk.examples.IteratorDemo.demo_1.iterators;

import com.hbk.examples.IteratorDemo.demo_1.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();
    Profile getNext();
    void reset();
}
