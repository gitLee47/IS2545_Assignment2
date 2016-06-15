


import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CityTest {
	
	//Test to test setters and getters for the city class
	//Setting a set of locations for the City class using setLocations()
	//and then using getLocaitons() to retrieve the locations and assert both
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
