package com.xebia.designpattern.structural.proxy;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test; 
import com.xebia.framework.TestFilePath;

public class ProxyExampleTest {
	static ProxyExample tProxyExample = new ProxyExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;
	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tProxyExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void proxyExecuter_ProperInput_Successful() throws Exception {
		actualValue = tProxyExample.proxyExecuter("admin", "admin", "create").toString();
		expectedValue = tProperties.get("proxyExecuter_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test(expected = Exception.class)
	public void proxyExecuter_ImproperInput_Failure() throws Exception {
		actualValue = tProxyExample.proxyExecuter("admin", "wrongpassword", "create").toString();
		expectedValue = tProperties.get("proxyExecuter_ImproperInput_Failure").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
	
	@Test(expected = Exception.class)
	public void proxyExecuter_invalidUser_ExceptionThrown() throws Exception {
		actualValue = tProxyExample.proxyExecuter("invaliduser", "admin", "create").toString();
		expectedValue = tProperties.get("proxyExecuter_invalidUser_ExceptionThrown").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
	
	@Test(expected = Exception.class)
	public void proxyExecuter_invalidPassword_ExceptionThrown() throws Exception {
		actualValue = tProxyExample.proxyExecuter("error", "admin", "create").toString();
		expectedValue = tProperties.get("proxyExecuter_invalidPassword_ExceptionThrown").toString();
		assertFalse(actualValue.equals(expectedValue));
	}

	@Test(expected = Exception.class)
	public void proxyExecuter_userNameInWrongCase_ExceptionThrown() throws Exception {
		actualValue = tProxyExample.proxyExecuter("ADMIN", "admin", "create").toString();
		expectedValue = tProperties.get("proxyExecuter_userNameInWrongCase_ExceptionThrown").toString();
		assertTrue(actualValue.equals(expectedValue));
	}
}
