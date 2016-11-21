package comp4007.other;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

class ButtonPanel extends JPanel implements ActionListener
{
    public JButton mbut[] = new JButton[8];  // 8 Buttons
    public boolean bp[] = new boolean[8]; // the state of each button, pressed or not

    //constructor
    public ButtonPanel()
    {
        this.setLayout(new GridLayout(8, 1, 0, 0));
        mbut = new JButton[8];
        for (int i = 8; i > 0; i--)
        {
            mbut[i - 1] = new JButton("F" + i);
            mbut[i - 1].setBackground(java.awt.Color.GREEN);
            mbut[i - 1].addActionListener(this);
            this.add(mbut[i - 1]);
            bp[i - 1] = true;
        }
    }
    //event
    public void actionPerformed(ActionEvent e)
    {
        int who = Integer.valueOf(e.getActionCommand().substring(1)) - 1;
        if (mbut[who].getBackground() == java.awt.Color.RED)
        {
            mbut[who].setBackground(java.awt.Color.GREEN);
            bp[who] = true;
        }
        else
        {
            bp[who] = false;
            mbut[who].setBackground(java.awt.Color.RED);
        }


        //handle the button pressing events
    }
} //the end of ButtonPanel class