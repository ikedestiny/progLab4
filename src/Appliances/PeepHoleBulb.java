package Appliances;

import RootOfModel.Blinkeable;
import RootOfModel.Onable;
import RootOfModel.RoomAppliance;

public class PeepHoleBulb extends RoomAppliance implements Onable, Blinkeable {
    private final Recess recess;
    private boolean bulbState = false;

    public PeepHoleBulb() {
        this.recess = new Recess();
    }

    @Override
    public void blink() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            System.out.println("Blinking, Blinking, Blinking");
        }
        System.out.println("SANTIC");
    }

    @Override
    public void toggleSwitch() {
        bulbState = !bulbState;


    }


    public void stickOutRecess() throws InterruptedException {
        blink();
        this.recess.setStuckOut(true);
        System.out.println("Recess Sticks out of Peephole");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
