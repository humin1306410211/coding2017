package com.coding2017.basic.test;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.coding2017.basic.LinkedList;

public class LinkedListTest {
	private LinkedList link;
	
	@Before
	public void setUpLinkedList() {
		link = new LinkedList();
	}

	@Test 
	public void isEmptyTest(){
		assertEquals(true,link.isEmpty());
	}
	
	@Test 
	public void sizeTest(){
		assertEquals(0,link.size());
	}
	
	@Test
	public void addLastTest() {
		link.add("hello");
		assertEquals("hello", link.get(0));
		
		link.add("world");
		assertEquals("hello", link.get(0));
		assertEquals("world", link.get(1));
		assertEquals(2, link.size());
	}
	
	@Test 
	public void addTest(){
		link.add("a");
		link.add("b");
		link.add("c");
		assertEquals("b",link.get(1));
		
		link.add(1, "s");
		assertEquals("s",link.get(1));
		assertEquals("b",link.get(2));
		assertEquals(4, link.size());
	}
	
	@Test
	public void addFirstTest() {
		link.addFirst(5);
		Assert.assertEquals(5, link.get(0));
	
		link.addFirst(6);
		assertEquals(6, link.get(0));
		assertEquals(5, link.get(1));
		assertEquals(2, link.size());
	}
	
	@Test
	public void removeFirstTest() {
		link.add("hello");
		link.add("world");
		
		link.removeFirst();
		assertEquals("world", link.get(0));
		assertEquals(1, link.size());
		
		link.removeFirst();
		assertEquals(0, link.size());
	}
	
	@Test
	public void removeLastTest() {
		link.addFirst("world");
		link.addFirst("hello");
		
		link.removeLast();
		assertEquals("hello", link.get(0));
		assertEquals(1, link.size());
		
		link.removeLast();
		assertEquals(0, link.size());
	}
	
	@Test
	public void removeTest(){
		link.add("hello");
		link.add("world");
		link.add("java");
		link.add("servlet");
		assertEquals("java",link.get(2));
		assertEquals("servlet",link.get(3));
		
		link.remove(2);
		assertEquals("servlet",link.get(2));
	}
	
	@Test
	public void testLinkedListFunctional() {
		for (int i=1; i<4; i++) {
			link.add(i);  // [1,2,3]
		}
		link.remove(1);  // [1,3]
		
		link.add(1, 0);  // [1,0,3]
		for (int i=4; i<6; i++) {
			link.addFirst(i);  // [5, 4, 1, 0, 3]
		}
		assertEquals(5, link.size());
		assertEquals(5, link.get(0));
		assertEquals(1, link.get(2));
		assertEquals(0, link.get(3));
		
		link.remove(3);  // [5, 4, 1, 3]
		assertEquals(3, link.get(link.size()-1));
		link.removeLast();  // [5, 4, 1]
		assertEquals(1, link.get(link.size()-1));
		link.removeFirst();   // [4,1]
		
		assertEquals(4, link.get(0));
		assertEquals(1, link.get(1));
		assertEquals(2, link.size());
	}
}
