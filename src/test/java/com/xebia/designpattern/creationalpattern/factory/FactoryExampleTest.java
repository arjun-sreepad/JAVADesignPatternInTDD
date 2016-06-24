package com.xebia.designpattern.creationalpattern.factory;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.xebia.framework.TestFilePath;

public class FactoryExampleTest {

	static FactoryExample tFactoryExample = new FactoryExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;

	/*@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tFactoryExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@Test
	public void currencyFactory_ProperInput_Successful() {
		String country = "INDIA";
		Currency rupee = CurrencyFactory.createCurrency(country);
		actualValue = rupee.getSymbol();
		//expectedValue = tProperties.get("currencyFactory_ProperInput_Successful").toString();
		assertTrue(actualValue.equals("Rs"));
	}

	@Test
	public void currencyFactory_ImproperInput_Failure() {
		String country = "SINGAPORE";
		Currency rupee = CurrencyFactory.createCurrency(country);
		actualValue = rupee.getSymbol();
	///	expectedValue = tProperties.get("currencyFactory_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals("USD"));
	}

	@Test
	public void currencyFactory_IndiaAsCountry_RupeeIsCurrency() {
		String country = "India";
		Currency rupee = CurrencyFactory.createCurrency(country);
		actualValue = rupee.getSymbol();
	//	expectedValue = tProperties.get("currencyFactory_IndiaAsCountry_RupeeIsCurrency").toString();
		assertTrue(actualValue.equals("Rs"));
	}

	@Test
	public void currencyFactory_SingaporeAsCountry_SGDollarIsCurrency() {
		String country = "Singapore";
		Currency rupee = CurrencyFactory.createCurrency(country);
		actualValue = rupee.getSymbol();
		//expectedValue = tProperties.get("currencyFactory_SingaporeAsCountry_SGDollarIsCurrency").toString();
		assertTrue(actualValue.equals("SGD"));
	}

	@Test
	public void currencyFactory_USAsCountry_USDIsCurrency() {
		String country = "US";
		Currency rupee = CurrencyFactory.createCurrency(country);
		actualValue = rupee.getSymbol();
		//expectedValue = tProperties.get("currencyFactory_USAsCountry_USDIsCurrency").toString();
		assertTrue(actualValue.equals("USD"));
	}

}
