package People;

import RootOfModel.Gender;
import RootOfModel.Position;

import java.util.Objects;

public class Worker extends Person {
    private final int id;
    private Position position;
    private int salary;

    public Worker(String name, int age, Gender gender, Position position) {
        super(name, age, gender);
        this.position = position;
        this.id = position.ordinal() + 19875;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getName(), getGender(), getPosition());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Worker worker = (Worker) obj;
        return Objects.equals(getName(), worker.getName()) && getAge() == worker.getAge() && getGender() == worker.getGender() && getPosition() == worker.getPosition();
    }

    @Override
    public String toString() {
        return "Worker " + getName();
    }

    @Override
    public String getName() {
        return this.getPosition() + " " + super.getName();
    }
}
