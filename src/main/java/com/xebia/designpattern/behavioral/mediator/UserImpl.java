package com.xebia.designpattern.behavioral.mediator;

public class UserImpl extends User {
	 
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }
 
    @Override
    public StringBuilder send(String msg,StringBuilder totalChat){
    	totalChat.append(this.name+": Sending Message="+msg+"\n");
        mediator.sendMessage(msg, this, totalChat);
        return totalChat;
    }
    @Override
    public StringBuilder receive(String msg,StringBuilder totalChat) {
    	totalChat.append(this.name+": Received Message:"+msg+"\n");
    	return totalChat;
    }
 
}