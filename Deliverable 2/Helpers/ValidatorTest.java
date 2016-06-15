package Helpers;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	Validator validator;
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		validator = new Validator();
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		validator = null;
	}

	//Test validateInput returns correct seed for valid integer
	//by passing in a String value of 8.
	//The validateInput() method should return 8 of type long.
	@Test
	public void testValidateInputReturnsSeedFor8() {
		//Arrange
		String args[] = new String[]{"8"};
		
		//Assert
		assertEquals(8, validator.validateInput(args));
	}
	
	//Test validateInput returns correct seed for negative input
	//by passing in a String value of -1.
	//The validateInput() method should return -1 of type long.
	@Test
	public void testValidateInputReturnsSeedForNegativeInput() {
		//Arrange
		String args[] = new String[]{"-1"};
			
		//Assert
		assertEquals(-1, validator.validateInput(args));
	}
}
