package Model;

import Model.Exceptions.RecessAlreadyOutException;
import Model.Exceptions.RemoteControlException;
import People.Guest;
import People.Receptionist;
import RootOfModel.Gender;

public class Main {
    public static void main(String[] args) throws InterruptedException, RecessAlreadyOutException, RemoteControlException {

        Hotel hotel = new Hotel("ЭКОНОМИЧЕСКАЯ", new Receptionist("Vivian", 25, Gender.FEMALE));
        Guest guests = new Guest("Dunno", 25, Gender.MALE);
        Guest guests1 = new Guest("Kozlik", 25, Gender.MALE);

        Activites labActivities = new Activites(hotel);
        labActivities.doActivities(guests, guests1);


    }
}
