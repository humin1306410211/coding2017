package com.coding2017.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements List,Iterable{
	private Node first;
	private int n;
	
	private static class Node{
		private Object data;
		private Node next;
	}
	
	public LinkedList (){
		first = null;
		n = 0;
	}
	
	public int size(){
		return n;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void add(Object o){
		if( isEmpty() ){
			first = new Node();
			first.data = o;
			first.next = null;
		} else{
			Node tail = first;
			while(tail.next != null){
				tail = tail.next;
			}
			Node node = new Node();
			node.data = o;
			tail.next = node;
		}
		n++;
	}
	
	public void add(int index,Object o){
		if (index < 0 || index >= n) {
			throw new NoSuchElementException();
		}
		
		if(index == 0){
			Node node = new Node();
			node.data = o;
			node.next = first;
			first = node;
		}else{ 
			Node preNode = first;
			for(int i = 0; i < index - 1; i++){
				preNode = preNode.next;
			}
			Node node = new Node();
			node.data = o;
			node.next = preNode.next;
			preNode.next = node;
		}
		n++;
	}
	
	public Object get(int index){
		Node current = first;
		for(int i =0; i <index; i++){
			current = current.next;
		}
		return current.data;
	}
	
	public Object remove(int index){
		Node current;
		
		if(index < 0 || index > n ){
			throw new NoSuchElementException();
		}
		
		if(first == null){
			throw new NoSuchElementException();
		}else{
			Node preNode = first;
			for(int i = 0; i < index - 1; i++){
				preNode = preNode.next;
			}
			current = preNode.next;
			preNode.next = preNode.next.next;
		}
		n--;
		return current.data;
	}
	
	
	public void addFirst(Object o){
		if(first == null){
			first = new Node();
			first.data = o;
			first.next = null;
		}else{
			Node node = new Node();
			node.data = o;
			node.next = first;
			first = node;
		}
		n++;
	}
	
	public Object removeFirst(){
		Node current;
		if(first == null){
			throw new NoSuchElementException();
		}else{
			current = first;
			first = first.next;
		}
		n--;
		return current.data;
	}
	
	public Object removeLast(){
		Node current;
		Node preNode = first;
		if(first == null){
			throw new NoSuchElementException();
		}else if(n == 1){
			current = first;
			first = null;
		}else{
			for(int i = 1; i < n - 1; ++i){
				preNode = preNode.next;
			}
			/*
			  while(preNode.next.next != null){
			  		preNode = preNode.next;
			  }
			 */
			current = preNode.next;
			preNode.next = null;
		}
		n--;
		return current.data;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Object data:this){
			sb.append(data + " ");
		}	
		return sb.toString();
	}

	public Iterator iterator() {
		return new LinkedListIterator(first);
	}
	
	private class LinkedListIterator implements Iterator{
		private Node current;
		
		public LinkedListIterator(Node first){
			current = first;
		}
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Object next() {
			if(!hasNext()){
				throw new UnsupportedOperationException();
			}
			Object data = current.data;
			current = current.next;
			return data;
		}
	}
}
