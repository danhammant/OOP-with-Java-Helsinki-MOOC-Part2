package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.robot = milkingRobot;
        this.robot.setBulkTank(this.tank);
    }

    public void takeCareOf(Cow cow) {
        if (this.robot == null) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        }

        this.robot.milk(cow);
    }

    public void takeCareOf(Collection<Cow> collection) {
        if (this.robot == null) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        }

        for (Cow cow : collection) {
            this.robot.milk(cow);
        }
    }

    @Override
    public String toString() {
        return "Barn: " + this.tank.toString();
    }
}
