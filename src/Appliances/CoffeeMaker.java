package Appliances;

import RootOfModel.CoffeeTypes;

import java.util.Objects;

public class CoffeeMaker extends RoomAppliance {
    private String brand;
    private String size;
    private String color;

    public CoffeeMaker() {

    }

    public CoffeeMaker(String brand, String size, String color) {
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public void makeCoffee(CoffeeTypes type, int volume) {
        Coffee coffee = new Coffee(type);
        System.out.println("Here is your " + volume + "ml " + coffee.type);
    }


    //Static nested class
    static class Coffee {
        final CoffeeTypes type;

        public Coffee(CoffeeTypes type) {
            this.type = type;
        }

        public CoffeeTypes getType() {
            return type;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CoffeeMaker that = (CoffeeMaker) o;
        return Objects.equals(getBrand(), that.getBrand()) && Objects.equals(getSize(), that.getSize()) && Objects.equals(getColor(), that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBrand(), getSize(), getColor());
    }

    @Override
    public String toString() {
        return "CoffeeMaker{" +
                "brand: '" + brand + '\'' +
                ", size: '" + size + '\'' +
                ", color: '" + color + '\'' +
                '}';
    }
}

