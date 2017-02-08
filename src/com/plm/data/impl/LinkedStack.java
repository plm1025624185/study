package com.plm.data.impl;

import com.plm.data.Stack;

/**
 * 使用链表形式实现栈
 * @author ex_panleiming
 *
 */
public class LinkedStack<T> implements Stack<T> {
	private int maxSize;//栈的最大数量
	private Node first;//最开始的链表
	private int size;//当前存放的元素数量
	
	public LinkedStack(){
		this.maxSize = 10;
		this.size = 0;
		first = null;
	}
	
	public LinkedStack(int maxSize){
		this.maxSize = maxSize;
		this.size = 0;
		first = null;
	}

	@Override
	public void push(T t) throws Exception {
		if(isFull()){
			throw new Exception("Stack is full, cannot push elements!");
		}else{
			Node oldNode = first;
			Node newNode = new Node();
			newNode.value = t;
			newNode.next = oldNode;
			first = newNode;
			++this.size;
		}
	}

	@Override
	public T pop() throws Exception {
		if(isEmpty()){
			throw new Exception("Stack is empty, cannot pop elements!");
		}else{
			Node tmp = first;
			first = first.next;
			--this.size;
			return tmp.value;
		}
	}

	@Override
	public boolean isEmpty() {
		if(this.first == null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if(this.size == this.maxSize){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	private class Node{
		public T value;//存放值
		public Node next;//存放链表的下一个地址
	}
}
