package com.hbk.examples.IteratorDemo.demo_1.spammer;

import com.hbk.examples.IteratorDemo.demo_1.social_networks.SocialNetwork;
import com.hbk.examples.IteratorDemo.demo_1.profile.Profile;
import com.hbk.examples.IteratorDemo.demo_1.iterators.ProfileIterator;

public class SocialSpammer {
    private SocialNetwork network;
    private ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network=network;
    }

    public void sendSpamToFriends(String email, String message) {
        System.out.println("\nIterating over friends...\n");
        iterator=network.createFriendsIterator(email);
        while(iterator.hasNext()) {
            Profile profile=iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }
    
    public void sendSpamToCoworkers(String email, String message) {
        System.out.println("\nIterating over coworkers...\n");
        iterator=network.createCoworkersIterator(email);
        while(iterator.hasNext()) {
            Profile profile=iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendMessage(String email, String message) {
        System.out.println(
                "Sent message to: '" + email + 
                "'. Message body: '" + message + "'");
    }
}
