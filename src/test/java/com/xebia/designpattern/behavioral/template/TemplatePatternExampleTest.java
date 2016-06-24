package com.xebia.designpattern.behavioral.template;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.xebia.framework.TestFilePath;

public class TemplatePatternExampleTest {
	static TemplatePatternExample tTemplatePatternExample = new TemplatePatternExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;
	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tTemplatePatternExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void buildHome_ProperInput_Successful() {
		actualValue = tTemplatePatternExample.buildHome(new GlassHouse()).toString();
		expectedValue=tProperties.get("buildHome_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void buildHome_ImproperInput_Failure() {
		actualValue = tTemplatePatternExample.buildHome(new GlassHouse()).toString();
		expectedValue=tProperties.get("buildHome_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));
	}

	@Test
	public void buildHome_BuildGlassHome_GlassHomeToBeBuilt() {
		actualValue = tTemplatePatternExample.buildHome(new GlassHouse()).toString();
		expectedValue=tProperties.get("buildHome_BuildGlassHome_GlassHomeToBeBuilt").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void buildHome_BuildWoodenHome_WoodenHomeToBeBuilt() {
		actualValue = tTemplatePatternExample.buildHome(new WoodenHouse()).toString();
		expectedValue=tProperties.get("buildHome_BuildWoodenHome_WoodenHomeToBeBuilt").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
	
	@Test
	public void buildHome_testOrderOfBuild_ProperOrderAsMentionedInOutput() {
		actualValue = tTemplatePatternExample.buildHome(new WoodenHouse()).toString();
		expectedValue=tProperties.get("buildHome_testOrderOfBuild_ProperOrderAsMentionedInOutput").toString();
		assertTrue(actualValue.equals(expectedValue));
	}


}
