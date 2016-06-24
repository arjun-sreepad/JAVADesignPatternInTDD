package com.xebia.designpattern.structural.adapter;
//This is our Adaptee
public class PrintString {
	public StringBuilder print(String s) {
		StringBuilder arrayFromList = new StringBuilder();
		return arrayFromList.append(s+" ");
	}
}