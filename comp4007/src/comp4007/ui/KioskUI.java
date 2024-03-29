package comp4007.ui;

import comp4007.SharedConsts;
import comp4007.item.KioskItem;
import comp4007.simulator.Kiosk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by michaelleung on 22/11/2016.
 */
public class KioskUI extends JPanel implements ActionListener{

    public JButton mbut[];
    public Boolean boolList[];
    public int mFloor;
    public int mKioskCount;
    public int mOption;

    public KioskUI(int floor, int option)
    {
        mFloor = floor;
        mKioskCount = mFloor; //* 4;
        mOption = option;

        mbut = new JButton[mKioskCount];
//        bp[] = new boolean[8];
        boolList = new Boolean[mKioskCount];
        if(mOption == 0) { //server side ui
            this.setLayout(new GridLayout(floor, 4, 0, 0));
        }
        else if(mOption == 1){ //client side ui
            this.setLayout(new GridLayout(floor / 4, 4, 0, 0));
        }
//        mbut = new JButton[8];
        for (int i = mKioskCount; i > 0; i--)
        {
            mbut[i - 1] = new JButton(SharedConsts.Kiosk + i);
            mbut[i - 1].setBackground(java.awt.Color.GREEN);
            mbut[i - 1].addActionListener(this);
            this.add(mbut[i - 1]);
            boolList[i - 1] = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < mbut.length; i++) {
            if (e.getSource() == mbut[i]) {
//                if (mbut[i].getBackground() == java.awt.Color.RED)
//                {
//                    mElevatorBtn[i].setBackground(java.awt.Color.GREEN);
//                    mBoolStop[i] = true;
//                }
//                else
//                {
//                    mBoolStop[i] = false;
//                    mElevatorBtn[i].setBackground(java.awt.Color.RED);
//                }
                System.out.println("onClick = " + mbut[i].getLabel());
                if(mOption == 1){
                    KioskItem item = new KioskItem();
                    item.setKID(i);
                    FloorUI floorUI = new FloorUI(item, mFloor);
                    floorUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    floorUI.setVisible(true);
                }
            }
        }
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
