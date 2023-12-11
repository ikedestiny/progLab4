package People;

import Appliances.Telephone;
import Model.Hotel;
import RootOfModel.Gender;
import RootOfModel.Position;

import java.util.Objects;

public class Receptionist extends Worker {
    public Receptionist(String name, int age, Gender gender) {
        super(name, age, gender, Position.RECEPTIONIST);
    }

    public void welcomeGuest(Guest guest, Hotel hotel) {
        System.out.println("Good day " + guest.getName() + " welcome to " + hotel.getName());
    }


    public void callGuest(Guest guest, Telephone telephone) throws InterruptedException {
        this.call(guest);
    }

    public void giveGuestKey(Guest guest) throws InterruptedException {
        if (guest.isHasBookedRoom()) {
            Thread.sleep(500);
            System.out.println("This is the Key to the room " + guest.getRoom().getNumber());
            Thread.sleep(500);
            System.out.println("Have a nice day");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getName(), getGender());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Receptionist receptionist = (Receptionist) obj;
        return Objects.equals(getName(), receptionist.getName()) && getAge() == receptionist.getAge() && getGender() == receptionist.getGender();
    }

    @Override
    public String toString() {
        return "Receptionist " + getName();
    }


    public void bookRoom(int RoomNumber, Hotel hotel, Guest... guests) {
        for (Guest guest : guests) {
            if (!guest.isHasBookedRoom()) {
                guest.setRoom(hotel.getRooms().get(RoomNumber));
                hotel.getRooms().get(RoomNumber).setBooked(true);
            }
        }
    }
}
