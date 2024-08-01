package de.supercode;


import java.util.Comparator;

import static java.util.Arrays.compare;

public class SuperHero {
    private String name;
    private int powerLevel;
    private int speed;
    private Category category;


    public enum Category {
        HERO,
        VILLAIN
    }

    public SuperHero(String name, int powerLevel, int speed, Category category) {
        this.speed = speed;
        this.powerLevel = powerLevel;
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name + ", powerLevel=" + powerLevel +
                ", speed=" + speed + "km/h";
    }

    //Implement of three Comparator instances: one for sorting by power level, one for sorting by speed, and one for sorting by name.
    // Three different ways, same result.

    public static Comparator<SuperHero> powerComparator = new Comparator<SuperHero>() {
        @Override
        public int compare(SuperHero o1, SuperHero o2) {
            return Integer.compare(o1.powerLevel, o2.powerLevel);
        }
    };

    public static Comparator<SuperHero> speedComparator = (superhero1, superhero2) -> Integer.compare(superhero1.speed, superhero2.speed);

    public static Comparator<SuperHero> nameComparator = Comparator.comparing(SuperHero::getName);


}
