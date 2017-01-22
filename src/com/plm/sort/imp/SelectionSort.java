package com.plm.sort.imp;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 选择排序（默认为升序）
 * 算法思想
 *     1.暂定第一个元素为最小元素，往后遍历，逐个与最小元素比较，若发现更小者，
 * 与先前的“最小元素”交换位置。达到更新最小元素的目的。
 *     2.一趟遍历完成后，能确保刚刚完成的这一趟遍历中，最小的元素已经放置在前方了。
 * 然后缩小排序范围，新一趟排序从数组的第二个元素开始。
 *     3.在新一轮排序中重复第1、2步骤，直到范围不能缩小为止，排序完成
 * @author ex_panleiming
 *
 */
public class SelectionSort extends BaseSort {

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
	public void sortAsc(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			for(int j = i; j < array.length; j++){
				if(array[i] > array[j]){
					swap(array, i, j);
				}
			}
		}
	}
	
	/**
	 * 进行降序排序
	 * @param array
	 */
	public void sortDesc(int[] array){
		
	}

	@Override
	public void sort(int[] array) {
		sort(array, SortType.asc);
	}
}
