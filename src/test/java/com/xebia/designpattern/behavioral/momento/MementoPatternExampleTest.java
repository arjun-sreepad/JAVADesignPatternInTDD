package com.xebia.designpattern.behavioral.momento;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.xebia.framework.TestFilePath;

public class MementoPatternExampleTest {
	static MementoPatternExample tMementoPatternExample = new MementoPatternExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;
	String actualValue;
	String expectedValue;

	@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tMementoPatternExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void checkMomentoPattern_ProperInput_Successful() {
		StringBuilder tempActualValue = new StringBuilder();
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		tempActualValue.append("Current State: " + originator.getState()+"\n");

		originator.getStateFromMemento(careTaker.get(0));
		tempActualValue.append("First saved State: " + originator.getState()+"\n");
		originator.getStateFromMemento(careTaker.get(1));
		tempActualValue.append("Second saved State: " + originator.getState()+"\n");
		actualValue = tempActualValue.toString();
		expectedValue = tProperties.get("checkMomentoPattern_ProperInput_Successful").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void checkMomentoPattern_ImproperInput_Failure() {
		StringBuilder tempActualValue = new StringBuilder();
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");

		originator.getStateFromMemento(careTaker.get(0));
		tempActualValue.append("First saved State: " + originator.getState()+"\n");
		originator.getStateFromMemento(careTaker.get(1));
		tempActualValue.append("Second saved State: " + originator.getState()+"\n");
		actualValue = tempActualValue.toString();
		expectedValue = tProperties.get("checkMomentoPattern_ImproperInput_Failure").toString();
		assertFalse(actualValue.equals(expectedValue));
	}

	@Test
	public void checkMomentoPattern_saveLastThreeStates_SuccessfulRetriveLastThreeStates() {
		StringBuilder tempActualValue = new StringBuilder();
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("State #1");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		tempActualValue.append("Current State: " + originator.getState()+"\n");

		originator.getStateFromMemento(careTaker.get(0));
		tempActualValue.append("First saved State: " + originator.getState()+"\n");
		originator.getStateFromMemento(careTaker.get(1));
		tempActualValue.append("Second saved State: " + originator.getState()+"\n");
		originator.getStateFromMemento(careTaker.get(2));
		tempActualValue.append("Third saved State: " + originator.getState()+"\n");
		actualValue = tempActualValue.toString();
		expectedValue = tProperties.get("checkMomentoPattern_saveLastThreeStates_SuccessfulRetriveLastThreeStates").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void checkMomentoPattern_checkOrderOfretrivedStates_OutputStatesShouldBeInExpectedOredr() {
		StringBuilder tempActualValue = new StringBuilder();
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("State #1");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		tempActualValue.append("Current State: " + originator.getState()+"\n");

		originator.getStateFromMemento(careTaker.get(0));
		tempActualValue.append("First saved State: " + originator.getState()+"\n");
		originator.getStateFromMemento(careTaker.get(1));
		tempActualValue.append("Second saved State: " + originator.getState()+"\n");
		originator.getStateFromMemento(careTaker.get(2));
		tempActualValue.append("Third saved State: " + originator.getState()+"\n");
		actualValue = tempActualValue.toString();
		expectedValue = tProperties.get("checkMomentoPattern_checkOrderOfretrivedStates_OutputStatesShouldBeInExpectedOredr").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

	@Test
	public void checkMomentoPattern_checkIsMoreNumberOfStatesAreSaved_OutputStatesShouldCountToThree() {
		StringBuilder tempActualValue = new StringBuilder();
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("State #1");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		tempActualValue.append("Current State: " + originator.getState()+"\n");

		originator.getStateFromMemento(careTaker.get(0));
		tempActualValue.append("First saved State: " + originator.getState()+"\n");
		originator.getStateFromMemento(careTaker.get(1));
		tempActualValue.append("Second saved State: " + originator.getState()+"\n");
		originator.getStateFromMemento(careTaker.get(2));
		tempActualValue.append("Third saved State: " + originator.getState()+"\n");
		actualValue = tempActualValue.toString();
		expectedValue = tProperties.get("checkMomentoPattern_checkIsMoreNumberOfStatesAreSaved_OutputStatesShouldCountToThree").toString();
		assertTrue(actualValue.equals(expectedValue));
	}

}
