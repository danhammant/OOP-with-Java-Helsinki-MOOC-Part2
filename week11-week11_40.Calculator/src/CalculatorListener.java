import javax.swing.*;

public class CalculatorListener {
    protected Calculator calculator;
    protected JTextField output;
    protected JTextField input;
    protected JButton zero;
    private boolean isInt;

    public CalculatorListener (Calculator calculator, JTextField output, JTextField input, JButton zero) {
        this.calculator = calculator;
        this.output = output;
        this.input = input;
        this.zero = zero;
    }

    protected boolean isInt() {
        try {
            int input = Integer.parseInt(this.input.getText());
            this.isInt = true;
        } catch (NumberFormatException e) {
            this.isInt = false;
        }

        return this.isInt;
    }

    protected void setZeroButton() {
        if (this.calculator.giveValue() == 0) {
            this.zero.setEnabled(false);
        } else {
            this.zero.setEnabled(true);
        }
    }
}
