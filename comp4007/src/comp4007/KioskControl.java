package comp4007;

import comp4007.panel.MainPanel;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class KioskControl {

    private static int totalFloor;



    public static void main(String args[]) {
        Properties prop = new Properties();
        InputStream input = null;
        boolean waitingInput=true;

        try {

            input = new FileInputStream(SharedConsts.Path +SharedConsts.ConfigFileName);

            // load a properties file
            prop.load(input);
            totalFloor=Integer.parseInt(prop.getProperty(SharedConsts.Floor));
            // get the property value and print it out
            //System.out.println(prop.getProperty(SharedConsts.Floor));


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

        Scanner scanner = new Scanner(System.in);

        while (waitingInput==true) {
            System.out.println("");
            System.out.println("Please select the input method");
            System.out.println("0)Keypad Input");
            System.out.println("1)RFID");
            System.out.print("Please input the number: ");
            int action = Integer.parseInt(scanner.nextLine());
            System.out.println("");
            waitingInput=false;

            switch (action) {
                case 0: {
                    System.out.println("Please input the floor number(1-" + totalFloor+")");
                    System.out.print("Floor Number:");

                    int inputFloor = Integer.parseInt(scanner.nextLine());
                    if(inputFloor<1||inputFloor>totalFloor){
                        System.out.print("The range of floor number should be (1-"+ totalFloor+")");
                        System.out.println("");
                    }







                    waitingInput=true;
                    break;
                }
                case 1: {
                    System.out.println("Please place your RFID card on the card reader");
                    System.out.print("RFID:");
                    int inputRFID = Integer.parseInt(scanner.nextLine());
                    System.out.println("");
















                    waitingInput=true;
                    break;
                }

                default: {
                    System.out.print("Input error,try again \n");
                    break;
                }
            }
        }
    }








}
