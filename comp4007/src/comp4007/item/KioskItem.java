package comp4007.item;

public class KioskItem {
	int KID;
	String host;
	int port;
	boolean KioskItem;
	public int getKID() {
		return KID;
	}
	public void setKID(int kID) {
		KID = kID;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public boolean isKioskItem() {
		return KioskItem;
	}
	public void setKioskItem(boolean kioskItem) {
		KioskItem = kioskItem;
	}
	
	
	
}
