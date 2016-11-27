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
        this.getContentPane().setLayout(new GridLayout(1, mFloor));

        kioskUI = new KioskUI(mFloor);
        this.getContentPane().add(kioskUI, BorderLayout.WEST);
    }

}
