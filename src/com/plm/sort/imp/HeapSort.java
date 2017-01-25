package com.plm.sort.imp;

import com.plm.sort.base.BaseSort;
import com.plm.sort.util.SortType;

/**
 * 堆排序
 * 
 * 相关知识
 *     二叉堆的定义：二叉堆是完全二叉树或者是近似完全二叉树
 *     二叉堆满足两个特性：
 *         1.父节点的键值总是大于或等于（小于或等于）任何一个子节点的键值。
 *         2.每个节点的左子数和右子数都是一个二叉堆（都是最大堆或最小堆）。
 *     当父节点的键值总是大于或等于任何一个子节点的键值时为最大堆。当父节点的键值总是
 * 小于或等于任何一个子节点的键值时为最小堆
 * 
 *     堆的存储：
 *         一般都用数组来表示堆，i节点的父节点下标就为(i-1)/2。它的左右子节点下标分别为
 *     2*i+1和2*i+2。
 *     
 *     堆的删除：（这里的堆是指已经堆化过的）
 *         按定义，堆中每次都只能删除第0个数据。为了便于重建堆，实际的操作是将最后一个数据
 *     的值赋给根节点，然后再从根节点进行一次从上向下的调整。调整时先在左右儿子结点中找最
 *     小的，如果父结点比这个最小的子结点还小说明不需要调整了，反之将父结点和它交换后再
 *     考虑后面的结点。相当于从根结点将一个数据的“下沉”过程
 *     
 *     堆化数组：
 *         将数组中的数据进行排序，使其符合最大堆或最小堆。
 *         堆化过程：
 *             对于叶子节点可以认为是一个合法的堆了，只需从最右边的叶节点的父节点与它的子节点进行比较。如果不满足条件就进行交换。
 *         反之则继续往上个节点进行比较，以此类推，直到判断完根节点为止。
 * @author ex_panleiming
 *
 */
public class HeapSort extends BaseSort {

	@Override
	public void sort(int[] array, SortType type) {
		if(type == SortType.asc){
			sortAsc(array);
		}else if(type == SortType.desc){
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
		
	}
	
	/**
	 * 降序排序
	 * @param array
	 */
	private void sortDesc(int[] array){
		//然后将堆进行删除，即将根节点与当前堆的最后一个节点进行互换，然后删除最后一个节点
		for(int i = array.length - 1; i > 0; i--){
			//先对数组进行堆化,并交换
			heapMinArrayUp(array, 0, i);
			swap(array, 0, i);
		}
	}

	/**
	 * 对数组进行堆化（最小堆），顺序是从最后一个叶节点上升到根节点
	 * @param array 需要堆化的数组
	 * @param start 开始的位置
	 * @param end 结束的位置 （此位置是包含在堆中的）
	 */
	public void heapMinArrayUp(int[] array, int start, int end){
		int left,right;//声明左右节点的变量
		//由于叶子节点没有左右节点，故从最后一个叶子节点的父节点开始比较
		for(int i = getParentIndex(end, start); i > start - 1; i--){
			//获得当前节点的左右节点的索引
			left = getLeftChildIndex(i, start);
			right = getRightChildIndex(i, start);
			//进行比较
			if(right < end + 1){
				//如果存在右节点，则右节点与父节点比较，如果父节点大于右节点则进行互换
				if(array[i] > array[right]){
					swap(array, i, right);
				}
			}
			if(left < end + 1){
				//如果存在左节点，则左节点与父节点比较，如果父节点大于左节点则进行互换
				if(array[i] > array[left]){
					swap(array, i, left);
				}
			}
		}
	}
	
	/**
	 * 获取父节点的索引
	 * @param index 当前节点的索引
	 * @param start 根节点的索引
	 * @return
	 */
	public int getParentIndex(int index, int start){
		int value = -1;
		int i = index;
		if(i > 0){
			value = (i - 1) / 2 + start; 
		}
		return value;
	}
	
	/**
	 * 获取左节点的索引
	 * @param index 当前节点的索引
	 * @param start 根节点的索引
	 * @return
	 */
	public int getLeftChildIndex(int index, int start){
		int value = -1;
		int i = index - start;
		if(i >= 0){
			value = i * 2 + 1 + start;
		}
		return value;
	}
	
	/**
	 * 获取右节点的索引
	 * @param index 当前节点的索引
	 * @param start 根节点的索引
	 * @return
	 */
	public int getRightChildIndex(int index, int start){
		int value = -1;
		int i = index - start;
		if(i >= 0){
			value = i * 2 + 2 + start;
		}
		return value;
	}
	
	/**
	 * 判断是否是叶节点
	 * @param i 当前索引相对于开始位置
	 * @param end 当前堆的最后一个叶节点
	 * @param start 根节点的索引
	 * @return
	 */
	public boolean isLeaf(int index, int end, int start){
		//如果当前节点大于最后一个叶节点的父节点，那么说明该节点为叶节点
		int parent = getParentIndex(end, start);
		if(index > parent){
			return true;
		}else{
			return false;
		}
	}
	
}
