package com.xebia.designpattern.structural.proxy;

import com.xebia.designpattern.framework.exceptions.UserNotAuthorisedException;

public class CommandExecutorImpl implements CommandExecutor {

 
   public StringBuilder runCommand(String cmd) throws UserNotAuthorisedException {
	   StringBuilder commandStatus = new StringBuilder();
	   return commandStatus.append("'" + cmd + "' command executed.");
   }

}