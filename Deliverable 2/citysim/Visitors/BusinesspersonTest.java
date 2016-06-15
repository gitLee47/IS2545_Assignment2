package citysim.Visitors;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BusinesspersonTest {

	Businessperson visitorObj;
	ArrayList<String> expectedLocations;
	
	@Before
	public void setUp() throws Exception {
		// any necessary test setup 
		 visitorObj = new Businessperson();
		 expectedLocations = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		// any necessary test cleanup 
		visitorObj = null;
		expectedLocations.clear();
	}
	
	//Test the liked locations for Business Person
	@Test
	public void testDefaultLikedLocations() {
		//Act
		expectedLocations.add("Squirrel Hill");
		expectedLocations.add("Downtown");
		
		//Assert
		assertArrayEquals(expectedLocations.toArray(), visitorObj.getVisitorLikedLocations().toArray());
	}
	
	//Test setting and getting of liked locations for Business Person
	@Test
	public void testSetterandGetterLocations() {
		//Arrange
		expectedLocations.add("Leeds");
		expectedLocations.add("Manchester");
		
		//Act
		visitorObj.setVisitorLikedLocations(expectedLocations);
		
		//Assert
		assertArrayEquals(expectedLocations.toArray(), visitorObj.getVisitorLikedLocations().toArray());
	}
	
	//Test default visitor type returns Business Person
	@Test
	public void testDefaultVisitorType() {
			
		//Assert
		assertEquals("business person".toUpperCase(), visitorObj.getVisitorType().toUpperCase());
	}
	
	//Test default visitor number returns 0
	@Test
	public void testDefaultVisitorNumber() {
			
		//Assert
		assertEquals(0, visitorObj.getVisitorNumber());
	}
	
	//Test visitor number cannot be negative
	@Test
	public void testVisitorNumberDoesNotTakeNegativeInput() {
		//Arrange
		int expVisitorNumber = -1;
						
		//Act
		visitorObj.setVisitorNumber(expVisitorNumber);
								
		//Assert
		assertNotEquals(-1, visitorObj.getVisitorNumber());
	}
	
	//Test getter and setter of valid visitor number
	@Test
	public void testSetterandGetterVisitorNumber() {
		//Arrange
		int expVisitorNumber = 100;
		
		//Act
		visitorObj.setVisitorNumber(expVisitorNumber);
		
		//Assert
		assertEquals(expVisitorNumber, visitorObj.getVisitorNumber());
	}

}
