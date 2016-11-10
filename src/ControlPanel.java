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
		readConfigs();
	}
	
	private void readConfigs(){
		readKioskConfig(mAliveKiosk);
		readElevatorConfig(mAliveElevator);
	}

	private void writeKioskConfig(int KID, int setupFloor, String model){

	}

	private void writeElevatorConfig(int EID, double speed, double maxWeight, String model){

	}

	private ArrayList<KioskItem> readKioskConfig(ArrayList<Integer> mAliveKiosk){
		ArrayList<KioskItem> allKiosk = new ArrayList<KioskItem>();
		return allKiosk;
	}


	private ArrayList<ElevatorItem> readElevatorConfig(ArrayList<Integer> mAliveElevator){
		ArrayList<ElevatorItem> allElevator = new ArrayList<ElevatorItem>();
		return allElevator;
	}

	public void onlineKiosk(int KID){
		mAliveKiosk.add(KID);
	}

	public void onlineElevator(int EID){
		mAliveElevator.add(EID);
	}

	public int getNumOfAliveKiosk(){
		return mAliveKiosk.size();
	}
	public int getNumOfAliveElevator(){
		return mAliveElevator.size();
	}

	private void portListener(String host, int port){

	}

	private void sendSignal(int EID, int destination){
		connectElevator(mElevatorHost, EID);
		
	}

	public void sendAssignedElevator(int EID){

	}

	public void sendDestination(int EID, int floor){

	}

	private void connectElevator(String host, int EID){
		int connectPort = mInitElevatorPort+EID;
	}

	private void connectKiosk(String host, int KID){
		int connectPort = mInitKioskPort+KID;
	}



	
}
