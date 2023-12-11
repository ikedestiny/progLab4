package Appliances;

import RootOfModel.RoomAppliance;

public class Closet extends RoomAppliance {
    private boolean open;

    public Closet() {

    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void openClose() {
        open = !this.isOpen();
        System.out.println("Opens Closet");
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

