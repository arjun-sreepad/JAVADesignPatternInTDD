package com.xebia.designpattern.structural.decorator;
/*Features 
Allows for the dynamic wrapping of objects in order to modify their existing responsibilities 
and behaviors.
The concept of a decorator is that it adds additional attributes to an object dynamically. 

Advantages
The main advantage of this pattern is to have minimal instance creation process which is much 
costly than cloning process.

When To Use
This pattern should be used when: 

The Decorator pattern should be used when:
	Object responsibilities and behaviors should be dynamically modifiable
	Concrete implementations should be decoupled from responsibilities and behaviors
	As mentioned in the previous section, this can be done by subclassing. 
	But too much subclassing is definitely a bad thing. As you add more behaviours to a base class, you will soon find yourself dealing with maintenance nightmare, as a new class is created for each possible combination. While the decorator can cause it's own issues, it does provide a better alternative to too much subclassing.er
	
Downside
	Overuse of the Open/Closed principle can lead to abstract and complex code. 
	This principle should really only be used in places where code is least likely to change. 

	The Design Patterns book does point out a couple of disadvantages with this pattern. 
Decorators can lead to a system with a lot of smaller objects that will look similar to a 
developer and introduce a maintenance headache. Also, the Decorator and it's enclosed 
components are not identical, so tests for object type (instanceof) will fail.

Usage in JDK:
	java.io.BufferedReader;
	java.io.FileReader;
*/
public class DecoratorExample {

	  public static void main(String args[]) {
	    Icecream icecream = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
	    System.out.println(icecream.makeIcecream());
	  }

	}