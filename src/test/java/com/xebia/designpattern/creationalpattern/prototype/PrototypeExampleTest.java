package com.xebia.designpattern.creationalpattern.prototype;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import com.xebia.framework.TestFilePath;

public class PrototypeExampleTest {
	static PrototypeExample tPrototypeExample = new PrototypeExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;
	static Employee emps;

	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tPrototypeExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emps = new Employee();
		emps.loadData();
	}

	@Test
	public void empListThroughProxy_ProperInput_Successful() throws CloneNotSupportedException {

		// Use the clone method to get the Employee object
		Employee empsNew = (Employee) emps.clone();
		List<String> list = empsNew.getEmpList();
		actualValue = "emp List: " + list;
		expectedValue = tProperties.get("empListThroughProxy_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void empListThroughProxy_ImproperInput_Failure() throws CloneNotSupportedException {

		// Use the clone method to get the Employee object
		Employee emp = (Employee) emps.clone();
		List<String> list = emp.getEmpList();
		list.add("John");

		actualValue = "emp List: " + list;
		expectedValue = tProperties.get("empListThroughProxy_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));
	}

	@Test
	public void empListThroughProxy_removeEmployee_EmployeeGetsRemovedInOutput() throws CloneNotSupportedException {

		// Use the clone method to get the Employee object
		Employee empsNew = (Employee) emps.clone();
		List<String> list = empsNew.getEmpList();
		list.remove("Lisa");

		actualValue = "emp List: " + list;
		expectedValue = tProperties.get("empListThroughProxy_removeEmployee_EmployeeGetsRemovedInOutput").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void empListThroughProxy_addNewEmployee_ExtraEmployeeInOutput() throws CloneNotSupportedException {

		// Use the clone method to get the Employee object
		Employee empsNew = (Employee) emps.clone();
		List<String> list = empsNew.getEmpList();
		list.add("John");

		actualValue = "emp List: " + list;
		expectedValue = tProperties.get("empListThroughProxy_addNewEmployee_ExtraEmployeeInOutput").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

}
