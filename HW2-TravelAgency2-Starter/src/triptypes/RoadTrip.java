// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

package triptypes;

public class RoadTrip extends VacationPackage
{
	private String[] sp;
	private double fc;
	private int m;
	private int mp;
	private int stars;
	
	
	/**
	 * Creates a newly initialized RoadTrip object using the parameter data.
	 * @param name - The promotional name to use for this RoadTrip in the travel agency system.
	 * @param numDays - The number of days required for this RoadTrip.
	 * @param stops - A list of destinations that will be visited along the way on this RoadTrip.
	 * @param fuelCost - The estimated cost of fuel in US Dollars per Gallon based on current rates.
	 * @param miles - The total number of miles for this RoadTrip, assuming people follow the intended route.
	 * @param maxPersons - The number of people for whom this trip package will be budgeted.
	 * @param hotelStars - The quality level of the hotels used during the RoadTrip, 
	 * 		  ranging from 1..5 stars, inclusive. Star values outside this range will 
	 * 		  be adjusted to the closest valid value.
	 */
	public RoadTrip(java.lang.String name, int numDays, java.lang.String[] stops, 
			double fuelCost, int miles, int maxPersons, int hotelStars)
	{
		super(name, numDays);
		sp = stops;
		fc = fuelCost;
		m = miles;
		mp = maxPersons;
		stars = hotelStars;
	}
	
	/**
	 * Retrieves the hotel quality level attached to this RoadTrip package.
	 * @return The number of stars for hotel stays.
	 */
	public int getHotelStars()
	{
		return stars;
	}
	/**
	 * Provides the full price of this RoadTrip object. RoadTrip prices are computed
	 * based on the total rental car, lodging, and fuel estimated costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		double c = getFuelPrice() + getCarCost() + getLodgingCost();
		return c;
	}
	/**
	 * Provides the required deposit amount for this RoadTrip object. The required
	 * deposit for a Road trip includes the full lodging cost plus the full rental car
	 * cost.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		double c = getLodgingCost() + getCarCost();
		return c;
	}
	/**
	 * All RoadTrips must be fully paid in advance, with the exception of fuel costs.
	 * Fuel costs are paid to the gas station, and not the travel agent. Thus, the
	 * balance due on RoadTrips is always 0.
	 * @return The remaining balance to pay the travel agency.
	 */
	public double getAmountDue()
	{
		return 0;
	}
	/**
	 * Provides the total lodging cost for a RoadTrip object. Lodging is computed
	 * based on the length of the vacation, the quality of the hotel (in stars),
	 * the number of rooms needed for the party and a base charge of $35.20 per room
	 * per night. Lodging costs assume a maximum 2 person occupancy per room. 
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost()
	{
		int p = mp % 2;
		if (p < 1)
		{
			p = 1;
		}
		
		double c = 35.2 * stars * p * super.getNumDays();
		return c;
	}
	/**
	 * Provides the total cost for the rental car based on the trip duration and the
	 * size of car needed. Rental cars are billed based on full days, with no partial
	 * day rentals allowed. Further, the travel agency uses a standard daily rental
	 * car charge based on the number of occupants riding along: 
	 * $ 36.75   1-2 passengers
	 * $ 50.13   3-4 passengers
	 * $ 60.25   5-6 passengers
	 * $ 70.50   7-8 passengers
	 * $150.00    9+ passengers (since you'll need a bus)
	 * @return The total rental car cost for this trip.
	 */
	public double getCarCost()
	{
		double c = 0;
		
		if (mp <= 2)
		{
			c = 36.75;
		}
		else if (mp == 3 || mp == 4)
		{
			c = 50.13;
		}
		else if (mp == 5 || mp == 6)
		{
			c = 60.25;
		}
		else if (mp == 7 || mp == 8)
		{
			c = 70.50;
		}
		else if (mp >= 9)
		{
			c = 150.00;
		}
		
		return super.getNumDays() * c;
	}
	/**
	 * Retrieves the number of stops along the route for this RoadTrip.
	 * @return The number of intermediate destinations.
	 */
	public int getNumStops()
	{
		int a = sp.length;
		return a;
	}
	/**
	 * Updates the number of people to be used for budgeting this RoadTrip within the
	 * travel agency.
	 * @param maxPeople - The new number of people to use in calculations.ople
	 */
	public void setPersons(int maxPeople)
	{
		mp = maxPeople;
	}
	/**
	 * Retrieves the number of people included for budget calculations by this RoadTrip.
	 * @return The number of persons.
	 */
	public int getNumPersons()
	{
		return mp;
	}
	/**
	 * Updates the cost of fuel in US dollars per gallon. This value is used
	 * for projecting out costs for this RoadTrip. Prices must be positive values,
	 * and a default assumption of $2.50 per gallon will be used if an invalid price
	 * is specified.
	 * @param pricePerGallon - The new price to use for cost projections.
	 */
	public void setFuelPrice(double pricePerGallon)
	{
		double p = pricePerGallon;
		
		if (p <= 0)
		{
			p = 2.50;
		}
		
		fc = p;
	}
	/**
	 * Retrieves the current fuel price used for cost projections.
	 * @return The fuel price in US dollars per gallon.
	 */
	public double getFuelPrice()
	{
		return fc;
	}
	
	public double getEstimatedFuelCost()
	{
		double c = 0;
		if (mp <= 2)
		{
			c = m / 45 * fc;
		}
		else if (mp == 3 || mp == 4)
		{
			c = m / 32 * fc;
		}
		else if (mp == 5 || mp == 6)
		{
			c = m / 28 * fc;
		}
		else if (mp == 7 || mp == 8)
		{
			c = m / 22 * fc;
		}
		else if (mp >= 9)
		{
			c = m / 15 * fc;
		}
		
		return c;
	}
	/**
	 * Retrieves the list of stops on this RoadTip as a single string with values
	 * separated by a comma and a single space. The last stop has no punctuation after
	 * it.
	 * @return The list of stops.
	 */
	public java.lang.String getStops()
	{
		return sp.toString().replace("[", "").replace("]", "");
	}
	/**
	 * Provides a string summary of this RoadTrip. Promotional details and trip duration
	 * are provided as with all VacationPackages, followed by a summary message about the stops to be made on 
	 * the following line with each stop separated by a comma. The
	 * second line should be prefixed with 11 blank spaces for alignment below the trip name.For example: 
	 * $  150.99  Rustic Backpacking at Mt. Rushmore
	 *            A road trip with stops at Carhenge, Chimney Rock, The Corn Palace, Mt. Rushmore
	 * @return The formatted string summary.
	 */
	public java.lang.String toString()
	{
		String s = "$  " + getPrice() + "  " + super.getName() 
			+  System.lineSeparator() + "           " + getStops();
		return s;
		
	}
}
