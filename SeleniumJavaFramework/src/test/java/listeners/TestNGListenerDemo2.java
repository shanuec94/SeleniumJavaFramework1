package listeners;

import org.apache.commons.collections4.iterators.SkippingIterator;
import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNGListenerDemo2 {


	@Test
	public void test4() {
		System.out.println("I am Inside test4");
	}


	@Test
	public void test5() {
		System.out.println("I am Inside test5");
		
	}


	@Test
	public void test6() {
		System.out.println("I am Inside test6");
		throw new SkipException("this test is skipped");
	}

}
