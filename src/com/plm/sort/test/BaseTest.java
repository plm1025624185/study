package com.plm.sort.test;

import org.junit.Before;
import org.junit.Test;

import com.plm.sort.base.Sort;

/**
 * 测试类的基础类
 * @author ex_panleiming
 *
 */
public abstract class BaseTest {
	protected int[] array;
	protected Sort sort;
	
	@Before
	public void init(){
		sort = createSort();
		array = new int[getArrayLength()];
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random()*100); 
		}
	}
	
	/**
	 * 使用工厂模式，子类自己实现需要的算法
	 * @return
	 */
	public abstract Sort createSort();
	
	/**
	 * 打印数组
	 * @param array
	 */
	public void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
	
	@Test
	public void testSort(){
		printArray(array);
		sort.sort(array);
		printArray(array);
	}
	
	/**
	 * 获取测试数组的长度，子类要改变长度可以进行重写
	 * @return
	 */
	protected int getArrayLength(){
		return 10;
	}
}
