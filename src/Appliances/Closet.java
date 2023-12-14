package Appliances;

import java.util.Objects;

public class Closet extends RoomAppliance {
    private boolean open;
    private int length;
    private int height;

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
        return Objects.hash(super.hashCode(), isOpen(), getHeight(), getLength());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (this == null || this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Closet closet = (Closet) obj;
        return Objects.equals(isOpen(), closet.isOpen()) && getHeight() == ((Closet) obj).getHeight() && getLength() == ((Closet) obj).getLength();
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
}

