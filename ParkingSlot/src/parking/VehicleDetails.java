package parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehicleDetails {
	/**
	 * checks is this duplicate email
	 * @param detailsList
	 * @return
	 */
	public boolean isFoundEmail(ArrayList<RegistrationDetails> detailsList,String email) {
		for(int i = 0;i<detailsList.size();i++) {
			if(((RegistrationDetails) detailsList.get(i)).getEmail().equals(email)) {
				return true;
			}
	}
		return false;
	}
	
	/**
	 * checks is this duplicate Phone Number
	 * @param detailsList
	 * @return
	 */
	public boolean isFoundPhoneNo(ArrayList<RegistrationDetails> detailsList,String phoneNo) {
		for(int i = 0;i<detailsList.size();i++) {
			if(((RegistrationDetails) detailsList.get(i)).getPhoneNo().equals(phoneNo)) {
				return true;
			}
	}
		return false;
	}
	
	/**
	 * checks is this duplicate Registration Number
	 * @param detailsList
	 * @return
	 */
	public boolean isFoundRegistrationNo(ArrayList<RegistrationDetails> detailsList,String registrationNo) {
		for(int i = 0;i<detailsList.size();i++) {
			if(((RegistrationDetails) detailsList.get(i)).getRegistrationNo().equals(registrationNo)) {
				return true;
			}
	}
		return false;
	}
	
	// TS 09 AB 1234
	/**
	 * validates Registration Number
	 * @param registrationNo
	 * @return
	 */
	public boolean validRegistrationNo(String registrationNo) {
			String s = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$";
		    Pattern p = Pattern.compile(s);
		    Matcher m = p.matcher(registrationNo);
		    return m.matches();
	}
	
	/**
	 * Validates the input and makes sure that this field is not empty
	 * @throws IOException 
	 * 
	 */
	public String validate(String detail,BufferedReader br) throws IOException {
		boolean isEmpty = detail == null || detail.trim().length() == 0;
		if(!isEmpty)
			return detail;
		String mandatoryDetail="";
		while (isEmpty) {
		    System.out.println("This field is mandatory* : ");
		    mandatoryDetail = br.readLine();
		    isEmpty = mandatoryDetail == null || mandatoryDetail.trim().length() == 0;
		}
		return mandatoryDetail;
	}
	
	/**
	 * Validates Gender and makes sure to set correct gender.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 */
	public String genderValidation(String gender,BufferedReader br) throws InterruptedException, IOException {
		String genderInput="";
		boolean isEmptyGender = gender == null || gender.trim().length() == 0;
		boolean wrongGender = !gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("M");
		if(!isEmptyGender && !wrongGender)
			return gender;
		while (isEmptyGender || wrongGender) {
		    try {
		    	if (isEmptyGender){
		    		throw new ValidateException("Gender is Mandatory* : ");
					}
		    	else if (wrongGender){
		    		throw new ValidateException("Enter the correct gender : ");
					}
		    }
		    catch(ValidateException e){
		    	System.err.println(e.getMessage());
		    	Thread.sleep(100);
		    }
		    genderInput = br.readLine();
		    wrongGender = !genderInput.equalsIgnoreCase("f") && !genderInput.equalsIgnoreCase("M");
		    isEmptyGender = genderInput == null || genderInput.trim().length() == 0;
		}
		return genderInput;
	}
	
	/**
	 * Validates Date of Birth and makes to set correct Date of Birth
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public String dobValidation(String dob,BufferedReader br) throws InterruptedException, IOException {
		String dobInput = "";
		boolean isEmptyDob = dob == null || dob.trim().length() == 0;
		boolean wrongDate;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		try {
		sdf.parse(dob);
//		setdob(dob);
		wrongDate = false;
		} catch (Exception e) {
			wrongDate = true;
		}
		if(!isEmptyDob || !wrongDate)
			return dob;
		while (isEmptyDob || wrongDate) {
			try {
				if(isEmptyDob)
					throw new ValidateException("Date Of Birth is Mandatory* : ");
				else if(wrongDate)
					throw new ValidateException("Enter correct Date : ");
			}
			catch(ValidateException e) {
				System.err.println(e.getMessage());
				Thread.sleep(100);
			}
		    dobInput = br.readLine();
		    isEmptyDob = dobInput == null || dobInput.trim().length() == 0;
		    SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			sdf1.setLenient(false);
			try {
			sdf1.parse(dobInput);
//			setdob(dobInput);
			wrongDate = false;
			} catch (Exception e) {
				wrongDate = true;
			}
		}
		return dobInput;
	}
	
	/**
	 * Validates Email id and makes sure to enter correct email id.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public String emailValidation(ArrayList<RegistrationDetails> detailsList,String email,BufferedReader br) throws InterruptedException, IOException {
		boolean isEmptyEmail = email == null || email.trim().length() == 0;
		boolean isValidEmail = !(email.contains("@")) && email.trim().length()>0;
		boolean duplicateEmailFound= isFoundEmail(detailsList,email);
			while(isEmptyEmail || isValidEmail || duplicateEmailFound ) {
				try {
					if (isEmptyEmail) {
						throw new ValidateException("Email is Mandatory* :");
					}
					else if(isValidEmail)
						throw new ValidateException("Enter correct Email : ");
					if(duplicateEmailFound)
						throw new ValidateException("An Account is already present with "+email+"\n Enter unique email : ");
				}
				catch(ValidateException e) {
					System.err.println(e.getMessage());
					Thread.sleep(100);
				}
			    email = br.readLine();
			    isEmptyEmail = email == null || email.trim().length() == 0 ;
			    isValidEmail =  ! (email.contains("@")) && email.trim().length()>0;
			    duplicateEmailFound=isFoundEmail(detailsList,email);
		}
			return email;
	}
	
	/**
	 * Validates Phone Number and makes sure to enter correct Phone number
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public String phoneNumberValidation( ArrayList<RegistrationDetails> detailsList,String phoneNo, BufferedReader br) throws InterruptedException, IOException {
		boolean isEmptyPhoneNo = phoneNo == null || phoneNo.trim().length() == 0;
		boolean isValidPhoneNo = phoneNo.length()<10 || phoneNo.charAt(0) == '0';
		boolean duplicatePhoneNoFound = isFoundPhoneNo(detailsList,phoneNo);
		while (isEmptyPhoneNo || duplicatePhoneNoFound || isValidPhoneNo) {
			try {
				if(isEmptyPhoneNo)
				throw new ValidateException("Phone Number is Mandatory* :");
				else if(isValidPhoneNo)
					throw new ValidateException("Enter correct Phone Number : ");
				else if(duplicatePhoneNoFound)
					throw new ValidateException("An Account is already present with "+phoneNo+"\n Enter unique phoneNo :");
			}
			catch(ValidateException e) {
				System.err.println(e.getMessage());
				Thread.sleep(100);
			}
		    phoneNo = br.readLine(); 
		    isEmptyPhoneNo = phoneNo == null || phoneNo.trim().length() == 0 ;
		    isValidPhoneNo = phoneNo.length()<10 || phoneNo.charAt(0) == '0';
		    duplicatePhoneNoFound = isFoundPhoneNo(detailsList,phoneNo);
		}
		return phoneNo;
	}
	
	/**
	 * Validates Registration Number and makes sure to enter correct Registration number
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public String registrationNumberValidation(ArrayList<RegistrationDetails> detailsList,String registrationNo, BufferedReader br) throws InterruptedException, IOException{
		boolean isEmptyRegistrationNo = registrationNo == null || registrationNo.trim().length() == 0 ;
		boolean isValidRegistrationNo  = validRegistrationNo(registrationNo);
		boolean duplicateRegistrationNo = isFoundRegistrationNo(detailsList,registrationNo);
		while(isEmptyRegistrationNo  || ! isValidRegistrationNo || duplicateRegistrationNo) {
			try {
				if(isEmptyRegistrationNo)
					throw new ValidateException("Registration Number is mandatory* : ");
				else if(!isValidRegistrationNo)
					throw new ValidateException("Enter Correct Registration Number : ");
				else if(duplicateRegistrationNo)
					throw new ValidateException("An Account is already present with "+registrationNo+"\n Enter unique Registration No :");
			}
			catch(ValidateException e){
				System.err.println(e.getMessage());
				Thread.sleep(100);
			}
		    registrationNo = br.readLine();
		    isEmptyRegistrationNo = registrationNo == null || registrationNo.trim().length() == 0;
		    isValidRegistrationNo  = validRegistrationNo(registrationNo);
		    duplicateRegistrationNo = isFoundRegistrationNo(detailsList,registrationNo);
		}
		return registrationNo;
	}
	
	
	
	
	/**
	 * Prints the details of vehicles
	 * @param block
	 * @param detailsList
	 */
	public void viewDetails(int[] block, ArrayList<RegistrationDetails> detailsList) {
		System.out.println("Slots Available "+Arrays.toString(block));
		if(detailsList.size()<=0) {
			System.out.println("No Details Available !");
		}
		else {
			for(RegistrationDetails detail : detailsList) {
				System.out.println(detail.getSlotNo()+" "+detail.getFirstName()+" "+detail.getMiddleName()+" "+detail.getLastName()+" "+detail.getAddress()+" "+detail.getDob()+" "+detail.getEmail()+" "+detail.getGender()+" "+detail.getPhoneNo()+" "+detail.getRegistrationNo());
			}
		}
	}
}
