package com.plm.data.test;

import org.junit.Before;

import com.plm.data.impl.LinkedStack;

public class LinkedStackTest extends BaseStackTest {
	
	@Before
	public void init(){
		stack = new LinkedStack<>(3);
	}
}
