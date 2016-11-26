package comp4007.ui;

import comp4007.SharedConsts;
import comp4007.panel.ControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by michaelleung on 22/11/2016.
 */

// The elevator class draws the elevator area and simulates elevator movement
class ElevatorUI extends JPanel implements ActionListener
{
    public JButton[] mElevatorBtn;
    public boolean mBoolStop[];
    public JLabel mStateLabel; // display the state of the elevator

    private int mFloor;
    private int mElevator;

    //Declaration of variables
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
    public ElevatorUI(int elevator, int floor)
    {
        mFloor = floor;
        mElevator = elevator;

        mElevatorBtn = new JButton[elevator];
        mBoolStop = new boolean[elevator];

//				("Elevator");
//        this.setLayout(new GridLayout(floor, 0,0 ,0));
        this.setLayout(new BorderLayout());
        Panel p = new Panel();
        p.setLayout(new GridLayout(1, mElevator,0 ,0));

        for (int i = 0; i < elevator; i++) {
            mElevatorBtn[i] = new JButton(SharedConsts.Elevator + String.valueOf(i + 1));
            mElevatorBtn[i].setBackground(java.awt.Color.GREEN);
            mElevatorBtn[i].addActionListener(this);
            p.add(mElevatorBtn[i]);
            mBoolStop[i] = true;
        }
        this.add(p,BorderLayout.SOUTH);

        //state label
        mStateLabel = new JLabel();
        mStateLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mStateLabel.setText("Moving up");
        mStateLabel.setForeground(Color.white);
        this.add(mStateLabel, BorderLayout.EAST);
        this.setVisible(true);

        up = true;
        stop = false;
        stopint = 0;
        eheight = ( Toolkit.getDefaultToolkit().getScreenSize().height - 300 )/mFloor;
//                15; //TODO
//                controlUI.control.mbut[0].getHeight();
        moving = (mFloor-1) * eheight;
        //  this.setBounds(controlUI.control.mbut[0].WIDTH,controlUI.control.mbut[0].getLocation().y, controlUI.WIDTH-controlUI.control.mbut[0].WIDTH, eheight*8);

        ewidth = eheight * 3 / 4;
        pathx = (this.getWidth() - ewidth) / 2;
        pathy = this.getHeight() - eheight;
        tm = new Timer(40, this);        //+ lisnner by timer
        tm.start();

        //necessary initialization
    }

    // Paint elevator area
    public void paintComponent(Graphics g)
    {
        //  System.out.println(" Paint me!");
        //  System.out.printf("\nBuuton %d h=%d ",controlUI.control.mbut[0].getWidth(),controlUI.control.mbut[0].getHeight());
        super.paintComponent(g);
        eheight = ( Toolkit.getDefaultToolkit().getScreenSize().height - 300 )/mFloor;
//                15; //TODO
                //controlUI.control.mbut[0].getHeight();
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
        int x = 10;
        for(int i=0; i<mElevator; i++) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, moving, ewidth, eheight); //elevetor rectangle
            g.setColor(Color.BLACK);
            g.drawLine(x + ewidth / 2, moving, x + ewidth / 2, moving + eheight); //elevator line
            x = x + 70;
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
                ControlPanel.onlineElevator(i);
                if (mElevatorBtn[i].getBackground() == java.awt.Color.RED)
                {
                    mElevatorBtn[i].setBackground(java.awt.Color.GREEN);
                    mBoolStop[i] = true;
                }
                else
                {
                    mBoolStop[i] = false;
                    mElevatorBtn[i].setBackground(java.awt.Color.RED);
                }
                System.out.println("onClick = " + mElevatorBtn[i].getLabel());
            }
        }

//        for(int i=0; i<ControlPanel.mAliveElevator.size() ; i++){
//            if(ControlPanel.mAliveElevator.get(i) != 0){
//                //TODO if condition have error
//            }
//        }

        if (!stop){ //runing
            int tempref = eheight / 10;
            if (up)
            {
                moving -= tempref;
                if (moving % eheight < tempref)
                {
                    N = 5 - moving / eheight;
                    if (N < 0 || N > 5) { N = 0; } // handler resize problem!
                    //TODO
                    if (mBoolStop[N] == false) //controlUI.control.bp
                    {
                        stop = true;
                    }
                }

                if (moving < 1)
                {
                    up = false;
                    mStateLabel.setText("Moving down!");
                }
            }
            else
            {

                moving += tempref;
                if (moving % eheight < tempref)
                {
                    N = 5 - moving / eheight;
                    if (N < 0 || N > 5) { N = 0; } // handler resize problem!
                    //TODO
                    if (mBoolStop[N] == false) //controlUI.control.bp[N]
                    {
                        stop = true;
                    }
                }
                if (moving > eheight * (mFloor-1))
                {
                    up = true;
                    mStateLabel.setText("Moving up!");
                }
            }
            repaint();
        }
        else
        {//stop la
            if (stopint == 0)
            { //adjust location;
                moving = (5 - N) * eheight;
                repaint();
                mStateLabel.setText("Stop at " + (N + 1));
            }
            stopint += 2;
            if (stopint > mFloor)
            {
                stopint = 0;
                stop = false;
                //TODO
                mBoolStop[N] = true;
                mElevatorBtn[N].setBackground(Color.GREEN);
                mStateLabel.setText("Let's Go!");
            }
        }
    }

} //the end of Elevator class