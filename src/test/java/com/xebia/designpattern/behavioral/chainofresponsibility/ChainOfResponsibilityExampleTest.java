package com.xebia.designpattern.behavioral.chainofresponsibility;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import com.xebia.framework.TestFilePath;
public class ChainOfResponsibilityExampleTest {
	static ChainOfResponsibilityExample atmDispenser = new ChainOfResponsibilityExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	StringBuilder actualOutputTmp = new StringBuilder();
	String expectedOutput;
	String actualOutput;
	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(atmDispenser);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void atmDispenser_ProperAmount_Successful() {
		int amount = 680;
		// process the request
		actualOutputTmp = atmDispenser.dispenseChain50.dispense(new Currency(amount), actualOutputTmp);
		expectedOutput = tProperties.get("atmDispenser_ProperAmount_Successful").toString();
		actualOutput=actualOutputTmp.toString();
		assertTrue(expectedOutput.equals(actualOutput));
	}
	
	@Test
	public void atmDispenser_ImproperAmountProperAmount_Failure()
	{
		int amount = 500;
		// process the request
		actualOutputTmp = atmDispenser.dispenseChain50.dispense(new Currency(amount), actualOutputTmp);
		expectedOutput = tProperties.get("atmDispenser_ImproperAmountProperAmount_Failure").toString();
		actualOutput=actualOutputTmp.toString();
		assertFalse(expectedOutput.equals(actualOutput));
	}

	@Test
	public void atmDispenser_multiplesOfFifty_OnlyFiftiesNotes()
	{
		int amount = 500;
		// process the request
		actualOutputTmp = atmDispenser.dispenseChain50.dispense(new Currency(amount), actualOutputTmp);
		expectedOutput = tProperties.get("atmDispenser_multiplesOfFifty_OnlyFiftiesNotes").toString();
		actualOutput=actualOutputTmp.toString();
		assertTrue(expectedOutput.equals(actualOutput));
	
	}
	
	@Test
	public void atmDispenser_multiplesOfTwenty_OnlyFiftiesAndTwentiesNotes()
	{
		int amount = 520;
		// process the request
		actualOutputTmp = atmDispenser.dispenseChain50.dispense(new Currency(amount), actualOutputTmp);
		expectedOutput = tProperties.get("atmDispenser_multiplesOfTwenty_OnlyFiftiesAndTwentiesNotes").toString();
		actualOutput=actualOutputTmp.toString();
		assertTrue(expectedOutput.equals(actualOutput));
	
	}
	
}
