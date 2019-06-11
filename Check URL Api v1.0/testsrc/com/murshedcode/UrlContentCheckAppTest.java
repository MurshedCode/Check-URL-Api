package com.murshedcode;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UrlContentCheckAppTest {
	private UrlContentCheckApp UrlContentCheckAppTest = null;
	
	
	@BeforeEach
	void setUp() throws Exception {
		UrlContentCheckAppTest = new UrlContentCheckApp();
	}


	@Test
	public void testForExceptions() {
	    UrlContentCheckApp UrlContentCheckAppTest = new UrlContentCheckApp();
	    try {
	    	UrlContentCheckAppTest.throwAnException();
		    fail("Expected exception not thrown");		// needed implement
	    } catch (Exception e) {
	        assertTrue(e instanceof NullPointerException);
	    }
	}
}