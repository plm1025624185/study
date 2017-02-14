package com.plm.sort.imp;

import java.util.Arrays;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 计数排序
 * 
 * 基本思想：对每一个输入元素x，确定小于x的元素个数，利用这一信息，可以直接把x放到它在输出数组中的位置上了。
 * 
 * @author ex_panleiming
 *
 */
public class CountSort extends BaseSort {
	//初始数组，用来复制乱序的数组
	private int[] srcArray;
	
	//临时的存储空间的数组
	private int[] sortArray;
	
	//默认的数组中的最大值
	private int maxValue = 20;
	
	public CountSort(){
		
	}
	
	public CountSort(int maxValue){
		this.maxValue = maxValue;
	}

	@Override
	public void sort(int[] array, SortType type) {
		if(SortType.asc.equals(type)){
			sortAsc(array);
		}else if(SortType.desc.equals(type)){
			sortDesc(array);
		}
	}

	@Override
	public void sort(int[] array) {
		sort(array, SortType.asc);
	}
	
	private void sortAsc(int[] array){                          
		//首先将当前乱序的数组复制到srcArray中
		srcArray = Arrays.copyOfRange(array, 0, array.length);
		//将临时空间数组初始化并赋值为0
		sortArray = new int[maxValue];
		//通过对临时空间数组赋值来统计源数组中的各个元素的数量
		for(int i = 0; i < srcArray.length; i++){
			sortArray[srcArray[i]]++;
		}
		//在临时空间数组中统计小于当前值的个数
		for(int i = 1; i < sortArray.length; i++){
			sortArray[i] = sortArray[i] + sortArray[i - 1];
		}
		//进行排序
		for(int i = 0; i < srcArray.length; i++){
			int value = srcArray[i];
			array[sortArray[value] - 1] = value;
			sortArray[value]--;
		}
	}

	private void sortDesc(int[] array){
		
	}
}
