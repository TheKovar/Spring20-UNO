// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

public class Table extends FurnitureProduct
{
	/*
	 * Count of possible place settings at the table.
	 */
	private int seats;
	
	/*
	 * Table constructor, takes all information required of a table furniture product. 
	 * Ensures table has a minimum of 1 seats.
	 */
	public Table(java.lang.String productNameIn, int productNumberIn, int seatsIn)
	{
		
		super(productNameIn, productNumberIn);
		
		if (seatsIn > 0)
		{
			seats = seatsIn;
		}
		else
		{
			seats = 1;
		}
		
	}
	
	/*
	 * Sets the number of seats for the table. Tables can have a minimum of 1 seats.
	 */
	public void setSeats(int seatsIn)
	{
		if (seatsIn > 0)
		{
			seats = seatsIn;
		}
		
	}
	
	/*
	 * Returns the number of seats for the table.
	 */
	public int getSeats()
	{
		return seats;
	}
	
	/*
	 * Used to get String representation of the Table. Returned String is of the format:
	 * Product Name: PROD_NAME, Product Number: PROD_NUM, Number of Seats: NUM_SEATS
	 * Where PROD_NAME is the name of the product, PROD_NUM is the product number,
	 * and NUM_SEATS is the number of seats.
	 */
	public java.lang.String toString()
	{
		String b = super.getProductName();
		int a = super.getProductNumber();
		String s;
		s = "Product Name: " + b + ", Product Number: " + a + ", Number of seats: " + this.getSeats();
		return s;
	}
}