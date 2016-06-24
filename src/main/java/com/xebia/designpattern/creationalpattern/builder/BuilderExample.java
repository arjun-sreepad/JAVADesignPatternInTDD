package com.xebia.designpattern.creationalpattern.builder;
//Builder Design Pattern

/*Features 

	This pattern was introduced to solve some of the problems with Factory and Abstract Factory
design patterns when the Object contains a lot of attributes. 
	Builder pattern solves the issue with large number of optional parameters and inconsistent 
state by providing a way to build the object step-by-step and provide a method that will 
actually return the final Object. 

Advantage
	Undoubtedly, the number of lines of code increase at least to double in builder pattern, 
but the effort pays off in terms of design flexibility and much more readable code. 
The parameters to the constructor are reduced and are provided in highly readable method calls.
	Builder pattern also helps minimizing the number of parameters in constructor and thus 
there is no need to pass in null for optional parameters to the constructor. 
It’s really attracts me.
	Another advantage is that Object is always instantiated in a complete state rather than 
sitting in an incomplete state until the developer calls (if ever calls) the appropriate “setter” method to set additional fields.

Drawback
	Though Builder pattern reduce some line of code buy eliminating the need of setter methods, 
	still in double up total lines by introducing the Builder object. 
	Furthermore, although client code is more readable, the client code is also more verbose.
	Though for me, readability weighs more than lines of code.

When to use
	This should be used only when you want to build different objects 
using same object building process.

Example
	Locale locale = new Builder().setLanguage("sr").setScript("Latn").setRegion("RS").build();
	StringBuilder builder = new StringBuilder("Temp");
	String data = builder.append(1)
                .append(true)
                .append("friend")
                .toString();
*/

public class BuilderExample {

	public static void main(String[] args) {
		// Using builder to get the object in a single line of code and
		// without any inconsistent state or arguments management issues
		Computer comp = new Computer.ComputerBuilder("50 GB", "2 GB").setBluetoothEnabled(true).build();
		System.out.println(comp);
		StringBuilder builder = new StringBuilder();
	}
}
