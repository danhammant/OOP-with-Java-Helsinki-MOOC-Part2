

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorLogic();
        SwingUtilities.invokeLater(new GraphicCalculator(calculator));

    }
}
