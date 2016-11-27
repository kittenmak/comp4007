package comp4007.ui;

import comp4007.item.KioskItem;
import comp4007.simulator.Kiosk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by michaelleung on 27/11/2016.
 */
public class FloorUI extends JFrame implements ActionListener {

    private JButton keys[];
    private Panel keypad;
    private TextField lcd;
    private KioskItem mItem;
    private int mFloor;

    public FloorUI(KioskItem item, int floor) {

//        this.setTitle("FloorUI");
        this.setSize(200, 200);

        mItem = item;
        mFloor = floor;
        // construct components and initialize beginning values
        lcd = new TextField(20);
        lcd.setEditable(false);

        keys = new JButton[12];
        // construct and assign captions to the Buttons
        for (int i = 0; i <= 9; i++) {
            keys[i] = new JButton(String.valueOf(i));
        }
        keys[10] = new JButton("Enter");
        keys[11] = new JButton("Clear");

        keypad = new Panel();
        keypad.setLayout(new GridLayout(4, 4));

        add(lcd, BorderLayout.NORTH);
        add(keypad, BorderLayout.CENTER);

        //Layout for the keypad
        for (int i = 7; i <= 9; i++) //1st row: 7, 8, 9
            keypad.add(keys[i]);

        for (int i = 4; i <= 6; i++) //2nd row: 4, 5, 6
            keypad.add(keys[i]);

        for (int i = 1; i <= 3; i++) //3rd row: 1, 2, 3
            keypad.add(keys[i]);

        keypad.add(keys[11]); // Clear key
        keypad.add(keys[0]); //4th row: 0 key
        keypad.add(keys[10]); // Enter key

        //register the button click events
        for (int i = 0; i < keys.length; i++)
            keys[i].addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // test for button clicks
        // search for the clicked key
        for (int i = 0; i < keys.length; i++) {
            if (e.getSource() == keys[i]) {
                switch (i) {
                    // number and decimal point buttons
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        lcd.setText(lcd.getText() + keys[i].getLabel());
                        break;
                    case 10:
                        int value = Integer.valueOf(lcd.getText());
                        if (value <= mFloor) {
                            System.out.println(lcd.getText());
                            mItem.setFloor(value);

                            try {
                                Kiosk kiosk = new Kiosk(mFloor);
                                kiosk.setKioskSignal(mItem);
                                kiosk.connect();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }

//                            Kiosk.connect();
                        } else {
                            System.out.println("Input error!");
                        }
                        break;
                    case 11:
                        lcd.setText("");
                        break;
                } // end of switch(i)
                i = keys.length;
            } // end of if
        } // end of for
    }

//    public static void main(String args[])
//    {
//        // set frame properties
//        FloorUI f = new FloorUI();
//        f.setBounds(200,200,300,300);
////        f.setSize(200, 200);
//        f.setVisible(true);
//    } // end of main
}
