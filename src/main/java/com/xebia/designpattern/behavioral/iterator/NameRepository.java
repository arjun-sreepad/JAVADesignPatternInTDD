package com.xebia.designpattern.behavioral.iterator;

public class NameRepository implements Container {
	   public String names[];

	   public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public Iterator getIterator() {
	      return new NameIterator();
	   }

	   private class NameIterator implements Iterator {

	      int index;

	      public boolean hasNext() {
	      if(names!=null)
	         if(index < names.length){
	            return true;
	         }
	         return false;
	      }

	     public Object next() {
	      
	         if(this.hasNext()){
	            return names[index++];
	         }
	         return null;
	      }		
	   }
	}