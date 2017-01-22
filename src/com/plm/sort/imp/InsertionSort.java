package com.plm.sort.imp;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 插入排序（默认为升序）
 * 
 * 简介
 *     插入排序是从一个乱序的数组中依次取值，插入到一个已经排好序的数组中。这看起来好像
 * 要两个数组才能完成，但如果只想在同一个数组内排序，也是可以的。此时需要想象出两个区域：
 * 前方有序区和后方乱序区。
 * 
 * 算法思想：
 *     1.分区。开始时前方有序区只有一个元素，就是数组的第一个元素。然后把从第二个元素开
 * 始直到结尾的数组作为乱序区。
 *     2.从乱序区取第一个元素，把它正确插入到前方有序区中。把它与前方有序区的最后一个元素
 * 比较，即与它前一个元素进行比较。如果比前一个元素大或相等，则不需要交换，这时有序区扩充一格，
 * 乱序区往后缩减一格，相当于直接拼在有序区末尾。反之则交换它们的位置。交换完后，继续往前
 * 进行比较。若更小就交换，直到遍历完成。
 *     3.往后缩小乱序区范围，继续取缩小范围后的第一个元素，重复第2步骤。直到范围不能缩小
 * 为止，排序完成。
 * @author ex_panleiming
 *
 */
public class InsertionSort extends BaseSort {

	@Override
	public void sort(int[] array, SortType type) {
		if(SortType.asc == type){
			sortAsc(array);
		}else if(SortType.desc == type){
			sortDesc(array);
		}
	}

	@Override
	public void sort(int[] array) {
		sort(array, SortType.asc);
	}
	
	/**
	 * 升序排序
	 * @param array
	 */
	public void sortAsc(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			int j = i;
			while(j >= 0 && array[j + 1] < array[j]){
				swap(array, j + 1, j);
				--j;
			}
		}
	}
	
	/**
	 * 降序排序
	 * @param array
	 */
	public void sortDesc(int[] array){
		
	}
}
