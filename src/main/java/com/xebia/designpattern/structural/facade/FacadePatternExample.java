package com.xebia.designpattern.structural.facade;
/*Features 
Provide a unified interface to a set of interfaces in a subsystem. 
Façade defines a higher-level interface that makes the subsystem easier to use.

When To Use
This pattern should be used when: 
	Many similar objects are used and the storage cost is high
	The majority of each object's state data can be made extrinsic
	A few shared objects would easily replace many unshared objects
	The identity of each object does not matter
	
Downside
	 By introducing the Facade into your code, you will be hardwiring subsystems into the 
Facade. This is fine if the subsystem never changes, but if it does, your Facade could be 
broken. Therefore, developers working on the subsystem should be made aware of any Facade 
around their code.

Usage in JDK:
	EJB, Soap Web-Services*/
public class FacadePatternExample {
	   public static void main(String[] args) {
	      ShapeMaker shapeMaker = new ShapeMaker();

	      shapeMaker.drawCircle();
	      shapeMaker.drawRectangle();
	      shapeMaker.drawSquare();		
	   }
	}