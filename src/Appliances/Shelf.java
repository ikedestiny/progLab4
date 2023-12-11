package Appliances;

import RootOfModel.Occupyable;
import RootOfModel.RoomAppliance;

public class Shelf extends RoomAppliance implements Occupyable {
    private boolean occupied;

    public Shelf() {

    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public void occupy() {
        this.setOccupied(true);
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
