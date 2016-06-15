package Helpers;

//This Class is used for validations. 
public class Validator {
	//The Input argument for seed can be validated here
	public long validateInput(String args[]){
		long seed = 0;
		
		if(args.length == 1){
			try{
				seed = Integer.parseInt(args[0]);
		    } 
			catch (NumberFormatException e) {
		        System.err.println("Please enter one integer argument, seed.");
		        System.exit(1);
		    }
		}
		else{
			System.err.println("Please enter one integer argument, seed.");
	        System.exit(1);
		}
		
		return seed;
	}
}
