import java.util.ArrayList;

public class ControlPanel{

		ArrayList<Integer> mAliveKiosk = new ArrayList<Integer>();
		ArrayList<Integer> mAliveElevator = new ArrayList<Integer>();
		static int mInitKioskPort = 20000;
		static String mKioskHost = "127.0.0.1";
		static int mInitElevatorPort = 25000;
		static String mElevatorHost = "127.0.0.2";

		double idleTimer = 30;
		

	public ControlPanel(){
		readKioskConfig();
		readElevatorConfig();
	}

	private void writeKioskConfig(int KID, int setupFloor, String model){

	}

	private void writeElevatorConfig(int EID, double speed, double maxWeight, String model){

	}

	private ArrayList<KioskItem> readKioskConfig(ArrayList<Integer> mAliveKiosk){
		return ArrayList<KioskItem>;
	}


	private ArrayList<ElevatorItem> readElevatorConfig(ArrayList<Integer> mAliveElevator){
		return ArrayList<ElevatorItem>;
	}

	public void onlineKiosk(int KID){
		mAliveKiosk.add(KID);
	}

	public void onlineElevator(int EID){
		mAliveElevator.add(EID);
	}

	public int getNumOfAliveKiosk(){
		reutrn mAliveKiosk.size();
	}
	public int getNumOfAliveElevator(){
		return mAliveElevator.size();
	}

	private void portListener(String host, int port){

	}

	private void sendSignal(int EID, int destination){
		connectElevator(mElevatorHost, EID)
		
	}

	public void sendAssignedElevator(int EID){

	}

	public void sendDestination(int EID, int floor){

	}

	private connectElevator(String host, int EID){
		int connectPort = mInitElevatorPort+EID;
	}

	private connectKiosk(String host, int KID){
		int connectPort = mInitKioskPort+KID;
	}



	
}
