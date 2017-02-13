package com.plm.data.test;

import org.junit.Before;

import com.plm.data.impl.ArrayStack;

public class ArrayStackTest extends BaseStackTest {
	
	@Before
	public void init(){
		stack = new ArrayStack<>(3);
	}
}
