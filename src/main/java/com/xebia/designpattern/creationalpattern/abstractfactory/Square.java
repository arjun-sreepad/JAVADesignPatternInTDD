package com.xebia.designpattern.creationalpattern.abstractfactory;

public class Square implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Inside Square::draw() method.");
	   }
	}