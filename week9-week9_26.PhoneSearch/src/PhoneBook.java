import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class PhoneBook {
    private Map<String, Person> allPeople;
    private Map<String, String> numbersPerson;

    public PhoneBook() {
        this.allPeople = new HashMap<>();
        this.numbersPerson = new HashMap<>();
    }

    public void addPerson(Person person) {
        this.allPeople.put(person.getName(), person);

        if (!person.numbersEmpty()) {
            updateNumbers(person);
        }

    }

    public void addNumber(String name, String number) {
        this.allPeople.get(name).addNumber(number);
        updateNumbers(this.allPeople.get(name));
    }

    public void addAddress(String name, String street, String city) {
            this.allPeople.get(name).addAddress(street, city);
    }

    public List<String> getPersonsNumbers(String name){
        return this.allPeople.get(name).getPhoneNumbers();
    }

    public String searchPersonByNumber(String number) {
        return this.numbersPerson.get(number);
    }

    public String getAddress(String name) {
        return this.allPeople.get(name).getAddress();
    }

    public Person getPerson(String name) {
        return this.allPeople.get(name);
    }

    public List<String> getAllPeople() {
        List<String> allPeople = new ArrayList<>();

        for(String name : this.allPeople.keySet()) {
            allPeople.add(name);
        }

        return allPeople;
    }

    public boolean personExists(String name) {
        if (this.allPeople.containsKey(name)) {
            return true;
        }

        return false;
    }

    public boolean numberExists(String number) {
        if (this.numbersPerson.containsKey(number)) {
            return true;
        }

        return false;
    }

    public boolean addressExists(String name) {
        if (this.allPeople.get(name).getAddress() == null) {
            return false;
        }

        return true;
    }

    public void deletePersonalInfo(String name) {
        List<String> numbers = this.allPeople.get(name).getPhoneNumbers();

        for (String number : numbers) {
            this.numbersPerson.remove(number);
        }

        this.allPeople.remove(name);
    }


    private void updateNumbers(Person person) {
        for(String number : person.getPhoneNumbers()) {
            this.numbersPerson.put(number, person.getName());
        }
    }






}
