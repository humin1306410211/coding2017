package com.coding2017.basic.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.coding2017.basic.BinaryTreeNode;



public class BinaryTreeNodeTest {
	private BinaryTreeNode<Integer> binaryTreeNode;
	/**
		//	    4
		//	  1   5
		//  2 	3
	*/
	@Before 
	public void setUpBinaryTreeNode() {
		binaryTreeNode = new BinaryTreeNode<Integer>();
		binaryTreeNode.insert(4);
		binaryTreeNode.insert(1);
		//binaryTreeNode.insert(3);
		//binaryTreeNode.insert(5);
		//binaryTreeNode.insert(2);
	}

	@Test
	public void testBinaryTreeNodeFunctional1() {
		assertEquals(false,binaryTreeNode.isEmpty());
		assertEquals(new Integer(4),binaryTreeNode.getData());
		//assertEquals(new Integer(1),binaryTreeNode.getLeft().getData());
		//assertEquals(new Integer(5), binaryTreeNode.getRight().getData());
		//assertEquals(new Integer(3), node.getData());
		//assertEquals(2, binaryTreeNode.getLeft().getRight().getLeft().getData());
	}
}
