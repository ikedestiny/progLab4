import Appliances.*;
import Exceptions.IllogicalActionException;
import Exceptions.RecessAlreadyOutException;
import Exceptions.RemoteControlException;
import Model.Hotel;
import People.Guest;
import People.Receptionist;
import RootOfModel.CoffeeTypes;
import RootOfModel.Gender;
import RootOfModel.Occupyable;

public class Main {
    public static void main(String[] args) throws InterruptedException, RecessAlreadyOutException, RemoteControlException, IllegalAccessException {

        Hotel hotel = new Hotel("ЭКОНОМИЧЕСКАЯ", new Receptionist("Vivian", 25, Gender.FEMALE));
        Guest guest1 = new Guest("Dunno", 25, Gender.MALE);
        Guest guest2 = new Guest("Kozlik", 25, Gender.MALE);


        hotel.setRoomsPrice(50);
        hotel.fillSomeRooms(100);
        hotel.fillAppliances(new PeepHoleBulb(),
                new Wardrobe(), new TV(), new Telephone(), new Closet(), new Shelf(), new CoffeeMaker());


        Receptionist receptionist = hotel.getReceptionist();
        receptionist.setPhoneNumber("jhdhuu67326bbbj76kkk732");


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

        //Anonymous class
        Occupyable chair = new Occupyable() {
            @Override
            public void occupy() {
                System.out.println(" sits on chair");
            }
        };

        guest1.sitOnChair(chair);
        try {
            guest1.drinkCoffee();
        } catch (IllogicalActionException e) {
            System.out.println("You need to make the coffee first");
        }


    }
}
