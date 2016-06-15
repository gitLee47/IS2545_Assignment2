package citysim.Visitors;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	Student visitorObj;
	ArrayList<String> expectedLocations;
	
	@Before
	public void setUp() throws Exception {
		// any necessary test setup 
		 visitorObj = new Student();
		 expectedLocations = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		// any necessary test cleanup 
		visitorObj = null;
		expectedLocations.clear();
	}
	
	//Test the liked locations for Student, should be empty.
	//This done by calling the getVisitorLikedLocations()
	//and comparing with an empty array.
	@Test
	public void testDefaultLikedLocations() {
		//Act
		expectedLocations.add("Squirrel Hill");
		expectedLocations.add("Downtown");
		expectedLocations.add("The Point");
		
		//Assert
		assertArrayEquals(expectedLocations.toArray(), visitorObj.getVisitorLikedLocations().toArray());
	}
	
	//Test the setters and getters for the liked locations
	//This done by calling the setVisitorLikedLocations()
	//and comparing with an empty setVisitorLikedLocations()
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
	
	//Test the visitor type for Student, should return Student,
	//the getVisitorType() method should return the correct type.
	@Test
	public void testDefaultVisitorType() {
			
		//Assert
		assertEquals("student".toUpperCase(), visitorObj.getVisitorType().toUpperCase());
	}
	
	//Test default visitor number, should return 0
	//when calling the getVisitorNumber() method
	@Test
	public void testDefaultVisitorNumber() {
			
		//Assert
		assertEquals(0, visitorObj.getVisitorNumber());
	}
	
	//Test visitor number cannot be negative
	//This is done by input -1 and asserting
	//that we don't get back -1 with getVisitorNumber()
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
	//by input 100, which is valid and using the
	//methods setVisitorNumber() and getVisitorNumber()
	@Test
	public void testSetterandGetterVisitorNumber() {
		//Arrange
		int expVisitorNumber = 10;
		
		//Act
		visitorObj.setVisitorNumber(expVisitorNumber);
		
		//Assert
		assertEquals(expVisitorNumber, visitorObj.getVisitorNumber());
	}

}
