package Appliances;

import Model.Exceptions.RemoteControlException;
import RootOfModel.Onable;

import java.util.Objects;

public class TV extends RoomAppliance implements Onable {
    boolean isOn = false;
    private String model;
    private int qrNumber;

    public TV(boolean isOn, String model, int qrNumber) {
        this.isOn = isOn;
        this.model = model;
        this.qrNumber = qrNumber;
    }

    public TV() {
    }

    public TV(String name, String color, boolean isOn, String model, int qrNumber) {
        super(name, color);
        this.isOn = isOn;
        this.model = model;
        this.qrNumber = qrNumber;
    }

    @Override
    public void toggleSwitch() {
        this.isOn = !this.isOn;

    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQrNumber() {
        return qrNumber;
    }

    public void setQrNumber(int qrNumber) {
        this.qrNumber = qrNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV tv = (TV) o;
        return isOn() == tv.isOn() && getQrNumber() == tv.getQrNumber() && Objects.equals(getModel(), tv.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOn(), getModel(), getQrNumber());
    }


    @Override
    public String toString() {
        return "TV{" +
                "isOn=" + isOn +
                ", model='" + model + '\'' +
                ", qrNumber=" + qrNumber +
                '}';
    }

    public static class remote {
        private final String brand;
        private final String color;
        private int[] buttonsPad = new int[9];

        public remote(String brand, String color, int[] buttonsPad) {
            this.brand = brand;
            this.color = color;
            this.buttonsPad = buttonsPad;
        }


        public void powerTVOn(TV tv) throws RemoteControlException {
            if (!tv.isOn()) {
                tv.setOn(true);
            } else
                throw new RemoteControlException("The TV is already on");
        }


        public void powerTVOff(TV tv) throws RemoteControlException {
            if (tv.isOn()) {
                tv.setOn(false);
            } else throw new RemoteControlException("The TV is already off");
        }
    }
}
