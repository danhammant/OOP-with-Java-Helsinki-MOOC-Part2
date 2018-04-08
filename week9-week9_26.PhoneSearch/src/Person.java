import java.util.List;
import java.util.ArrayList;

public class Person {
    private String name;
    private String address;
    private List<String> phoneNumbers;

    public Person(String name, String phoneNumber) {
        this.name = name;

        this.phoneNumbers = new ArrayList<>();
        this.phoneNumbers.add(phoneNumber);

    }

    public Person(String name, String street, String city) {
        this.name = name;
        this.address = street + " " + city;

        this.phoneNumbers = new ArrayList<>();
    }

    public void addNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public void addAddress(String street, String city) {
        this.address = street;
        this.address += " " + city;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public String getAddress() {
        return this.address;
    }

    public boolean numbersEmpty() {
        if(this.phoneNumbers.isEmpty()) {
            return true;
        }

        return false;
    }

}
