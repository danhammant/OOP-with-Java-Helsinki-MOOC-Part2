package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive{
    private String name;
    private double udderCapacity;
    private double milkAmount;
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.udderCapacity = 15 + new Random().nextInt(26);
        this.milkAmount = 0;
        this.name = NAMES[new Random().nextInt(NAMES.length - 1)];
    }

    public Cow(String name) {
        this.udderCapacity = 15 + new Random().nextInt(26);
        this.milkAmount = 0;
        this.name = name;
    }

    public double getCapacity() {
        return this.udderCapacity;
    }

    public double getAmount() {
        return this.milkAmount;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public void liveHour() {
        double amountToAdd = 0.7 + new Random().nextInt(2);

        if (this.milkAmount + amountToAdd > this.udderCapacity) {
            this.milkAmount = this.udderCapacity;
        } else {
            this.milkAmount += amountToAdd;
        }
    }

    @Override
    public double milk() {
        double milk = this.milkAmount;
        this.milkAmount = 0;
        return milk;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.milkAmount) + "/" + Math.ceil(this.udderCapacity);
    }
}
