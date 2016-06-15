package Helpers;

import java.util.ArrayList;

import citysim.Interfaces.IVisitor;

public class Printer {
	
	public void printVisits(String location, IVisitor visitor, boolean IsExit) throws IllegalArgumentException{
			
		if(visitor == null){
			throw new IllegalArgumentException("visitor cannot be null.");
		}
		
		ArrayList<String> likedLocations = visitor.getVisitorLikedLocations();
			
		if(!IsExit && likedLocations.contains(location)){
			System.out.println("Visitor "+visitor.getVisitorNumber()+" is going to "+location+"!");
			System.out.println("Visitor "+visitor.getVisitorNumber()+" did like "+location+"!");
		}
		else if(!IsExit){
			System.out.println("Visitor "+visitor.getVisitorNumber()+" is going to "+location+"!");
			System.out.println("Visitor "+visitor.getVisitorNumber()+" did not like "+location+"!");
		}
		else{
			System.out.println("Visitor "+visitor.getVisitorNumber()+" has left the city.");
			System.out.println("***");
		}			
	}
}
