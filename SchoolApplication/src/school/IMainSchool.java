package school;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * MainSchool Interface has all the main methods used by this application
 */

public interface IMainSchool {
	
	/**
	 * Takes common inputs from user and pass it to it's subclasses.
	 * 
	 * @param detailsList
	 * @throws RuntimeException
	 * @throws IOException
	 * @throws ParseException
	 * @throws ValidateException
	 * @throws InterruptedException
	 * 
	 * 
	 */
	void storeDetails(ArrayList<Object> detailsList) throws RuntimeException,  IOException,ParseException ,ValidateException, InterruptedException;
	
	
}