package Task1;

import javax.swing.*;

public class PercentageCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main frame for the application
            JFrame frame = new JFrame("Percentage Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            // Create and set the content pane
            CalculatorPanel panel = new CalculatorPanel();
            frame.setContentPane(panel);

            // Set the frame to be visible
            frame.setVisible(true);
        });
    }
}
