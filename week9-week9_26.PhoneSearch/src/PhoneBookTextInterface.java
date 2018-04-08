import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PhoneBookTextInterface {
    private Scanner reader;
    private PhoneBook phoneBook;

    public PhoneBookTextInterface() {
        this.reader = new Scanner(System.in);
        this.phoneBook = new PhoneBook();
    }

    public void start() {
        commandList();
        input();

    }

    private void input() {
        while(true) {
            System.out.print("command: ");
            String command = this.reader.nextLine();

            if (command.equals("1")) {
                addNumber();
            } else if (command.equals("2")) {
                searchForNumber();
            } else if (command.equals("3")) {
                searchPersonByNumber();
            } else if (command.equals("4")) {
                addAddress();
            } else if (command.equals("5")) {
                searchPersonalInformation();
            } else if (command.equals("6")) {
                deletePersonalInformation();
            } else if (command.equals("7")) {
                filteredListing();
            } else if (command.equals("x")) {
                break;
            }
        }
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();

        if(!this.phoneBook.personExists(name)) {
            this.phoneBook.addPerson(new Person(name, number));
        } else {
            this.phoneBook.addNumber(name, number);
        }

        System.out.println();
    }

    private void searchForNumber() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();

        if(!this.phoneBook.personExists(name)) {
            System.out.println("  not found");
        } else if (this.phoneBook.getPerson(name).numbersEmpty()){
            System.out.println("  not found");
        } else {
            for(String number : this.phoneBook.getPersonsNumbers(name)) {
                System.out.println(" " + number);
            }
        }

        System.out.println();
    }

    private void searchPersonByNumber() {
        System.out.print("number: ");
        String number = this.reader.nextLine();

        if(!this.phoneBook.numberExists(number)) {
            System.out.println(" not found");
        } else {
            System.out.println(" " + this.phoneBook.searchPersonByNumber(number));
        }
    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = this.reader.nextLine();

        System.out.print("street: ");
        String street = this.reader.nextLine();

        System.out.print("city: ");
        String city = this.reader.nextLine();

        if (!this.phoneBook.personExists(name)) {
            this.phoneBook.addPerson(new Person(name, street, city));
        } else {
            this.phoneBook.addAddress(name, street, city);
        }

        System.out.println();
    }

    private void searchPersonalInformation() {
        System.out.print("whose information: ");
        String name = this.reader.nextLine();

        personalInfo(name);
    }

    private void personalInfo(String name) {
        if(!phoneBook.personExists(name)) {
            System.out.println("not found");
            return;
        }

        if (!this.phoneBook.addressExists(name)) {
            System.out.println("  address unknown");
        } else {
            System.out.println("  address: " + this.phoneBook.getAddress(name));
        }

        if (this.phoneBook.getPerson(name).numbersEmpty()) {
            System.out.println("  phone number not found");
        } else {

            System.out.println("  phone numbers:");
            for (String number : this.phoneBook.getPersonsNumbers(name)) {
                System.out.println("   " + number);
            }
        }

        System.out.println();
    }

    private void deletePersonalInformation() {
        System.out.print("whose information: ");
        String name = this.reader.nextLine();

        if(!phoneBook.personExists(name)) {
            System.out.println("not found");
        } else {
            this.phoneBook.deletePersonalInfo(name);
        }
    }

    private void filteredListing() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = this.reader.nextLine();
        System.out.println();

        List<String> allPeople = this.phoneBook.getAllPeople();
        Collections.sort(allPeople);

        if(keyword.isEmpty()) {
            for(String name : allPeople) {
                System.out.println(" " + name);
                personalInfo(name);
            }

            return;
        }

        int numberFound = 0;
        for(String name : allPeople) {
            if (name.contains(keyword) || (phoneBook.addressExists(name) && this.phoneBook.getAddress(name).contains(keyword))) {
                System.out.println(" " + name);
                personalInfo(name);
                numberFound++;
            }
        }

        if(numberFound == 0) {
            System.out.println(" keyword not found");
        }


    }

    private void commandList() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");

        System.out.println();
    }
}
