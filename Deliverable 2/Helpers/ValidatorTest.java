package Helpers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	Validator validator;
	
	@Before
	public void setUp() throws Exception {
		validator = new Validator();
	}

	@After
	public void tearDown() throws Exception {
		validator = null;
	}

	//Test ValidateInput returns correct seed for valid integer 8
	@Test
	public void testValidateInputReturnsSeedFor8() {
		//Arrange
		String args[] = new String[]{"8"};
		
		//Assert
		assertEquals(8, validator.ValidateInput(args));
	}
	
	//Test ValidateInput returns correct seed for negative input
	@Test
	public void testValidateInputReturnsSeedForNegativeInput() {
		//Arrange
		String args[] = new String[]{"-1"};
			
		//Assert
		assertEquals(-1, validator.ValidateInput(args));
	}

}
