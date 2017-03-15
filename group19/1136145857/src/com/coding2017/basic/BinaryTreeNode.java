package com.coding2017.basic;

import java.util.NoSuchElementException;

/*
 * �����ң���߀���؁�ġ�
 */

public class BinaryTreeNode<Item extends Comparable<Item>>{
	
	
	private Node<Item> root;
	
	
	public  class Node<Item>{
		private Item data;
		private Node<Item> left;
		private Node<Item> right;
		
		public Node(){

		}
		
		public Node(Item o){
			this.data = o;
		}
	}
	
	public BinaryTreeNode(){
		this.root = new Node<Item>();
	}
	
	public BinaryTreeNode(Item data){
		this.root = new Node<Item>(data);
	}
	
	public Item getData() {
		return root.data;
	}
	
	public void setData(Item data) {
		this.root.data = data;
	}
	
	
	public Node<Item> getLeft() {
		
		return this.root.left == null?null:root.left;
	}
	
	public void setLeft(Node<Item> left) {
		this.root.left = left;
	}
	
	public Node<Item> getRight() {
		
		return this.root.right == null?null:root.right;
	}
	public void setRight(Node<Item> right) {
		this.root.right = right;
	}
	
	public boolean isEmpty(){
		return this.root.data == null;
	}
	
	public Node<Item> getRoot(){
		
			return this.root;

	} 
	
	public void insert(Item o){
		if(o == null){
			System.out.println("????");
			throw new NullPointerException("argument is null");
			
		}
		this.root = insert(this.root,o);
		/*
		System.out.println("----");
		System.out.println("��ʼ�Y�c��Ն᣿��"+isEmpty());
		System.out.println("ԓ���c��data�飺"+getData());
		System.out.println("ԓ���c��left�飺"+getLeft());
		System.out.println("ԓ���c��right�飺"+getRight());
		*/
	}
	
	private Node<Item> insert(Node<Item> node,Item o){
		//Node<Item> target;
		if(node.data == null){
			/*
			target = new Node<Item>(o);
			return target;
			*/
			System.out.println("######");
			
			return new Node<Item>(o);
		}
			System.out.println("****");
			//int cmp = o.compareTo(node.data);
			int cmp = (o.toString().compareTo(node.data.toString()));
			if(cmp < 0){
				/*
				if(getLeft() == null){
					target = new Node<Item>(o);
					setLeft(target);
					return getLeft();
				}else{
					return root.left.insert(o);
				}
				*/
				node.left = insert(node.left,o);
			}else if(cmp >0){
				/*
				if(getRight() == null){
					target = new Node<Item>(o);
					setRight(target);
					return getRight();
				}else{
					return insert(o);
				}*/
				node.right = insert(node.right,o);
			}else{
				node.data = o;
			}
			return node;
	}
	
	public static void main(String[] args ){
		BinaryTreeNode<Integer> tree = new BinaryTreeNode<Integer>();
		tree.insert(new Integer(4));
		tree.insert(new Integer(1));
	}
}
