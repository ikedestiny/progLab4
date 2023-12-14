package Appliances;

import java.util.Objects;

public class Recess {
    private boolean stuckOut;
    private String color;
    private int radius;

    public Recess() {

    }

    public Recess(String color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    public boolean isStuckOut() {
        return stuckOut;
    }

    public void setStuckOut(boolean stuckOut) {
        this.stuckOut = stuckOut;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recess recess = (Recess) o;
        return isStuckOut() == recess.isStuckOut() && getRadius() == recess.getRadius() && Objects.equals(getColor(), recess.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isStuckOut(), getColor(), getRadius());
    }

    @Override
    public String toString() {
        return "Recess{" +
                "color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

