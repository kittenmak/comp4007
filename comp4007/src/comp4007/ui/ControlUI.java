package comp4007.ui;

import comp4007.SharedConsts;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ControlUI extends JFrame {

    private KioskUI kioskUI;
    private ElevatorUI elevatorUI;

    int mElevator = 0;
    int mFloor = 0;

    public ControlUI() {
        readConfig();

        this.setTitle("ControlUI");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.WIDTH) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.HEIGHT) / 2);
        this.getContentPane().setLayout(new BorderLayout(0, 0));

        kioskUI = new KioskUI(mFloor);
        this.getContentPane().add(kioskUI, BorderLayout.WEST);

        elevatorUI = new ElevatorUI(this, mElevator, mFloor);
        this.getContentPane().add(elevatorUI, BorderLayout.CENTER);
//		setLayout(new BorderLayout());


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

    public static void main(String args[]) {
        // set frame properties
        ControlUI f = new ControlUI();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    } // end of main
}
