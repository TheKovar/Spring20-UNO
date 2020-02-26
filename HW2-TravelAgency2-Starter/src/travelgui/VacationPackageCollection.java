// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Nathan Kovar
// RESOURCES: No resources used

package travelgui;
import triptypes.VacationPackage;

public class VacationPackageCollection
{
	VacationPackage[] vpc;

	
	/*
	 * Creates a new empty VacationPackageCollection.
	 */
	public VacationPackageCollection()
	{
		vpc = new VacationPackage[];
	}
	/**
	 * Retrieves the number of trip packages that have been
	 * added to this collection for purchase.
	 * @return The total number of available packages.
	 */
	public int getNumTrips()
	{
		int count = 0;
		for (int i = 0; i < vpc.length; i++)
		{
			if (vpc[i] != null)
			{
				count += 1;
			}
		}
		return count;
	}
	/**
	 * Retrieves an array of all available packages from the
	 * collection. Valid packages are guaranteed to be stored
	 * contiguously in the left most array cells. Any empty cells
	 * will appear to the right of the last valid VacationPackage. 
	 * Unless a sort has occurred, packages will appear in the
	 * order in which they were added.
	 * @return The list of available packages.
	 */
	public VacationPackage[] getAllVacations()
	{
		return vpc;
	}
	
	public void addVactation(VacationPackage trip)
	{
		for (int i = 0, i < vpc.length; i++)
		{
			if ()
		}
	}
}
