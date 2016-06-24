package com.xebia.designpattern.behavioral.template;

public abstract class HouseTemplate {
	 
    //template method, final so subclasses can't override
    public final StringBuilder buildHouse(StringBuilder houseStatus){
        buildFoundation(houseStatus);
        buildPillars(houseStatus);
        buildWalls(houseStatus);
        buildWindows(houseStatus);
        return houseStatus.append("House is built.\n");
    }
 
    //default implementation
    private StringBuilder buildWindows(StringBuilder houseStatus) {
        return houseStatus.append("Building Glass Windows\n");
    }
 
    //methods to be implemented by subclasses
    public abstract StringBuilder buildWalls(StringBuilder houseStatus);
    public abstract StringBuilder buildPillars(StringBuilder houseStatus);
 
    private StringBuilder buildFoundation(StringBuilder houseStatus) {
    	return houseStatus.append("Building foundation with cement,iron rods and sand\n");
    }
}