package com.coding2017.basic.test;

public class JavaTest {
	public static void main(String[] args){
		int[] arr = new int[10];
		arr[0] = 1;
		arr[5] = 9;
		arr[9] = 7;
		//target[10] = 10;
		for(int n = 0;n<arr.length;n++){
			System.out.print(arr[n] + " ");
		}
		System.out.println("\n-----------------");
		arr = grow(arr,arr.length);
		for(int n = 0;n<arr.length;n++){
			System.out.print(arr[n] + " ");
		}
	}

	public static int[] grow(int[] arr, int length) {
		int[] target =new int[arr.length+length];
		System.arraycopy(arr, 0, target, 0, arr.length);
		return target;
	}
}
