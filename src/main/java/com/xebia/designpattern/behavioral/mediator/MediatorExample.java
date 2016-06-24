package com.xebia.designpattern.behavioral.mediator;

/*Features 
Allows loose coupling by encapsulating the way disparate sets of objects interact and 
communicate with each other.  Allows for the actions of each object set to vary independently 
of one another. 

Captures and externalizes an object's internal state so that it can be restored later, 
all without violating encapsulation.


When To Use
The mediator is a good choice of pattern when the communication between objects is complicated, 
but well defined. When there are too many relationships between the objects in your code, 
it's time to think of having such a central point of control.

An observer based variation of the mediator pattern is used in Java Message Service (JMS) 
implementations, which allows applications to subscribe and publish data to other applications. 
This is a common combination of patterns that makes sense.
	
Downside
While this pattern aims to reduce complexity, without proper design, the Mediator 
object itself can become very complicated itself.The Observer pattern could help here, 
with the colleague objects dealing with the events from the mediator, rather than having the 
mediator look after all orchestration.
Usage in JDK:
	JMS
	*/
public class MediatorExample {
	public StringBuilder messageSystem(String msgToBeSent) {
		StringBuilder totalChat = new StringBuilder();
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		totalChat=user1.send(msgToBeSent,totalChat);
		return totalChat;

	}
}