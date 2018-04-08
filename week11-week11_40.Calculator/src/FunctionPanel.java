import javax.swing.*;
import java.awt.*;

public class FunctionPanel extends JPanel {
    private Calculator calculator;
    private JTextField input;
    private JTextField output;

    public FunctionPanel(Calculator calculator, JTextField output, JTextField input) {
        super(new GridLayout(1,3));
        this.calculator = calculator;
        this.output = output;
        this.input = input;

        createComponents();
    }

    private void createComponents() {
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton zero = new JButton("Z");

        plus.addActionListener(new PlusListener(calculator, output, input, zero));
        minus.addActionListener(new MinusListener(calculator, output, input, zero));
        zero.addActionListener(new ZeroListener(calculator, output, input, zero));

        zero.setEnabled(false);

        add(plus);
        add(minus);
        add(zero);
    }

}
