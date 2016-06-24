package com.xebia.designpattern.behavioral.chainofresponsibility;
/*Features 
Gives more than one object an opportunity to handle a request by linking receiving objects 
together. 
The idea of the Chain Of Responsibility is that it avoids coupling the sender of the 
request to the receiver, giving more than one object the opportunity to handle the request.  
This process of delegation appears quite frequently in the real world where there is one 
interface for the customer to go through.

Client doesn’t know which part of the chain will be processing the request and it will send 
the request to the first object in the chain. For example, in our program ATMDispenseChain is 
unaware of who is processing the request to dispense the entered amount.

Each object in the chain will have it’s own implementation to process the request, either full 
or partial or to send it to the next object in the chain.

Every object in the chain should have reference to the next object in chain to forward the 
request to, its achieved by java composition.

Advantages
The main advantage of this pattern is to have minimal instance creation process which is 
much costly than cloning process.

When To Use
This pattern is recommended when either of the following scenarios occur in your application:
	Multiple objects can handle a request and the handler doesn't have to be a specific object
	A set of objects should be able to handle a request with the handler determined at runtime
	A request not being handled is an acceptable outcome.

Downside
	 Chain of Responsibility can make it difficult to follow through the logic of a particular path in the code at runtime. It's also important to note that there is the potential that the request could reach the end of the chain and not be handled at all.

Usage in JDK:
	Exception handling*/
public class ChainOfResponsibilityExample {
 
    public DispenseChain dispenseChain50;
 
    public ChainOfResponsibilityExample() {
        // initialize the chain
        this.dispenseChain50 = new Dollar50Dispenser();
        DispenseChain dispenseChain20 = new Dollar20Dispenser();
        DispenseChain dispenseChain10 = new Dollar10Dispenser();
 
        // set the chain of responsibility
        dispenseChain50.setNextChain(dispenseChain20);
        dispenseChain20.setNextChain(dispenseChain10);
    }
 
    public static void main(String[] args) {
        ChainOfResponsibilityExample atmDispenser = new ChainOfResponsibilityExample();
        int amount = 680;
        StringBuilder finalAMt = new StringBuilder();
          
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.dispenseChain50.dispense(new Currency(amount),finalAMt);
            System.out.println(finalAMt.toString());
 
    }
 
}
