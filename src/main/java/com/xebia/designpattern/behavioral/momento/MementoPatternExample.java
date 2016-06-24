package com.xebia.designpattern.behavioral.momento;
/*Features 
Memento design pattern is used when we want to save the state of an object so that we can 
restore later on. Memento pattern is used to implement this in such a way that the saved state 
data of the object is not accessible outside of the object, this protects the integrity of 
saved state data.

Memento pattern is implemented with two objects – Originator and Caretaker. 
Originator is the object whose state needs to be saved and restored and it uses an 
inner class to save the state of Object. The inner class is called Memento and its private, 
so that it can’t be accessed from other objects.

Captures and externalizes an object's internal state so that it can be restored later, all 
without violating encapsulation.

Advantages
The main advantage of this pattern is to have minimal instance creation process which is 
much costly than cloning process.

When To Use
The Memento pattern is useful when you need to provide an undo mechanism in your applications, 
when the internal state of an object may need to be restored at a later stage. Using serialization along with this pattern, it's easy to preserve the object state and bring it back later on.
	
Downside
Some problems with this pattern is that the saving or restoring of state can be a time 
consuming process. Used incorrectly, it can expose the internal structure of your object, thus allowing any other object to change the state of your object.

The Design Patterns book does point out a couple of disadvantages with this pattern. 
Decorators can lead to a system with a lot of smaller objects that will look similar to a 
developer and introduce a maintenance headache. Also, the Decorator and it's enclosed components are not identical, so tests for object type (instanceof) will fail.

Usage in JDK:
	java serializable*/

public class MementoPatternExample {
	public static void main(String[] args) {

		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("State #1");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		System.out.println("Current State: " + originator.getState());

		originator.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State: " + originator.getState());
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State: " + originator.getState());
		originator.getStateFromMemento(careTaker.get(2));
		System.out.println("Third saved State: " + originator.getState());
	}
}