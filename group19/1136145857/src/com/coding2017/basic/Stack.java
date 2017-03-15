package com.coding2017.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack implements Iterable{
	ArrayList elementData = new ArrayList();
	
	public boolean isEmpty(){
		return elementData.isEmpty();
	}

	public Object size() {
		return elementData.size();
	}
	
	public void push(Object o){
		elementData.ensureCapacity(elementData.size());
		elementData.add(o);
	}
	
	public Object pop(){
		if(elementData.isEmpty()){
			throw new NoSuchElementException();
		}else{
			Object data = elementData.remove(elementData.size()-1);
			return data;
		}
		
	}
	
	public Object peek(){
		
		if(elementData.isEmpty()){
			throw new NoSuchElementException();
		}else{
			Object data = elementData.get(elementData.size()-1);
			return data;
		}
	}
	
	@Override
	public Iterator iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator{
		private int cur;
		@Override
		public boolean hasNext() {
			return !elementData.isEmpty();
		}

		@Override
		public Object next() {
			if(!hasNext()){
				throw new UnsupportedOperationException();
			}else{
				Object data = elementData.get(cur++);
				return data;
			}
		}
	}

	
}
