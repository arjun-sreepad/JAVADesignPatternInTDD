package com.xebia.designpattern.behavioral.observer;

/*Define a one-to-many dependency between objects so that when one object changes state, 
 * all its dependents are notified and updated automatically.
 * 
 * When to use
 * 	In general, you want to use this pattern to reduce coupling. If you have an object that 
needs to share it's state with others, without knowing who those objects are, the Observer 
is exactly what you need.
	You'll have seen, and probably used, the Observer many times if you've done any 
UI programming, especially in Swing. The whole concept of listeners is based on this pattern. 
The event listener is the most popular, where you register an ActionListener to a UI control, 
such a button, and react to action events using the actionPerformed method. In this case, the 
ActionListener is the Observer and the button is your Subject. As the button changes state, you 
can react, if you choose to, in your actionPerformed method. 
	The typical real world uses of the pattern all revolve around this type of event handling 
system.
*/
public class ObserverPatternExample {

	public static void main(String[] args) {
		//create subject
		MyTopic topic = new MyTopic();
		
		//create observers
		Observer obj1 = new MyTopicSubscriber("Obj1");
		Observer obj2 = new MyTopicSubscriber("Obj2");
		Observer obj3 = new MyTopicSubscriber("Obj3");
		
		//register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//check if any update is available
		obj1.update();
		
		//now send message to subject
		topic.postMessage("New Message");
	}

}