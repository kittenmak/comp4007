package comp4007.ui;

import comp4007.SharedConsts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by michaelleung on 22/11/2016.
 */
public class KioskUI extends JPanel implements ActionListener{

    public JButton mbut[] = new JButton[8];  // 8 Buttons
    public boolean bp[] = new boolean[8]; // the state of each button, pressed or not


    public KioskUI(int floor)
    {
        this.setLayout(new GridLayout(4, floor, 0, 15));
        mbut = new JButton[8];
        for (int i = 8; i > 0; i--)
        {
            mbut[i - 1] = new JButton(SharedConsts.Kiosk + i);
            mbut[i - 1].setBackground(java.awt.Color.GREEN);
            mbut[i - 1].addActionListener(this);
            this.add(mbut[i - 1]);
            bp[i - 1] = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        int who = Integer.valueOf(e.getActionCommand().substring(5)) - 5; //eg. Kiosk1 --> 1
//        if (mbut[who].getBackground() == java.awt.Color.RED)
//        {
//            mbut[who].setBackground(java.awt.Color.GREEN);
//            bp[who] = true;
//        }
//        else
//        {
//            bp[who] = false;
//            mbut[who].setBackground(java.awt.Color.RED);
//        }
    }
}
