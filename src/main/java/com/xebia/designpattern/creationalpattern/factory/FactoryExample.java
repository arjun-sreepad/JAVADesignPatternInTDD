package com.xebia.designpattern.creationalpattern.factory;

//Factory Design Pattern
/*Features 

	Creates objects without exposing the instantiation logic to the client.
	Refers to the newly created object through a common interface
	Provides approach to code for interface rather than implementation.
	Provides abstraction between implementation and client classes through inheritance.
	Decouples the calling class from the target class, which result in less coupled and highly cohesive code?

Advantages
	New Concrete can be added without changing a single line of code in the framework

When To Use
	When you design an application just think if you really need it a factory to create objects. 
Maybe using it will bring unnecessary complexity in your application. If you have many objects of the same base 
type and you manipulate them mostly casted to abstract types, then you need a factory. 
If you're code should have a lot of code like the following, you should reconsider it:
	Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class.
This pattern take out the responsibility of instantiation of a class from client program to the factory class. Let’s first learn how to implement 
factory pattern in java and then we will learn it’s benefits and we will see its usage in JDK.
	
Example
	Factory method design pattern decouples the calling class from the target class, which result in less coupled and highly cohesive code?
USAGE: JDBC is a good example for this pattern; application code doesn't need to know what database it will be used with, 
so it doesn't know what database-specific driver classes it should use. Instead, it uses factory methods to get Connections,
Statements, and other objects to work with. Which gives you flexibility to change your back-end database without changing your DAO 
layer in case you are using ANSI SQL features and not coded on DBMS specific feature?
	valueOf() method in wrapper classes like Boolean, Integer etc.
	
Design principle used: Code to Interface and ISP	
*/
public class FactoryExample {
    public static void main(String args[]) {
           String country = "INDIA";
           Currency rupee = CurrencyFactory.createCurrency(country);
           System.out.println(rupee.getSymbol());
    }
}
