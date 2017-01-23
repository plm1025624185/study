package com.plm.sort.imp;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 快速排序
 * 
 * 简介
 *     快排的版本有好几种，粗略可分为：
 *         ·原始的快排
 *         ·为制造适合高效排序环境而事先打乱数组顺序的快排
 *         ·为数组内大量重复值而优化的三向切分快排
 *     
 * 这里只讨论原始快排，关于在快排过程中何时进行交换以及交换谁的问题，这里有两种不同的思路。
 * 思想一
 *     当左右两个游标都停止时，交换两个游标所指向元素。枢轴所在位置暂时不变，直到两个游标
 * 相遇重合，才更新枢轴位置，交换枢轴与游标所指元素。
 * 思想二
 *     当右游标找到一个比枢轴小的元素时，马上把枢轴交换到游标所在位置，而游标位置的元素则
 * 移到枢轴那里。完成一次枢轴更新。然后左游标再去寻找比枢轴大的元素，同理。
 * 
 * 实现思路：
 *     1.将基准设在左边第一个位置上
 *     2.右边指针上的值先和基准进行比较，若值比基准小，则值与基准互换位置，左边指针上的值
 * 与基准进行比较。反之右边指针左移一格进行比较。
 *     3.如上所述，一直比较，知道左右指针相遇，则将相遇位置更新成基准的值，然后在对左右
 * 两边进行1,2步的操作。直至左右两坐标相等。
 * 
 * @author ex_panleiming
 *
 */
public class QuickSort extends BaseSort {

	@Override
	public void sort(int[] array, SortType type) {
		if(type == SortType.asc){
			sortAsc(array);
		}else{
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
		sortAsc(array, 0, array.length - 1);
	}
	
	/**
	 * 对数组快速排序的实现
	 * @param array
	 * @param start	开始位置
	 * @param end	结束位置
	 */
	private void sortAsc(int[] array, int start, int end){
		//前提条件左指针小于右指针
		if(start < end){
			//设置基准
			int base = start;
			//设置左右指针
			int left = start;
			int right = end;
			//设置顺序，由于基准设置为左边第一个值，故先从右指针开始比较
			boolean isLeft = false;
			//首先判断左指针是否小于右指针，是则进行比较，不是则说明比较完毕
			while(left < right){
				//如果当前是右指针顺序，将右指针的值与基准进行比较
				if(!isLeft){
					if(array[right] >= array[base]){
						//如果右指针值大于等于基准，则不动，索引减1
						--right;
					}else{
						//否则就将值与基准互换位置
						swap(array, right, base);
						//并更新基准的位置
						base = right;
						//顺序交换
						isLeft = true;
					}
				}else{
					if(array[left] <= array[base]){
						//当右指针的值小于等于基准时，左指针右移
						++left;
					}else{
						//否则和基准交换位置
						swap(array, left, base);
						//并更新基准的位置
						base = left;
						//顺序交换
						isLeft = false;
					}
				}
			}
			//当遍历完一遍，基于划分出来的两个区域进行迭代
			sortAsc(array, start, base);
			sortAsc(array, base + 1, end);
		}
	}
	
	/**
	 * 降序排序
	 * @param array
	 */
	private void sortDesc(int[] array){
		
	}
	
}
