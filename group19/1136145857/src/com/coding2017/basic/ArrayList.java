package com.coding2017.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList implements List,Iterable{
	private Object[] elementData ;
	private int n ;
	
	public ArrayList(){
		elementData = new Object[10];
		n = 0;
	}
	
	public boolean isEmpty(){
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public void add(Object o) {
		ensureCapacity(n+1);	
		elementData[n] = o;
		n++;
	}

	public void add(int index, Object o) {
		if (index < 0 || index >= n) {
			throw new NoSuchElementException("underflow");
		}
		ensureCapacity(n+1);
		System.arraycopy(elementData, index, elementData, index + 1, n - index);
		elementData[index] = o;
		n++;
	}

	public Object get(int index) {
		return elementData[index ];
	}

	public Object remove(int index) {
		if (index < 0 || index >= n) {
			throw new NoSuchElementException("underflow");
		}
		Object removeElement = elementData[index];
		System.arraycopy(elementData, index + 1, elementData, index, n - (index + 1));
		elementData[n-1] = null;
		n--;
		return removeElement;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(Object obj:elementData){
			s.append(obj + " ");
		}
		return s.toString();
	}
	
	public int length(){
		return elementData.length;
	}
	
	public void ensureCapacity(int minCapacity){
		if(minCapacity > length()){
			int newCapacity =Math.max(minCapacity, elementData.length* 2) ;
			Object[] newElementData = new Object[newCapacity];
			System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
			elementData = newElementData;
		}	
	}

	@Override
	public Iterator iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator{
		private int cur;
		
		public ArrayListIterator(){
			cur = 0;
		}
		
		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public Object next() {
			if(!hasNext()){
				throw new UnsupportedOperationException();	
			}
			Object data = elementData[cur++];
			return data;
		}
	}
}
