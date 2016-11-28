package comp4007.panel;

import comp4007.simulator.Kiosk;
import comp4007.SharedConsts;
import comp4007.simulator.Elevator;
import comp4007.item.ElevatorItem;
import comp4007.item.KioskItem;
import comp4007.ui.ControlUI;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class ControlPanel {

    ArrayList<Integer> mAliveKiosk = new ArrayList<Integer>();
    public static ArrayList<Integer> mAliveElevator = new ArrayList<Integer>();

    int mElevator = 0;
    int mFloor = 0;

    static int mInitKioskPort = 20000;
    static String mKioskHost = "127.0.0.1";
    static int mInitElevatorPort = 25000;
    static String mElevatorHost = "127.0.0.2";

    double idleTimer = 30;


    public ControlPanel() throws IOException, InterruptedException {
        readConfig();
        startUI();
        startServer();
//		startElevator();
//		startKiosk();
//		readConfigs();
    }

    private void readConfig() {
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

    private void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(SharedConsts.ServerPort);

        System.out.println("Listening to TCP port# " + serverSocket.getLocalPort());

        Socket clientSocket = null;
        int tmp=0;

        while (true) {


            clientSocket = serverSocket.accept();
            MyThread th = new MyThread(clientSocket);
            th.start();

            tmp++;
            th.setName("sender"+tmp);



            System.out.println(th.getName());
            System.out.println("Alive num: " +Thread.activeCount());




            System.out.println("try to get: " + MyThread.info);
            System.out.println("try to get2: " + MyThread.info2);



        }
    }

    private void startUI() {
        ControlUI f = new ControlUI(mElevator, mFloor);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

//	private void startElevator() throws IOException, InterruptedException {
//		for(int i = 0; i<mElevator; i++) {
//			ElevatorItem item = new ElevatorItem();
//			item.setEID(i);
//			Elevator elevator = new Elevator(item);
//		}
//	}
//
//	private void startKiosk() throws IOException, InterruptedException {
//		for(int i=0; i<mFloor; i++) {
//			KioskItem item = new KioskItem();
//			item.setKID(i);
//			Kiosk kiosk = new Kiosk(item);
//		}
//	}

    private void readConfigs() {
        readKioskConfig(mAliveKiosk);
        readElevatorConfig(mAliveElevator);
    }

    private void writeKioskConfig(int KID, int setupFloor, String model) {

    }

    private void writeElevatorConfig(int EID, double speed, double maxWeight, String model) {

    }

    private ArrayList<KioskItem> readKioskConfig(ArrayList<Integer> mAliveKiosk) {
        ArrayList<KioskItem> allKiosk = new ArrayList<KioskItem>();
        return allKiosk;
    }


    private ArrayList<ElevatorItem> readElevatorConfig(ArrayList<Integer> mAliveElevator) {
        ArrayList<ElevatorItem> allElevator = new ArrayList<ElevatorItem>();
        return allElevator;
    }

    public void onlineKiosk(int KID) {
        mAliveKiosk.add(KID);
    }

    public static void onlineElevator(int EID) {
        mAliveElevator.add(EID);
    }

    public int getNumOfAliveKiosk() {
        return mAliveKiosk.size();
    }

    public int getNumOfAliveElevator() {
        return mAliveElevator.size();
    }

    private void portListener(String host, int port) {

    }

    private void sendSignal(int EID, int destination) {
        connectElevator(mElevatorHost, EID);

    }

    public void sendAssignedElevator(int EID) {

    }

    public void sendDestination(int EID, int floor) {

    }

    private void connectElevator(String host, int EID) {
        int connectPort = mInitElevatorPort + EID;
    }

    private void connectKiosk(String host, int KID) {
        int connectPort = mInitKioskPort + KID;
    }

}
