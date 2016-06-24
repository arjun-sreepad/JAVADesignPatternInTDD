package com.xebia.designpattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;
/*Features 

Convert the interface of a class into another interface clients expect. 
Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.

Adaptee is the existing interface that needs adapting in order for our client to interact with it.
The Adapter adapts the Adaptee to the Target interface - in other words, 
it translates the request from the client to the adaptee. 

Advantages
The main advantage of this pattern is to have minimal instance creation process which is much 
costly than cloning process.

When To Use
The main use of this pattern is when a class that you need to use doesn't meet the 
requirements of an interface. As mentioned before, adapters are common across Eclipse plug-ins. For a particular object to contribute to the Properties view, adapters are used display the objects data. The view itself doesn't need to know anything about the object the it is displaying properties for. 

Downside
Some say that the Adapter pattern is just a fix for a badly designed system, which 
didn't consider all possibilities. While this is a fair point, it is an important part of a pluggable architecture.  It can also add a level of complexity to your code, making debugging more difficult.
*/

public class AdapterExample {
	public static void main(String[] args) {
		StringBuilder arrayFromList = new StringBuilder();
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		AdapterExample adapterExample = new AdapterExample();
		System.out.println(adapterExample.convertArrayFromList(list).toString());
	}
	
	public StringBuilder convertArrayFromList(ArrayList<String> inpArrayList)
	{
		StringBuilder arrayFromList;
		PrintableList pl = new PrintableListAdapter();
		arrayFromList = pl.printList(inpArrayList);
		
		return arrayFromList;
	}
}
