import static org.junit.Assert.*;

import org.junit.Test;

import citysim.Visitors.Blogger;
import citysim.Visitors.Businessperson;
import citysim.Visitors.Professor;
import citysim.Visitors.Student;

public class VisitorFactoryTest {

	VisitorFactory factoryObj = new VisitorFactory();
	//-----------------------------------
	//TEST Factory returns valid objects
	//-----------------------------------
	
	//Test input of null as a parameter. 
	//It should throw an IllegalArgumentException
	//this should be handled correctly
	@Test(expected=IllegalArgumentException.class)
	public void testNullVisitorTypeThrowsIllegalArgumentException() {
		//Act
		factoryObj.getVisitor(null);
	}
	
	//Test input of student parameter into the Factory 
	//this should return an object of Student 
	//and no other using the getVisitor() method
	@Test
	public void testVisitorFactoryReturnsStudent() {
		
		assertTrue(factoryObj.getVisitor("student") instanceof Student);
	}
	
	//Test input of professor parameter into the Factory 
	//this should return an object of Professor 
	//and no other using the getVisitor() method
	@Test
	public void testVisitorFactoryReturnsProfessor() {
		
		assertTrue(factoryObj.getVisitor("professor") instanceof Professor);
	}
	
	//Test input of businessperson parameter into the Factory 
	//this should return an object of Businessperson 
	//and no other using the getVisitor() method
	@Test
	public void testVisitorFactoryReturnsBusinessperson() {
		
		assertTrue(factoryObj.getVisitor("businessperson") instanceof Businessperson);
	}
	
	//Test input of blogger parameter into the Factory 
	//this should return an object of Blogger 
	//and no other using the getVisitor() method
	@Test
	public void testVisitorFactoryReturnsBlogger() {
		
		assertTrue(factoryObj.getVisitor("blogger") instanceof Blogger);
	}
	
	//Test input of any invalid visitor type parameter returns null.
	//Any invalid visitortype not specified in the factory
	//should return null. Passing in "Chemist" and testing
	@Test
	public void testVisitorFactoryReturnsNullForInvalidVisitorType() {
		
		assertNull(factoryObj.getVisitor("Chemist"));
	}

}
