package com.plm.sort.imp;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 基数排序
 * 
 * 简介：
 * 	      基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或bin sort，
 * 顾名思义，它是透过键值的部份资讯，将要排序的元素分配至某些“桶”中，藉以达到排序的作用，
 * 基数排序法是属于稳定性的排序，其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，
 * 在某些时候，基数排序法的效率高于其它的稳定性排序法。
 * 
 * 算法思想：
 *     将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，
 * 依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 * 
 * 实现方法：
 *     最高位优先(Most Significant Digit first)法，简称MSD法：先按k1排序分组，同一组中记录，关键码k1相等，
 * 再对各组按k2排序分成子组，之后，对后面的关键码继续这样的排序分组，直到按最次位关键码kd对各子组排序后。
 * 再将各组连接起来，便得到一个有序序列。
 *     最低位优先(Least Significant Digit first)法，简称LSD法：先从kd开始排序，再对kd-1进行排序，依次重复，直到对k1排序后便得到一个有序序列。
 * 
 * @author ex_panleiming
 *
 */
public class RadixSort extends BaseSort {

	@Override
	public void sort(int[] array, SortType type) {
		sort(array, SortType.asc);
	}

	@Override
	public void sort(int[] array) {
		sortAscLSD(array, 2);
	}

	/**
	 * 升序排序，LSD实现方式
	 * @param array 待排序数组
	 * @param num 最大数的位数
	 */
	private void sortAscLSD(int[] array, int num){
		int k = 1;//当前排序的位数，个位，十位...
		int[][] temp = new int[10][array.length];//用于临时存储数组的值
		int[] count = new int[10];//用于计算在同一个基数的数量
		int t = 0;
		while(k <= num){
			//当当前位数小于最大位数时，反复执行排序
			for(int i = 0; i < array.length; i++){
				//获取当前位数的值（个位，十位...）
				int n = array[i]/(int)(Math.pow(10, k-1))%10;
				//将当前的值存进对应索引的临时数组中，并将计数数组对应的索引值加1
				temp[n][count[n]] = array[i];
				count[n]++;
			}
			//存完后再将临时存储数组中的值依次取出来放到数组中
			for(int i = 0; i < 10; i++){
				if(count[i] != 0){
					for(int j = 0; j < count[i]; j++){
						array[t] = temp[i][j];
						t++;
						temp[i][j] = 0;
					}
					count[i] = 0;
				}
			}
			t = 0;
			k++;
		}
	}
}
