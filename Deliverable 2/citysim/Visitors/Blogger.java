package citysim.Visitors;

import java.util.ArrayList;

import citysim.Interfaces.IVisitor;

public class Blogger implements IVisitor {

	private String visitorType;
	private int visitorNumber;
	private ArrayList<String> visitorLikedLocations;
	
	public Blogger()
	{
		visitorLikedLocations = new ArrayList<String>();
		
		visitorType = "Blogger";
	}
	/* (non-Javadoc)
	 * @see citysim.IVisitor#getVisitorType()
	 */
	@Override
	public String getVisitorType() {
		return visitorType;
	}
	
	/* (non-Javadoc)
	 * @see citysim.IVisitor#getVisitorNumber()
	 */
	@Override
	public int getVisitorNumber() {
		return visitorNumber;
	}
	/* (non-Javadoc)
	 * @see citysim.IVisitor#setVisitorNumber(int)
	 */
	@Override
	public void setVisitorNumber(int visitorNumber) {
		if(visitorNumber > 0)
			this.visitorNumber = visitorNumber;
	}
	/* (non-Javadoc)
	 * @see citysim.IVisitor#getVisitorLikedLocations()
	 */
	@Override
	public ArrayList<String> getVisitorLikedLocations() {
		return visitorLikedLocations;
	}
	/* (non-Javadoc)
	 * @see citysim.IVisitor#setVisitorLikedLocations(java.lang.String[])
	 */
	@Override
	public void setVisitorLikedLocations(ArrayList<String> visitorLikedLocations) {
		this.visitorLikedLocations = visitorLikedLocations;
	}
}
