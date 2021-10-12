package parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Car inherits RegistrationDetails and storeBikeDetails() store them in detailsList 
 */
public class Car extends RegistrationDetails {

	/**
	 * Stores car details into list.
	 * @param detailsList
	 * @throws InterruptedException 
	 * @throws ValidateException 
	 * @throws IOException 
	 * @throws RuntimeException 
	 */
	public void registerDetails(ArrayList<RegistrationDetails> detailsList,RegistrationDetails carObj,BufferedReader br,int[] block,int slot) throws RuntimeException, IOException, ValidateException, InterruptedException {
		super.registerDetails(detailsList,carObj,br,block,slot);
		
		try {
			for(int i = 0;i<=5;i++) {
				if(block[i]>=2) {
					block[i] -= 2;
					slot = i+1;
					setSlotNo(slot);
					break;
				}
			}
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("No Slot Available !");
			Thread.sleep(100);
		}
		
		detailsList.add(carObj);
	}
	
}