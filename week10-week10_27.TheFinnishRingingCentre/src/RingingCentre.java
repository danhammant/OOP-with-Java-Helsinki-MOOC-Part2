import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RingingCentre {
    private Map<Bird, List<String>> birdList;

    public RingingCentre() {
        this.birdList = new HashMap<>();
    }

    public void observe(Bird bird, String place) {
        if (!this.birdList.containsKey(bird)) {
            this.birdList.put(bird, new ArrayList<>());
            this.birdList.get(bird).add(place);
        } else {
            this.birdList.get(bird).add(place);
        }
    }

    public void observations(Bird bird) {
        if(!this.birdList.containsKey(bird)) {
            System.out.println(bird + " observations: 0");
        } else {
            System.out.println(bird + " observations: " + this.birdList.get(bird).size());
            for (String place : this.birdList.get(bird)) {
                System.out.println(place);
            }
        }
    }

    public void printAll() {
        for (Bird bird : this.birdList.keySet()) {
            System.out.println(bird);
            System.out.println(this.birdList.get(bird));
        }
    }
}
