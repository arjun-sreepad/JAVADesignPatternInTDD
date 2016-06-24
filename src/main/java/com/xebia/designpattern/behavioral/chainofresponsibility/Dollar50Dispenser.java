package com.xebia.designpattern.behavioral.chainofresponsibility;

public class Dollar50Dispenser implements DispenseChain {
	 
    private DispenseChain chain;
 
    
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }
 
    public StringBuilder dispense(Currency cur, StringBuilder outputValue) {
        if(cur.getAmount() >= 50){
            int num = cur.getAmount()/50;
            int remainder = cur.getAmount() % 50;
            outputValue.append("Dispensing "+num+" 50$ note\n");
            if(remainder !=0) this.chain.dispense(new Currency(remainder),outputValue);
        }else{
            this.chain.dispense(cur,outputValue);
        }
        return outputValue;
    }
 
}