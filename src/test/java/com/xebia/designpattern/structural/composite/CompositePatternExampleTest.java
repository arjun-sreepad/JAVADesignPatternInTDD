package com.xebia.designpattern.structural.composite;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.framework.TestFilePath;

public class CompositePatternExampleTest {

	static CompositePatternExample tCompositePatternExample = new CompositePatternExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;

	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tCompositePatternExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void checkCompositePattern_ProperInput_Successful() {
		StringBuilder tmpOutput = new StringBuilder();
		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);

		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

		CEO.add(headSales);
		CEO.add(headMarketing);

		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);

		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		// print all employees of the organization
		tmpOutput.append(CEO+"\n");

		for (Employee headEmployee : CEO.getSubordinates()) {
			tmpOutput.append(headEmployee+"\n");

			for (Employee employee : headEmployee.getSubordinates()) {
				tmpOutput.append(employee+"\n");
			}
		}

		actualValue = tmpOutput.toString();
		expectedValue = tProperties.get("checkCompositePattern_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void checkCompositePattern_ImproperInput_Failure() {
		StringBuilder tmpOutput = new StringBuilder();
		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);

		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);

		CEO.add(headSales);
		CEO.add(headMarketing);

		headSales.add(salesExecutive1);

		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		// print all employees of the organization
		tmpOutput.append(CEO+"\n");

		for (Employee headEmployee : CEO.getSubordinates()) {
			tmpOutput.append(headEmployee+"\n");

			for (Employee employee : headEmployee.getSubordinates()) {
				tmpOutput.append(employee+"\n");
			}
		}

		actualValue = tmpOutput.toString();
		expectedValue = tProperties.get("checkCompositePattern_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));
	}

	@Test
	public void checkCompositePattern_OneCEOThreeManagersEightSubordinates_OutputShouldBeAsExpected() {
		StringBuilder tmpOutput = new StringBuilder();
		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales1 = new Employee("Robert", "Head Sales", 10000);
		Employee headSales2 = new Employee("Tom", "Head Sales", 20000);
		Employee headSales3 = new Employee("Cook", "Head Sales", 30000);
		
	
		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Harry", "Sales", 20000);
		Employee salesExecutive3 = new Employee("Peter", "Sales", 30000);
		Employee salesExecutive4 = new Employee("Bob", "Sales", 40000);
		Employee salesExecutive5 = new Employee("Sam", "Sales", 50000);
		Employee salesExecutive6 = new Employee("Richard", "Sales", 60000);
		Employee salesExecutive7 = new Employee("Andrew", "Sales", 70000);
		Employee salesExecutive8 = new Employee("Peter", "Sales", 80000);

		CEO.add(headSales1);
		CEO.add(headSales2);
		CEO.add(headSales3);

		headSales1.add(salesExecutive1);
		headSales1.add(salesExecutive2);
		headSales1.add(salesExecutive3);
		headSales1.add(salesExecutive4);
		headSales1.add(salesExecutive5);
		headSales1.add(salesExecutive6);
		headSales1.add(salesExecutive7);
		headSales1.add(salesExecutive8);
		
		// print all employees of the organization
		tmpOutput.append(CEO+"\n");

		for (Employee headEmployee : CEO.getSubordinates()) {
			tmpOutput.append(headEmployee+"\n");

			for (Employee employee : headEmployee.getSubordinates()) {
				tmpOutput.append(employee+"\n");
			}
		}

		actualValue = tmpOutput.toString();
		expectedValue = tProperties.get("checkCompositePattern_OneCEOThreeManagersEightSubordinates_OutputShouldBeAsExpected").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void checkCompositePattern_NoSubordinatesToManager_OutputShouldBeAsExpected() {
		StringBuilder tmpOutput = new StringBuilder();
		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales1 = new Employee("Robert", "Head Sales", 10000);
		Employee headSales2 = new Employee("Tom", "Head Sales", 20000);
		Employee headSales3 = new Employee("Cook", "Head Sales", 30000);

		CEO.add(headSales1);
		CEO.add(headSales2);
		CEO.add(headSales3);
	
		// print all employees of the organization
		tmpOutput.append(CEO+"\n");

		for (Employee headEmployee : CEO.getSubordinates()) {
			tmpOutput.append(headEmployee+"\n");

			for (Employee employee : headEmployee.getSubordinates()) {
				tmpOutput.append(employee+"\n");
			}
		}

		actualValue = tmpOutput.toString();
		expectedValue = tProperties.get("checkCompositePattern_NoSubordinatesToManager_OutputShouldBeAsExpected").toString();
		assertTrue(actualValue.equals(expectedValue));
	}


	@Test
	public void checkCompositePattern_NoSubordinatesToCEO_OutputShouldBeAsExpected() {
		StringBuilder tmpOutput = new StringBuilder();
		Employee CEO = new Employee("John", "CEO", 30000);

		// print all employees of the organization
		tmpOutput.append(CEO+"\n");

		for (Employee headEmployee : CEO.getSubordinates()) {
			tmpOutput.append(headEmployee+"\n");

			for (Employee employee : headEmployee.getSubordinates()) {
				tmpOutput.append(employee+"\n");
			}
		}

		actualValue = tmpOutput.toString();
		expectedValue = tProperties.get("checkCompositePattern_NoSubordinatesToCEO_OutputShouldBeAsExpected").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

}
