import java.util.ArrayList;

public class AdminPanel {

	public AdminPanel() {
	}
	
	
	private void createRFID(RFIDItem item){	
	}

	private void modifyRFID(RFIDItem item){
		
	}
	
	private void deleteRFID(RFIDItem item){
		
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
