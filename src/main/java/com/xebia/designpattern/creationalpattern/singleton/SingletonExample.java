package com.xebia.designpattern.creationalpattern.singleton;

public class SingletonExample {
	public static void main(String[] args) {
		ThreadSafeSingleton firstSingletonInstance = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		ThreadSafeSingleton secondSingletonInstance = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		if (firstSingletonInstance == secondSingletonInstance)
			System.out.println(true);

	}

	public Boolean checkSingleton(ThreadSafeSingleton[] singletonArray) {
		for (int i = 1; i < singletonArray.length; i++) {
			if (singletonArray[0] != singletonArray[i]) {
				return false;
			}

		}
		return true;
	}
}
