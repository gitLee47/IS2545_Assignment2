package Helpers;

import java.util.Random;

public class RandomNumberGenerator {
	
	public int[] generateRandomNumber(int times, int range, long seed){
			
			Random randomGenerator = new Random(seed);
			int[] randomInts = new int[times];
			
		    for (int idx = 0; idx < times; ++idx){
		      randomInts[idx] = randomGenerator.nextInt(range);
		    }
		    
			return randomInts;
	}

}
