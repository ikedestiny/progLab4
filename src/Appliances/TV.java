package Appliances;

import RootOfModel.Onable;
import RootOfModel.RoomAppliance;

public class TV extends RoomAppliance implements Onable {
    boolean isOn = false;

    @Override
    public void toggleSwitch() {
        this.isOn = !this.isOn;

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
