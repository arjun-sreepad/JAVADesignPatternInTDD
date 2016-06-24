package com.xebia.designpattern.behavioral.template;

public class GlassHouse extends HouseTemplate {
	 
    public StringBuilder buildWalls(StringBuilder houseStatus) {
    	return houseStatus.append("Building Glass Walls\n");
    }
 
    public StringBuilder buildPillars(StringBuilder houseStatus) {
    	return houseStatus.append("Building Pillars with glass coating\n");
    }
 
}