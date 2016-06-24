package com.xebia.designpattern.behavioral.mediator;

public interface ChatMediator {
	 
	public StringBuilder sendMessage(String msg, User user,StringBuilder totalChat);
 
    void addUser(User user);
}