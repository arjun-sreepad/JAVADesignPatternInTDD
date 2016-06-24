package com.xebia.designpattern.structural.flyweight;
/*Features 
Flyweight design pattern is used when we need to create a lot of Objects of a class. 
Since every object consumes memory space that can be crucial for low memory devices, 
such as mobile devices or embedded systems, flyweight design pattern can be applied to reduce 
the load on memory by sharing objects. 

Advantages
The main advantage of this pattern is to have minimal instance creation process which is much 
costly than cloning process.

When To Use
This pattern should be used when: 
	Many similar objects are used and the storage cost is high
	The majority of each object's state data can be made extrinsic
	A few shared objects would easily replace many unshared objects
	The identity of each object does not matter
	
Downside
	 One of the drawbacks of this pattern is that all instances of the class are related, 
	 so single instances of the class will not be able to behave independently from other instances.

Usage in JDK:
	String Pool*/

import java.util.HashSet;

public class FlyWeightExample {

	public int flyWeightObjCreator(String colors[], int numberOfElementsRequired) {

		HashSet<Circle> circleSet = new HashSet<>();

		for (int i = 0; i < numberOfElementsRequired; ++i) {
			Circle circle = (Circle) ShapeFactory.getCircle(colors[i % colors.length]);
			circle.setX(i * 56);
			circle.setY(i * 43);
			circle.setRadius(100);
			circleSet.add(circle);
		}
		return circleSet.size();
	}

}