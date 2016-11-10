import java.util.ArrayList;

public class RFIDItem {
	int id;
	String expiryDate;
	String firstName;
	String surname;
	ArrayList<Integer> floor = new ArrayList<Integer>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public ArrayList<Integer> getFloor() {
		return floor;
	}
	public void setFloor(ArrayList<Integer> floor) {
		this.floor = floor;
	}

	public void addFloor(int floor){
		this.floor.add(floor);
	}
	
	
}
