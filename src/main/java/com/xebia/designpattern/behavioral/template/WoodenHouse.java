package com.xebia.designpattern.behavioral.template;

public class WoodenHouse extends HouseTemplate {
	 
    public StringBuilder buildWalls(StringBuilder houseStatus) {
    	return houseStatus.append("Building Wooden Walls\n");
    }
 
   public StringBuilder buildPillars(StringBuilder houseStatus) {
	   return houseStatus.append("Building Pillars with Wood coating\n");
    }
 
}
