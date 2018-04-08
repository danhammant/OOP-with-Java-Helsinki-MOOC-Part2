import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> vehicleRegister;


    public VehicleRegister() {
        this.vehicleRegister = new HashMap<>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (this.vehicleRegister.containsKey(plate)) {
            return false;
        }

        this.vehicleRegister.put(plate, owner);
        return true;
    }

    public String get(RegistrationPlate plate) {
        if (!this.vehicleRegister.containsKey(plate)) {
            return null;
        }

        return this.vehicleRegister.get(plate);
    }

    public boolean delete(RegistrationPlate plate) {
        if (!this.vehicleRegister.containsKey(plate)) {
            return false;
        }

        this.vehicleRegister.remove(plate);
        return true;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate plate : this.vehicleRegister.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        String owners = "";
        for (String owner : this.vehicleRegister.values()) {
            if (!owners.contains(owner)) {
                owners += owner + "\n";
            }
        }

        System.out.println(owners);
    }
}
