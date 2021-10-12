package school;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * SchoolApp is Main class that passes control to different classes based on user input
 */

public class SchoolApp {
	
	enum Role{
		STUDENT,TEACHER,HEADMASTER;
	}
	
	/**
	 *  Based on user choice control is passed to different classes of this application.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InValidPositionException
	 * @throws RuntimeException
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	
	public static void main(String[] args) throws IOException,InValidPositionException, RuntimeException, ParseException, InterruptedException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Object> detailsList = new ArrayList<>();
		String choice ;
		String next = "yes";
		while(next.equals("yes")) {
			System.out.println("1.SingUp     2.Details");
			System.out.println("please select an option : ");
			choice = br.readLine();
			boolean isValidChoice= !choice.equals("1") && !choice.equals("2");
			while(isValidChoice) {
				try{
					if(isValidChoice)
						throw new InValidPositionException("Invalid Option");
					}
					catch(InValidPositionException e) {
						System.err.println(e.getMessage());
						Thread.sleep(100);
					}
				System.out.println("Enter correct option : ");
				choice = br.readLine();
				isValidChoice = !choice.equals("1") && !choice.equals("2");
			}
		if(choice.equals("1")) {
			SchoolFactory schoolFactory = new SchoolFactory();
			System.out.println("1.Student 2.Teacher 3.HeadMaster");
			System.out.println("select your position : ");
			String position  = br.readLine();
			boolean isValidPosition = !position.equals("1") && !position.equals("2") && !position.equals("3");
			while(isValidPosition) {
				try {
					if(isValidPosition)
					throw new InValidPositionException("Invalid Option");
				}
				catch(InValidPositionException e) {
					System.err.println(e.getMessage());
					Thread.sleep(100);
				}
				System.out.println("Enter correct option : ");
				position = br.readLine();
				isValidPosition = !position.equals("1") && !position.equals("2") && !position.equals("3");
			}
			
			SignupDetails signupDetailsObj = schoolFactory.getFactory(position);
			System.out.println("factory returned obj :"+signupDetailsObj);
//			UserDetails userDetailobj  = new UserDetails();
//			userDetailobj.storeDetails(detailsList, signupDetailsObj);
			signupDetailsObj.storeDetails(detailsList,signupDetailsObj);
		}
		else if(choice.equals("2")) {
			System.out.println("\nDetails");
			ViewDetails viewDetailsObj = new ViewDetails();
			System.out.println("Enter text to be searched : ");
			String searchElement = br.readLine();
			viewDetailsObj.display(searchElement,detailsList);
		}
		System.out.println("Contine or terminate :(yes/no) ");
		next = br.readLine();
		}
		System.out.println("Thank you...");
	}

}