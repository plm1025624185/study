package com.plm.sort.test;

import org.junit.Before;
import org.junit.Test;

import com.plm.sort.base.Sort;
import com.plm.sort.imp.BubbleSort;
import com.plm.sort.util.SortType;

/**
 * 进行冒泡排序的测试
 * @author ex_panleiming
 *
 */
public class BubbleSortTest {
	private int[] array;
	private Sort bubbleSort;
	
	@Before
	public void init(){
		bubbleSort = new BubbleSort();
		array = new int[20];
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random()*100); 
		}
	}
	
	@Test
	public void testSort(){
		printSort(array);
		bubbleSort.sort(array, SortType.asc);
		printSort(array);
	}
	
	public void printSort(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
}
