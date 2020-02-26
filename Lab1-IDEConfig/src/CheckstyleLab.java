// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: <DISCLOSURE OF RESOURCE USE>
/**
 * Lab to practice Checkstyle formatting.
 * @author nrkovar
 */
public class CheckstyleLab
{
	/**
	 * Creates an integer value limited to 10.
	 */
	private static final int ARR_SIZE = 10;
	
	/**
	 * Main method which calculates the sum of the squares of the integers 1 to 10 inclusive.
	 * @param args Command line arguments (Unused)
	 */
	public static void main(String[] args)
	{
		int[] squares = new int[ARR_SIZE];
		
		for (int i = 0; i < 10; i++) 
		{
			squares[i] = (int) Math.pow(i + 1, 2);
			System.out.printf("Square of %d is %d\n", i + 1, squares[i]);
		}	
		System.out.printf("The sum of the squares is %d!\n\n", sumArray(squares));
	}
	
	/**
	 * This method returns the sum of the values in the arr parameter or zero when arr is null.
	 * @param arr array
	 * @return sum
	 */
	public static int sumArray(int[] arr)
	{
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
		}
		return sum;
	}
}
