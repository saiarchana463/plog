package school;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * SignupDetails class takes all user inputs and validates them.
 * @author savant
 */

 class SignupDetails  extends UserDetails {

	private String firstName, lastName,middleName,gender,dob,email,address,phoneNo,id;
	 
	protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Sets the firstName taken from user to firstName variable;
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns First Name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the lastName taken from user to lastName variable;
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns LastName
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the middleName taken from user to middleName variable;
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * Returns Middle Name
	 * @return
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * Sets the gender taken from user to gender variable;
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Returns Gender
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the Date of Birth taken from user to dob variable;
	 * @param dob
	 */
	public void setdob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * Returns Date Of Birth
	 * @return
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * Sets the email taken from user to email variable;
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns Email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the Address taken from user to address variable;
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Returns Address
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the Phone Number taken from user to phoneNo variable;
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Returns Phone Number
	 * @return
	 */
	public String getId() {
		
		return id;
	}
	
	/**
	 * Sets the Phone Number taken from user to phoneNo variable;
	 * @param phoneNo
	 */
	public void setid(String id) {
		this.id = id;
	}

	/**
	 * Returns Phone Number
	 * @return
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	
//	void storeDetail(SignupDetails signupDetailsObj, ArrayList<Object> detailsList) throws IOException {}

	public void setId() {	}
	
	/**
	 *  This method will take inputs(firstName, lastName, middleName, gender, dob,email, address, phoneNo ) from user and calls set methods.
	 */
	public void storeDetails(ArrayList<Object> detailsList,SignupDetails signupDetailObj) throws RuntimeException, IOException, ParseException, InterruptedException
	{
		
		
		System.out.println("Enter your Details : ");
		
		System.out.println("FirstName : ");
		signupDetailObj.setFirstName(validate(br.readLine()));
					
		System.out.println("LastName : ");
		signupDetailObj.setLastName(validate(br.readLine()));
			
		System.out.println("MiddleName : ");
		signupDetailObj.setMiddleName(br.readLine());
		
		System.out.println("Gender(F/M) : ");
		signupDetailObj.setGender(genderValidation(br.readLine()));
			
		System.out.println("Date of Birth(MM/DD/YYYY) : ");
		signupDetailObj.setdob(dobValidation(br.readLine()));
		
		System.out.println("Email id : ");
		signupDetailObj.setEmail(emailValidation(br.readLine(),detailsList));
		
		System.out.println("Address : ");
		signupDetailObj.setAddress(validate(br.readLine()));
			
		System.out.println("Phone No : ");
		signupDetailObj.setPhoneNo(phoneNumberValidation(br.readLine(),detailsList));
		
	}
	
	
	
}