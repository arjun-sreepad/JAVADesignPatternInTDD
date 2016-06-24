package com.xebia.designpattern.structural.composite;

/*Features 
Composite pattern is used where we need to treat a group of objects in similar way as a 
single object. Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy. This type of design pattern comes under structural pattern as this pattern creates a tree structure of group of objects.

Advantages
The main advantage of this pattern is to have minimal instance creation 
process which is much costly than cloning process.

When To Use
This pattern should be used when you want to represent objects in a hierarchical fashion, 
or you need objects and composites to be treated uniformly. 

Downside
	The Composite pattern does one thing really well, and that is that it allows you to treat 
both nodes and leafs in the same way. However, by providing this flexibility and 
transparency, you're choosing a trade-off on the Single Responsibility principle.  
This is not necessarily a bad thing, but it's something that you should keep in mind. 
	Your system could also be overly general, and it can be difficult to find objects. 
Taking this into account, the pattern probably isn't ideal to use as a data structure. 
In cases where the ordering of child nodes is important, you will need to add in extra 
functionality, perhaps utilizing the Iterator pattern. 

Usage in JDK:
	java.util.Map#putAll(Map)
	java.util.List#addAll(Collection)
	java.util.Set#addAll(Collection)*/

public class CompositePatternExample {
	public static void main(String[] args) {

		Employee CEO = new Employee("John", "CEO", 30000);

		// print all employees of the organization
		System.out.println(CEO);

		for (Employee headEmployee : CEO.getSubordinates()) {
			System.out.println(headEmployee);

			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee);
			}
		}
	}
}