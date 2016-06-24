package com.xebia.designpattern.structural.adapter;

import java.util.ArrayList;
//FPrintableListAdapter class which will implement PrintableList interface 
//and will deal with our adaptee class.

public class PrintableListAdapter implements PrintableList {

	public StringBuilder printList(ArrayList<String> list) {

		// Converting ArrayList<String> to String so that we can pass String to
		// adaptee class
		String listString = "";

		for (String s : list) {
			listString += s + "\t";
		}

		// instantiating adaptee class
		PrintString printString = new PrintString();
		return printString.print(listString);
	}
}