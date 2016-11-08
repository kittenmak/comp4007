
public class Elevator{

	
	ElevatorItem mItem = new ElevatorItem();
	
	public Elevator(ElevatorItem item){
		this.mItem = item;
		enable();
	}

	void enable(){
		mItem.setElevatorStatus(true);
	}

	void disable(){
		mItem.setElevatorStatus(false);
	}
	
	void portListener(){
		//listen to control room's commands
	}
	
	void sendSignal(ElevatorItem item){
		//send singal to control room
		item.getCurrentWeight();
		item.getCurrentFloor();
		item.isDoorStatus();
		item.isElevatorStatus();
		
	}
	void floorIncrement(){
		int currentFloor = mItem.getCurrentFloor();
		mItem.setCurrentFloor(currentFloor++);
	}
	void floorDecrement(){
		int currentFloor = mItem.getCurrentFloor();
		mItem.setCurrentFloor(currentFloor--);
	}
	void doorClose(){
		mItem.setDoorStatus(true);
	}
	void doorOpen(){
		mItem.setDoorStatus(false);
	}

}