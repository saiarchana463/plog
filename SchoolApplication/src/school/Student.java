package school;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Student class inherits SignupDeatils and storeStudent() will store details into detailsList ArrayList
 */
class Student extends SignupDetails{
	
	private static int studentId = 0;
	
	/**
	 * storeStudent will store the details received from signupDetails class into detailsList.
	 * @param studentObj
	 * @param detailsList
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws ParseException 
	 * @throws RuntimeException 
	 */
	public void storeDetails(ArrayList<Object> detailsList,SignupDetails studentObj) throws IOException, RuntimeException, ParseException, InterruptedException {
		super.storeDetails(detailsList, studentObj);
		studentObj.setId(); 
//		studentObj.storeDetail(studentObj, detailsList);
		detailsList.add(studentObj);
	}
	
	/**
	 * Returns StudentId.
	 * @return
	 */
	public String getStudentId() {
		
		return String.valueOf(studentId);
	}
	
	/**
	 * sets id
	 */
	public void setId() {
		
		studentId = studentId+1;
	}
	
}