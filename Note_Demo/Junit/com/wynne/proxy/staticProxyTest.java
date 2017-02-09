package com.wynne.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

public class staticProxyTest {

	@Test
	public void test() {
		CountImpl countimpl=new CountImpl();
		staticProxy sProxy=new staticProxy(countimpl);
		sProxy.queryCount();
		System.out.println("====================");
		sProxy.updateCount();
	}

}
