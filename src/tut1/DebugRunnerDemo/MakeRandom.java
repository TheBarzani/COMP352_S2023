// Ismael Ridha
// Assignment-0
// Date: 01-07-2022
// Course: COEN-352

import java.util.Random;

public class MakeRandom {

	public static void main(String[] args) {
		int[] arr;
		int seed;
		int num;
		Random random = new Random();
		
		// Check for number of parameters
		if (args.length == 0) {
			System.out.println("No paramaters are passed. Please provide 1 or 2 parameters.");
			return;
		}
		else if(args.length == 1) {
			num = Integer.parseInt(args[0]);
			// set number of items if one parameter is passed
		}
		else if(args.length == 2) {
			seed = Integer.parseInt(args[0]);
			num = Integer.parseInt(args[1]);
			random.setSeed(seed);
			// set number of items and seed if two parameters are passed
		}
		else {
			System.out.println("More than 2 parameters are passed. Please provide 1 or 2 parameters.");
			return;
		}
		
		arr = new int[num];
		
		// Fill out the Array 
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(Integer.MAX_VALUE);
		}
	
		// Output the contents of the array
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
