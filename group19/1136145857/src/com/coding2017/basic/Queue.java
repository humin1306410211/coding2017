package com.coding2017.basic;

import java.util.Iterator;

public class Queue implements Iterable{
	LinkedList elementData = new LinkedList();
	
	public boolean isEmpty(){
		return elementData.isEmpty();
	}
	
	public int size(){
		return elementData.size();
	}
	
	public void enQueue(Object o){
		elementData.add(o);
	}
	
	public Object deQueue(){
		return elementData.removeFirst();
	}
	
	public Object peek(){
		return elementData.get(0);
	}
	
	public String toString(){
		return elementData.toString();
	}
	
	@Override
	public Iterator iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator{

		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public Object next() {
			return elementData.iterator().next();
		}
		
	}
}
