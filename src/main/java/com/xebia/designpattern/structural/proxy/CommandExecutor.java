package com.xebia.designpattern.structural.proxy;

import com.xebia.designpattern.framework.exceptions.UserNotAuthorisedException;

@FunctionalInterface 
public interface CommandExecutor {
	public StringBuilder runCommand(String cmd) throws UserNotAuthorisedException;
}