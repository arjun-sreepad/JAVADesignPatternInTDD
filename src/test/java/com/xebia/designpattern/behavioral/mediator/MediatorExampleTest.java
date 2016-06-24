package com.xebia.designpattern.behavioral.mediator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.xebia.framework.TestFilePath;

public class MediatorExampleTest {
	static MediatorExample tMediatorExample = new MediatorExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;
	
	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tMediatorExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void messageSystem_ProperInput_Successful() {
		
		StringBuilder totalChat = new StringBuilder();
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		String msgToBeSent = "Hi All";
		actualValue=user1.send(msgToBeSent,totalChat ).toString();
		expectedValue=tProperties.get("messageSystem_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void messageSystem_ImproperInput_Failure() {
		StringBuilder totalChat = new StringBuilder();
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		String msgToBeSent = "Hi All";
		actualValue=user1.send(msgToBeSent,totalChat ).toString();
		expectedValue=tProperties.get("messageSystem_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));
	}

	@Test
	public void messageSystem_testSentMessage_SenderWorkingIsTheMessageToBeSent() {
		StringBuilder totalChat = new StringBuilder();
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		String msgToBeSent = "Test Sender";
		actualValue=user1.send(msgToBeSent,totalChat ).toString();
		expectedValue=tProperties.get("messageSystem_testSentMessage_SenderWorkingIsTheMessageToBeSent").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
	
	@Test
	public void messageSystem_testReceivedMessage_ReceiverWorkingIsTheMessageToBeSent() {
		StringBuilder totalChat = new StringBuilder();
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		String msgToBeSent = "Test Receiver";
		actualValue=user1.send(msgToBeSent,totalChat ).toString();
		expectedValue=tProperties.get("messageSystem_testReceivedMessage_ReceiverWorkingIsTheMessageToBeSent").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
	
	@Test
	public void messageSystem_isSenderReceivingTheMessage_SenderShouldNotReceiveTheMessage() {
		StringBuilder totalChat = new StringBuilder();
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		String msgToBeSent = "Hi All";
		actualValue=user1.send(msgToBeSent,totalChat ).toString();
		expectedValue=tProperties.get("messageSystem_isSenderReceivingTheMessage_SenderShouldNotReceiveTheMessage").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
	
	@Test
	public void messageSystem_isEveryoneExceptSenderReceivedMessage_EveroneExceptSenderShouldReceive() {
		StringBuilder totalChat = new StringBuilder();
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		String msgToBeSent = "Hi All";
		actualValue=user1.send(msgToBeSent,totalChat ).toString();
		expectedValue=tProperties.get("messageSystem_isEveryoneExceptSenderReceivedMessage_EveroneExceptSenderShouldReceive").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
}
