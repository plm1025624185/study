package com.plm.sort.test;

import com.plm.factory.SortFactory;
import com.plm.sort.base.Sort;
import com.plm.sort.util.SortType;
import com.plm.sort.util.SortVariety;

public class HeapSortTest extends BaseTest {

	@Override
	public Sort createSort() {
		SortFactory factory = SortFactory.newInstance();
		return factory.createSort(SortVariety.heap);
	}

	@Override
	public void testSort() {
		printArray(array);
		sort.sort(array, SortType.desc);
		printArray(array);
	}

	
}
