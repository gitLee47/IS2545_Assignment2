package Helpers;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import citysim.Interfaces.IVisitor;
import citysim.Visitors.Student;

public class PrinterTest {

	IVisitor visitorMock;
	Printer printer;
	ArrayList<String> visitorLikedLocations;
	
	@Before
	public void setUp() throws Exception {
		visitorMock =  Mockito.mock(Student.class);
		Mockito.when(visitorMock.getVisitorNumber()).thenReturn(1);
		
		visitorLikedLocations = new ArrayList<String>();
		
		printer = new Printer();
	}

	@After
	public void tearDown() throws Exception {
		visitorMock = null;
		printer = null;
		visitorLikedLocations.clear();
	}

	// ----------------------------------------------------------------------
	// Tests- Null and valid parameters while creating VisitorIterator Object
	// ----------------------------------------------------------------------
		
	//Test Null Visitor IllegalArgumentException.
	//When a null is passed in for visitor object
	//it should throw an IllegalArgumentException.
	@Test(expected=IllegalArgumentException.class)
	public void testNullVisitorThrowsIllegalArgumentException(){
		//Act
		printer.printVisits("Hello", null, false);
	}
	
	//Test Visitor Object passed does not throw Exception.
	//When no null and a visitor object is passed in 
	//it should not throw any exceptions
	@Test
	public void testVisitorPassedNoExceptionThrown(){
		//Act
		printer.printVisits("Hello", visitorMock, false);
	}
}
