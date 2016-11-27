package comp4007.other;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
// The elevator class draws the elevator area and simulates elevator movement
class Elevator extends JPanel implements ActionListener
{
    //Declaration of variables
    private Elevator_Simulation app; //the Elevator Simulation frame
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
    public Elevator()
    {
        //necessary initialization
    }
    //constructor
    public Elevator(Elevator_Simulation App)
    {
        up = true;
        app = App;
        stop = false;
        stopint = 0;
        eheight = app.control.mbut[0].getHeight();
        moving = 7 * eheight;
        //  this.setBounds(app.control.mbut[0].WIDTH,app.control.mbut[0].getLocation().y, app.WIDTH-app.control.mbut[0].WIDTH, eheight*8);

        ewidth = eheight * 3 / 4;
        pathx = (this.getWidth() - ewidth) / 2;
        pathy = this.getHeight() - eheight;
        tm = new Timer(50, this);        //+ lisnner by timer
        tm.start();

        //necessary initialization
    }

    // Paint elevator area
    public void paintComponent(Graphics g)
    {
        //  System.out.println(" Paint me!");
        //  System.out.printf("\nBuuton %d h=%d ",app.control.mbut[0].getWidth(),app.control.mbut[0].getHeight());
        super.paintComponent(g);
        eheight = app.control.mbut[0].getHeight();
        ewidth = eheight * 3 / 4;
        g.fillRect(0, 0, this.getWidth(), eheight * 8);
        g.setColor(Color.YELLOW);
        for (int i = 1; i < 8; i++)
        {
            g.drawLine(0, eheight * i, this.getWidth(), eheight * i);
        }
        pathx = (this.getWidth() - ewidth) / 2;
        g.fillRect(pathx, moving, ewidth, eheight);
        g.setColor(Color.black);
        g.drawLine(pathx + ewidth / 2, moving, pathx + ewidth / 2, moving + eheight);
        //obtain geometric values of components for drawing the elevator area
        //clear the painting canvas
        //start the Timer if not started elsewhere
        //draw horizontal lines and the elevator
    }

    //Handle the timer events
    public void actionPerformed(ActionEvent e)
    {
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
                    if (app.control.bp[N] == false)
                    {
                        stop = true;
                    }
                }

                if (moving < 1)
                {
                    up = false;
                    app.state.setText("Moving down!");
                }
            }
            else
            {

                moving += tempref;
                if (moving % eheight < tempref)
                {
                    N = 7 - moving / eheight;
                    if (N < 0 || N > 7) { N = 0; } // handler resize problem!
                    if (app.control.bp[N] == false)
                    {
                        stop = true;
                    }
                }
                if (moving > eheight * 7)
                {
                    up = true;
                    app.state.setText("Moving up!");
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
                app.state.setText("Stop at " + (N + 1));
            }
            stopint += 2;
            if (stopint > 30)
            {
                stopint = 0;
                stop = false;
                app.control.bp[N] = true;
                app.control.mbut[N].setBackground(Color.GREEN);
                app.state.setText("Let's Go!");
            }
        }

        //loop if the elevator needs to be stopped for a while
        //adjust Y coordinate to simulate elevetor movement
        //change moving direction when hits the top and bottom
        //repaint the panel
        //update the state of the elevator
    }

} //the end of Elevator class