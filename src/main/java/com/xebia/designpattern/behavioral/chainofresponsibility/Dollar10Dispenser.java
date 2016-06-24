package com.xebia.designpattern.behavioral.chainofresponsibility;

public class Dollar10Dispenser implements DispenseChain {
	 
    private DispenseChain chain;
     
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }
 
    public StringBuilder dispense(Currency cur, StringBuilder outputValue)  {
        if(cur.getAmount() >= 10){
            int num = cur.getAmount()/10;
            int remainder = cur.getAmount() % 10;
            outputValue.append("Dispensing "+num+" 10$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder),outputValue);
        }else{
            this.chain.dispense(cur,outputValue);
        }
        return outputValue;
    }
 
}