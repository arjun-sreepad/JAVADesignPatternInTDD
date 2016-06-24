package com.xebia.designpattern.behavioral.Iterator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.designpattern.behavioral.iterator.IteratorPatternExample;
import com.xebia.framework.TestFilePath;

public class IteratorPatternExampleTest {
	static IteratorPatternExample tIteratorPattern = new IteratorPatternExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;
	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tIteratorPattern);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getNamesFromArrayThroughIterator_EmptyArray_NullOutput() {
		String[] inpNames = {};
		actualValue = tIteratorPattern.getNamesFromArrayThroughIterator(inpNames).toString();
		expectedValue=tProperties.get("getNamesFromArrayThroughIterator_EmptyArray_NullOutput").toString();
		assert(actualValue.equals(expectedValue));

	}
	
	@Test
	public void getNamesFromArrayThroughIterator_ProperInput_Successful() {
		String[] inpNames = {"one","two","three","four"};
		actualValue = tIteratorPattern.getNamesFromArrayThroughIterator(inpNames).toString();
		expectedValue=tProperties.get("getNamesFromArrayThroughIterator_ProperInput_Successful").toString();
		assert(actualValue.equals(expectedValue));
	}

	@Test
	public void getNamesFromArrayThroughIterator_ImproperInput_Failure() {
		String[] inpNames = {"one","two","three"};
		actualValue = tIteratorPattern.getNamesFromArrayThroughIterator(inpNames).toString();
		expectedValue=tProperties.get("getNamesFromArrayThroughIterator_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));
	}
	
	@Test
	public void getNamesFromArrayThroughIterator_FiveNames_FiveNamesInOutput() {
		String[] inpNames = {"one","two","three","four","five"};
		actualValue = tIteratorPattern.getNamesFromArrayThroughIterator(inpNames).toString();
		expectedValue=tProperties.get("getNamesFromArrayThroughIterator_FiveNames_FiveNamesInOutput").toString();
		assert(actualValue.equals(expectedValue));
	}
}
