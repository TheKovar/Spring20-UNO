// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used


public class Chair extends FurnitureProduct
{
	/*
	 * Denotes whether or not the chair has cushions.
	 */
	private boolean cushioned;
	
	/*
	 * Chair constructor, takes all information required of a chair furniture product.
	 */
	public Chair(java.lang.String productNameIn, int productNumberIn, boolean cushionedIn)
	{
		
		super(productNameIn, productNumberIn);
		cushioned = cushionedIn;
		
	}
	
	/*
	 * Used to get String representation of the Chair. Returned String is of the format:
	 * Product Name: PROD_NAME, Product Number: PROD_NUM, CUSHIONED
	 * Where PROD_NAME is the name of the product, PROD_NUM is the product number, 
	 * and CUSHOINED is either the String "Has cushions" or "No cushions".
	 */
	public java.lang.String toString()
	{
		int a = super.getProductNumber();
		String b = super.getProductName();
		String c;
		
		if (this.cushioned)
		{
			c = "Has cushions";
		}
		else
		{
			c = "No cushions";
		}
		
		String s = "Product Name: " + b + ", Product Number: " + a + ", " + c;
		return s;
	}
}