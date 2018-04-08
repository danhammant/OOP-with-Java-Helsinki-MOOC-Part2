package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ContainerHistory {
    private List<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double situation) {
        this.history.add(situation);
    }

    public void reset() {
        this.history.clear();
    }

    public double maxValue() {
        if (this.history.isEmpty()) {
            return 0;
        }

        return Collections.max(this.history);
    }

    public double minValue() {
        if (this.history.isEmpty()) {
            return 0;
        }

        return Collections.min(this.history);
    }

    public double average() {
        if (this.history.isEmpty()) {
            return 0;
        }

        double total = 0;
        for(double situation : this.history) {
            total += situation;
        }

        return total / this.history.size();
    }

    public double greatestFluctuation() {
        if(emptyOrOne()) {
            return 0;
        }

        double greatestDistance = 0;
        for (int i = 0; i < this.history.size() - 1; i++) {
            double first = this.history.get(i);
            double second = this.history.get(i + 1);
            double tempDistance;

            if (first - second > 0) {
                tempDistance = first - second;
            } else {
                tempDistance = second - first;
            }

            if(tempDistance > greatestDistance) {
                greatestDistance = tempDistance;
            }
        }

        return greatestDistance;
    }

    public double variance() {
        if(emptyOrOne()) {
            return 0;
        }

        double average = average();
        double variance = 0;

        for(double number : this.history) {
            variance += Math.pow(number - average, 2);
        }

        return variance / (this.history.size() - 1);
    }

    @Override
    public String toString(){
        return this.history.toString();
    }

    private boolean emptyOrOne() {
        if(this.history.isEmpty() || this.history.size() == 1) {
            return true;
        }
        return false;
    }
}
