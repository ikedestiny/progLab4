package Appliances;

import RootOfModel.Occupyable;

import java.util.Objects;

public class Shelf extends RoomAppliance implements Occupyable {
    private boolean occupied;
    private String brand;

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


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shelf shelf = (Shelf) o;
        return isOccupied() == shelf.isOccupied() && Objects.equals(getBrand(), shelf.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOccupied(), getBrand());
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "occupied=" + occupied +
                ", brand='" + brand + '\'' +
                '}';
    }
}
