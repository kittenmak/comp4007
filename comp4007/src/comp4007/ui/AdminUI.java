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

        this.setTitle("AdminUI");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.WIDTH) / 8, (Toolkit.getDefaultToolkit().getScreenSize().height - this.HEIGHT) / 8);

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
            AdminPanel.createRFID(item);

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

            AdminPanel.deleteRFID(item);
            System.out.println("onClick = " + SharedConsts.Delete);
        }
    }
}
