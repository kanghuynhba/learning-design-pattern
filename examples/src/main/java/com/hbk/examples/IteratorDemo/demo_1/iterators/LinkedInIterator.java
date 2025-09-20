package com.hbk.examples.IteratorDemo.demo_1.iterators;

import com.hbk.examples.IteratorDemo.demo_1.profile.Profile;
import com.hbk.examples.IteratorDemo.demo_1.social_networks.LinkedIn;

import java.util.List;
import java.util.ArrayList;

public class LinkedInIterator implements ProfileIterator{
    private LinkedIn linkedin;
    private String type;
    private String email;
    private int currentPosition=0;
    private List<String> emails=new ArrayList<>();
    private List<Profile> profiles=new ArrayList<>();

    public LinkedInIterator(LinkedIn linkedin, String type, String email) {
        this.linkedin=linkedin;
        this.type=type;
        this.email=email;
    }

    private void lazyLoad() {
        if(emails.size()==0) {
            List<String> profiles=linkedin.
                requestProfileFriendsFromLinkedIn(this.email, this.type);
            for(String profile : profiles) {
                this.emails.add(profile);
                this.profiles.add(null); 
            }
        }
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition<emails.size();
    }

    @Override
    public Profile getNext() {
        if(!hasNext()) {
            return null;
        }    
        String friendEmail=emails.get(currentPosition);
        Profile friendProfile=profiles.get(currentPosition);
        if(friendProfile==null) {
            friendProfile=linkedin.requestProfileFromLinkedIn(friendEmail);
            profiles.set(currentPosition, friendProfile);
        }
        currentPosition++;
        return friendProfile;
    }

    @Override
    public void reset() {
        currentPosition=0;
    }
}
