// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

/**
 * The FurnitureProduct class is the base class for all products sold in a furniture store.
 * It contains the two things that all furniture products have, a name and product number.
 * @author nrkovar
 */
public class FurnitureProduct
{
	/**
	 * The smallest allowed value for a product number, set to 10000.
	 */
	private static final int MINIMUM_PRODUCT_NUMBER = 10000;
	/**
	 * The largest allowed value for a product number, set to 99999.
	 */
	private static final int MAXIMUM_PRODUCT_NUMBER = 99999;	
	/**
	 * The name of the product.
	 */
	private String productName;
	/**
	 * The number of the product. An invalid product number will be denoted by a -1.
	 */
	private int productNumber;
	
	/*
	 * FurnitureProduct constructor used to create a new furniture product. 
	 * Takes product name and product number.
	 */
	public FurnitureProduct(java.lang.String productNameIn, int productNumberIn)
	{
		
		productName = productNameIn;
		setProductNumber(productNumberIn);
		
	}
	
	/*
	 * Sets the product number of the product to the value passed if it is in range of the minimum and maximum,
	 * otherwise it does nothing.
	 */
	public void setProductNumber(int productNumberIn)
	{
		if (productNumberIn >= MINIMUM_PRODUCT_NUMBER && productNumberIn <= MAXIMUM_PRODUCT_NUMBER)
		{
			productNumber = productNumberIn;
		}
		else
		{
			productNumber = -1;
		}
	}
	
	/*
	 * Returns the product number of the furniture product.
	 */
	public int getProductNumber()
	{
		return productNumber;
	}
	/*
	 * Returns the product name of the furniture
	 */
	public String getProductName()
	{
		return productName;
	}
	
	/*
	 * Determines if one FurnitureProduct is equal to another based solely on product number.
	 */
	public boolean equals(FurnitureProduct other)
	{
		if (other == null)
		{
			return false;
		}
		return this.getProductNumber() == other.getProductNumber();
		
	}
	/*
	 * Used to get String representation of the FurnitureProduct. Returned String is of the format:		  
	 * Product Name: PROD_NAME, Product Number: PROD_NUM
	 * Where PROD_NAME is the name of the product and PROD_NUM is the product number
	*/
	public java.lang.String toString()
	{
		String s = "Product Name: " + productName + ", Product Number: " + productNumber;
		return s;
	}
}
