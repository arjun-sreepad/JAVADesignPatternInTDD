package com.xebia.designpattern.structural.proxy;

import com.xebia.designpattern.framework.exceptions.UserNotAuthorisedException;

/*Features 
Proxy pattern intent is to “Provide a surrogate or placeholder for another object to control 
access to it”. The definition itself is very clear and proxy pattern is used when we want to 
provide controlled access of a functionality.
When To Use
This pattern is recommended when either of the following scenarios occur in your application:
	The object being represented is external to the system.
	Objects need to be created on demand. 
	Access control for the original object is required
	Added functionality is required when an object is accessed.
	
	Example in JDK
	java.rmi.*
*/

public class ProxyExample {

	public  StringBuilder proxyExecuter(String userName,String password,String command) throws UserNotAuthorisedException {
		CommandExecutor executor = new CommandExecutorProxy(userName,password);
		StringBuilder commandStatus;
	
			commandStatus =	executor.runCommand(command);
		return commandStatus;

	}
}
