package citysim.Interfaces;

import java.util.ArrayList;

public interface IVisitor {

	/**
	 * @return the visitorType
	 */
	String getVisitorType();

	/**
	 * @return the visitorNumber
	 */
	int getVisitorNumber();

	/**
	 * @param visitorNumber the visitorNumber to set
	 */
	void setVisitorNumber(int visitorNumber);

	/**
	 * @return the visitorLikedCities
	 */
	ArrayList<String> getVisitorLikedLocations();

	/**
	 * @param visitorLikedLocations the visitorLikedCities to set
	 */
	void setVisitorLikedLocations(ArrayList<String> visitorLikedLocations);

}