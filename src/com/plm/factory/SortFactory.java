package com.plm.factory;

import com.plm.sort.base.Sort;
import com.plm.sort.imp.BubbleSort;
import com.plm.sort.imp.HeapSort;
import com.plm.sort.imp.InsertionSort;
import com.plm.sort.imp.MergeSort;
import com.plm.sort.imp.QuickSort;
import com.plm.sort.imp.SelectionSort;
import com.plm.sort.util.SortVariety;

/**
 * 排序工厂，使用单例模式进行急切构建
 * @author ex_panleiming
 *
 */
public class SortFactory {
	private static SortFactory factory = new SortFactory();
	
	/**
	 * 构造方法进行私有化
	 */
	private SortFactory(){
		
	}
	
	/**
	 * 工厂初始化并返回实例
	 * @return
	 */
	public static SortFactory newInstance(){
		return factory;
	}
	
	/**
	 * 根据选择的排序中类，返回排序类
	 * @param variety
	 * @return
	 */
	public Sort createSort(SortVariety variety){
		if(variety == SortVariety.bubble){
			return new BubbleSort();
		}else if(variety == SortVariety.selection){
			return new SelectionSort();
		}else if(variety == SortVariety.insertion){
			return new InsertionSort();
		}else if(variety == SortVariety.quick){
			return new QuickSort();
		}else if(variety ==  SortVariety.merge){
			return new MergeSort();
		}else if(variety ==  SortVariety.heap){
			return new HeapSort();
		}else{
			return null;
		}
	}
}
