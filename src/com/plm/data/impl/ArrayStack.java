package com.plm.data.impl;

import com.plm.data.Stack;

/**
 * 用数组来实现栈
 * @author ex_panleiming
 *
 */
public class ArrayStack<T> implements Stack<T> {
	private int maxSize;//栈的最大数量
	private T[] elements;//用来存储元素
	private int index;//当前的索引
	
	public ArrayStack(){
		this.maxSize = 10;//默认为10
		this.index = 0;
		elements = (T[]) new Object[this.maxSize];
	}
	
	public ArrayStack(int maxSize){
		this.maxSize = maxSize;
		this.index = 0;
		elements = (T[]) new Object[this.maxSize];
	}
	
	

	@Override
	public void push(T t) throws Exception {
		if(isFull()){
			throw new Exception("Stack is full, cannot push elements!");
		}else{
			this.elements[this.index] = t;
			++this.index;
		}
	}

	@Override
	public T pop() throws Exception {
		if(isEmpty()){
			throw new Exception("Stack is empty, cannot pop elements!");
		}else{
			T tmp = elements[this.index - 1];
			elements[this.index - 1] = null;
			--this.index;
			return tmp;
		}
	}

	@Override
	public boolean isEmpty() {
		if(this.index != 0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean isFull() {
		if(this.index == this.maxSize){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int size() {
		return this.index;
	}

	
}
