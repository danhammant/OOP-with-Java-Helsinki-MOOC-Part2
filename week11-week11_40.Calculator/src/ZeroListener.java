import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ZeroListener extends CalculatorListener implements ActionListener{

    public ZeroListener (Calculator calculator, JTextField output, JTextField input, JButton zero) {
        super (calculator, output, input, zero);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculator.setToZero();
        this.output.setText("" + this.calculator.giveValue());
        this.input.setText("");
        setZeroButton();
    }
}
