package People;

import Appliances.Closet;
import Appliances.Shelf;
import Model.Exceptions.illogicalActionException;
import Model.Exceptions.noObjectException;
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


    public void openCloset() {
        Closet closet = null;
        for (int i = 0; i < this.getRoom().getAppliances().size(); i++) {
            if (getRoom().getAppliances().get(i) instanceof Closet) {
                closet = (Closet) getRoom().getAppliances().get(i);
                closet.openClose();
            }
        }
        if (closet == null) {
            throw new noObjectException("There is no closet in the room");
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

        Shelf shelf = null;


        for (int i = 0; i < this.getRoom().getAppliances().size(); i++) {
            if (getRoom().getAppliances().get(i) instanceof Shelf) {
                shelf = (Shelf) getRoom().getAppliances().get(i);
                Thread.sleep(200);
                System.out.println("Removes hat and places it in shelf");
                shelf.occupy();
            }
        }
        if (shelf == null) {
            throw new noObjectException("There is no shelf in the room");
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
        Room.coffeeMaker coffeeMaker = new Room.coffeeMaker();
        coffeeMaker.makeCoffee(type, volume);

        hasMadeCoffee = true;
    }


    public void drinkCoffee() throws illogicalActionException {
        if (this.hasMadeCoffee) {
            System.out.println("Drinking the coffee");
        } else {
            throw new illogicalActionException("Cannot drink coffee that hasnt been made");
        }
    }


    public void sitOnChair() {
        //anonymous class changed to lambda
        Occupyable chair = () -> System.out.println(getName() + " sits on chair");
        chair.occupy();
    }


}
