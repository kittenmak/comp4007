package comp4007.panel;

import comp4007.SharedConsts;
import comp4007.item.RFIDItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class AdminPanel {

	public AdminPanel() {
	}

	//TODO to private (create adapter?)
	public void createRFID(RFIDItem item){
		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(SharedConsts.RFIDFilePath);
			//TODO
			// set the properties value
			prop.setProperty(SharedConsts.Id, String.valueOf(item.getId()));
			prop.setProperty(SharedConsts.SurName, item.getSurname());
			prop.setProperty(SharedConsts.FirstName, item.getFirstName());
			prop.setProperty(SharedConsts.Floor, String.valueOf(item.getFloor()));
			prop.setProperty(SharedConsts.ExpiryDate, item.getExpiryDate());



			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	private void modifyRFID(RFIDItem item){
		
	}
	
	public void deleteRFID(RFIDItem item){
		File file = new File(SharedConsts.RFIDFilePath);
		if(file.exists()){
			file.delete();
		}
	}
	
	private RFIDItem readRFID(RFIDItem item){
		return item;
	}
	
	private ArrayList<Integer> showFloors(RFIDItem item){
		return item.getFloor(); 
	}
	
	private void addFloor(RFIDItem item, int floor){
		item.addFloor(floor);
	}
	
	private void removeFloorFromAll(int floor){
	//disable the access right from all users for a certain floor
	}
	
	private void addFloorToAll(int floor){
	//grant access right to all users for a certain floor	
	}
	
	
}
