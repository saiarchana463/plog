package school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserDetails {

	/**
	 * checks whether the email entered is duplicate or not.
	 * @param detailsList
	 * @return
	 */
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public boolean isFoundEmail(String email,ArrayList<Object> detailsList) {
		for(int i = 0;i<detailsList.size();i++) {
			if(((SignupDetails) detailsList.get(i)).getEmail().equals(email)) {
				return true;
			}
	}
		return false;
	}
	
	/**
	 * checks whether the Phone Number entered is duplicate or not.
	 * @param detailsList
	 * @return
	 */
	//isPhoneNoFound
	public boolean isFoundPhoneNo(String phoneNo,ArrayList<Object> detailsList) {
		for(int i = 0;i<detailsList.size();i++) {
			if(((SignupDetails) detailsList.get(i)).getPhoneNo().equals(phoneNo)) {
				return true;
			}
	}
		return false;
	}
	
	/**
	 * Validates the input and makes sure that this field is not empty
	 * @throws IOException 
	 * 
	 */
	public String validate(String detail) throws IOException {
		//recursion
		boolean isEmpty = detail == null || detail.trim().length() == 0;
		while (isEmpty) {
		    System.out.println("This field is mandatory* : ");
		    detail = br.readLine();
		    isEmpty = detail == null || detail.trim().length() == 0;
		}
		return detail;
	}
	
	/**
	 * Validates Gender and makes sure to set correct gender.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 */
	//validateGender - readAndValidateGender 
	public String genderValidation(String gender) throws InterruptedException, IOException {
		boolean isEmptyGender = gender == null || gender.trim().length() == 0;
		boolean wrongGender = !gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("M");
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
		    gender = br.readLine();
		    wrongGender = !gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("M");
		    isEmptyGender = gender == null || gender.trim().length() == 0;
		}
		return gender;
	}
	
	/**
	 * Validates Date of Birth and makes to set correct Date of Birth
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public String dobValidation(String dob) throws InterruptedException, IOException {
		boolean isEmptyDob = dob == null || dob.trim().length() == 0;
		boolean wrongDate;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		try {
		sdf.parse(dob);
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
		    dob = br.readLine();
		    isEmptyDob = dob == null || dob.trim().length() == 0;
		    SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			sdf1.setLenient(false);
			try {
			sdf1.parse(dob);
			wrongDate = false;
			} catch (Exception e) {
				wrongDate = true;
			}
		}
		return dob;
	}
	

	/**
	 * Validates Email id and makes sure to enter correct email id.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public String emailValidation(String email,ArrayList<Object> detailsList) throws InterruptedException, IOException {
		boolean isEmptyEmail = email == null || email.trim().length() == 0;
		boolean isValidEmail = !(email.contains("@")) && email.trim().length()>0;
		boolean duplicateEmailFound= isFoundEmail(email,detailsList);
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
			    email = br.readLine() ;
			    isEmptyEmail = email == null || email.trim().length() == 0 ;
			    isValidEmail =  ! (email.contains("@")) && email.trim().length()>0;
			    duplicateEmailFound=isFoundEmail(email,detailsList);
		}
			return email;
	}
	
	/**
	 * Validates Phone Number and makes sure to enter correct Phone number
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public String phoneNumberValidation(String phoneNo, ArrayList<Object> detailsList) throws InterruptedException, IOException {
		boolean isEmptyPhoneNo = phoneNo == null || phoneNo.trim().length() == 0;
		boolean isValidPhoneNo = phoneNo.length()<10 || phoneNo.charAt(0) == '0';
		boolean duplicatePhoneNoFound = isFoundPhoneNo(phoneNo ,detailsList);
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
		    duplicatePhoneNoFound = isFoundPhoneNo(phoneNo,detailsList);
		}
		return phoneNo;
	
	}
	
	
	
	
}
