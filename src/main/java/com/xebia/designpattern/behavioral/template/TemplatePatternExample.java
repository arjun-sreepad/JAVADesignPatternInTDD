package com.xebia.designpattern.behavioral.template;
/*Features 
A Template method pattern provides a skeleton for performing any sort of algorithm or an 
operation, and it allows the sub-classes to re-define part of the logic.

Template Method is a behavioral design pattern and it’s used to create a method stub and 
deferring some of the steps of implementation to the subclasses. Template method defines the 
steps to execute an algorithm and it can provide default implementation that might be common 
for all or some of the subclasses.

Advantages
The main advantage of this pattern is to have minimal instance creation process which is much 
costly than cloning process.
Natural fit for building frameworks, so that parent framework classes can make callbacks into 
methods implemented in child.

When To Use

When behavior of an algorithm can vary, you let subclasses implement the behaviour through 
overriding
You want to avoid code duplication, implementing variations of the algorithm in subclasses
You want to control the point that subclassing is allowed.
Template Method may not be an obvious choice in the beginning, but the usual sign that you 
should use the pattern is when you find that you have two almost identical classes working on 
some logic. At that stage, you should consider the power of the template method pattern to 
clean up your code.

Downside
There are some downsides to the template method pattern. Firstly, your base classes tend to 
get cluttered up with a lot of seemingly unrelated code. Program flow is a little more 
difficult to follow - without the help of stepping through the code with a debugger. 

Restricts you to a single inheritance in Java.

Usage in JDK:
	java.util.AbstractList
Servlet's doGet and doPost methods
MDB's onMessage method
Struts Action class
Spring's data access classes
*/

public class TemplatePatternExample {
	 
    public static void main(String[] args) {
      /*  StringBuilder houseStatus = new StringBuilder();
        HouseTemplate houseType = new WoodenHouse();
         
        //using template method
        houseType.buildHouse(houseStatus);
        houseType = new GlassHouse();
        houseType.buildHouse(houseStatus);
        
        System.out.println(houseStatus.toString());*
        /
         */
    	
    	TemplatePatternExample client = new TemplatePatternExample();
    	System.out.println(client.buildHome(new GlassHouse()).toString());
    }
    
    public StringBuilder buildHome(HouseTemplate houseTemplate)
    {
    	StringBuilder houseStatus = new StringBuilder();
        HouseTemplate houseType = houseTemplate;
        houseType.buildHouse(houseStatus);
        
        return houseStatus;
    }
 
}