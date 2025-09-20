package com.hbk.examples.ObjectPoolDemo.demo_2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public abstract class ObjectPool<T> {

    public ObjectPool(final int minObjects) {
        initialize(minObjects);
    }

    public ObjectPool(final int minObjects, 
            final int maxObjects, final long validationInterval) {

        initialize(minObjects);
        
        mExecutorService=Executors.newSingleThreadScheduledExecutor();
        mExecutorService.scheduleWithFixedDelay(new Runnable() {

            @Override
            public void run() {
                int size=mPool.size();
                
                if(size<minObjects) {
                    int sizeToBeAdded=minObjects-size;
                    for(int i=0; i<sizeToBeAdded; i++) {
                        mPool.add(createObject());
                    }
                } else if(size>maxObjects) {
                    int sizeToBeRemoved=size-maxObjects;
                    for(int i=0; i<sizeToBeRemoved; i++) {
                        mPool.poll();
                    }
                }
            }
        }, validationInterval, validationInterval, TimeUnit.SECONDS);
    }

    public T borrowObject() {
        T object = mPool.poll();
        if(object==null) {
            object=createObject();
        }
        return object;
    }

    public void returnObject(T object) {
        if(object==null) {
            return;
        }
        this.mPool.offer(object);
    }
    
    public void shutdown() {
        if(mExecutorService != null) {
            mExecutorService.shutdown();
        }
    }

    protected abstract T createObject();

    private void initialize(final int minObjects) {
        mPool=new ConcurrentLinkedQueue<>();
        for(int i=0; i<minObjects; i++) {
            mPool.add(createObject());
        }
    }

    private ConcurrentLinkedQueue<T> mPool;
    private ScheduledExecutorService mExecutorService;
}
