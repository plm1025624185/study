package com.plm.data;

/**
 * 栈（Stack）是一种后进先出（last in first off， LIFO）的数据结构
 * @author ex_panleiming
 *
 */
public interface Stack<T> {
	/**
	 * 往栈中添加一个新的元素
	 * @param t
	 */
	public void push(T t) throws Exception;
	
	/**
	 * 移除并返回最近添加的元素
	 * @return
	 */
	public T pop() throws Exception;
	
	/**
	 * 栈是否为空
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * 栈是否已满
	 * @return
	 */
	public boolean isFull();
	
	/**
	 * 返回栈中元素的个数
	 * @return
	 */
	public int size();
}
