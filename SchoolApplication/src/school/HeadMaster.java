package school;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * HeadMaster class inherits SignupDeatils and storeHeadMaster will store details into detailsList ArrayList
 */

public class HeadMaster extends SignupDetails {
	
	private String subject;
	private static int headMasterId =0;
	
/**
 * This method will take subject input which is optional and store it along with details inherited from singupDetails.	
 * 
 * @param headMasterObj
 * @param detailsList
 * @throws IOException
 * @throws InterruptedException 
 * @throws ParseException 
 * @throws RuntimeException 
 * 
 * 
 */
	public void storeDetails(ArrayList<Object> detailsList,SignupDetails headMasterObj)throws IOException, RuntimeException, ParseException, InterruptedException {
		super.storeDetails(detailsList, headMasterObj);
		headMasterObj.setId();
		setSubject();
		detailsList.add(headMasterObj);
	}
	
	/**
	 * Returns Subject
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * sets Id
	 */
	public void setId() {
		headMasterId = headMasterId+1;
	}
	
	/**
	 * Returns id
	 * @return
	 */
	public String getHeadMasterId() {
		return String.valueOf(headMasterId);
	}

	public void setSubject() throws IOException {
		System.out.println("Subject :");
	    subject = br.readLine();
		boolean isEmptySubject = subject == null || subject.trim().length() == 0;
		if (isEmptySubject) {
		    subject = " ";
		}
	}

}