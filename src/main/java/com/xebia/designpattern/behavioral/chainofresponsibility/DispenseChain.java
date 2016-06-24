package com.xebia.designpattern.behavioral.chainofresponsibility;

public interface DispenseChain {
	 
    void setNextChain(DispenseChain nextChain);
     
    public StringBuilder dispense(Currency cur, StringBuilder outputValue);
}