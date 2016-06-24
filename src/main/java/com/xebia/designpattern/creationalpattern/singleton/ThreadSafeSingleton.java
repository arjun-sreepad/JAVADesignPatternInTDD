package com.xebia.designpattern.creationalpattern.singleton;

public class ThreadSafeSingleton {
    
    //private constructor to avoid client applications to use constructor
    private ThreadSafeSingleton(){}
    private static ThreadSafeSingleton instance;
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
		if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
