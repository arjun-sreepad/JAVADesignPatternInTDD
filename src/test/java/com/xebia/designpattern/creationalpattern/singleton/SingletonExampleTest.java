package com.xebia.designpattern.creationalpattern.singleton;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;
import com.xebia.framework.TestFilePath;

public class SingletonExampleTest {
	static SingletonExample tSingletonExample = new SingletonExample();
	static TestFilePath testFilePath = new TestFilePath();
	static Properties tProperties;

	/*@BeforeClass
	public static void setUP() {
		String filepath = testFilePath.getResource(tSingletonExample);
		try {
			tProperties = testFilePath.getFile(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@Test
	public void checkSingleton_ProperInput_Successful() {
		ThreadSafeSingleton[] threadSafeSingletonArray = new ThreadSafeSingleton[2];
		for (int i = 0; i < threadSafeSingletonArray.length; i++) {
			threadSafeSingletonArray[i]= ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		}
		assertTrue(tSingletonExample.checkSingleton(threadSafeSingletonArray));
	}

	@Test
	public void checkSingleton_ImproperInput_Failure() {
		ThreadSafeSingleton[] threadSafeSingletonArray = new ThreadSafeSingleton[5];
		for (int i = 2; i < threadSafeSingletonArray.length; i++) {
			threadSafeSingletonArray[i]= ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		}
		assertFalse(tSingletonExample.checkSingleton(threadSafeSingletonArray));
	
	}
	
	@Test
	public void checkSingleton_FourSingletonObjects_CreatesOnlyOneInstanceAllReferToSame() {
		ThreadSafeSingleton[] threadSafeSingletonArray = new ThreadSafeSingleton[4];
		for (int i = 0; i < threadSafeSingletonArray.length; i++) {
			threadSafeSingletonArray[i]= ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		}
		assertTrue(tSingletonExample.checkSingleton(threadSafeSingletonArray));
	}

}
