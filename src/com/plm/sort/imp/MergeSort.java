package com.plm.sort.imp;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 归并排序
 * 
 * 简介
 *     归并排序主要是将数组归类，切成一份份的，然后各份之间排好序，然后在和其他一起合并后，
 * 再进行排序，以此类推直到全部合并成一个整的数组
 * 
 * 实现思路：
 *     1.首先将数组进行拆分成若干个小组
 *     2.第1组和第2组合并排序，第3组和第4组合并排序。。。
 *     3.合并完后重复第2歩操作，直至合并成一个数组为止
 * @author ex_panleiming
 *
 */
public class MergeSort extends BaseSort {

	@Override
	public void sort(int[] array, SortType type) {
		if(type == SortType.asc){
			sortAsc(array) ;
		}else if (type == SortType.desc){
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
	private void sortAsc(int[] array){
		sortAscBetter(array, 0, array.length - 1);
	}
	
	private int[] sortAsc(int[] array, int start, int end){
		//首先判断当前是否已经分配到最细，即只有一个值
		if(end - start == 0){
			//如果是最细的就直接返回当前值所组成的数组
			int[] temp = new int[1];
			temp[0] = array[start];
			return temp;
		}else if(end - start == 1){
			//当分组出来只有两个值时，可以直接比较
			int[] temp = new int[2];
			if(array[start] > array[end]){
				temp[0] = array[end];
				temp[1] = array[start];
			}else{
				temp[0] = array[start];
				temp[1] = array[end];
			}
			return temp;
		}else{
			//不然就进行归类分组
			int did = (end - start + 1)/2;
			int[] left = sortAsc(array, start, did - 1);
			int[] right = sortAsc(array, did, end);
			//分好组后就进行合并
			return combine(left, right);
		}
	}
	
	/**
	 * 代码进行改善
	 * @param array
	 * @param start
	 * @param end
	 * @return 现返回值用来存开始结束的索引
	 */
	private int[] sortAscBetter(int[] array, int start, int end){
		//首先判断当前是否已经分配到最细，即只有一个值
		if(end - start == 0){
			//如果是最细的就直接返回开始的索引
			return new int[]{start, end};
		}else if(end - start == 1){
			//当分组出来只有两个值时，可以直接比较
			if(array[start] > array[end]){
				swap(array, start, end);
			}
			return new int[]{start, end};
		}else{
			//进行归类分组
			int did = (end - start + 1)/2;
			int[] left = sortAscBetter(array, start, did - 1);
			int[] right = sortAscBetter(array, did, end);
			return combineBetter(array, left, right);
		}
	}
	
	/**
	 * 两个数组进行合并
	 * @param suba 子数组a
	 * @param subb 字数组b
	 * @return
	 */
	private int[] combine(int[] suba, int[] subb){
		//声明一个新数组，该数组就是两个子数组合并以后的数组
		int[] newArray = new int[suba.length + subb.length];
		//声明两个索引，用来分别从子数组中取值
		int i = 0,j = 0;
		//由于两个子数组是有序，所以只需两个数组比较后存入新数组中
		while(i < suba.length && j < subb.length){
			//两数组中的值进行比较
			if(suba[i] < subb[j]){
				//当a数组中的值比b数组中的值小时，将当前数组a的值存入新数组中，
				//并且索引往后移一位
				newArray[i + j] = suba[i];
				++i;
			}else{
				newArray[i + j] = subb[j];
				++j;
			}
		}
		//比较到最后把另外一个余下的存入新数组中
		if(i > suba.length - 1){
			for(; j < subb.length; j++){
				newArray[i+ j] = subb[j];
			}
		}else{
			for(; i < suba.length; i++){
				newArray[i+ j] = suba[i];
			}
		}
		return newArray;
	}
	
	/**
	 * 进行合并
	 * @param array 源数组
	 * @param suba 左数组的开始结束索引
	 * @param subb 右数组的开始结束索引
	 * @return
	 */
	private int[] combineBetter(int[] array, int[] suba, int[] subb){
		 //这时只需右边的进行插入排序即可
		for(int i = subb[0]; i <= subb[1]; i++){
			int temp = i;
			while(array[temp] < array[temp - 1]){
				swap(array, temp, temp - 1);
				temp = temp - 1;
				if(temp == suba[0]){
					break;
				}
			}
		}
		return new int[]{suba[0], subb[1]};
	}

	/**
	 * 降序排序
	 * @param array
	 */
	private void sortDesc(int[] array){
		
	}
}
