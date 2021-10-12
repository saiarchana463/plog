package parking;


public class ParkingFactory {

	public RegistrationDetails getInstance(String entryOrExit, int[] block) {
		if(entryOrExit == null){
	         return null;
	      }		
		System.out.println("option:"+entryOrExit);
	      if(entryOrExit.equalsIgnoreCase("1"))
	    	  return new Bike();
	       else if(entryOrExit.equalsIgnoreCase("2"))
	         return new Car();
	       else if(entryOrExit.equalsIgnoreCase("3"))
	         return new Bus();
		return null;
	}

}
