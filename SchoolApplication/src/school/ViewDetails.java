package school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewDetails class is used to display details based on user search text
 */
class ViewDetails{
	private List<Object> resultList = new ArrayList<Object>();
	
	/**
	 * This method search for given search element ,if it finds single record then it displays , if it finds multiple records then it calls displayFilter() , 
	 * 	if no match found it displays "No results Found"
	 * @param searchElement
	 * @param detailsList
	 * @throws IOException
	 */
	public void display(String searchElement,ArrayList<Object> detailsList) throws IOException {
		for(Object i : detailsList) {
			if(i instanceof Student) {
				if(((Student) i).getFirstName().equals(searchElement) || ((Student) i).getMiddleName().equals(searchElement) || ((Student) i).getLastName().equals(searchElement) ||((Student) i).getEmail().equals(searchElement) ||((Student) i).getPhoneNo().equals(searchElement) ||((Student) i).getDob().equals(searchElement)||((Student) i).getGender().equals(searchElement)){
					resultList.add(i);
				}
			}
			else if(i instanceof Teacher) {
				if(((Teacher) i).getFirstName().equals(searchElement) || ((Teacher) i).getMiddleName().equals(searchElement) || ((Teacher) i).getLastName().equals(searchElement) ||((Teacher) i).getEmail().equals(searchElement) ||((Teacher) i).getPhoneNo().equals(searchElement) ||((Teacher) i).getDob().equals(searchElement) || ((Teacher) i).getSubject().equals(searchElement)){
					resultList.add(i);
				}
			}
			else if(i instanceof HeadMaster) {
				if(((HeadMaster) i).getFirstName().equals(searchElement) || ((HeadMaster) i).getMiddleName().equals(searchElement) || ((HeadMaster) i).getLastName().equals(searchElement) ||((HeadMaster) i).getEmail().equals(searchElement) ||((HeadMaster) i).getPhoneNo().equals(searchElement) ||((HeadMaster) i).getSubject().equals(searchElement) || ((HeadMaster) i).getDob().equals(searchElement) ){
					resultList.add(i);
				}
			}
		}
		
		// resultList = detailsList.stream().filter(c -> c.stream().anyMatch(a->a.equals(searchElement))).collect(Collectors.toList());
		 if( resultList.size()== 0) {
			 System.out.println("No results Found...");
		 }
		 else if(resultList.size()==1)
		 {
			 printDetails(resultList.get(0));
		 }
		 else if(resultList.size()>1) {
			 displayFilter(); 
		 }
			 
}
	/**
	 * This method will print the details.
	 * @param i
	 */
	public void printDetails(Object i) {
		if(i instanceof Student) {
			 System.out.println(((Student) i).getStudentId()+" "+((Student) i).getFirstName()+" "+ ((Student) i).getMiddleName() +" "+((Student) i).getLastName() +" "+((Student) i).getGender()+" "+((Student) i).getDob()+"  "+((Student) i).getEmail()+" "+((Student) i).getAddress()+" "+((Student)i).getPhoneNo()+" "+((Student)i).getDob());
		 }
		 else if(i instanceof Teacher) {
			 System.out.println(((Teacher) i).getTeacherId()+" "+((Teacher) i).getFirstName()+" "+ ((Teacher) i).getMiddleName() +" "+((Teacher) i).getLastName() +" "+((Teacher) i).getGender()+" "+((Teacher) i).getDob()+" "+((Teacher) i).getEmail()+" "+((Teacher) i).getAddress()+" "+((Teacher) i).getPhoneNo()+" "+((Teacher)i).getSubject()+" "+((Teacher)i).getDob());
		 }
		 else if(i instanceof HeadMaster) {
			 System.out.println(((HeadMaster) i).getHeadMasterId()+" "+((HeadMaster) i).getFirstName()+" "+ ((HeadMaster)i).getMiddleName() +" "+((HeadMaster) i).getLastName() +" "+((HeadMaster) i).getGender()+" "+((HeadMaster) i).getDob()+" "+((HeadMaster) i).getEmail()+" "+((HeadMaster) i).getAddress()+" "+((HeadMaster) i).getPhoneNo()+" "+((HeadMaster) i).getSubject());
		 }
	}
	
	/**
	 * This method will filters the list until it finds only a single record ,if no record is found it displays "No data is present"
	 * @return
	 * @throws IOException
	 * 	
	 */
	public void displayFilter() throws IOException{
		String searchElement ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = resultList.size(),index = -1;
		while(count>1) {
			System.out.println("Extend your search : ");
			searchElement = br.readLine();
			count = 0;
			for(int i = 0;i<resultList.size();i++) {
				if(resultList.get(i) instanceof Student) {
					if(((Student) resultList.get(i)).getFirstName().equals(searchElement) || ((Student) resultList.get(i)).getMiddleName().equals(searchElement) || ((Student) resultList.get(i)).getLastName().equals(searchElement) ||((Student) resultList.get(i)).getEmail().equals(searchElement) ||((Student) resultList.get(i)).getPhoneNo().equals(searchElement) ||((Student) resultList.get(i)).getGender().equals(searchElement) ||((Student) resultList.get(i)).getDob().equals(searchElement)){
						count += 1;
						index = i;
					}
				}
				else if(resultList.get(i) instanceof Teacher) {
					if(((Teacher) resultList.get(i)).getFirstName().equals(searchElement) || ((Teacher) resultList.get(i)).getMiddleName().equals(searchElement) || ((Teacher) resultList.get(i)).getLastName().equals(searchElement) ||((Teacher) resultList.get(i)).getEmail().equals(searchElement) ||((Teacher) resultList.get(i)).getPhoneNo().equals(searchElement) ||((Teacher) resultList.get(i)).getGender().equals(searchElement) ||((Teacher) resultList.get(i)).getDob().equals(searchElement) || ((Teacher) resultList.get(i)).getSubject().equals(searchElement)){
						count += 1;
						index = i;
					}
				}
				else if(resultList.get(i) instanceof HeadMaster) {
					if(((HeadMaster) resultList.get(i)).getFirstName().equals(searchElement) || ((HeadMaster) resultList.get(i)).getMiddleName().equals(searchElement) || ((HeadMaster) resultList.get(i)).getLastName().equals(searchElement) ||((HeadMaster) resultList.get(i)).getEmail().equals(searchElement) ||((HeadMaster) resultList.get(i)).getPhoneNo().equals(searchElement) ||((HeadMaster) resultList.get(i)).getGender().equals(searchElement) ||((HeadMaster) resultList.get(i)).getSubject().equals(searchElement) || ((HeadMaster) resultList.get(i)).getDob().equals(searchElement)){
						count += 1;
						index = i;
					}
				}
			}
			
		}
		if(count==1)
			printDetails(resultList.get(index));
		else if(count==0)
			System.out.println("Given Data is not present");
	}
}