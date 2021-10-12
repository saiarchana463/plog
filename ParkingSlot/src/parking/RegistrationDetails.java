package parking;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * RegistrationDetails class is responsible for taking inputs and validating them
 */

public class RegistrationDetails extends VehicleDetails {

	private String firstName,middleName, lastName,dob,phoneNo,email,gender,address,registrationNo;
	private int slotNo;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Sets user input to First Name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns First Name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets user input to middle Name
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * Returns Middle Name
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * Sets user input to Last Name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns Last Name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets user input to gender
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Returns Gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets user input to Date of Birth
	 * @param dob
	 */
	public void setdob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * Returns DOB
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * Sets user input to email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Returns Email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets user input to Address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Returns Address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets user input to Phone Number
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	/**
	 * Returns Phone Number
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	
	/**
	 * Sets user input to Registration Number
	 * @param registrationNo
	 */
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	
	/**
	 * Returns Registration Number
	 */
	public String getRegistrationNo() {
		return registrationNo;
	}
	
	/**
	 * Sets user input to Slot Number
	 * @param slotNo
	 */
	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	/**
	 * Returns Slot Number
	 */
	public int getSlotNo() {
		return slotNo;
	}
	
	/**
	 * Takes inputs from user and sets to variable using setters.
	 */
	public void registerDetails(ArrayList<RegistrationDetails> detailsList,RegistrationDetails registrationDetailsObj,BufferedReader br,int[] block,int slot) throws RuntimeException,IOException, ValidateException, InterruptedException {
		
		
		System.out.println("Enter your Details : ");
		
		System.out.println("FirstName : ");
		setFirstName(validate (br.readLine(),br) );
					
		System.out.println("LastName : ");
		registrationDetailsObj.setLastName(validate (br.readLine(),br));
			
		System.out.println("MiddleName : ");
		registrationDetailsObj.setMiddleName(br.readLine());
		
		System.out.println("Gender(F/M) : ");
		registrationDetailsObj.setGender(genderValidation(br.readLine(),br));
			
		System.out.println("Date of Birth(MM/DD/YYYY) : ");
		registrationDetailsObj.setdob(dobValidation(br.readLine(),br));
		
		System.out.println("Email id : ");
		registrationDetailsObj.setEmail(emailValidation(detailsList,br.readLine(),br));
		
		System.out.println("Address : ");
		registrationDetailsObj.setAddress(validate(br.readLine(),br));
			
		System.out.println("Phone No : ");
		registrationDetailsObj.setPhoneNo(phoneNumberValidation(detailsList,br.readLine(),br));
		
		System.out.println("Registration No : ");
		registrationDetailsObj.setRegistrationNo(registrationNumberValidation(detailsList,br.readLine(),br));
	}

	
	

	
	
	
}