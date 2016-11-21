package comp4007;

import comp4007.item.KioskItem;
import comp4007.item.RFIDItem;

public class Kiosk{

//	static int mInitPort = 20000;
	KioskItem mItem = new KioskItem();

	public Kiosk(KioskItem item){
		this.mItem = item;
		enable();
	}

	void enable(){
		mItem.setKioskItem(true);
	}

	void disable(){
		mItem.setKioskItem(false);
	}

	void portListener(String host, int port){
		//TODO   listen control room's commands		
	}

	void sendKeyRequest(int inputFloor){
		//TODO send the request to the message box of control room (queue)
	}
	void sendRFIDRequest(RFIDItem RFID){
		//TODO send the request to the message box of control room (queue)
	}
	
	
}
