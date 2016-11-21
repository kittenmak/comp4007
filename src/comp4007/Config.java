package comp4007;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Config {
    int mElevator = 6;
    int mFloor = 30;

    public Config(){
        setConfig();
        createFile();
    }

    public void setConfig(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("0) set Elevator ");
        System.out.println("1) set Floor ");
        System.out.print("please input the number: ");
        int action = Integer.parseInt(scanner.nextLine());

        switch(action){
            case 0:{
                //TODO
                break;
            }
            case 1:{
                //TODO
                break;
            }
            default:
            {
                System.out.print("Input error,try again \n");
                break;
            }
        }
    }

    public void createFile(){
        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream(SharedConsts.ConfigFilePath);

            // set the properties value
            prop.setProperty(SharedConsts.Elevator, String.valueOf(mElevator));
            prop.setProperty(SharedConsts.Floor, String.valueOf(mFloor));

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String args[])
    {
        Config config = new Config();
    }

}
