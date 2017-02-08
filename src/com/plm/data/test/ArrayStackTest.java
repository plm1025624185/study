package com.plm.data.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.plm.data.impl.ArrayStack;

public class ArrayStackTest {
	private ArrayStack<Integer> stack;
	
	@Before
	public void init(){
		stack = new ArrayStack<>(3);
	}
	
	@Test
	public void testPush(){
		try {
			stack.push(1);
			Assert.assertEquals(1, stack.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPop(){
		try {
			stack.push(1);
			stack.push(2);
			Assert.assertEquals(new Integer(2).intValue(), stack.pop().intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
