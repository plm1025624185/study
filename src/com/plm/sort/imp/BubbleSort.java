package com.plm.sort.imp;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 冒泡排序（默认升序排序）
 * 
 * 算法思想：
 *     1.在一趟遍历中，不断地对相邻的两个元素进行排序，小的在前大的在后，这样会造成大值不断
 * 沉底的效果，当一趟遍历完成时，最大的元素会被排在后方正确的位置上。
 *     2.然后缩小排序范围，即去掉最后方位置正确的元素，对前方数组进行新一轮遍历，重复第1
 * 步骤。直到范围不能缩小为止，排序完成。
 * @author ex_panleiming
 *
 */
public class BubbleSort extends BaseSort {

	@Override
	public void sort(int[] array, SortType type) {
		if(type == SortType.asc){
			sortAsc(array);
		}else if(type == SortType.desc){
			sortDesc(array);
		}
	}
	
	/**
	 * 进行升序排序
	 * @param array
	 */
	private void sortAsc(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			for(int j = 0; j < array.length - 1 - i; j++){
				//当前一个大于后一个时，则进行交换
				if(array[j] > array[j + 1]){
					swap(array, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * 进行降序排序
	 * @param array
	 */
	private void sortDesc(int[] array){
		
	}

	@Override
	public void sort(int[] array) {
		sort(array, SortType.asc);
	}
}
