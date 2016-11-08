import java.util.ArrayList;

public class ElevatorItem{
	
	int EID=0;
	String model ="";
	int currentFloor =0;
	double speed = 0;
	double maxWeight = 0;
	double currentWeight = 0;
	double idleTimer = 0;
	double doorTimer = 0;
	double ETA = 0;
	boolean doorStatus = false;
	int port = 0;
	String host = "";
	ArrayList<Integer> destination = new ArrayList<Integer>();
	boolean elevatorStatus = false;

	
	public ArrayList<Integer> getDestination() {
		return destination;
	}
	public void setDestination(ArrayList<Integer> destination) {
		this.destination = destination;
	}
	

	public boolean isElevatorStatus() {
		return elevatorStatus;
	}
	public void setElevatorStatus(boolean elevatorStatus) {
		this.elevatorStatus = elevatorStatus;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getEID() {
		return EID;
	}
	public void setEID(int eID) {
		EID = eID;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	public double getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}
	public double getIdleTimer() {
		return idleTimer;
	}
	public void setIdleTimer(double idleTimer) {
		this.idleTimer = idleTimer;
	}
	public double getDoorTimer() {
		return doorTimer;
	}
	public void setDoorTimer(double doorTimer) {
		this.doorTimer = doorTimer;
	}
	public double getETA() {
		return ETA;
	}
	public void setETA(double eTA) {
		ETA = eTA;
	}

	public boolean isDoorStatus() {
		return doorStatus;
	}
	public void setDoorStatus(boolean doorStatus) {
		this.doorStatus = doorStatus;
	}
	



	

}