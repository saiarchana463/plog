package school;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Teacher class inherits SignupDeatils and storeHeadMaster() will store details into detailsList ArrayList
 */

class Teacher extends SignupDetails{
	private String subject,teacherId = "0";
	
	/**
	 * storedTeacher will take subject input from user which is mandatory and store them along with details received from singupDetails class.
	 * @param teacherObj
	 * @param detailsList
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws ParseException 
	 * @throws RuntimeException 
	 */
	public void storeDetails(ArrayList<Object> detailsList,SignupDetails teacherObj) throws IOException, RuntimeException, ParseException, InterruptedException 
	{
		super.storeDetails(detailsList, teacherObj);
		setTeacherId(teacherId);
		setSubject();
		detailsList.add(teacherObj);
		
	}
	
	/**
	 * Returns Subject
	 * @return
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * sets teacher id
	 */
	public void setTeacherId(String teacherId) {
		int id = Integer.parseInt(teacherId)+1;
		teacherId = String.valueOf(id);
	}
	
	/**
	 * Returns Teacher Id.
	 * @return
	 */
	public String getTeacherId() {
		return teacherId;
	}

	/**
	 * This method will take subject input
	 * @throws IOException
	 */
	public void setSubject() throws IOException {
		System.out.println("Subject* : ");
		subject = br.readLine();
		boolean isEmptySubject = subject == null || subject.trim().length() == 0;
		while (isEmptySubject) {
		    System.out.println("Subject is mandatory* : ");
		    subject = br.readLine();
		    isEmptySubject = subject == null || subject.trim().length() == 0;
		}
	}
	
	
	
	
}