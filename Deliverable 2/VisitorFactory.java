import citysim.Interfaces.IVisitor;
import citysim.Visitors.Blogger;
import citysim.Visitors.Businessperson;
import citysim.Visitors.Professor;
import citysim.Visitors.Student;

public class VisitorFactory {
	//use getVisitor method to get object of type IVisitor 
	public IVisitor getVisitor(String visitorType) throws IllegalArgumentException{
		
		if(visitorType == null){
			throw new IllegalArgumentException("visitorType cannot be null.");
		}	
		
		if(visitorType.equalsIgnoreCase("student")){
			return new Student();  
		} 
		else if(visitorType.equalsIgnoreCase("professor")){
			return new Professor();	         
		} 
		else if(visitorType.equalsIgnoreCase("businessperson")){
			return new Businessperson();
		}
		else if(visitorType.equalsIgnoreCase("blogger")){
			return new Blogger();
		}
	      
		return null;
	}
}
