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
	
	//Test input of null as a parameter. It should throw an IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void testNullVisitorTypeThrowsIllegalArgumentException() {
		//Act
		factoryObj.getVisitor(null);
	}
	
	//Test input of student parameter returns Student object
	@Test
	public void testVisitorFactoryReturnsStudent() {
		
		assertTrue(factoryObj.getVisitor("student") instanceof Student);
	}
	
	//Test input of professor parameter returns Professor object
	@Test
	public void testVisitorFactoryReturnsProfessor() {
		
		assertTrue(factoryObj.getVisitor("professor") instanceof Professor);
	}
	
	//Test input of businessperson parameter returns Businessperson object
	@Test
	public void testVisitorFactoryReturnsBusinessperson() {
		
		assertTrue(factoryObj.getVisitor("businessperson") instanceof Businessperson);
	}
	
	//Test input of blogger parameter returns Blogger object
	@Test
	public void testVisitorFactoryReturnsBlogger() {
		
		assertTrue(factoryObj.getVisitor("blogger") instanceof Blogger);
	}
	
	//Test input of invaid visitor type parameter returns null
	@Test
	public void testVisitorFactoryReturnsNullForInvalidVisitorType() {
		
		assertNull(factoryObj.getVisitor("Chemist"));
	}

}
