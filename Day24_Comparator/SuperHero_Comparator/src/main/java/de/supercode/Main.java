package de.supercode;

//Sort a list of SuperHero objects first by power level, then by speed, and finally by name if the previous attributes are equal.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SuperHero> heros = generateSuperHero();

        printList(heros);

        heros.sort(SuperHero.powerComparator.thenComparing(SuperHero.speedComparator.thenComparing(SuperHero.nameComparator)));

        printList(heros);
    }

    private static void printList(List<SuperHero> heros) {
        System.out.println("=============================================================================");
        System.out.println("________________________________List of Heros________________________________");
        System.out.println("=============================================================================");
        heros.forEach(System.out::println);
    }

    private static List<SuperHero> generateSuperHero() {
        List<SuperHero> list= new ArrayList<SuperHero>(List.of(            new SuperHero("Spider-Man", 85, 500, SuperHero.Category.HERO),
                new SuperHero("Iron Man", 90, 1200, SuperHero.Category.HERO),
                new SuperHero("Wonder Woman", 95, 800, SuperHero.Category.HERO),
                new SuperHero("Batman", 80, 300, SuperHero.Category.HERO),
                new SuperHero("Captain America", 85, 400, SuperHero.Category.HERO),
                new SuperHero("Thor", 100, 1500, SuperHero.Category.HERO),
                new SuperHero("Aquaman", 80, 600, SuperHero.Category.HERO),
                new SuperHero("Hulk", 100, 1800, SuperHero.Category.HERO),
                new SuperHero("Black Widow", 75, 350, SuperHero.Category.HERO),
                new SuperHero("Doctor Strange", 90, 700, SuperHero.Category.HERO),
                new SuperHero("Flash", 95, 2000, SuperHero.Category.HERO),
                new SuperHero("Green Lantern", 85, 800, SuperHero.Category.HERO),
                new SuperHero("Green Arrow", 70, 500, SuperHero.Category.HERO),
                new SuperHero("Daredevil", 75, 400, SuperHero.Category.HERO),
                new SuperHero("Wolverine", 80, 600, SuperHero.Category.HERO),
                new SuperHero("Black Panther", 90, 700, SuperHero.Category.HERO),
                new SuperHero("Scarlet Witch", 85, 600, SuperHero.Category.HERO),
                new SuperHero("Vision", 95, 1200, SuperHero.Category.HERO),
                new SuperHero("Silver Surfer", 100, 1500, SuperHero.Category.HERO),
                new SuperHero("Ghost Rider", 90, 1300, SuperHero.Category.HERO),
                new SuperHero("Loki", 80, 250, SuperHero.Category.VILLAIN),
                new SuperHero("Thanos", 95, 400, SuperHero.Category.VILLAIN),
                new SuperHero("Magneto", 85, 600, SuperHero.Category.VILLAIN),
                new SuperHero("Green Goblin", 75, 300, SuperHero.Category.VILLAIN),
                new SuperHero("Joker", 70, 200, SuperHero.Category.VILLAIN),
                new SuperHero("Doctor Doom", 90, 500, SuperHero.Category.VILLAIN),
                new SuperHero("Red Skull", 80, 350, SuperHero.Category.VILLAIN),
                new SuperHero("Kingpin", 70, 250, SuperHero.Category.VILLAIN),
                new SuperHero("Hydra", 85, 400, SuperHero.Category.VILLAIN),
                new SuperHero("Ultron", 95, 700, SuperHero.Category.VILLAIN),
                new SuperHero("Dormammu", 100, 800, SuperHero.Category.VILLAIN),
                new SuperHero("Mysterio", 75, 600, SuperHero.Category.VILLAIN),
                new SuperHero("Kraven the Hunter", 80, 500, SuperHero.Category.VILLAIN),
                new SuperHero("Sabretooth", 85, 400, SuperHero.Category.VILLAIN),
                new SuperHero("Vulture", 70, 550, SuperHero.Category.VILLAIN),
                new SuperHero("Electro", 80, 600, SuperHero.Category.VILLAIN)));

        return list;
    }
}