


import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CityTest {
	
//Test to test setters and getters for the city class
	@Test
	public void testSetterGetterLocations() {
		//Arrange
		City city = new City();
		String[] locations = new String[]{"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown"};
		
		city.setLocations(locations);
		
		//Act
		String[] result = city.getLocations();
		
		//Assert
		assertArrayEquals(locations, result);
	}

}
