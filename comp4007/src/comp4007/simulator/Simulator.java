package comp4007.simulator;

import comp4007.SharedConsts;
import comp4007.item.KioskItem;
import comp4007.simulator.Kiosk;
import comp4007.simulator.Elevator;
import comp4007.item.ElevatorItem;
import comp4007.ui.SimulatorUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by michaelleung on 26/11/2016.
 */
public class Simulator {

    private static int mElevator=0;
    private static int mFloor=0;
    private static List<Elevator> elevatorArrayList = new ArrayList<Elevator>();

    public static void main(String args[]) throws IOException, InterruptedException {
        readConfig();
        startUI();

        for(int i = 0; i<mElevator; i++) {
                //TODO
                final ElevatorItem item = new ElevatorItem();
                item.setEID(i);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            elevatorArrayList.add(new Elevator(item));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
        }

//        for(int i = 0; i<mElevator; i++) {
//            final int finalI = i;
//            new Thread(new Runnable() {
//                public void run() {
//                    ElevatorItem item = new ElevatorItem();
//                    item.setEID(finalI);
//                    try {
//                        elevators[finalI] = new Elevator(item);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//
//        for(int i = 0; i<mFloor; i++) {
//            final int finalI = i;
//            new Thread(new Runnable() {
//                public void run() {
//                    KioskItem item = new KioskItem();
//                    item.setKID(finalI);
//                    try {
//                        kiosks[finalI] = new Kiosk(item);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
    } // end of main

    private static void startUI(){
        SimulatorUI simulatorUI = new SimulatorUI(mFloor);
    }

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
