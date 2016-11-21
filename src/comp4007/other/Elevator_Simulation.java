package comp4007.other;

import javax.swing.*;
import java.awt.*;

//The main class
public class Elevator_Simulation extends JFrame
{
    public JLabel state; // display the state of the elevator
    private JLabel id;  //your name and group
    public ButtonPanel control; //the button control panel
    private Elevator elevator; // the elevator area

    //constructor
    public Elevator_Simulation()
    {
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.WIDTH) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.HEIGHT) / 2);
        this.getContentPane().setLayout(new BorderLayout(0, 0));
        JPanel leftpanel = new JPanel();
        JPanel centerpanel = new JPanel();
        centerpanel.setLayout(new FlowLayout());
        control = new ButtonPanel();
        this.getContentPane().add(control, BorderLayout.WEST);
        //id label
        id = new JLabel();
        id.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        id.setText("                   Name: DU SIJUN   Group:FEA1           ");
        id.setBackground(java.awt.Color.LIGHT_GRAY);
        this.getContentPane().add(id, BorderLayout.NORTH);
        //state label
        state = new JLabel();
        state.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        state.setText(" ");
        state.setBackground(java.awt.Color.LIGHT_GRAY);
        this.getContentPane().add(state, BorderLayout.SOUTH);
        this.setVisible(true);
        //elevator
        elevator = new Elevator(this);
        this.getContentPane().add(elevator, BorderLayout.CENTER);
        // Create GUI
    }

    // Main method
    public static void main(String[] args)
    {
        Elevator_Simulation es = new Elevator_Simulation();
        es.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        es.setVisible(true);
        System.out.println("ri!");
        // Create a frame and display it
    }

} //the end of Elevator_Simulation class

