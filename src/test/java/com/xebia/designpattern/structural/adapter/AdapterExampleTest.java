package com.xebia.designpattern.structural.adapter;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.framework.TestFilePath;

public class AdapterExampleTest {

	static AdapterExample tAdapterExample = new AdapterExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;
	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tAdapterExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void listToArray_ProperInput_Successful() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		actualValue = tAdapterExample.convertArrayFromList(list).toString();
		expectedValue = tProperties.get("listToArray_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void listToArray_ImproperInput_Failure() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("three");
		actualValue = tAdapterExample.convertArrayFromList(list).toString();
		expectedValue = tProperties.get("listToArray_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));

	}
	
	@Test 
	public void listToArray_countNoOfElementsInOutput_SixElementsInOutput() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		actualValue = tAdapterExample.convertArrayFromList(list).toString();
		expectedValue = tProperties.get("listToArray_countNoOfElementsInOutput_SixElementsInOutput").toString();
		assertTrue(actualValue.equals(expectedValue));

	}
	
	@Test
	public void listToArray_checkElementsOrderInOutput_OutputShouldBeInExpectedOredr() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		list.add("two");
		actualValue = tAdapterExample.convertArrayFromList(list).toString();
		expectedValue = tProperties.get("listToArray_checkElementsOrderInOutput_OutputShouldBeInExpectedOredr").toString();
		assertTrue(actualValue.equals(expectedValue));

	}

}
