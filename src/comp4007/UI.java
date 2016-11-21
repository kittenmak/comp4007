package comp4007;

import comp4007.item.RFIDItem;
import comp4007.panel.AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class UI extends JFrame implements ActionListener {

	private Panel mControlPanel;
	private Panel mAdminPanel;

	private Button mElevatorBtn[];
	private Button mCreateBtn;
	private Button mModifyBtn;
	private Button mDeleteBtn;

	int mElevator = 0;
	int mFloor = 0;

	public UI(){
		readConfig();

//		setLayout(new BorderLayout());
		controlPanel();
		adminPanel();
	}

	private void adminPanel(){
		mAdminPanel = new Panel();
		mCreateBtn = new Button(SharedConsts.Create);
		mModifyBtn = new Button(SharedConsts.Modify);
		mDeleteBtn = new Button(SharedConsts.Delete);

		mAdminPanel.add(mCreateBtn);
		mAdminPanel.add(mModifyBtn);
		mAdminPanel.add(mDeleteBtn);

		mCreateBtn.addActionListener(this);
		mModifyBtn.addActionListener(this);
		mDeleteBtn.addActionListener(this);

		add(mAdminPanel, BorderLayout.WEST);
	}

	private void controlPanel(){
		mControlPanel = new Panel();
		mElevatorBtn = new Button[mElevator];
//				("Elevator");
		mControlPanel.setLayout(new GridLayout(mFloor, mElevator));

		for (int i=0; i<mElevator; i++) {
			mElevatorBtn[i] = new Button(SharedConsts.Elevator + String.valueOf(i+1));
			mElevatorBtn[i].addActionListener(this);
			mControlPanel.add(mElevatorBtn[i]);
		}

		add(mControlPanel, BorderLayout.EAST);
	}

	private void readConfig(){


		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(SharedConsts.ConfigFilePath);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			mElevator = Integer.valueOf(prop.getProperty(SharedConsts.Elevator));
			mFloor = Integer.valueOf(prop.getProperty(SharedConsts.Floor));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[])
	{
		// set frame properties
		UI f = new UI();
		f.setTitle("UI");
		f.setBounds(200,200,800,600); //(x, y, width, height)
		f.setVisible(true);

		// set image as the icon
//		Image icon = Toolkit.getDefaultToolkit().getImage("calcImage.gif");
//		f.setIconImage(icon);
	} // end of main

	@Override
	public void actionPerformed(ActionEvent e) {

		String arg = e.getActionCommand();
		if (arg == SharedConsts.Create){

			RFIDItem item = new RFIDItem();
			item.setFirstName("firstname");
			item.setSurname("surename");
			item.setExpiryDate("expirydate");
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(3);
			item.setFloor(list);

			AdminPanel admin = new AdminPanel();
			admin.createRFID(item);

			System.out.println("onClick = " + SharedConsts.Create);
		}
		else if(arg == SharedConsts.Modify){
			System.out.println("onClick = " + SharedConsts.Modify);
		}
		else if(arg == SharedConsts.Delete){

			RFIDItem item = new RFIDItem();
			item.setFirstName("firstname");
			item.setSurname("surename");
			item.setExpiryDate("expirydate");
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(3);
			item.setFloor(list);

			AdminPanel admin = new AdminPanel();
			admin.deleteRFID(item);
			System.out.println("onClick = " + SharedConsts.Delete);
		}

		for (int i=0; i< mElevatorBtn.length; i++)
		{
			if(e.getSource() == mElevatorBtn[i])
			{
				System.out.println("onClick = " + mElevatorBtn[i].getLabel());
			}
		}
	}
}
