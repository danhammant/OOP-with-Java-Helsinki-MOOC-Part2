import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusListener extends CalculatorListener implements ActionListener {


    public PlusListener(Calculator calculator, JTextField output, JTextField input, JButton zero) {
        super (calculator, output, input, zero);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isInt()) {
            int number = Integer.parseInt(this.input.getText());
            this.calculator.increaseValue(number);
            this.output.setText("" + this.calculator.giveValue());
            setZeroButton();
        }

        this.input.setText("");
    }


}
