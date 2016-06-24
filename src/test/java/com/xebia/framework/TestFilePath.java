package com.xebia.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestFilePath {
	public String getResource(Object tObject)
	{
		String filePath = tObject.getClass().getName();
		filePath=filePath.replace('.','/');
		filePath=filePath.concat(".txt");
		return filePath;
	}
	
	public Properties getFile(String fileName) throws IOException {


		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		FileInputStream fileInput = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInput);
		fileInput.close();
		return properties;
	  }
}
