package com.plm.sort.imp;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 希尔排序
 * 
 * 算法思想：
 *     先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，
 * 然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。
 * 因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的。
 * @author ex_panleiming
 *
 */
public class ShellSort extends BaseSort {

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
	
	/**
	 * 升序排序
	 */
	private void sortAsc(int[] array){
		//声明增量
		int gap = 0;
		//将增量逐渐减小
		for(gap = array.length / 2; gap > 0; gap /= 2){
			//然后根据组进行比较，如：
			//第一组：0, 0 + gap, 0 + 2*gap, ...
			//第二组：1, 1 + gap, 1 + 2*gap, ...
			//等等
			for(int i = 0; i < gap; i++){
				for(int j = i + gap; j < array.length; j += gap){
					int temp = j;
					while(array[temp] < array[temp - gap]){
						swap(array, temp, temp -gap);
						temp = temp -gap;
						if(temp == i){
							break;
						}
					}
				}
			}
		}
	}
	
	/**
	 * 倒序排序
	 */
	private void sortDesc(int[] array){
		
	}

}
