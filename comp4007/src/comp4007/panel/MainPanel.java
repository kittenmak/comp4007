package comp4007.panel;

import sun.applet.Main;

import java.io.IOException;

/**
 * Created by michaelleung on 26/11/2016.
 */
public class MainPanel {
    public MainPanel() throws IOException, InterruptedException {
        AdminPanel adminPanel = new AdminPanel();
        ControlPanel controlPanel = new ControlPanel();
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        MainPanel panel = new MainPanel();
    } // end of main
}
