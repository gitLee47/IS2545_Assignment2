import static org.junit.Assert.*;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.any;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Helpers.Printer;
import Helpers.RandomNumberGenerator;
import citysim.Interfaces.IVisitor;
import citysim.Visitors.Student;


public class VisitorIteratorTest {

	IVisitor visitorMock;
	City cityMock;
	int seed;
	RandomNumberGenerator randMock;
	Printer printerMock;
	
	VisitorIterator iteratorObj;
	
	@Before
	public void setUp() throws Exception {
		//setup mocks
		visitorMock =  Mockito.mock(Student.class);
		Mockito.when(visitorMock.getVisitorNumber()).thenReturn(1);
		Mockito.when(visitorMock.getVisitorType()).thenReturn("Student");
		
		randMock = Mockito.mock(RandomNumberGenerator.class);
		printerMock = Mockito.mock(Printer.class);
		
		cityMock = new City();
		String[] locations = new String[]{"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown"};
		
		cityMock.setLocations(locations);
		
		seed = 1;
		
		//Create the VisitorIterator object with all parameters set
		iteratorObj = new VisitorIterator(seed, cityMock, randMock, printerMock, visitorMock);
	}

	@After
	public void tearDown() throws Exception {
		visitorMock = null;
		cityMock = null;
		randMock = null;
		printerMock = null;
	}
	
	// --------------------------------------------------------------
	// Tests- Null parameter while creating VisitorIterator Object
	// --------------------------------------------------------------
	
	//Test Null City throws IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void testNullCityThrowsIllegalArgumentException() {
		//Act
		new VisitorIterator(seed, null, randMock, printerMock, visitorMock);
	}
	
	//Test Null RandomNumberGenerator IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void testNullRandomNumberGeneratorThrowsIllegalArgumentException() {
		//Act
		new VisitorIterator(seed, cityMock, null, printerMock, visitorMock);
	}
	
	//Test Null Printer IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void testNullPrinterthrowsIllegalArgumentException() {
		//Act
		new VisitorIterator(seed, cityMock, randMock, null, visitorMock);
	}
	
	//Test Null Visitor IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void testNullVisitorThrowsIllegalArgumentException() {
		//Act
		new VisitorIterator(seed, cityMock, randMock, printerMock, null);
	}
	
	// --------------------------------------------------------------
	// Tests- VISITS and PRINTING
	// --------------------------------------------------------------
		
	//Test Starting Location is accessed and printed
	@Test
	public void testStartVisitsPrintsFirstLocation() {
		//Arrange
		int startLoc[] = new int[]{2};
		int otherLocs[] = new int[]{4};
		
		Mockito.when(randMock.generateRandomNumber(1, 4, seed)).thenReturn(startLoc);
		Mockito.when(randMock.generateRandomNumber(10, 5, seed+1)).thenReturn(otherLocs);
		
		//Act
		iteratorObj.startVisits();
		
		//Assert
		Mockito.verify(printerMock, times(1)).printVisits("The Point", visitorMock, false);
	}
	
	//Test Other Locations are accessed and printed
	@Test
	public void testStartVisitsPrintsOtherLocations() {
		//Arrange
		int startLoc[] = new int[]{2};
		int otherLocs[] = new int[]{0,1,3,4};
		
		Mockito.when(randMock.generateRandomNumber(1, 4, seed)).thenReturn(startLoc);
		Mockito.when(randMock.generateRandomNumber(10, 5, seed+1)).thenReturn(otherLocs);
		
		//Act
		iteratorObj.startVisits();
		
		//Assert
		Mockito.verify(printerMock, times(1)).printVisits("The Point", visitorMock, false);
		Mockito.verify(printerMock, times(1)).printVisits("The Cathedral of Learning", visitorMock, false);
		Mockito.verify(printerMock, times(1)).printVisits("Squirrel Hill", visitorMock, false);
		Mockito.verify(printerMock, times(1)).printVisits("Downtown", visitorMock, false);
	}
	
	//Test Exit from a City happens correctly
	@Test
	public void testStartVisitsExits() {
		//Arrange
		int startLoc[] = new int[]{2};
		int otherLocs[] = new int[]{0,1,3,4};
		
		Mockito.when(randMock.generateRandomNumber(1, 4, seed)).thenReturn(startLoc);
		Mockito.when(randMock.generateRandomNumber(10, 5, seed+1)).thenReturn(otherLocs);
		
		//Act
		iteratorObj.startVisits();
		
		//Assert
		Mockito.verify(printerMock, times(1)).printVisits("Exit", visitorMock, true);
	}
	
	//Test Exit from a City happens correctly
	@Test
	public void testUpdatesSeeds() {
		//Arrange
		int startLoc[] = new int[]{2};
		int otherLocs[] = new int[]{0,1,3,4};
			
		Mockito.when(randMock.generateRandomNumber(1, 4, seed)).thenReturn(startLoc);
		Mockito.when(randMock.generateRandomNumber(10, 5, seed+1)).thenReturn(otherLocs);
			
		//Act
		long seed = 2;
			
		//Assert
		assertEquals(seed, iteratorObj.startVisits());
	}
}
