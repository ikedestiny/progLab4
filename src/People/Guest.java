package People;

import Appliances.Closet;
import Appliances.CoffeeMaker;
import Appliances.Shelf;
import Exceptions.IllogicalActionException;
import Exceptions.NoCoffeeMaker;
import Exceptions.NoObjectException;
import Model.Room;
import RootOfModel.CoffeeTypes;
import RootOfModel.Gender;
import RootOfModel.Occupyable;

import java.util.Objects;

public class Guest extends Person {

    boolean hasMadeCoffee;
    private boolean hasBookedRoom = false;
    private Room room;

    public Guest(String name, int age, Gender gender) {
        super(name, age, gender);
    }


    public void layOnBed() throws InterruptedException {
        if (this.hasBookedRoom) {
            Thread.sleep(500);
            System.out.println("Guest " + this.getName() + " is resting ");
            Thread.sleep(500);
            System.out.println("Laying on bed");
            Thread.sleep(500);
        }
    }




    public boolean isHasBookedRoom() {
        return hasBookedRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
        hasBookedRoom = true;
    }

    public void getSettled() throws InterruptedException {
//        Shelf shelf = null;
//        for (int i = 0; i < this.getRoom().getAppliances().size(); i++) {
//            if (getRoom().getAppliances().get(i) instanceof Shelf) {
//                shelf = (Shelf) getRoom().getAppliances().get(i);
//                Thread.sleep(200);
//                System.out.println("Removes hat and places it in shelf");
//                shelf.occupy();
//            }
//        }

        Shelf shelf = (Shelf) this.getRoom().getThisAppliance("Shelf");
        if (shelf == null) {
            throw new NoObjectException("There is no shelf in the room");
        } else {
            Thread.sleep(200);
            System.out.println("Removes hat and places it in shelf");
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
        Guest guest = (Guest) obj;
        return Objects.equals(getName(), guest.getName()) && getAge() == guest.getAge() && getGender() == guest.getGender();
    }

    @Override
    public String toString() {
        return "Guest " + getName();
    }

    public void makeCoffee(CoffeeTypes type, int volume) {
        boolean makerInRoom = false;
//        for (RoomAppliance app : this.getRoom().getAppliances()) {
//            if (app instanceof CoffeeMaker coffeeMaker) {
//                makerInRoom = true;
//                coffeeMaker.makeCoffee(type, volume);
//                hasMadeCoffee = true;
//            }
//        }
//        if (!makerInRoom) {
//            System.out.println();
//            throw new NoCoffeeMaker("There is no coffee maker in  this room");
//        }


        CoffeeMaker coffeeMaker = (CoffeeMaker) this.getRoom().getThisAppliance("CoffeeMaker");
        if (!(coffeeMaker == null)) {
            makerInRoom = true;
            coffeeMaker.makeCoffee(type, volume);
            hasMadeCoffee = true;
        } else {
            throw new NoCoffeeMaker("There is no coffee Maker in this room");
        }
    }


    public void drinkCoffee() throws IllogicalActionException {
        if (this.hasMadeCoffee) {
            System.out.println("Drinking the coffee");
        } else {
            throw new IllogicalActionException("Cannot drink coffee that hasnt been made");
        }
    }


    public void sitOnChair(Occupyable chair) {
        chair.occupy();
    }

    public void openCloset() {
        boolean closetInRoom = false;
//        for (int i = 0; i < this.getRoom().getAppliances().size(); i++) {
//            if (getRoom().getAppliances().get(i) instanceof Closet) {
//                closetInRoom = true;
//                Closet closet = new Closet();
//                closet.openClose();
//            }
//        }
//        if (!closetInRoom) {
//            System.out.println("Closet not in room");
//        }

        Closet closet = (Closet) this.getRoom().getThisAppliance("Closet");
        if (closet != null) {
            closetInRoom = true;
            closet.openClose();
        } else {
            throw new NoObjectException("There is no Closet in this room");
        }

    }


}
