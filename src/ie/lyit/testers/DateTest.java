package ie.lyit.testers;

import static org.junit.Assert.*;
import ie.lyit.hotel.Date;
import org.junit.Before;
import org.junit.Test;

public class DateTest {
    private Date d1, d2;
    
	@Before
	public void setUp() throws Exception {
		// Construct d1
		d1=new Date();
	}

	@Test
	public void testDate() {
		// Check d1’s day is 0
		assertEquals(d1.getDay(), 0);
		// Check d1’s month is 0, if it is not display appropriate message
		assertEquals("Month should be 0", d1.getMonth(), 0);
		// Check d1’s year is 5, if it is not display appropriate message
		// NOTE : This should fail!
		assertEquals("Year should be 0", d1.getYear(), 0);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDateIntIntInt() {
		d2=new Date(32,13,2017);
	}

	@Test
	public void testSetDay() {
		d1.setDay(20);
		// Check d1’s day is 20
		assertEquals(d1.getDay(), 20);		
	}

	@Test
	public void testSetMonth() {
		d1.setMonth(11);
		// Check d1’s month is 11
		assertEquals(d1.getMonth(), 11);		
	}

	@Test
	public void testSetYear() {
		d1.setYear(2017);
		// Check d1’s year is 2017
		assertTrue(d1.getYear()==2017);		
	}

}