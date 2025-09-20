package com.hbk.examples.IteratorDemo.demo_1.social_networks;

import com.hbk.examples.IteratorDemo.demo_1.iterators.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
