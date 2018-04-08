

public class CalculatorLogic implements Calculator {
    private int value;

    public CalculatorLogic() {
        this.value = 0;
    }

    public void increaseValue(int number) {
        this.value += number;
    }

    public void decreaseValue(int number) {
        this.value -= number;
    }

    public void setToZero() {
        this.value = 0;
    }

    public int giveValue() {
        return this.value;
    }
}
