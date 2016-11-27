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

    public ControlUI(int elevator, int floor) {

        this.setTitle("ControlUI");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.WIDTH) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.HEIGHT) / 2);
        this.getContentPane().setLayout(new BorderLayout(0, 0));

        kioskUI = new KioskUI(floor, 0); //0 represent Server side
        this.getContentPane().add(kioskUI, BorderLayout.WEST);

        elevatorUI = new ElevatorUI(elevator, floor);
        this.getContentPane().add(elevatorUI, BorderLayout.CENTER);
//		setLayout(new BorderLayout());


    }

//    public static void main(String args[]) {
//        // set frame properties
//        ControlUI f = new ControlUI();
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//    } // end of main
}
