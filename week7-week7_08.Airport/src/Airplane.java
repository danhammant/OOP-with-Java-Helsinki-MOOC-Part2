import java.util.HashMap;
import java.util.ArrayList;

public class Airplane {
    private HashMap<String, String> planes;

    public Airplane() {
        this.planes = new HashMap<>();
    }

    public void addPlane(String id, int capacity) {
        String capacityToString = "(" + capacity + " ppl)";
        this.planes.put(id, capacityToString);
    }

    public String getCapacity(String id) {
        if (this.planes.containsKey(id)) {
            return this.planes.get(id);
        }

        return "Plane not found!";
    }

    public String planeToString(String planeID) {
        return planeID + " " + this.planes.get(planeID);
    }

    public ArrayList<String> airplaneList() {
        ArrayList<String> airplaneList = new ArrayList<>();

        for (String key : this.planes.keySet()) {
            String airplane = key + " " + this.planes.get(key);
            airplaneList.add(airplane);
        }

        return airplaneList;
    }


}
