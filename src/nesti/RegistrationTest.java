package nesti;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegistrationTest {

	@Test
	public void testCheckEmail() {
		Registration registration = new Registration();
		assertTrue(registration.checkEmail("steph@example.com"));
		assertFalse(registration.checkEmail("steph&example.com"));
	}
}
