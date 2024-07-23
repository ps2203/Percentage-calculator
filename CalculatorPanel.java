package Task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
    private final JTextField inputField;
    private final JTextField percentageField;
    private final JTextArea resultArea;
    private final JComboBox<String> calculationTypeBox;

    public CalculatorPanel() {
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel inputLabel = new JLabel("Input Value:");
        inputField = new JTextField();
        JLabel percentageLabel = new JLabel("Percentage:");
        percentageField = new JTextField();
        JLabel typeLabel = new JLabel("Calculation Type:");
        calculationTypeBox = new JComboBox<>(new String[]{
                "Percentage of a Number",
                "Percentage Increase/Decrease",
                "Find the Whole from Part and Percentage"
        });
        JButton calculateButton = new JButton("Calculate");
        resultArea = new JTextArea(4, 20);
        resultArea.setEditable(false);

        add(inputLabel);
        add(inputField);
        add(percentageLabel);
        add(percentageField);
        add(typeLabel);
        add(calculationTypeBox);
        add(calculateButton);
        add(new JScrollPane(resultArea));

        calculateButton.addActionListener(new CalculateButtonListener());
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Retrieve input values
                double inputValue = Double.parseDouble(inputField.getText());
                double percentage = Double.parseDouble(percentageField.getText());
                String selectedType = (String) calculationTypeBox.getSelectedItem();

                // Perform calculation based on selected type
                String result = "";
                switch (selectedType) {
                    case "Percentage of a Number":
                        result = Calculator.calculatePercentage(inputValue, percentage);
                        break;
                    case "Percentage Increase/Decrease":
                        result = Calculator.calculatePercentageChange(inputValue, percentage);
                        break;
                    case "Find the Whole from Part and Percentage":
                        result = Calculator.calculateWhole(inputValue, percentage);
                        break;
                }

                // Display the result
                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(CalculatorPanel.this, 
                        "Invalid input! Please enter valid numbers.", 
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
