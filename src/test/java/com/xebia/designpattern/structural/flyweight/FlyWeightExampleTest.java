package com.xebia.designpattern.structural.flyweight;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.xebia.framework.TestFilePath;

public class FlyWeightExampleTest {

	static FlyWeightExample tFlyWeightExample = new FlyWeightExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;

	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tFlyWeightExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void flyWeightObjCreator_ProperInput_Successful() {
		String colors[] = { "Red", "Green", "Blue", "White", "Black" };
		int numberOfElementsRequired=90;
		int numberOfElementsCreated=(tFlyWeightExample.flyWeightObjCreator(colors,numberOfElementsRequired));
		assertTrue(numberOfElementsCreated==5);
	}

	@Test
	public void flyWeightObjCreator_ImproperInput_Failure() {
		String colors[] = { "Red", "Green", "Blue", "White", "Black" };
		int numberOfElementsRequired=90;
		int numberOfElementsCreated=(tFlyWeightExample.flyWeightObjCreator(colors,numberOfElementsRequired));
		assertFalse(numberOfElementsCreated==3);
	}

	@Test
	public void flyWeightObjCreator_SixColorsAsInput_CreateSixObjects() {
		String colors[] = { "Red", "Green", "Blue", "White", "Black","Brown" };
		int numberOfElementsRequired=90;
		int numberOfElementsCreated=(tFlyWeightExample.flyWeightObjCreator(colors,numberOfElementsRequired));
		assertTrue(numberOfElementsCreated==6);
	}

}
