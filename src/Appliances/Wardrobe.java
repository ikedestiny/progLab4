package Appliances;

import RootOfModel.Occupyable;
import RootOfModel.RoomAppliance;

import java.util.Objects;

public class Wardrobe extends RoomAppliance implements Occupyable {
    private boolean occupied;
    private int length;
    private int height;
    private int width;

    public Wardrobe() {
    }


    @Override
    public void occupy() {
        this.setOccupied(true);
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getHeight(), getWidth(), getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Wardrobe wardrobe = (Wardrobe) obj;
        return Objects.equals(getHeight(), wardrobe.getHeight()) && getWidth() == wardrobe.getWidth() && getLength() == wardrobe.getLength();
    }

    @Override
    public String toString() {
        return "Wardrobe " + getLength() + "'" + getHeight() + "'" + getWidth();
    }


}
