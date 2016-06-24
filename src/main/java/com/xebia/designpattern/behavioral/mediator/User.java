package com.xebia.designpattern.behavioral.mediator;

public abstract class User {
    protected ChatMediator mediator;
    protected String name;
     
    public User(ChatMediator med, String name){
        this.mediator=med;
        this.name=name;
    }
     
    public abstract StringBuilder send(String msg,StringBuilder totalChat);
     
    public abstract StringBuilder receive(String msg,StringBuilder totalChat);
}