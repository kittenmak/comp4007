package comp4007.simulator;

import comp4007.AES;
import comp4007.SharedConsts;
import comp4007.item.ElevatorItem;

import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Elevator{

	private Socket clientSocket;
	private DataInputStream in;
	private DataOutputStream out;

	Scanner scanner = new Scanner(System.in);
	ElevatorItem mItem = new ElevatorItem();

	private static int mElevator=0;
	private static int mFloor=0;


	public Elevator(ElevatorItem item) throws IOException, InterruptedException {
		readConfig();
		connectServer();
		process();

		this.mItem = item;
		enable();
	}

	void connectServer() throws IOException {
		clientSocket = new Socket(SharedConsts.ServerAddress, SharedConsts.ServerPort);
		System.out.printf("Elevator " + mItem.getEID() + " Connected to server using local port: %d.\n", clientSocket.getLocalPort());

		in = new DataInputStream(clientSocket.getInputStream());
		out = new DataOutputStream(clientSocket.getOutputStream());
	}

	public void send(byte[] data, int len) throws IOException {
		out.writeInt(len);
		out.write(data, 0, len);
		out.flush();
	}

	public byte[] receive() throws IOException {
		byte[] data = new byte[4];
		int size;
		int len;

		size = in.readInt();
		data = new byte[size];
		do {
			len = in.read(data, data.length - size, size);
			size -= len;
		} while (size > 0);

		return data;
	}

	public void disconnect() {
		System.out.println("disconnected.");
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException ex) {
		}
	}

	private void process() throws IOException, InterruptedException {
//        System.out.println("debug process");
		AES aes = new AES(SharedConsts.Key);
//		Gson gson = new Gson();
		String msg, encrypt_msg, decrypt_msg;


		msg = "Elevator " + mItem.getEID() + " connect"; //user + "," + password;
		encrypt_msg = aes.encrypt(msg);
		send(encrypt_msg.getBytes(), encrypt_msg.length());

		msg = new String(receive());
		decrypt_msg = aes.decrypt(msg);
//		fileList = gson.fromJson(decrypt_msg, new TypeToken<ArrayList<FileList>>(){}.getType());
//		for(int i=0; i<fileList.size(); i++) {
//			System.out.println(fileList.get(i).getFileName() + " " + fileList.get(i).getFileSize() + "bytes");
//		}
		while (true) {
			// get a new message from the console
			System.out.print("Client: ");
			msg = scanner.nextLine();
			encrypt_msg = aes.encrypt(msg);
			// send the message to the server
			send(encrypt_msg.getBytes(), encrypt_msg.length());

//			if (msg.startsWith("get")) {
//				try {
//					String fileName = msg.replaceFirst("get", "");
//					receiveFile(in, fileName);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			} else {
				// receive a message from the server
				msg = new String(receive());
				System.out.println("Server: " + aes.decrypt(msg));

				if (decrypt_msg.equals("QUIT")) {
					break;
				}
//			}
		}
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

//	public static void main(String args[]) throws IOException, InterruptedException {
//		readConfig();
//		for(int i = 0; i<mElevator; i++) {
//			ElevatorItem item = new ElevatorItem();
//			item.setEID(i);
//			Elevator elevator = new Elevator(item);
//		}
//	} // end of main

	private static void readConfig() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(SharedConsts.ConfigFilePath);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			mElevator = Integer.valueOf(prop.getProperty(SharedConsts.Elevator));
			mFloor = Integer.valueOf(prop.getProperty(SharedConsts.Floor));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}