// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

package triptypes;

public class Cruise extends FlightOptionalPackage
{
	/**
	 * Stores vessel name.
	 */
	private String vn;
	/**
	 * Stores port city.
	 */
	private String pc;
	/**
	 * Stores departure date.
	 */
	private java.util.Calendar d;
	/**
	 * Stores return date. 
	 */
	private java.util.Calendar r;
	/**
	 * Stores base price.
	 */
	private double bp;
	/**
	 * Array to store excursion names.
	 */
	private String[] ex;
	/**
	 * Array to store excursion prices.
	 */
	private double[] exp;
	/**
	 * Stores cabin type.
	 */
	private CabinType ct = CabinType.INTERIOR;
	
	/**
	 * Creates a new Cruise trip with specified values for all data except optional excursions.
	 * @param name - The promotional name of the travel package.
	 * @param numDays - The number of days for this travel package.
	 * @param vesselName - The ship name for this Cruise.
	 * @param portCity - The departure port for this Cruise.
	 * @param departs - The time and date of departure from the port.
	 * @param returns - The time and date of return to the port.
	 * @param basePrice - The base price for the cheapest tier cabin (interior) on the ship.
	 * Cabin upgrades can be accommodated through a subsequent setter call.
	 */
	public Cruise(java.lang.String name, int numDays, java.lang.String vesselName, java.lang.String portCity,
			java.util.Calendar departs, java.util.Calendar returns, double basePrice)
	{
		super(name, numDays);
		vn = vesselName;
		pc = portCity;
		d = departs;
		r = returns;
		bp = basePrice;
	}
	/**
	 * Adds a named excursion to this Cruise. Excursions may or may not
	 * have an additional charge associated.
	 * @param excursion - The name of the excursion to add to this package.
	 * Empty excursion values are invalid and should not result in a change
	 * to the Cruise package configuration.
	 * @param price - The price of the excursion. Prices must be >= 0, with
	 * any negative values being treated as equivalent to 0.
	 */
	public void addExcursion(java.lang.String excursion, double price)
	{
		if (!excursion.equals("") || !excursion.equals(null))
		{		
			ex[ex.length] = excursion;
			if (price <= 0)
			{
				exp[exp.length] = 0;
			}
			else
			{
				exp[exp.length] = price;
			}
		}
	}
	/**
	 * Retrieves an array containing all of the excursions which have been
	 * added to this Cruise, in the order in which they were added.
	 * @return The list of excursions.
	 */
	public java.lang.String[] getExcursions()
	{
		return ex;
	}
	/**
	 * Updates the cabin configuration for this Cruise. This method can be
	 * used to upgrade a cruise from the base price corresponding to the
	 * cheapest cabin (an interior cabin without any ocean view).
	 * @param cabin - A valid alternate cabin level for this package.
	 */
	public void setCabinType(CabinType cabin)
	{
		ct = cabin;
	}
	/**
	 * Retrieves the cabin level currently associated with this Cruise package.
	 * @return The current cabin level.
	 */
	public CabinType getCabinType()
	{
		return ct;
	}
	/**
	 * Retrieves the home port of the cruise ship for this package.
	 * @return The city from which this Cruise departs.
	 */
	public java.lang.String getHomePort()
	{
		return pc;
	}
	/**
	 * Retrieves the date and time of departure for this Cruise.
	 * @return The departure time at the port.
	 */
	public java.util.Calendar getDepatureDate()
	{
		return d;
	}
	/**
	 * Retrieves the date and time of arrival for this Cruise.
	 * @return The arrival time at the port.
	 */
	public java.util.Calendar getReturnDate()
	{
		return r;
	}
	/**
	 * Retrieves the name of ship sailing for this Cruise.
	 * @return The ship name.
	 */
	public java.lang.String getVesselName()
	{
		return vn;
	}
	/**
	 * Retrieves the total cost for all added excursions on this Cruise.
	 * @return The excursions total in US Dollars.
	 */
	public double getExcursionCosts()
	{
		double cost = 0;
		for (int i = 0; i < exp.length; i++)
		{
			cost += exp[i];
		}
		return cost;
	}
	/**
	 * Retrieves the number of excursions which have been added to this Cruise package.
	 * @return The number of excursions.
	 */
	public int getNumExcursions()
	{
		return ex.length;
	}
	/**
	 * Retrieves the full price of this Cruise package, including pre-cruise
	 * flight arrangements (as applicable), full lodging costs, and any
	 * additional excursion costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return getFlightCosts() + getLodgingCost() + getExcursionCosts();
	}
	/**
	 * Retrieves the deposit amount required upfront for this Cruise.
	 * Cruise packages require that all applicable flight costs and 50%
	 * of expected lodging costs are paid at the time of booking.
	 * Optional excursion costs are not included in the deposit amount,
	 * but must be paid prior to departure.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return getFlightCosts() + (getLodgingCost() / 2) + getExcursionCosts();
	}
	/**
	 * Retrieves the lodging charge for this Cruise package, calculated
	 * from the base price scaled based on the cabin level according to
	 * the following fee schedule.
	 * Interior Room:     100% of base price
	 * Ocean View Room:   150% of base price
	 * Balcony Room:      300% of base price
	 * Luxury Suite:      500% of base price
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost()
	{
		if (ct == CabinType.INTERIOR)
		{
			return bp;
		}
		else if (ct == CabinType.OCEAN_VIEW)
		{
			return bp * 1.5;
		}
		else if (ct == CabinType.BALCONY)
		{
			return bp * 3;
		}
		else
		{
			return bp * 5;
		}
	}
	/**
	 * Retrieves a formatted string summarizing this Cruise package. The required format
	 * for this string includes information as described by FlightOptionalPackage followed
	 * by cruise details on the next line. The second line should be prefixed with 11 blank
	 * spaces for alignment below the trip name. An example of this format is shown here: 
	 * $2499.99 Bermuda Triangle...and Maybe Back (Flight Not Included)
	 *          Cruising from Miami on the Caribbean Princess
	 * If optional excursions have been added, a parenthetical suffix will be added indicating
	 * how many excursions are included: 
	 * $2499.99  Bermuda Triangle...and Maybe Back (Flight Not Included)
	 *           Cruising from Miami on Caribbean Princess (includes 4 excursions)
	 * @return The formatted string summary.
	 */
	public java.lang.String toString()
	{
		String s;
		if (ex[0].equals(null))
		{
			s = "$" + (getPrice() - getFlightCosts()) + " " + getName() + " (Flight Not Included)" 
				+ System.lineSeparator() + "           Cruising from " + pc + " on the " + vn;
		}
		else
		{
			s = "$" + (getPrice() - getFlightCosts()) + " " + getName() + " (Flight Not Included)" 
					+ System.lineSeparator() + "           Cruising from " + pc + " on the " + vn 
					+ " (includes " + getNumExcursions() + " excursions)";
		}
		return s;
	}
}
