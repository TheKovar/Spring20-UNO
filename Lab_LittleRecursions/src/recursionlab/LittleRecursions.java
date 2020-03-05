// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

package recursionlab;

////////////////////////////////////////////////////////////
//
// NOTE: No loops or fields are allowed in this file!
//       Solve these methods using only 
//       recursion.  
//
//       Use of fields will be penalized by WebCAT testing,
//       and points will be scaled proportionally based on 
//       your use of recursion.  If you use for/while to solve
//       these problems you will have points deducted!
//
////////////////////////////////////////////////////////////

public class LittleRecursions
{
	/**
	 * Determines if a given String is a palindrome 
	 * (meaning it is the same forwards and backwards).
	 * Comparison of characters are not case sensitive.
	 * 
	 * <P>Thus, the following are palindromes
	 * <BR>RACECAR
	 * <BR>rAcECar
	 * <BR>aBbA
	 * <P>The following are NOT palindromes
	 * <BR>DOG
	 * <BR>Taylor Swift
	 * <BR>OO00
	 * 
	 * @param s The string to check for palindrome status.
	 * @return True if and only if s is a palindrome; false otherwise.
	 */
	public static boolean isPalindrome(String s)
	{
		if (s == null) 
		{ 
			return false; 
		} 
		
		String reverse = reverseSome(s); 
		
		return s.equals(reverse); 
	}
	
	/**
	 * Creates a string like the one given in the input parameter, but
	 * with all letters in reverse order.  All non-letters will be 
	 * removed from the final string.  For example:
	 * 
	 * <p>reverseSome("asdf") ==> "fdsa"
	 * <br>reverseSome("this is a test") ==> "tsetasisiht"
	 * <br>reverseSome("ABC 123!") ==> "CBA"
	 * 
	 * @param s The string to reverse.
	 * @return A version of s in which all letter characters are in 
	 * the reverse order of the original.
	 */
	public static String reverseSome(String s)
	{
		if (s == null || s.length() <= 1) 
		{ 
			return s; 
		} 
		return reverseSome(s.substring(1)) + s.charAt(0); 
	}
	
	/**
	 * This method computes the greatest common divisor
	 * of two numbers using Euclid's algorithm. 
	 * 
	 * <p>Mathematically, gcd is recursively defined as:
	 * <br>gcd(x, 0) = x
	 * <br>gcd(x, y) = gcd(y, x mod y)
	 * 
	 * @param x The first operand in the greatest common divisor.
	 * @param y The second operand in the greatest common divisor.
	 * @return The greatest common divisor of x and y.
	 */
	public static int gcd(int x, int y)
	{
		if (x == 0)
		{
			return y;
		}
		
		return gcd(y % x, x);
	}
	
	/**
	 * Computes the sum of all positive values in the
	 * array parameter.
	 * 
	 * @param array The array of values to consider
	 * @return The additive sum of all integers in array that are
	 *         positive.  The sum will be 0 when the array 
	 *         parameter is null.  
	 */
	public static int sumPositive(int[] array)
	{
		if (counter(array) <= 0)
		{
			return 0;
		}
		
		return sumPositive(array) + array[counter(array) - 1];
		
	}
	/**
	 * Used to count the array for sumPosttive.
	 * @param n - input array
	 * @return current length of the array
	 */
	public static int counter(int[] n)
	{
		if (n == null)
		{
			return 0;
		}
		int s = n.length;
		return s;
	}
}
