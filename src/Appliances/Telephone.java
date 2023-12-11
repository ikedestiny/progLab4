package Appliances;


import RootOfModel.Ringeable;
import RootOfModel.RoomAppliance;

public class Telephone extends RoomAppliance implements Ringeable {
    private static final String regexForPhone = "[^0-9]";


    public Telephone() {
    }


    public String validatePhoneNumber(String phoneNumber) {
        final int numberLength = 10;

        //local nested class inside method validate phone number
        class PhoneNumber {
            String formattedPhoneNumber = null;

            public PhoneNumber(String phoneNumber) {
                phoneNumber = phoneNumber.replaceAll(regexForPhone, "");
                if (phoneNumber.length() == numberLength) {
                    formattedPhoneNumber = phoneNumber;
                } else {
                    formattedPhoneNumber = null;
                }
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }


        }


        PhoneNumber number = new PhoneNumber(phoneNumber);

        if (number.getNumber() == null) {
            System.out.println("The number is not valid");
            return number.getNumber();
        } else {
            System.out.println("Number " + number.getNumber() + " is valid");
            return number.getNumber();
        }
    }


    @Override
    public void ring() {
        System.out.println("Grin Grin Grin");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void call(String number) throws InterruptedException {
        String checkedNumber = validatePhoneNumber(number);
        if (checkedNumber == null) {
            System.out.println("Please check the number".toUpperCase());
        } else {
            for (int i = 5; i > 0; i--) {
                Thread.sleep(300);
                System.out.println("Calling " + checkedNumber);
                ring();
            }
        }

    }
}
