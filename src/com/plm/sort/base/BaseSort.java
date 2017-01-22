package com.plm.sort.base;

/**
 * 该类是排序基类，由于每个排序都有交换，故放到基类中实现
 * @author ex_panleiming
 *
 */
public  abstract class BaseSort implements Sort {
	/**
	 * 排序时数组交换的共有方法
	 * @param array 需要交换的数组
	 * @param i 交换的索引
	 * @param j 交换的索引
	 */
	protected void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
