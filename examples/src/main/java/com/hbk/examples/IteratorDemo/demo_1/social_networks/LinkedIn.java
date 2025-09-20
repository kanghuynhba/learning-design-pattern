package com.hbk.examples.IteratorDemo.demo_1.social_networks;

import com.hbk.examples.IteratorDemo.demo_1.profile.Profile;
import com.hbk.examples.IteratorDemo.demo_1.iterators.ProfileIterator;
import com.hbk.examples.IteratorDemo.demo_1.iterators.LinkedInIterator;

import java.util.ArrayList;
import java.util.List;

public class LinkedIn implements SocialNetwork {
    private List<Profile> profiles;

    public LinkedIn(List<Profile> cache) {
        if(cache!=null) {
            this.profiles=cache;
        } else {
            this.profiles=new ArrayList<>();
        }

    }

    public Profile requestProfileFromLinkedIn(String profileEmail) {
        simulateNetworkLatency(); 
        System.out.println("LinkedIn: Loading profile '" + profileEmail + "' over the network...");
        return findProfile(profileEmail);
    }

    public List<String> requestProfileFriendsFromLinkedIn(
        String profileEmail, String contactType) {
        simulateNetworkLatency(); 
        System.out.println("LinkedIn: Loading '" + contactType +"' list of '" + profileEmail + "' over the network...");
        Profile profile=findProfile(profileEmail);
        if(profile!=null) {
            return profile.getContacts(contactType);
        } 
        return null;
    }

    private Profile findProfile(String profileEmail) {
        for(Profile profile : profiles) {
           if(profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override 
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new LinkedInIterator(this, "friends", profileEmail);
    };

    @Override 
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new LinkedInIterator(this, "coworkers", profileEmail);
    }
}
