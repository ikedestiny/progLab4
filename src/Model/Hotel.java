package Model;

import People.Receptionist;
import People.Worker;
import RootOfModel.RoomAppliance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {
    private final String name;
    private final List<Room> rooms;
    private final List<Worker> workers;
    private final Receptionist receptionist;

    public Hotel(String name, Receptionist receptionist) {
        this.name = name;
        this.receptionist = receptionist;
        System.out.println("The cheapest rooms in the world".toUpperCase());
        this.rooms = new ArrayList<>();
        this.workers = new ArrayList<>();

    }

    public List<Room> getRooms() {

        return rooms;
    }

    public void fillSomeRooms(int numberOfRooms) {
        for (int i = 0; i <= numberOfRooms; i++) {
            Room newRoom = new Room(Integer.parseInt("10" + i));
            if (i < 20) {
                newRoom.setBooked(true);
            }
            this.rooms.add(newRoom);
        }
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }


    public String getName() {
        return name;
    }


    public void setRoomsPrice(int price) {
        for (Room room : this.getRooms()) {
            room.setPrice(price);
        }
    }

    public void addAppliance(RoomAppliance appliance) {
        for (Room room : this.getRooms()) {
            room.addApplianceInRoom(appliance);
        }
    }

    public void fillAppliances(RoomAppliance... appliances) {
        for (RoomAppliance appliance : appliances) {
            this.addAppliance(appliance);
        }
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getReceptionist(), getRooms(), getWorkers());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Hotel hotel = (Hotel) obj;
        return Objects.equals(getName(), hotel.getName()) && hotel.getReceptionist() == getReceptionist() && getRooms() == hotel.getRooms() && getWorkers() == hotel.getWorkers();
    }

    @Override
    public String toString() {
        return "Hotel " + getName();
    }
}
