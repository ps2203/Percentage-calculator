package Task1;

public class Calculator {
    // Calculate percentage of a number
    public static String calculatePercentage(double value, double percentage) {
        double result = (value * percentage) / 100;
        return String.format("Result: %.2f%% of %.2f is %.2f", percentage, value, result);
    }

    // Calculate percentage increase or decrease
    public static String calculatePercentageChange(double originalValue, double percentageChange) {
        double result = (originalValue * percentageChange) / 100;
        double newValue = originalValue + result;
        return String.format("Original Value: %.2f\nPercentage Change: %.2f%%\nNew Value: %.2f", 
                             originalValue, percentageChange, newValue);
    }

    // Find the whole given a part and percentage
    public static String calculateWhole(double part, double percentage) {
        if (percentage == 0) {
            return "Percentage cannot be zero!";
        }
        double whole = (part * 100) / percentage;
        return String.format("Part: %.2f\nPercentage: %.2f%%\nWhole: %.2f", part, percentage, whole);
    }
}