package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		double seconds = Time.getTotalSeconds("05:05:05:000");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}
	
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(
				 StringIndexOutOfBoundsException.class, 
				 ()-> {Time.getTotalSeconds("10:00");}); //saying with this input we should be getting this kind of error throw
	}
	
	@Test
	void testGetTotalSecondsBoundary() {
		double seconds = Time.getTotalSeconds("00:00:00:000");
		assertTrue("The seconds were not calculated properly", seconds==0);
	}

	@ParameterizedTest //for both boundary and good
	@ValueSource(strings = { "00:00:15:000", "00:22:15:000", "00:59:15:000" })
	void testGetSeconds(String candidate) {
		int seconds = Time.getSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds ==15);
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(
				 StringIndexOutOfBoundsException.class, 
				 ()-> {Time.getTotalSeconds("10:22:4");}); //saying with this input we should be getting this kind of error throw
	}

	@ParameterizedTest //for both boundary and good
	@ValueSource(strings = { "00:22:00:000", "00:22:15:000", "00:22:59:000" })
	void testGetTotalMinutes(String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes ==22);
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
				 StringIndexOutOfBoundsException.class, 
				 ()-> {Time.getTotalMinutes("10:0");}); //saying with this input we should be getting this kind of error throw
	}
	
	@ParameterizedTest //for both boundary and good
	@ValueSource(strings = { "05:00:00:000", "05:15:15:000", "05:59:59:000" })
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours ==5);
	}
	
	@Test
	void testGetTotalHoursBad() {
		assertThrows(
				 StringIndexOutOfBoundsException.class, 
				 ()-> {Time.getTotalHours("1");}); //saying with this input we should be getting this kind of error throw
	}
	
	/*------------------------------------------------------------------------------------------------*/
	
	@Test
	void testGetTotalMilliseconds() {
		int milli = Time.getMilliseconds("10:05:05:007");
		assertTrue("milli not calculated properly", milli==7);
	}


}
