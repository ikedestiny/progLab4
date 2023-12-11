package RootOfModel;

import java.util.Objects;

public abstract class RoomAppliance {
    private static final int objectCount = 0;
    private String name;
    private String color;

    public RoomAppliance() {
    }

    public RoomAppliance(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor(), getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        RoomAppliance roomAppliance = (RoomAppliance) obj;
        return Objects.equals(getName(), roomAppliance.getName()) && getColor() == roomAppliance.getColor();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getName();
    }
}
