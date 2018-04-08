
public class Calculator {
    private Reader reader;
    private int stats;

    public Calculator() {
        this.reader = new Reader();
        this.stats = 0;
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }

    private void sum() {
        int[] values = numberInput();
        System.out.println("sum of the value: " + (values[0] + values[1]));

    }

    private void difference() {
        int[] values = numberInput();

        int difference = values[0] - values[1];

        System.out.println("difference of the values: " + difference);

    }

    private void product() {
        int[] values = numberInput();
        System.out.println("product of the values: " + (values[0] * values[1]));

    }

    private void statistics() {
        System.out.println("Calculations done " + this.stats);
    }

    private int[] numberInput() {
        System.out.print("value1: ");
        int value1 = this.reader.readInteger();
        System.out.print("value2: ");
        int value2 = this.reader.readInteger();

        int[] values = {value1, value2};
        this.stats++;

        return values;
    }
}
