package Appliances;

import java.util.Objects;

public class Closet extends RoomAppliance {
    private boolean open;
    private int length;
    private int height;

    public Closet() {

        height = 100;
        length = 20;

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
    public String toString() {
        return "Closet: " + getLength() + ":" + getHeight();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Closet closet = (Closet) o;
        return isOpen() == closet.isOpen() && getLength() == closet.getLength() && getHeight() == closet.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOpen(), getLength(), getHeight());
    }
}

