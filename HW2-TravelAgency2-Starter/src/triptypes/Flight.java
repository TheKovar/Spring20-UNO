// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

package triptypes;

public class Flight
{
	
	/**
	 * Stores airline info.
	 */
	private String al;
	/**
	 * Stores flightNum info.
	 */
	private int fn;
	/**
	 * Stores from info.
	 */
	private String fr;
	/**
	 * Stores to info.
	 */
	private String t;
	/**
	 * Stores leavesAt info.
	 */
	private java.util.Calendar la;
	/**
	 * Stores arrives info.
	 */
	private java.util.Calendar ar;
	/**
	 * Stores price info.
	 */
	private double pr;
	
	/**
	 * Creates a new flight leg in the system.
	 * @param airline - The two letter airline code (e.g, "DL", "AA")
	 * @param flightNum - The unique flight number on a given day
	 * @param from - The three letter airport code for the departure airport (e.g, "OMA")
	 * @param to - The three letter airport code for the arrival airport (e.g., "CDG")
	 * @param leavesAt - The departure time
	 * @param arrives - The arrival time
	 * @param price - The price for this flight in US Dollars.
	 */
	public Flight(java.lang.String airline, int flightNum, java.lang.String from, java.lang.String to, 
			java.util.Calendar leavesAt, java.util.Calendar arrives, double price)
	{
		al = airline;
		fn = flightNum;
		fr = from;
		t = to;
		la = leavesAt;
		ar = arrives;
		pr = price;
	}
	
	/**
	 * Retrieves the price of this flight.
	 * @return The price in US Dollars.
	 */
	public double getPrice()
	{
		return pr;
	}
	
	/**
	 * Retrieves a formatted string summarizing this Flight. Strings will
	 * be formatted as: XX#### Departs: AIR at HH:mm MM-dd-YYYY; Arrives POR at HH:mm MM-dd-YYYY
	 * Where XX is the two letter airline abbreviation and #### is the flight number, which may be
	 * 1-4 digits in length and is right aligned in a 4 character wide field. 
	 * AIR and POR are the departure and arrival airport codes, respectively.
	 * The HH:mm MM-dd-YYYY values correspond to the departure and arrival time formats using a 24-hour clock.
	 * (see, e.g., java.util.SimpleDateFormat). 
	 * For example: DL 123 Departs: OMA at 15:25 03-15-2019; Arrives ATL at 18:01 03-15-2019
	 * 
	 * @return XX#### Departs: AIR at HH:mm MM-dd-YYYY; Arrives POR at HH:mm MM-dd-YYYY
	 */
	public java.lang.String toString()
	{
		String s =  al + fn + " Departs: " + fr + " at " + la + "; Arrives " + t + " at " + ar;
		return s;
	}
}
