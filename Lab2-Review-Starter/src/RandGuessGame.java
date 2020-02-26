// COURSE: CSCI1620
// TERM: SPRING 2020
//
// NAME: Nathan Kovar
// RESOURCES: <DISCLOSURE OF RESOURCE USE>

/**
 * A random guessing game.
 * @author nrkovar
 */

import java.util.Random;

/**
 * Class for a simple, randomized guessing game. Five integer values between 1 and MAX_VALUE (inclusive) will be
 * generated. Only the first and last will be shown to the player. The player must then guess if the sum
 * of all of the numbers is greater than the possible average or not.
 *
 */
public class RandGuessGame
{
	
	private static int ARR_SIZE = 5;
	private int arraySum = 0;
	private char guess;
	private int guessTarget = ARR_SIZE * (MAX_VALUE / 2);
	private boolean hideMiddleVals = true;
	private static int MAX_VALUE = 100;
	private int[] numbers = new int[ARR_SIZE];
	private java.util.Random rand = new Random();
	
	/**
	 * Constructor for the RandGuessGame. Creates "numbers" array of size ARR_SIZE to 
	 * store random values,sets arraySum to zero, and calculates value of "guessTarget" 
	 * by multiplying the amount of numbers by half of "MAX_VALUE". The passed Random object 
	 * is assigned to the class' Random member. hideMiddleValsis defaulted to "true".
	 */
	public RandGuessGame(java.util.Random randIn)
	{
		rand = randIn;
	}
	
	/**
	 * Retrieves the numbers array. Used for testing, do not change.
	 * @return The numbers array.
	 */
	public int[] getNumbers()
	{
		return numbers;
	}
	
	/**
	 * Retrieves the sum of the numbers in the array. Used for testing, do not change.
	 * @return The value of arraySum.
	 */
	public int getArraySum()
	{
		return arraySum;
	}

	/**
	 * Checks to see if player's guess was correct, and constructs and returns a String 
	 * that reports if they are correct or incorrect, and appends the correct sum of the array.
	 * @return Returns a string showing a wrong or correct answer.
	 */
	public java.lang.String getResult()
	{
		if ((guess == 'Y') && (arraySum > guessTarget) || ((guess == 'N') && (arraySum <= guessTarget)))
		{
			String a = "You guessed correctly! The sum was " + arraySum + '!';
			return a;
		}
		else
		{
			String a = "You guessed wrong! The sum was " + arraySum + '!';
			return a;
		}
	}
	
	/**
	 * Populates the "numbers" array with random numbers between 1 and "MAX_VALUE".
	 */
	public void populateArray()
	{
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(MAX_VALUE) + 1;
		}
	
		for (int i = 0; i < numbers.length; i++)
		{
			arraySum += numbers[i];
		}
	}

	/**
	 * Toggles the value of hideMiddleVals. If it is currently true, sets it to false, 
	 * and vice-versa.
	 */
	public void toggleHidden()
	{
		if (hideMiddleVals)
		{
			hideMiddleVals = false;
		}
		else
		{
			hideMiddleVals = true;
		}
	}

	/**
	 * Returns a String containing the values in the "numbers" array on a single line, 
	 * separated by spaces with the middle values hidden or all visible based on value 
	 * of "hideMiddleValue" data member. There is a trailing space on the end, so an 
	 * example String returned may be: "5 X X X 67 ". NOTE: This does not output to 
	 * System.out, it generates and returns a String.
	 */
	public java.lang.String toString()
	{
		if (!hideMiddleVals)
		{
			String list = numbers[0] + " " + numbers[1] + " " + numbers[2] 
					+ " " + numbers[3] + " " + numbers[4] + " ";
			return list;
		}
		else
		{
			String list = numbers[0] + " X X X " + numbers[4] + " ";
			return list;
		}
	}

	/**
	 * Accepts a user's guess for the game. Validates that it is either the character 'Y' or 'N'. 
	 * If it is a valid guess, sets the guess data member to the passed value and returns "true". 
	 * If it is not valid it does not change the value of guess and returns false.
	 * @param guessIn
	 * @return
	 */
	public boolean validatePlayerGuess(char guessIn)
	{
		if (guessIn == 'Y' || guessIn == 'N')
		{
			boolean guessOut = true;
			guess = guessIn;
			return guessOut;
		}
		else
		{
			boolean guessOut = false;
			return guessOut;
		}
	}
}
