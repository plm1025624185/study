package com.plm.sort.test;

import com.plm.factory.SortFactory;
import com.plm.sort.base.Sort;
import com.plm.sort.util.SortVariety;

public class ShellSortTest extends BaseTest {

	@Override
	protected Sort createSort() {
		SortFactory factory = SortFactory.newInstance();
		return factory.createSort(SortVariety.shell);
	}

}
