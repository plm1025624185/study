package com.plm.sort.test;

import com.plm.factory.SortFactory;
import com.plm.sort.base.Sort;
import com.plm.sort.util.SortVariety;

public class SelectionSortTest extends BaseTest {

	@Override
	public Sort createSort() {
		SortFactory factory = SortFactory.newInstance();
		return factory.createSort(SortVariety.selection);
	}

}
