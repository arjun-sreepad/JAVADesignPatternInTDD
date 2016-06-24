package com.xebia.designpattern.structural.decorator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.framework.TestFilePath;

public class DecoratorExampleTest {

	static DecoratorExample tDecoratorExample = new DecoratorExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;

	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tDecoratorExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void decorator_ProperInput_Successful() {
		Icecream icecream = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
		actualValue = icecream.makeIcecream();
		expectedValue = tProperties.get("decorator_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void decorator_ImproperInput_Failure() {
		Icecream icecream = new HoneyDecorator(new SimpleIcecream());
		actualValue = icecream.makeIcecream();
		expectedValue = tProperties.get("decorator_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));
	}

	@Test
	public void decorator_SimpleIceCream_BaseIceCream() {
		Icecream icecream = new SimpleIcecream();
		actualValue = icecream.makeIcecream();
		expectedValue = tProperties.get("decorator_SimpleIceCream_BaseIceCream").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void decorator_SimplePlusNuttyIceCream_BasePlusCrunchyIceCream() {
		Icecream icecream = new NuttyDecorator(new SimpleIcecream());
	    actualValue = icecream.makeIcecream();
	    expectedValue = tProperties.get("decorator_SimplePlusNuttyIceCream_BasePlusCrunchyIceCream").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void decorator_SimplePlusHoneyIceCream_BasePlusSweetIceCream() {
		Icecream icecream = new HoneyDecorator(new SimpleIcecream());
	    actualValue = icecream.makeIcecream();
	    expectedValue = tProperties.get("decorator_SimplePlusHoneyIceCream_BasePlusSweetIceCream").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void decorator_SimplePlusHoneyPLusNuttyIceCream_BasePlusSweetPlusCrunchyIceCream() {
		Icecream icecream = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
	    actualValue = icecream.makeIcecream();
	    expectedValue = tProperties.get("decorator_SimplePlusHoneyPLusNuttyIceCream_BasePlusSweetPlusCrunchyIceCream").toString();
	    assertTrue(actualValue.equals(expectedValue));
	}
}

