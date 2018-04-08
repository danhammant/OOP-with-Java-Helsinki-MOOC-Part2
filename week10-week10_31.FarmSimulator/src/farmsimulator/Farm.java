package farmsimulator;


import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive{
    private String name;
    private List<Cow> cows;
    private Barn barn;

    public Farm(String name, Barn barn) {
        this.name = name;
        this.barn = barn;
        this.cows = new ArrayList<>();
    }

    public void addCow(Cow cow) {
        this.cows.add(cow);
    }

    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

    public String getOwner() {
        return this.name;
    }

    @Override
    public void liveHour() {
        for (Cow cow : this.cows) {
            cow.liveHour();
        }
    }

    @Override
    public String toString() {
        return "Farm owner: " + this.name + "\n" +
                "Barn bulk tank: " + this.barn.toString() + "\n" + animals();

    }

    private String animals() {
        if (this.cows.isEmpty()) {
            return "No cows.";
        }

        String animals = "Animals:\n";
        for (Cow cow : this.cows) {
            animals += "        " + cow + "\n";
        }

        return animals;
    }
}

