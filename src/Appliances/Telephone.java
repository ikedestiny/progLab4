package Appliances;


import RootOfModel.Ringeable;

import java.util.Objects;

public class Telephone extends RoomAppliance implements Ringeable {


    public Telephone() {
    }


    public String validatePhoneNumber(String phoneNumber) {
        final int numberLength = 10;

        //local nested class inside method validate phone number
        class PhoneNumber {
            String formattedPhoneNumber = null;
            final String regexForPhone = "[^0-9]";
            private String phoneNumber;


            public PhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;


            }


            public String validate() {
                phoneNumber = phoneNumber.replaceAll(regexForPhone, "");
                if (phoneNumber.length() == numberLength) {
                    System.out.println("The Number is valid");
                    formattedPhoneNumber = phoneNumber;
                } else {
                    System.out.println("the number is not valid");
                    formattedPhoneNumber = null;
                }

                return formattedPhoneNumber;

            }

            public String getNumber() {
                return this.validate();
            }


        }


        PhoneNumber number = new PhoneNumber(phoneNumber);
        return number.getNumber();
    }


    @Override
    public void ring() {
        System.out.println("Grin Grin Grin");
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


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null || this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Telephone telephone = (Telephone) obj;
        return Objects.equals(getColor(), telephone.getColor()) && getName() == telephone.getName();
    }


    @Override
    public String toString() {
        return getColor() + " " + getName();
    }


}
