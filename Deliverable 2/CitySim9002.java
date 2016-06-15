import Helpers.Printer;
import Helpers.RandomNumberGenerator;
import Helpers.Validator;
import citysim.Interfaces.IVisitor;

public class CitySim9002 {

	public static void main(String[] args) {
		
		//validate the input and get seed
		//if validate fails, program will exit
		Validator validate = new Validator();
		long seed = validate.validateInput(args) ;
		
		IVisitor visitorObj;
		VisitorIterator visits;
		
		//Start
		System.out.println("Welcome to CitySim! Your seed is "+seed+".");
		
		//initialize city and specify all valid locations
		City city = new City();
		String[] locations = new String[]{"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown"};
		
		city.setLocations(locations);
		
		//specify all valid visitors
		String[] visitors = new String[]{"Student", "Businessperson", "Professor", "Student", "Blogger"};
		
		// Use VisitorFactory to get visitors and then start visits using VisitorIterator
		VisitorFactory factory = new VisitorFactory();
		int visitorIndex = 0;
		RandomNumberGenerator randGen = new RandomNumberGenerator();
		Printer printObj = new Printer();
		
		while(visitorIndex < visitors.length){
			visitorObj = factory.getVisitor(visitors[visitorIndex]);
			visitorObj.setVisitorNumber(visitorIndex+1);
			visits = new VisitorIterator(seed, city, randGen, printObj, visitorObj);
			seed = visits.startVisits();
			visitorIndex++;
		}		
	}
}
