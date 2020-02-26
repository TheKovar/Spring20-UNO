// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

package triptypes;

public class AllInclusiveResort extends FlightOptionalPackage
{
	/**
	 * Stores resort name.
	 */
	private String r;
	/**
	 * Stores guests per room.
	 */
	private int gpr;
	/**
	 * Stores price per night.
	 */
	private double ppn;
	/**
	 * Stores amenities list.
	 */
	private String[] am;
	
	/**
	 * Creates a new AllInclusiveResort package.
	 * @param name - The promotional name for this package.
	 * @param numDays - The number of days included in this vacation package.
	 * @param resort - The name of the resort.
	 * @param guestsPerRoom - The number of guests allowed per room at the included price.
	 * @param pricePerNight - The price of the stay per night.
	 * @param amenitiesList - A list of amenities available for free at the resort.
	 */
	public AllInclusiveResort(java.lang.String name, int numDays, java.lang.String resort,
			int guestsPerRoom, double pricePerNight, java.lang.String[] amenitiesList)
	{
		super(name, numDays);
		r = resort;
		gpr = guestsPerRoom;
		ppn = pricePerNight;
		am = amenitiesList;
	}
	/**
	 * Retrieves a single String containing all of the available amenities at there
	 * sort. Individual amenities should be separated by a single comma and space
	 * character, with no such separator at the end of the string.
	 * @return The amenities list.
	 */
	public java.lang.String getAmenities()
	{
		return am.toString().replace("[", "").replace("]", "").replace(",", ", ");
	}
	/**
	 * Retrieves the number of guests allowed per room at the specified rate.
	 * @return The number of guests per room.
	 */
	public int getGuestsPerRoom()
	{
		return gpr;
	}
	/**
	 * The full price for this all-inclusive package, including any optional
	 * flight pricing.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return super.getFlightCosts() + (super.getNumDays() * ppn);
	}
	/**
	 * The required deposit amount to be made at the time of booking. All
	 * upfront flight-related costs and 50% of the total lodging costs for this
	 * trip must be paid as a deposit.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return super.getFlightCosts() + (getLodgingCost() / 2);
	}
	/**
	 * A formatted summary string with details about this all-inclusive resort
	 * package. The string will contain information as described by FlightOptionalPackage
	 * followed by details about the resort and the number of people included at the
	 * specified price. The second line should be prefixed with 11 blank
	 * spaces for alignment below the trip name. For example: 
	 * $  450.35  Punta Cana Fiesta! (Flight Included)
	 *            An all-inclusive stay at Flip Flops for 2 people!
	 * @return The formatted string summary.
	 */
	public java.lang.String toString()
	{
		String s = "$  " + getPrice() + "  " + super.getName() + " (Flight Included)" + System.lineSeparator() 
			+ "           An all-inclusive stay at " + r + " for " + gpr + " people!";
		return s;
	}
	/**
	 * Retrieves the subtotal for lodging associated with this
	 * all inclusive resort stay based on the number of nights
	 * in the package and the base price.
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost()
	{
		return (super.getNumDays() - 1) * ppn;
	}
}
