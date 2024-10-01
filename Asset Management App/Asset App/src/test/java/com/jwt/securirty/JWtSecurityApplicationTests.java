package com.jwt.securirty;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = JWtSecurityApplicationTests.class)
class JWtSecurityApplicationTests {

	@Test
	public void myTst() {
		assertEquals(true, true);
	}
}
