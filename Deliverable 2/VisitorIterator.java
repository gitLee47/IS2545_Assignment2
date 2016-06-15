import Helpers.Printer;
import Helpers.RandomNumberGenerator;
import citysim.Interfaces.IVisitor;

public class VisitorIterator {
	
	private long _seed;
	private IVisitor _visitor;
	private City _city;
	private RandomNumberGenerator _rand;
	private Printer _printer;
	
	public VisitorIterator(long seed, City city, RandomNumberGenerator rand, Printer printer, IVisitor visitor) throws IllegalArgumentException{
		
		if(city == null){
			throw new IllegalArgumentException("city cannot be null.");
		}
		
		if(rand == null){
			throw new IllegalArgumentException("rand cannot be null.");
		}
		
		if(printer == null){
			throw new IllegalArgumentException("printer cannot be null.");
		}
		
		if(visitor == null){
			throw new IllegalArgumentException("visitor cannot be null.");
		}
		
		this._seed = seed;
		this._visitor = visitor;
		this._city = city;
		this._rand = rand;
		this._printer = printer;
	}

	public long startVisits(){
		int[] startLocation = _rand.generateRandomNumber(1, 4, _seed);
		String[] cityLocations = _city.getLocations();
		
		//print first visit
		System.out.println("Visitor "+_visitor.getVisitorNumber()+" is a "+_visitor.getVisitorType()+".");
		_printer.printVisits(cityLocations[startLocation[0]], _visitor, false);
		
		//incrementing seed for ensuring breaks
		_seed++;
		
		//print rest of visits
		int[] allLocations = _rand.generateRandomNumber(10, 5, _seed);
		
		int index = 0;
		
		while(allLocations[index] != 4){
			_printer.printVisits(cityLocations[allLocations[index]], _visitor, false);
			index++;
			
			if(index == 9){
				_seed++;
				allLocations = _rand.generateRandomNumber(10, 5, _seed);
				index = 0;
			}
		}
		
		//Visitor leaves city
		_printer.printVisits("Exit", _visitor, true);
		
		return _seed;
	}
}
