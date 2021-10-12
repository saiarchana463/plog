package school;

public class SchoolFactory {
	public SignupDetails getFactory(String factoryType){
	      if(factoryType == null){
	         return null;
	      }		
	      if(factoryType.equalsIgnoreCase("1"))
	    	  return new Student();
	       else if(factoryType.equalsIgnoreCase("2"))
	         return new Teacher();
	       else if(factoryType.equalsIgnoreCase("3"))
	         return new HeadMaster();
	      
	      
	      return null;
	   }

}