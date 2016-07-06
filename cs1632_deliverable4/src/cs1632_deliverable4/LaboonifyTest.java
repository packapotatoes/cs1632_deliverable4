package cs1632_deliverable4;

import java.util.Random;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LaboonifyTest {
	
	private int numRepetitions = 1000000000;
	Random rng = new Random();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * This test verifies the size of the returned array.
	 * The returned array should be 1 larger than the input array
	 */
	@Test
	public void testLaboonifySize() {
		for(int reps=0; reps < numRepetitions; reps++){
			int lengthOfArray = getNum();	// generate a random number between 1 and 100
			int expectedLengthOfOutputArray = lengthOfArray + 1;
			int[] input = new int[lengthOfArray];
			
			// fill array with random integers
			for(int i=0; i<lengthOfArray; i++){
				input[i] = getNum();	// generate a number between 1 and 100 (inclusive)
			}
			
			int[] output = laboonify(input);
			assertTrue(output.length == expectedLengthOfOutputArray);
		}
	}
	
	/*
	 * This test verifies that the integer at each index is properly squared.
	 * It checks that for each integer at each index in the input array,
	 * the output array at that index contains the square of the input at that index
	 */
	@Test
	public void testLaboonifySquare(){
		for(int i=0; i<numRepetitions; i++){
			int lengthOfArray = getNum();
			int[] input = new int[lengthOfArray];
			
			// fill array with random ints
			for(int j=0; j<lengthOfArray; j++){
				input[j] = getNum();
			}
			
			int[] output = laboonify(input);
			
			for(int j=0; j<lengthOfArray; j++){
				int expected = input[j] * input[j];
				if( output[j] != expected){
					fail("index: " + j + "\toutput: " + output[j] + "\texpected: " + expected);	// give useful information on a failure
				}
			}
		}
	}
	
	/*
	 * This test verifies that the end of the output array contains the sum of the squares of the input
	 */
	@Test
	public void testLaboonifySumOfSquares(){
		for(int reps = 0; reps < numRepetitions; reps++){
			int lengthOfArray = getNum();
			int[] input = new int[lengthOfArray];
			int sumOfSquares = 0;
			
			for(int i=0; i<lengthOfArray; i++){
				input[i] = getNum();
				sumOfSquares += input[i] * input[i];
			}
			
			int[] output = laboonify(input);
			
			// compare the sum calculated here to the last index of the returned array
			if(output[lengthOfArray] != sumOfSquares){
				fail("Expected sum: " + sumOfSquares + "\tresult sum: " + output[lengthOfArray]);
			}
		}
	}
	
	// helper function generates a random int between 1 and 100 inclusive
	private int getNum(){
		return rng.nextInt(100) + 1;
	}
	
	public int[] laboonify(int[] x){
		int result[] = new int[x.length+1];
		int total = 0;
		for( int i = 0; i< x.length; i++){
			result[i] = x[i] * x[i];	// square
			total += result[i];			// sum the squares
		}
		result[x.length] = total;	// Add sum to end
		return result;
	}
}
