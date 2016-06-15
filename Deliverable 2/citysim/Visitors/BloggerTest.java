package citysim.Visitors;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BloggerTest {

	Blogger visitorObj;
	ArrayList<String> expectedLocations;
	
	@Before
	public void setUp() throws Exception {
		// any necessary test setup 
		 visitorObj = new Blogger();
		 expectedLocations = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		// any necessary test cleanup 
		visitorObj = null;
		expectedLocations.clear();
	}
	
	//Test the liked locations for Blogger, should be empty
	@Test
	public void testDefaultLikedLocations() {
			
		//Assert
		assertArrayEquals(expectedLocations.toArray(), visitorObj.getVisitorLikedLocations().toArray());
	}
	
	//Test the setters and getters for the liked locations
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
	
	//Test the visitor type for Blogger, should return Blogger
	@Test
	public void testVisitorType() {
			
		//Assert
		assertEquals("blogger".toUpperCase(), visitorObj.getVisitorType().toUpperCase());
	}
	
	//Test default visitor number, should return 0
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
	
	//Test setting and getting a visitor number
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
