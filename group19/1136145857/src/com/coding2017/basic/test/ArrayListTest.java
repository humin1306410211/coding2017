package com.coding2017.basic.test;

import org.junit.Before;
import org.junit.Test;

import com.coding2017.basic.ArrayList;

import junit.framework.Assert;

public class ArrayListTest {
	private int initTestSize;
	private ArrayList arr;
	@Before
	public void init(){
		arr = new ArrayList();
		
		initTestSize = 5;
		
		for(int i = 0; i < initTestSize; i++){
			arr.add(i);
		}
	}
	@Test
	public void isEmptyTest() throws Exception{
		Assert.assertEquals(false, arr.isEmpty());
	}
	
	@Test
	public void sizeTest() throws Exception{
		Assert.assertEquals(initTestSize, arr.size());
	}
	
	@Test
	public void addTest() throws Exception{
		arr.add("ele-1");
		arr.add("ele-2");
		Assert.assertEquals(initTestSize+2,arr.size());
		arr.add(0, "ele-0");
		Assert.assertEquals("ele-0", arr.get(0));
	}
	
	@Test
	public void removeTest(){
		Assert.assertEquals(5,arr.size());
		arr.remove(0);
		Assert.assertEquals(4,arr.size());
		Assert.assertEquals(1, arr.get(0));
	}
}
