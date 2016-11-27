package comp4007.simulator;

import comp4007.AES;
import comp4007.SharedConsts;
import comp4007.item.KioskItem;
import comp4007.item.RFIDItem;
import comp4007.ui.KioskUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Kiosk{

	private static Socket clientSocket;
	private static DataInputStream in;
	private static DataOutputStream out;

	static Scanner scanner = new Scanner(System.in);
//	static int mInitPort = 20000;
	private static KioskItem mItem = new KioskItem();
	private int mFloor;

	public Kiosk(int floor) throws IOException, InterruptedException {
		mFloor = floor;
	}

	public static void setKioskSignal(KioskItem item){
		mItem = item;
	}

	public static void connect(){
		try {
			connectServer();
			process();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}

//		enable();
	}

	static void connectServer() throws IOException {
		clientSocket = new Socket(SharedConsts.ServerAddress, SharedConsts.ServerPort);
		System.out.printf("Kiosk " + mItem.getKID() + " Connected to server using local port: %d.\n", clientSocket.getLocalPort());

		in = new DataInputStream(clientSocket.getInputStream());
		out = new DataOutputStream(clientSocket.getOutputStream());
	}

	public static void send(byte[] data, int len) throws IOException {
		out.writeInt(len);
		out.write(data, 0, len);
		out.flush();
	}

	public static byte[] receive() throws IOException {
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

	public static void disconnect() {
		System.out.println("sent");
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException ex) {
		}
	}

	private static void process() throws IOException, InterruptedException {
//        System.out.println("debug process");
		AES aes = new AES(SharedConsts.Key);
//		Gson gson = new Gson();
		String msg, encrypt_msg, decrypt_msg;


		msg = "Kiosk " + mItem.getKID() + " connect"; //user + "," + password;
		encrypt_msg = aes.encrypt(mItem.toString());
		send(encrypt_msg.getBytes(), encrypt_msg.length());

		msg = new String(receive());
		decrypt_msg = aes.decrypt(msg);
//		fileList = gson.fromJson(decrypt_msg, new TypeToken<ArrayList<FileList>>(){}.getType());
//		for(int i=0; i<fileList.size(); i++) {
//			System.out.println(fileList.get(i).getFileName() + " " + fileList.get(i).getFileSize() + "bytes");
//		}


//		while (true) {
//			// get a new message from the console
//			System.out.print("Client: ");
//			msg = scanner.nextLine();
//			encrypt_msg = aes.encrypt(msg);
//			// send the message to the server
//			send(encrypt_msg.getBytes(), encrypt_msg.length());
//
////			if (msg.startsWith("get")) {
////				try {
////					String fileName = msg.replaceFirst("get", "");
////					receiveFile(in, fileName);
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////			} else {
//			// receive a message from the server
//			msg = new String(receive());
//			System.out.println("Server: " + aes.decrypt(msg));
//
//			if (decrypt_msg.equals("QUIT"))
//				break;
////			}
//		}
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
