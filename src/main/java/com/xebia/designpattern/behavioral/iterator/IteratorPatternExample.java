package com.xebia.designpattern.behavioral.iterator;

/*Features 
This pattern is used to get a way to access the elements of a collection object in sequential 
manner without any need to know its underlying representation.
*/
public class IteratorPatternExample {

	public StringBuilder getNamesFromArrayThroughIterator(String[] inpNames) {
		NameRepository namesRepository = new NameRepository();
		namesRepository.setNames(inpNames);
		StringBuilder namesFromArray = new StringBuilder();
		for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
			String name = (String) iter.next();
			namesFromArray.append("Name : " + name + "\n");
		}
		return namesFromArray;
	}
}