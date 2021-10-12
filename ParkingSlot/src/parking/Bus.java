package parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Bus inherits RegistrationDetails and storeBikeDetails() store them in detailsList 
 */
public class Bus extends RegistrationDetails {
	
	/**
	 * stores Bus Details into list.
	 * @param detailsList
	 * @throws InterruptedException 
	 * @throws ValidateException 
	 * @throws IOException 
	 * @throws RuntimeException 
	 */
	public void registerDetails(ArrayList<RegistrationDetails> detailsList,RegistrationDetails busObj,BufferedReader br,int[] block,int slot) throws RuntimeException, IOException, ValidateException, InterruptedException {
		super.registerDetails(detailsList,busObj,br,block,slot);
		
		try {
			for(int i = 0;i<=5;i++) {
				if(block[i]>=4) {
					block[i] -= 4;
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
		
		detailsList.add(busObj);
	}

}