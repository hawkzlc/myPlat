package com.yue.cas.test;


import org.junit.Test;

import com.yue.cas.security.MD5SaltPasswordEncoder;

public class TestEncoder {
	@Test
	public void myTest() {
		MD5SaltPasswordEncoder encoder = new MD5SaltPasswordEncoder("salt","20160910");
		String password = "1qaz4esz";
		String pwdEncode = null;
		pwdEncode = encoder.encode(password);
		System.out.println(encoder.MD51(password));
		System.out.println(pwdEncode);
	}
}
