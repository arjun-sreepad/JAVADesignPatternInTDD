package com.xebia.designpattern.structural.proxy;

import com.xebia.designpattern.framework.exceptions.UserNotAuthorisedException;

public class CommandExecutorProxy implements CommandExecutor {
	 
    private boolean isAdmin;
    private CommandExecutor executor;
     
    public CommandExecutorProxy(String user, String pwd){
        if("admin".equals(user) && "admin".equals(pwd)) isAdmin=true;
        executor = new CommandExecutorImpl();
    }
     
    public StringBuilder runCommand(String cmd) throws UserNotAuthorisedException {
    	StringBuilder commandStatus;
    	if(isAdmin){
    		commandStatus= executor.runCommand(cmd);
        }else{
            throw new UserNotAuthorisedException("rm command is not allowed for non-admin users.");
          
            }
    	return commandStatus;
        }
    }
 