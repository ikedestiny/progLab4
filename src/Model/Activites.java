package Model;

import Appliances.*;
import Model.Exceptions.illogicalActionException;
import People.Guest;
import People.Receptionist;
import RootOfModel.CoffeeTypes;

public class Activites {
    Hotel hotel;

    public Activites(Hotel hotel) {
        this.hotel = hotel;
    }

    void doActivities(Guest guest1, Guest guest2) throws InterruptedException {
        hotel.setRoomsPrice(50);
        hotel.fillSomeRooms(100);
        hotel.fillAppliances(new PeepHoleBulb(),
                new Wardrobe(), new TV(), new Telephone(), new Closet(), new Shelf());


        Receptionist receptionist = hotel.getReceptionist();

        receptionist.welcomeGuest(guest2, hotel);
        receptionist.bookRoom(100, hotel, guest1, guest2);

        hotel.getReceptionist().giveGuestKey(guest2);

        guest2.openCloset();
        guest2.getSettled();
        guest1.layOnBed();
        guest2.layOnBed();

        guest2.getRoom().ringBell();
        guest2.getRoom().blinkHole();
        guest2.call(hotel.getReceptionist());

        guest1.makeCoffee(CoffeeTypes.AMERICANO, 500);
        guest1.sitOnChair();
        try {
            guest1.drinkCoffee();
        } catch (illogicalActionException e) {
            System.out.println("You need to make the coffee first");
        }

    }
}
