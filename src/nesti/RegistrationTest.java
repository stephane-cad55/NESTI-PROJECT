package nesti;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class RegistrationTest {

	@Test
	public void testCheckEmail() {
		Registration registration = new Registration();
		assertTrue(registration.checkEmail("steph@example.com"));
		assertFalse(registration.checkEmail("steph&example.com"));
	}
	
	@Test
	public void testCheckForceMdp() {
		Registration registration = new Registration();

		assertEquals(registration.checkForceMdp(
				"DURAND%%%+++65657777777777777777777777777777777777777////////////////////////////////////////"),
				Color.GREEN);
		assertEquals(registration.checkForceMdp("durand123777"), Color.YELLOW);
		assertEquals(registration.checkForceMdp("durand123"), Color.ORANGE);
		assertEquals(registration.checkForceMdp("jean"), Color.RED);
	}
}
