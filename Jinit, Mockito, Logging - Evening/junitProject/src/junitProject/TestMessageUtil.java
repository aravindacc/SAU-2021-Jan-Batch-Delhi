package junitProject;

import org.junit.Test;
public class TestMessageUtil {
	MessageUtil messageUtil;
	public void setUp() {
		messageUtil=new MessageUtil("Hello");
	}

	@Test
	public void test1() {
		assertEquals("Helloprint",messageUtil.test1("Hello"));
	}
}
