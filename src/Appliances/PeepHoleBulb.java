package Appliances;

import Exceptions.RecessAlreadyOutException;
import RootOfModel.Blinkeable;
import RootOfModel.Onable;

import java.util.Objects;

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


    public void stickOutRecess() throws InterruptedException, RecessAlreadyOutException {
        if (!recess.isStuckOut()) {
            blink();
            this.recess.setStuckOut(true);
            System.out.println("Recess Sticks out of Peephole");
        } else {
            throw new RecessAlreadyOutException("The recess is already out");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRecess(), bulbState);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null || this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        PeepHoleBulb peep = (PeepHoleBulb) obj;
        return Objects.equals(getRecess(), peep.getRecess()) && bulbState == peep.bulbState;
    }

    @Override
    public String toString() {
        return getRecess().toString() + " " + bulbState;
    }

    public Recess getRecess() {
        return recess;
    }
}
