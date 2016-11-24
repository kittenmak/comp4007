package comp4007.ui;

import comp4007.SharedConsts;
import comp4007.item.RFIDItem;
import comp4007.panel.AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by michaelleung on 22/11/2016.
 */
public class AdminUI extends JFrame implements ActionListener{

    private Panel mAdminPanel;
    private Button mCreateBtn;
    private Button mModifyBtn;
    private Button mDeleteBtn;

    public AdminUI(){
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

    public static void main(String args[])
    {
        // set frame properties
        AdminUI f = new AdminUI();
        f.setTitle("AdminUI");
        f.setBounds(200,200,400,300); //(x, y, width, height)
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
    }
}
