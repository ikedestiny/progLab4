package Model;

import Appliances.PeepHoleBulb;
import RootOfModel.CoffeeTypes;
import RootOfModel.Ringeable;
import RootOfModel.RoomAppliance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {
    private static int objectCount = 0;
    private final int id;
    private final List<RoomAppliance> appliances;
    private int price;
    private int number;
    private boolean booked;

    public Room(int number) {
        this.number = number;
        this.appliances = new ArrayList<>();
        objectCount++;
        this.id = objectCount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<RoomAppliance> getAppliances() {
        return appliances;
    }

    public void addApplianceInRoom(RoomAppliance appliance) {
        this.getAppliances().add(appliance);
    }

    public void ringBell() throws InterruptedException {
        //Anonymous class bell created here just because it will be used once only when an alarm in the room rings
        Ringeable bell = () -> {
            for (int i = 0; i <= 5; i++) {
                Thread.sleep(500);
                System.out.println("Bell ringing Grin Grin Grin");
            }
        };
    }

    public void blinkHole() throws InterruptedException {
        for (RoomAppliance appliance : this.getAppliances()) {
            if (appliance.getClass().getSimpleName().equalsIgnoreCase("PeepHoleBulb")) {
                PeepHoleBulb hole = (PeepHoleBulb) appliance;
                hole.stickOutRecess();
            }
        }
    }

    public int getId() {
        return id;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getPrice(), getNumber());
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Room room = (Room) obj;
        return Objects.equals(getNumber(), room.getNumber()) && getPrice() == room.getPrice() && getId() == room.getId();
    }

    @Override
    public String toString() {
        return "Room " + getNumber();
    }

    //this is a static nested  class in room class
    public static class coffeeMaker extends RoomAppliance {
        public coffeeMaker() {

        }

        public void makeCoffee(CoffeeTypes type, int volume) {
            //This is a local class inside an inner class
            class Coffee {
                final CoffeeTypes type;

                public Coffee(CoffeeTypes type) {
                    this.type = type;
                }
            }
            Coffee coffee = new Coffee(type);
            System.out.println("Here is your " + volume + "ml " + coffee.type);
        }
    }

}
