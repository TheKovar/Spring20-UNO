// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

package triptypes;

public abstract class VacationPackage
{
	/**
	 * Stores name.
	 */
	private String nm;
	/**
	 * Stores days.
	 */
	private int d;
	
	/**
	 * Initializes a VacationPackage with provided values.
	 * @param name - The promotional marketing name for this package.
	 * @param numDays - The number of days included in this VacationPackage trip.
	 */
	public VacationPackage(java.lang.String name, int numDays)
	{
		nm = name;
		d = numDays;
	}
	/**
	 * Updates the VacationPackage's externally facing promotional
	 * name. Due to travel agency policy, this name is never allowed to
	 * be empty as it would be confusing for agents and customers interacting
	 * with the system. Names that do not comply with this policy will be
	 * ignored and the package will be given the name "PACKAGE NAME TBD" as
	 * a placeholder.
	 * @param name - The updated name to use for this package.
	 */
	public void setName(java.lang.String name)
	{
		if (name.equals("") || name == null)
		{
			nm = "PACKAGE NAME TBD";
		}
		else
		{
			nm = name;
		}
	}
	/**
	 * Updates the length of this VacationPackage. All packages must have
	 * a minimum of one day.
	 * @param numDays - The new number of days for this package.
	 */
	public void setLength(int numDays)
	{
		if (numDays >= 1)
		{
			d = numDays;
		}
		else
		{
			d = 1;
		}
	}
	/**
	 * Retrieves the promotional name of this package.
	 * @return The name.
	 */
	public java.lang.String getName()
	{
		return nm;
	}
	/**
	 * Retrieves the number of days included in this package.
	 * @return The number of days for this trip.
	 */
	public int getNumDays()
	{
		return d;
	}
	/**
	 * This method provides the full price of a vacation package, which
	 * is must be computed based on the specific kind of trip being
	 * booked.
	 * @return The price of a vacation package in US Dollars.
	 */
	public abstract double getPrice();
	/**
	 * This method provides the required upfront deposit amount for a
	 * given vacation. This must be computed based on rules determined
	 * by specific package types, per travel agency policies.
	 * @return The deposit amount required in US Dollars.
	 */
	public abstract double getDepositAmount();
	/**
	 * This method provides the remaining amount due to the travel agent
	 * for this trip less any deposit made upfront.
	 * @return The remaining balance to pay the travel agency.
	 */
	public double getAmountDue()
	{
		return getPrice() - getDepositAmount();
	}
	/**
	 * This method provides the subtotal for a trip related to lodging
	 * expenses (ie, not including flights, meals, and incidentals).
	 * Lodging rates are determined by specific package types.
	 * @return The lodging subtotal in US Dollars.
	 */
	public abstract double getLodgingCost();
	/**
	 * This method produces a String summary of a VacationPackage. Strings
	 * will be prefixed with the $ symbol, followed by trip total price rounded
	 * to two decimal places in a 8 character wide field. Price details should be
	 * followed by two spaces and the promotional name of this trip. 
	 * For example: 
	 * 
	 * $ 1234.56  Spring Break at the Beach
	 * $  150.99  Rustic Backpacking at Mt. Rushmore
	 * @return The formatted string summary.
	 */
	public java.lang.String toString()
	{
		String s = "$  " + getPrice() + "  " + getName();
		return s;
	}
}
