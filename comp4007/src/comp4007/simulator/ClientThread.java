package comp4007.simulator;

import comp4007.item.ElevatorItem;
import comp4007.other.*;

/**
 * Created by michaelleung on 26/11/2016.
 */
public class ClientThread extends Thread {

    Elevator elevator;
    ElevatorItem item;
    public ClientThread(Elevator elevator, ElevatorItem item) {
        this.elevator = elevator;
        this.item = item;
    }

    @Override
    public void run() {
        try {
            elevator = new Elevator(item);
        } catch (Exception e) {
            System.out.println("Connection terminated!");
        }
        finally {
            //TODO
//            disconnect();
        }
    }
}
