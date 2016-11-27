package comp4007.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by michaelleung on 27/11/2016.
 */
public class SimulatorUI extends JFrame {
    private KioskUI kioskUI;
    private int mFloor;

    public SimulatorUI(int floor){
        mFloor = floor;

        this.setTitle("SimulatorUI");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.WIDTH) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.HEIGHT) / 2);
//        this.getContentPane().setLayout(new GridLayout(mFloor, 4,0 ,0));

        kioskUI = new KioskUI(mFloor, 1); // 1 represent Client side
        this.getContentPane().add(kioskUI);
    }

//        public static void main(String args[]) {
//        // set frame properties
//            SimulatorUI f = new SimulatorUI(30);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//    } // end of main
}
