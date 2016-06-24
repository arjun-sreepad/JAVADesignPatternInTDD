package com.xebia.designpattern.behavioral.chainofresponsibility;

public class Dollar20Dispenser implements DispenseChain{
	 
    private DispenseChain chain;
     
 
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }
 
   
    public StringBuilder dispense(Currency cur, StringBuilder outputValue)  {
        if(cur.getAmount() >= 20){
            int num = cur.getAmount()/20;
            int remainder = cur.getAmount() % 20;
            outputValue.append("Dispensing "+num+" 20$ note\n");
            if(remainder !=0) this.chain.dispense(new Currency(remainder),outputValue);
        }else{
            this.chain.dispense(cur,outputValue);
        }
        return outputValue;
    }
 
}