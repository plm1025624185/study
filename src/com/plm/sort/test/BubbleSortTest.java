package com.plm.sort.test;

import com.plm.factory.SortFactory;
import com.plm.sort.base.Sort;
import com.plm.sort.util.SortVariety;

/**
 * 进行冒泡排序的测试
 * @author ex_panleiming
 *
 */
public class BubbleSortTest extends BaseTest {

	@Override
	public Sort createSort() {
		SortFactory factory = SortFactory.newInstance();
		return factory.createSort(SortVariety.bubble);
	}
	
	
}
