package comp4007.ui;

import comp4007.SharedConsts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by michaelleung on 22/11/2016.
 */

// The elevator class draws the elevator area and simulates elevator movement
class ElevatorUI extends JPanel implements ActionListener
{
    public JButton[] mElevatorBtn;
    private int mFloor;
    private int mElevator;

    //Declaration of variables
    private ControlUI app; //the Elevator Simulation frame
    private boolean up; // the elevator is moving up or down
    private int ewidth;  // Elevator width
    private int eheight; // Elevator height
    private int pathx;
    private int pathy;
    private int moving;
    private boolean stop;
    private int stopint;
    private int N;
    private Timer tm; //the timer to drive the elevator movement
    //other variables to be used ...

    public ElevatorUI()
    {
        //necessary initialization
    }

    //constructor
    public ElevatorUI(ControlUI App, int elevator, int floor)
    {
        mFloor = floor;
        mElevator = elevator;

//        mControlPanel = new Panel();
        mElevatorBtn = new JButton[elevator];
//				("Elevator");
//        this.setLayout(new GridLayout(floor, 0,0 ,0));
        this.setLayout(new BorderLayout());
        Panel p = new Panel();
        p.setLayout(new GridLayout(5, 5,0 ,0));

        for (int i = 0; i < elevator; i++) {
            mElevatorBtn[i] = new JButton(SharedConsts.Elevator + String.valueOf(i + 1));
            mElevatorBtn[i].addActionListener(this);
            p.add(mElevatorBtn[i]);
        }
        this.add(p,BorderLayout.SOUTH);

        up = true;
        app = App;
        stop = false;
        stopint = 0;
        eheight = 15; //TODO
//                app.control.mbut[0].getHeight();
        moving = (mFloor-1) * eheight;
        //  this.setBounds(app.control.mbut[0].WIDTH,app.control.mbut[0].getLocation().y, app.WIDTH-app.control.mbut[0].WIDTH, eheight*8);

        ewidth = eheight * 3 / 4;
        pathx = (this.getWidth() - ewidth) / 2;
        pathy = this.getHeight() - eheight;
        tm = new Timer(10, this);        //+ lisnner by timer
        tm.start();

        //necessary initialization
    }

    // Paint elevator area
    public void paintComponent(Graphics g)
    {
        //  System.out.println(" Paint me!");
        //  System.out.printf("\nBuuton %d h=%d ",app.control.mbut[0].getWidth(),app.control.mbut[0].getHeight());
        super.paintComponent(g);
        eheight = 15; //TODO
                //app.control.mbut[0].getHeight();
        ewidth = eheight * 3 / 4;

        //TODO
        g.fillRect(0, 0, this.getWidth(), eheight * mFloor); //set height black rectangle

        g.setColor(Color.MAGENTA);
        for (int i = 0; i < mFloor; i++)
        {
            g.drawString(Integer.toString(i), 0, eheight* (mFloor-i));
        }

        g.setColor(Color.YELLOW);
        for (int i = 1; i < mFloor; i++)
        {
            g.drawLine(0, eheight * i, this.getWidth(), eheight * i); // draw line
        }

        pathx = (this.getWidth() - ewidth) / 2;

        //TODO pathx to x
        int x = 50;
        for(int i=0; i<mElevator; i++) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, moving, ewidth, eheight); //elevetor rectangle
            g.setColor(Color.BLACK);
            g.drawLine(x + ewidth / 2, moving, x + ewidth / 2, moving + eheight); //elevator line
            x = x + 50;
        }

        //obtain geometric values of components for drawing the elevator area
        //clear the painting canvas
        //start the Timer if not started elsewhere
        //draw horizontal lines and the elevator
    }

    //Handle the timer events
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < mElevatorBtn.length; i++) {
            if (e.getSource() == mElevatorBtn[i]) {
                System.out.println("onClick = " + mElevatorBtn[i].getLabel());
            }
        }

        if (!stop)
        { //runing
            int tempref = eheight / 10;
            if (up)
            {
                moving -= tempref;
                if (moving % eheight < tempref)
                {
                    N = 7 - moving / eheight;
                    if (N < 0 || N > 7) { N = 0; } // handler resize problem!
                    //TODO
//                    if (app.control.bp[N] == false)
//                    {
//                        stop = true;
//                    }
                }

                if (moving < 1)
                {
                    up = false;
//                    app.state.setText("Moving down!");
                }
            }
            else
            {

                moving += tempref;
                if (moving % eheight < tempref)
                {
                    N = 7 - moving / eheight;
                    if (N < 0 || N > 7) { N = 0; } // handler resize problem!
                    //TODO
//                    if (app.control.bp[N] == false)
//                    {
//                        stop = true;
//                    }
                }
                if (moving > eheight * (mFloor-1))
                {
                    up = true;
//                    app.state.setText("Moving up!");
                }
            }
            repaint();
        }
        else
        {//stop la
            if (stopint == 0)
            { //adjust location;
                moving = (7 - N) * eheight;
                repaint();
//                app.state.setText("Stop at " + (N + 1));
            }
            stopint += 2;
            if (stopint > mFloor)
            {
                stopint = 0;
                stop = false;
                //TODO
//                app.control.bp[N] = true;
//                app.control.mbut[N].setBackground(Color.GREEN);
//                app.state.setText("Let's Go!");
            }
        }

        //loop if the elevator needs to be stopped for a while
        //adjust Y coordinate to simulate elevetor movement
        //change moving direction when hits the top and bottom
        //repaint the panel
        //update the state of the elevator
    }

} //the end of Elevator class