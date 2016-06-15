package Helpers;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomNumberGeneratorTest {

	RandomNumberGenerator randomer;
	@Before
	public void setUp() throws Exception {
		randomer = new RandomNumberGenerator();
	}

	@After
	public void tearDown() throws Exception {
		randomer = null;
	}
	
	//Test to check the seed value gives same result on every call
	//by calling the generateRandomNumber method twice with
	//the same parameters including the seed.
	@Test
	public void testSameSeedGivesSameResult() {
		assertArrayEquals(randomer.generateRandomNumber(1, 4, 1), randomer.generateRandomNumber(1, 4, 1));
	}
	
	//Test to check different seed value gives different result on every call
	//by calling the generateRandomNumber method twice with
	//different seed but same values for other parameters
	@Test
	public void testDifferentSeedGivesDifferentResult() {
		assertFalse(Arrays.equals(randomer.generateRandomNumber(1, 100, 100), randomer.generateRandomNumber(1, 100, 1)));
	}

}
