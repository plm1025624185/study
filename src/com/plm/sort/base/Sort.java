package com.plm.sort.base;

import com.plm.sort.util.SortType;

/**
 * 排序接口
 * @author ex_panleiming
 *
 */
public interface Sort {
	/**
	 * 排序方法，进行排序
	 * @param array 需要进行的排序数组
	 * @param type 是升序排序还是降序排序
	 */
	public void sort(int[] array, SortType type);
	
	/**
	 * 默认排序方法
	 * @param array
	 */
	public void sort(int[] array);
}
