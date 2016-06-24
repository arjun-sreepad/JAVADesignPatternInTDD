package com.xebia.designpattern.creationalpattern.builder;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.designpattern.behavioral.template.TemplatePatternExample;
import com.xebia.framework.TestFilePath;

public class BuilderExampleTest {

	static BuilderExample tBuilderExample = new BuilderExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;
	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tBuilderExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void buildComputer_ProperInput_Successful() {
		actualValue=new Computer.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(true).build().toString();
		expectedValue=tProperties.get("buildComputer_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void buildComputer_ImproperInput_Failure() {
		actualValue=new Computer.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(true).build().toString();
		expectedValue=tProperties.get("buildComputer_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));
	}
	
	@Test
	public void buildComputer_withoutBluetooth_ComputerWillNotHaveBluetooth() {
		actualValue=new Computer.ComputerBuilder("50 GB", "2 GB").setBluetoothEnabled(false).build().toString();
		expectedValue=tProperties.get("buildComputer_withoutBluetooth_ComputerWillNotHaveBluetooth").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
	
	@Test
	public void buildComputer_with50GBRam_ComputerWillHave50GBRam() {
		actualValue=new Computer.ComputerBuilder("50 GB", "2 GB").setBluetoothEnabled(true).build().toString();
		expectedValue=tProperties.get("buildComputer_with50GBRam_ComputerWillHave50GBRam").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
	
	@Test
	public void buildComputer_withgraphicsCard_ComputerWillHaveBluetooth() {
		actualValue=new Computer.ComputerBuilder("50 GB", "2 GB").setBluetoothEnabled(true).setGraphicsCardEnabled(true).build().toString();
		expectedValue=tProperties.get("buildComputer_withgraphicsCard_ComputerWillHaveBluetooth").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
}
